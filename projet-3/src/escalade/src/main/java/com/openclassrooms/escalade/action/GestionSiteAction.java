package com.openclassrooms.escalade.action;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.openclassrooms.escalade.exceptions.FunctionalException;
import com.openclassrooms.escalade.exceptions.NotFoundException;
import com.openclassrooms.escalade.exceptions.TechnicalException;
import com.openclassrooms.escalade.model.Site;
import com.openclassrooms.escalade.model.Topo;
import com.openclassrooms.escalade.service.SiteService;
import com.openclassrooms.escalade.service.TopoService;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class GestionSiteAction extends ActionSupport {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ==================== Attributs ====================
    // ----- Paramètres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private List<Site> listSite;
    private Site site;
    
    private List<Topo> listTopo;
    private Topo topo;
    
    private String selectedTopos;
    
    @Autowired
	private SiteService siteService;
    
    @Autowired
	private TopoService topoService;
    
    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer sId) {
        id = sId;
    }
    public List<Site> getListSite() {
        return listSite;
    }
    
    public Site getSite() {
        return site;
    }
    
    public void setSite(Site site) {
		this.site = site;
	}
    
 	public List<Topo> getListTopo() {
		return listTopo;
	}
	public void setListTopo(List<Topo> listTopo) {
		this.listTopo = listTopo;
	}
	public Topo getTopo() {
		return topo;
	}
	public void setTopo(Topo topo) {
		this.topo = topo;
	}
	
	public String getSelectedTopos() {
		return selectedTopos;
	}
	public void setSelectedTopos(String selectedTopos) {
		this.selectedTopos = selectedTopos;
	}
	// ==================== Méthodes ====================
    /**
     * Action listant les {@link Site}
     * @return success
     */
    public String doList() {
        listSite = siteService.findAll();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action affichant les détails d'un {@link Site}
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError("Vous devez indiquer un id de site");
        } else {
            try {
                site = siteService.findById(id);
            } catch (Exception sE) {
                this.addActionError(getText("error.site.notfound", Collections.singletonList(id)));
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
    
    /**
     * Action supprimant {@link Site}
     * @return success / error
     */
    public String doDelete() {
        if (id == null) {
            this.addActionError("Vous devez indiquer un id de site");
        } else {
            try {
                id = siteService.delete(id);
                listSite = siteService.findAll();
            } catch (Exception sE) {
                this.addActionError(getText("error.site.notfound", Collections.singletonList(id)));
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
    
    /**
     * Action permettant de créer un nouveau {@link Site}
     * @return input / success / error
     */
    public String doCreate() {
        // Si (this.site == null) c'est que l'on entre dans l'ajout de site
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout

        // Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;
        listTopo = topoService.findAll();

        // ===== Validation de l'ajout de site (site != null)
        if (this.site != null) {
            
          // Si pas d'erreur, ajout du projet...
            if (!this.hasErrors()) {
                try {
                	 id = siteService.create(this.site, selectedTopos);
                	 // Si ajout avec succés -> Result "success"
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Site ajouté avec succés");

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
     * Action permettant de mettre à jour un {@link Site}
     * @return input / success / error
     */
    public String doUpdate() {
    	
    	// Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;
        if (id == null) {
        	if (this.site == null) {
        		this.addActionError("Vous devez indiquer un id de site");
        	} else {
       		 // Si pas d'erreur, mise à jour du site...
                if (!this.hasErrors()) {
                    try {
                    	siteService.update(this.site);
                    	// Si mise à jour avec succés -> Result "success"
                        vResult = ActionSupport.SUCCESS;
                        this.addActionMessage("Site mis à jour avec succés");

                    } catch (Exception sEx) {
                        // Sur erreur fonctionnelle on reste sur la page de saisie
                        // et on affiche un message d'erreur
                        this.addActionError(sEx.getMessage());
                    } 
                } 
       	 	}

         } else {
        	 	 try {
	                 site = siteService.findById(id);
	             } catch (Exception sE) {
	            	 vResult = ActionSupport.ERROR;
	                 this.addActionError(getText("error.site.notfound", Collections.singletonList(id)));
	             }
         }

        return vResult;
    }
}
