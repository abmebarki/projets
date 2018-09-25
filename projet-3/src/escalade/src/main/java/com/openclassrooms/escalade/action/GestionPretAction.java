package com.openclassrooms.escalade.action;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.openclassrooms.escalade.exceptions.NotFoundException;
import com.openclassrooms.escalade.model.Site;
import com.openclassrooms.escalade.model.Pret;
import com.openclassrooms.escalade.service.PretService;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class GestionPretAction extends ActionSupport {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ==================== Attributs ====================
    // ----- Paramétres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private List<Pret> listPret;
    private Pret pret;
    
    @Autowired
	private PretService pretService;


    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer tId) {
        id = tId;
    }
    public List<Pret> getListPret() {
        return listPret;
    }
    public Pret getPret() {
        return pret;
    }
    public void setPret(Pret pret) {
		this.pret = pret;
	}
	// ==================== Méthodes ====================
    /**
     * Action listant les {@link Pret}
     * @return success
     */
    public String doList() {
        listPret = pretService.findAll();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action affichant les détails d'un {@link Pret}
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError("Vous devez indiquer un id de prêt");
        } else {
            try {
                pret = pretService.findById(id);
            } catch (Exception sE) {
                this.addActionError(getText("error.pret.notfound", Collections.singletonList(id)));
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
    
    /**
     * Action supprimant {@link Pret}
     * @return success / error
     */
    public String doDelete() {
        if (id == null) {
            this.addActionError("Vous devez indiquer un id de pret");
        } else {
            try {
                id = pretService.delete(id);
                listPret = pretService.findAll();
            } catch (Exception sE) {
                this.addActionError(getText("error.pret.notfound", Collections.singletonList(id)));
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
    
    /**
     * Action permettant de créer un nouveau {@link Pret}
     * @return input / success / error
     */
    public String doCreate() {
        // Si (this.pret == null) c'est que l'on entre dans l'ajout de pret
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout

        // Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;

        // ===== Validation de l'ajout de pret (pret != null)
        if (this.pret != null) {
            
          // Si pas d'erreur, ajout du projet...
            if (!this.hasErrors()) {
                try {
                	 id = pretService.create(this.pret);
                	// Si ajout avec succés -> Result "success"
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Pret ajouté avec succés");

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
     * Action permettant de mettre à jour un {@link Pret}
     * @return input / success / error
     */
    public String doUpdate() {
    	
    	// Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;
        if (id == null) {
        	if (this.pret == null) {
        		this.addActionError("Vous devez indiquer un id de pret");
        	} else {
       		 // Si pas d'erreur, mise à jour du pret...
                if (!this.hasErrors()) {
                    try {
                    	pretService.update(this.pret);
                    	// Si mise à jour avec succés -> Result "success"
                        vResult = ActionSupport.SUCCESS;
                        this.addActionMessage("Pret mis à jour avec succés");

                    } catch (Exception sEx) {
                        // Sur erreur fonctionnelle on reste sur la page de saisie
                        // et on affiche un message d'erreur
                        this.addActionError(sEx.getMessage());
                    } 
                } 
       	 	}

         } else {
        	 	 try {
	                 pret = pretService.findById(id);
	             } catch (Exception sE) {
	            	 vResult = ActionSupport.ERROR;
	                 this.addActionError(getText("error.pret.notfound", Collections.singletonList(id)));
	             }
         }

        return vResult;
    }
}
