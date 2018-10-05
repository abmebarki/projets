package com.openclassrooms.escalade.action;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.openclassrooms.escalade.exceptions.NotFoundException;
import com.openclassrooms.escalade.model.Site;
import com.openclassrooms.escalade.model.Commentaire;
import com.openclassrooms.escalade.model.Grimpeur;
import com.openclassrooms.escalade.service.CommentaireSiteService;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class CommentaireSiteAction extends ActionSupport implements SessionAware {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ----- Eléments Struts
    private Map<String, Object> session;
    
    public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	// ==================== Attributs ====================
    // ----- Paramétres en entrée
    private Integer id;
    
 // ----- Paramétres en entrée
    private Integer siteId;

    // ----- Eléments en sortie
    private List<Commentaire> listCommentaire;
    private Commentaire commentaire;
    
    @Autowired
	private CommentaireSiteService commentaireSiteService;


    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer tId) {
        id = tId;
    }
    public Integer getSiteId() {
		return siteId;
	}
    public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
	public List<Commentaire> getListCommentaire() {
        return listCommentaire;
    }
    public Commentaire getCommentaire() {
        return commentaire;
    }
    public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}
	// ==================== Méthodes ====================
   
    /**
     * Action supprimant {@link Commentaire}
     * @return success / error
     */
    public String doDelete() {
    	
    	String vResult;
    	
    	Grimpeur utilisateur = (Grimpeur)session.get("user");
    	if(utilisateur == null) {
    		vResult = "loginUser";
    	} else {
        if (id == null) {
            this.addActionError("Vous devez indiquer un id de commentaire");
        } else {
            try {
                id = commentaireSiteService.delete(id);
                //listCommentaire = commentaireSiteService.findAll();
            } catch (Exception sE) {
                this.addActionError(getText("error.commentaire.notfound", Collections.singletonList(id)));
            }
        }

        vResult = (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
      	}
      	
        return vResult;
    }
    
    /**
     * Action permettant de créer un nouveau {@link Commentaire}
     * @return input / success / error
     */
    public String doCreate() {
        // Si (this.commentaire == null) c'est que l'on entre dans l'ajout de commentaire
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout

        // Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;
        
        Grimpeur utilisateur = (Grimpeur)session.get("user");
    	if(utilisateur == null) {
    		vResult = "loginUser";
    	}

        // ===== Validation de l'ajout de commentaire (commentaire != null)
        if (this.commentaire != null) {
            
          // Si pas d'erreur, ajout du projet...
            if (!this.hasErrors()) {
                try {
                	 id = commentaireSiteService.create(this.commentaire, siteId);
                	// Si ajout avec succés -> Result "success"
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Commentaire ajouté avec succés");

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
     * Action permettant de mettre à jour un {@link Commentaire}
     * @return input / success / error
     */
    public String doUpdate() {
    	
    	// Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;
        
        Grimpeur utilisateur = (Grimpeur)session.get("user");
    	if(utilisateur == null) {
    		vResult = "loginUser";
    	}
    	
        if (id == null) {
        	if (this.commentaire == null) {
        		this.addActionError("Vous devez indiquer un id de commentaire");
        	} else {
       		 // Si pas d'erreur, mise à jour du commentaire...
                if (!this.hasErrors()) {
                    try {
                    	commentaireSiteService.update(this.commentaire);
                    	// Si mise à jour avec succés -> Result "success"
                        vResult = ActionSupport.SUCCESS;
                        this.addActionMessage("Commentaire mis à jour avec succés");

                    } catch (Exception sEx) {
                        // Sur erreur fonctionnelle on reste sur la page de saisie
                        // et on affiche un message d'erreur
                        this.addActionError(sEx.getMessage());
                    } 
                } 
       	 	}

         } else {
        	 	 try {
	                 commentaire = commentaireSiteService.findById(id);
	             } catch (Exception sE) {
	            	 vResult = ActionSupport.ERROR;
	                 this.addActionError(getText("error.commentaire.notfound", Collections.singletonList(id)));
	             }
         }

        return vResult;
    }
}
