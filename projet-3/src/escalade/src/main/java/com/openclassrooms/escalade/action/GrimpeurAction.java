package com.openclassrooms.escalade.action;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.openclassrooms.escalade.exceptions.NotFoundException;
import com.openclassrooms.escalade.model.Exposition;
import com.openclassrooms.escalade.model.Grimpeur;
import com.openclassrooms.escalade.model.Role;
import com.openclassrooms.escalade.model.Site;
import com.openclassrooms.escalade.model.Topo;
import com.openclassrooms.escalade.service.GrimpeurService;
import com.openclassrooms.escalade.service.SiteService;
import com.openclassrooms.escalade.service.TopoService;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class GrimpeurAction extends ActionSupport implements SessionAware {
	
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
    private List<Role> roleList = Arrays.asList(Role.values());
    // ----- Eléments en sortie
    private List<Grimpeur> listGrimpeur;
    private Grimpeur grimpeur;
    private String data;
    
    @Autowired
	private GrimpeurService grimpeurService;
    
    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer tId) {
        id = tId;
    }
   
    public List<Grimpeur> getListGrimpeur() {
		return listGrimpeur;
	}
	public void setListGrimpeur(List<Grimpeur> listGrimpeur) {
		this.listGrimpeur = listGrimpeur;
	}
	public Grimpeur getGrimpeur() {
		return grimpeur;
	}
	public void setGrimpeur(Grimpeur grimpeur) {
		this.grimpeur = grimpeur;
	}
	
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	// ==================== Méthodes ====================
    /**
     * Action listant les {@link Grimpeur}
     * @return success
     */
    public String doList() {
        listGrimpeur = grimpeurService.findAll();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action affichant les détails d'un {@link Grimpeur}
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError("Vous devez indiquer un id de grimpeur");
        } else {
            try {
                grimpeur = grimpeurService.findById(id);
            } catch (Exception sE) {
                this.addActionError(getText("error.topo.notfound", Collections.singletonList(id)));
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
    
    /**
     * Action supprimant {@link Grimpeur}
     * @return success / error
     */
    public String doDelete() {
    	
    	String vResult = null;
    	
    	Grimpeur utilisateur = (Grimpeur)session.get("user");
    	if(utilisateur == null) {
    		vResult = "loginUser";
    	} else {
    	
        if (id == null) {
            this.addActionError("Vous devez indiquer un id de grimpeur");
        } else {
            try {
            	
            	// Vérifier si le grimpeur est le créateur du site sinon l'admin
            	if(!utilisateur.getRole().equals(Role.ADMIN) && grimpeurService.findById(id).getId() != utilisateur.getId()) {
            		this.addActionError("Vous n'êtes pas le propriétaire du profile");
            	}else {
            	
                id = grimpeurService.delete(id);
            	}
                listGrimpeur = grimpeurService.findAll();
                vResult = ActionSupport.SUCCESS;
                               
                
            } catch (Exception sE) {
                this.addActionError(getText("error.grimpeur.notfound", Collections.singletonList(id)));
                vResult = ActionSupport.ERROR;
            }
        }

        //vResult = (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    	}
    	
    	return vResult;
    }
    
    /**
     * Action permettant de créer un nouveau {@link Grimpeur}
     * @return input / success / error
     */
    public String doCreate() {
        // Si (this.grimpeur == null) c'est que l'on entre dans l'ajout de grimpeur
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout

        // Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;
        
        // ===== Validation de l'ajout de grimpeur (grimpeur != null)
        if (this.grimpeur != null) {
         
        	// Si pas d'erreur, ajout du projet...
            if (!this.hasErrors()) {
                try {
                	 id = grimpeurService.create(this.grimpeur);
                	// Si ajout avec succés -> Result "success"
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Grimpeur ajouté avec succés");

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
     * Action permettant de créer un nouveau {@link Grimpeur}
     * @return input / success / error
     */
    public String doInitPassword() {
        // Si (this.grimpeur == null) c'est que l'on entre dans l'ajout de grimpeur
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout

        // Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;
        
        if(this.data != null) {
        	
        	// decrypt
        }
        
        // ===== Validation de l'ajout de grimpeur (grimpeur != null)
        if (this.grimpeur != null) {
         
        	// Si pas d'erreur, ajout du projet...
            if (!this.hasErrors()) {
                try {
                	grimpeur = grimpeurService.findByNameEmail(this.grimpeur.getNom(), this.grimpeur.getEmail());
                	
                	grimpeurService.sendEmailInitPassword(this.grimpeur);
                	// Si ajout avec succés -> Result "success"
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Un email vous a été envoyé pour reinitialiser votre mot de passe");

                } catch (Exception sEx) {
                    // Sur erreur fonctionnelle on reste sur la page de saisie
                    // et on affiche un message d'erreur
                    this.addActionError("Grimpeur non trouvé");

                } 
            }
        }
        
        return vResult;
    }
    
    /**
     * Action permettant de mettre à jour un {@link Grimpeur}
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
        	if (this.grimpeur == null) {
        		this.addActionError("Vous devez indiquer un id de grimpeur");
        	} else {
       		 // Si pas d'erreur, mise à jour du grimpeur...
                if (!this.hasErrors()) {
                    try {
                    	// Vérifier si le grimpeur est le créateur du site sinon l'admin
                    	if(!utilisateur.getRole().equals(Role.ADMIN) && grimpeurService.findById(grimpeur.getId()).getId() != utilisateur.getId()) {
                    		this.addActionError("Vous n'êtes pas le propriétaire du profile");
                    	}else {
                    	grimpeurService.update(this.grimpeur);
                    	}
                    	// Si mise à jour avec succés -> Result "success"
                        vResult = ActionSupport.SUCCESS;
                        this.addActionMessage("Grimpeur mis à jour avec succés");

                    } catch (Exception sEx) {
                        // Sur erreur fonctionnelle on reste sur la page de saisie
                        // et on affiche un message d'erreur
                        this.addActionError(sEx.getMessage());
                    } 
                } 
       	 	}

         } else {
        	 	 try {
	                 grimpeur = grimpeurService.findById(id);
	             } catch (Exception sE) {
	            	 vResult = ActionSupport.ERROR;
	                 this.addActionError(getText("error.grimpeur.notfound", Collections.singletonList(id)));
	             }
         }

        return vResult;
    }
}
