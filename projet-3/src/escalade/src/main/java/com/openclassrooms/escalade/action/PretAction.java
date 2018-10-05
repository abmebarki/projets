package com.openclassrooms.escalade.action;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.openclassrooms.escalade.exceptions.NotFoundException;
import com.openclassrooms.escalade.model.Site;
import com.openclassrooms.escalade.model.Topo;
import com.openclassrooms.escalade.model.Grimpeur;
import com.openclassrooms.escalade.model.Pret;
import com.openclassrooms.escalade.service.PretService;
import com.openclassrooms.escalade.service.TopoService;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class PretAction extends ActionSupport implements SessionAware {
	
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
	private Integer emprunteurId;
    // ----- Eléments en sortie
    private List<Pret> listPret;
    private Pret pret;
    
    private List<Topo> listTopo;
    private Topo topo;
    
    @Autowired
	private PretService pretService;
    
    @Autowired
	private TopoService topoService;

    // ==================== Getters/Setters ====================
    
    public List<Pret> getListPret() {
        return listPret;
    }
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEmprunteurId() {
		return emprunteurId;
	}
	public void setEmprunteurId(Integer emprunteurId) {
		this.emprunteurId = emprunteurId;
	}
	public Pret getPret() {
        return pret;
    }
    public void setPret(Pret pret) {
		this.pret = pret;
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
     * Action listant les {@link Pret}
     * @return success
     */
    public String doMyList() {
    	String vResult = ActionSupport.SUCCESS;
    	
    	Grimpeur utilisateur = (Grimpeur)session.get("user");
    	if(utilisateur == null) {
    		vResult = "loginUser";
    	}
    	
    	listPret = pretService.findAll(emprunteurId);
    	
    	return vResult;
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
    	
    	String vResult = null;
    	
    	Grimpeur utilisateur = (Grimpeur)session.get("user");
    	if(utilisateur == null) {
    		vResult = "loginUser";
    	} else {
        if (id == null) {
            this.addActionError("Vous devez indiquer un id de pret");
        } else {
            try {
                id = pretService.delete(id);
                
                if(utilisateur.getRole().equals("USER")) {
                	listPret = pretService.findAll(emprunteurId);
                	vResult = "successUser";
                }else {
                	listPret = pretService.findAll();
                	vResult = "successAdmin";
                }
                
                
            } catch (Exception sE) {
                this.addActionError(getText("error.pret.notfound", Collections.singletonList(id)));
                vResult = ActionSupport.ERROR;
            }
        }
    	
    	}
    	
    	return vResult;
    	
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
        
        Grimpeur utilisateur = (Grimpeur)session.get("user");
    	if(utilisateur == null) {
    		vResult = "loginUser";
    	}
    	
        listTopo = topoService.findAll();
        

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
        
        Grimpeur utilisateur = (Grimpeur)session.get("user");
    	if(utilisateur == null) {
    		vResult = "loginUser";
    	}
    	
        if (id == null ) {
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
