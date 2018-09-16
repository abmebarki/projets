package com.openclassrooms.escalade.action;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.openclassrooms.escalade.exceptions.FunctionalException;
import com.openclassrooms.escalade.exceptions.NotFoundException;
import com.openclassrooms.escalade.exceptions.TechnicalException;
import com.openclassrooms.escalade.model.Site;
import com.openclassrooms.escalade.service.SiteService;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class GestionSiteAction extends ActionSupport {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ==================== Attributs ====================
    // ----- Param�tres en entr�e
    private Integer id;

    // ----- El�ments en sortie
    private List<Site> listSite;
    private Site site;
    
    @Autowired
	private SiteService siteService;
    
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
	// ==================== M�thodes ====================
    /**
     * Action listant les {@link Site}
     * @return success
     */
    public String doList() {
        listSite = siteService.findAll();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action affichant les d�tails d'un {@link Site}
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
     * Action permettant de cr�er un nouveau {@link Site}
     * @return input / success / error
     */
    public String doCreate() {
        // Si (this.site == null) c'est que l'on entre dans l'ajout de site
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout

        // Par d�faut, le result est "input"
        String vResult = ActionSupport.INPUT;

        // ===== Validation de l'ajout de site (site != null)
        if (this.site != null) {
            
          // Si pas d'erreur, ajout du projet...
            if (!this.hasErrors()) {
                try {
                	id = siteService.save(this.site);
                	// Si ajout avec succ�s -> Result "success"
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Site ajout� avec succ�s");

                } catch (Exception sEx) {
                    // Sur erreur fonctionnelle on reste sur la page de saisie
                    // et on affiche un message d'erreur
                    this.addActionError(sEx.getMessage());

                } 
            }
        }
        
        return vResult;
    }
}
