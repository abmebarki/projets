package com.openclassrooms.escalade.action;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.openclassrooms.escalade.exceptions.NotFoundException;
import com.openclassrooms.escalade.model.Grimpeur;
import com.openclassrooms.escalade.model.Role;
import com.openclassrooms.escalade.model.Site;
import com.openclassrooms.escalade.model.Topo;
import com.openclassrooms.escalade.service.SiteService;
import com.openclassrooms.escalade.service.TopoService;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class TopoAction extends ActionSupport implements SessionAware {
	
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
    private Integer proprietaireId;
    // ----- Eléments en sortie
    private List<Topo> listTopo;
    private Topo topo;
    
    private List<Site> listSite;
    private Site site;
    
    @Autowired
	private TopoService topoService;
    
    @Autowired
	private SiteService siteService;


    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer tId) {
        id = tId;
    }
    public Integer getProprietaireId() {
		return proprietaireId;
	}
	public void setProprietaireId(Integer proprietaireId) {
		this.proprietaireId = proprietaireId;
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
        
	public List<Site> getListSite() {
		return listSite;
	}
	public void setListSite(List<Site> listSite) {
		this.listSite = listSite;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	// ==================== Méthodes ====================
	 /**
     * Action listant les {@link Topo}
     * @return success
     */
    public String doMyList() {
    	String vResult = ActionSupport.SUCCESS;
    	
    	Grimpeur utilisateur = (Grimpeur)session.get("user");
    	if(utilisateur == null) {
    		vResult = "loginUser";
    	}
    	
    	listTopo = topoService.findAll(proprietaireId);
    	
    	return vResult;
    }
    
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
    	
    	String vResult = null;
    	
    	Grimpeur utilisateur = (Grimpeur)session.get("user");
    	if(utilisateur == null) {
    		vResult = "loginUser";
    	} else {
    	
        if (id == null) {
            this.addActionError("Vous devez indiquer un id de topo");
        } else {
            try {
            	
            	// Vérifier si le grimpeur est le créateur du site sinon l'admin
            	if(!utilisateur.getRole().equals(Role.ADMIN) || topoService.findById(id).getProprietaire().getId() != utilisateur.getId()) {
            		this.addActionError("Vous n'êtes pas le propiétaire du topo");
            	}else {
            	
                id = topoService.delete(id);
            	}
                
                if(utilisateur.getRole().equals("USER")) {
                	listTopo = topoService.findAll(proprietaireId);
                	vResult = "successUser";
                }else {
                	listTopo = topoService.findAll();
                	vResult = "successAdmin";
                }
                
                
            } catch (Exception sE) {
                this.addActionError(getText("error.topo.notfound", Collections.singletonList(id)));
                vResult = ActionSupport.ERROR;
            }
        }

        //vResult = (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    	}
    	
    	return vResult;
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
        
        Grimpeur utilisateur = (Grimpeur)session.get("user");
    	if(utilisateur == null) {
    		vResult = "loginUser";
    	}
        
        listSite = siteService.findAll();
        
        // Création d'un topo à partir d'un site d'escalade
        if(site != null) {
        	site = siteService.findById(site.getId());
        }
        
        		

        // ===== Validation de l'ajout de topo (topo != null)
        if (this.topo != null) {
            
          // Si pas d'erreur, ajout du projet...
            if (!this.hasErrors()) {
                try {
                	 id = topoService.create(this.topo);
                	
                	// Si ajout avec succés -> Result "success"
                	 if(site != null) {
                		 vResult = "successSite";
                	 }else {
                		 vResult = ActionSupport.SUCCESS;
                	 }
             
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
        
        Grimpeur utilisateur = (Grimpeur)session.get("user");
    	if(utilisateur == null) {
    		vResult = "loginUser";
    	}
    	
        if (id == null) {
        	if (this.topo == null) {
        		this.addActionError("Vous devez indiquer un id de topo");
        	} else {
       		 // Si pas d'erreur, mise à jour du topo...
                if (!this.hasErrors()) {
                    try {
                    	
                    	// Vérifier si le grimpeur est le créateur du site sinon l'admin
                    	if(!utilisateur.getRole().equals(Role.ADMIN) || topoService.findById(topo.getId()).getProprietaire().getId() != utilisateur.getId()) {
                    		this.addActionError("Vous n'êtes pas le propriétaire du topo");
                    	}else {
                    	topoService.update(this.topo);
                    	}
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
