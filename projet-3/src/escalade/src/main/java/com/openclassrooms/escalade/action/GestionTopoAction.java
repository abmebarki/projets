package com.openclassrooms.escalade.action;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.openclassrooms.escalade.exceptions.NotFoundException;
import com.openclassrooms.escalade.model.Site;
import com.openclassrooms.escalade.model.Topo;
import com.openclassrooms.escalade.service.TopoService;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class GestionTopoAction extends ActionSupport {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ==================== Attributs ====================
    // ----- Paramétres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private List<Topo> listTopo;
    private Topo topo;
    
    @Autowired
	private TopoService topoService;


    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer tId) {
        id = tId;
    }
    public List<Topo> getListTopo() {
        return listTopo;
    }
    public Topo getTopo() {
        return topo;
    }
    public void setTopo(Topo topo) {
		this.topo = topo;
	}
	// ==================== Méthodes ====================
    /**
     * Action listant les {@link Topo}
     * @return success
     */
    public String doList() {
        listTopo = topoService.findAll();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action affichant les détails d'un {@link Topo}
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError("Vous devez indiquer un id de topo");
        } else {
            try {
                topo = topoService.findById(id);
            } catch (Exception sE) {
                this.addActionError(getText("error.topo.notfound", Collections.singletonList(id)));
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
    
    /**
     * Action supprimant {@link Topo}
     * @return success / error
     */
    public String doDelete() {
        if (id == null) {
            this.addActionError("Vous devez indiquer un id de topo");
        } else {
            try {
                id = topoService.delete(id);
                listTopo = topoService.findAll();
            } catch (Exception sE) {
                this.addActionError(getText("error.topo.notfound", Collections.singletonList(id)));
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
    
    /**
     * Action permettant de créer un nouveau {@link Topo}
     * @return input / success / error
     */
    public String doCreate() {
        // Si (this.topo == null) c'est que l'on entre dans l'ajout de topo
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout

        // Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;

        // ===== Validation de l'ajout de topo (topo != null)
        if (this.topo != null) {
            
          // Si pas d'erreur, ajout du projet...
            if (!this.hasErrors()) {
                try {
                	 id = topoService.create(this.topo);
                	// Si ajout avec succés -> Result "success"
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Topo ajouté avec succés");

                } catch (Exception sEx) {
                    // Sur erreur fonctionnelle on reste sur la page de saisie
                    // et on affiche un message d'erreur
                    this.addActionError(sEx.getMessage());

                } 
            }
        }
        
        return vResult;
    }
    
    /**
     * Action permettant de mettre à jour un {@link Topo}
     * @return input / success / error
     */
    public String doUpdate() {
    	
    	// Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;
        if (id == null) {
        	if (this.topo == null) {
        		this.addActionError("Vous devez indiquer un id de topo");
        	} else {
       		 // Si pas d'erreur, mise à jour du topo...
                if (!this.hasErrors()) {
                    try {
                    	topoService.update(this.topo);
                    	// Si mise à jour avec succés -> Result "success"
                        vResult = ActionSupport.SUCCESS;
                        this.addActionMessage("Topo mis à jour avec succés");

                    } catch (Exception sEx) {
                        // Sur erreur fonctionnelle on reste sur la page de saisie
                        // et on affiche un message d'erreur
                        this.addActionError(sEx.getMessage());
                    } 
                } 
       	 	}

         } else {
        	 	 try {
	                 topo = topoService.findById(id);
	             } catch (Exception sE) {
	            	 vResult = ActionSupport.ERROR;
	                 this.addActionError(getText("error.topo.notfound", Collections.singletonList(id)));
	             }
         }

        return vResult;
    }
}
