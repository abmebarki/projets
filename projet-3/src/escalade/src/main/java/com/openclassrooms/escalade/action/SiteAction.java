package com.openclassrooms.escalade.action;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.openclassrooms.escalade.exceptions.FunctionalException;
import com.openclassrooms.escalade.exceptions.NotFoundException;
import com.openclassrooms.escalade.exceptions.TechnicalException;
import com.openclassrooms.escalade.model.Difficulte;
import com.openclassrooms.escalade.model.Exposition;
import com.openclassrooms.escalade.model.Grimpeur;
import com.openclassrooms.escalade.model.Role;
import com.openclassrooms.escalade.model.Saison;
import com.openclassrooms.escalade.model.Site;
import com.openclassrooms.escalade.model.Topo;
import com.openclassrooms.escalade.model.Type;
import com.openclassrooms.escalade.service.SiteService;
import com.openclassrooms.escalade.service.TopoService;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class SiteAction extends ActionSupport implements SessionAware {
	
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
    // ----- Paramètres en entrée
    private Integer id;
    private Integer createurId;
    private List<Exposition> expositiontList = Arrays.asList(Exposition.values());
    private List<Saison> saisonList = Arrays.asList(Saison.values());
    private List<Type> typeList = Arrays.asList(Type.values());
    private List<Difficulte> difficulteList = Arrays.asList(Difficulte.values());
    
   	// ----- Eléments en sortie
    private List<Site> listSite;
    private Site site;
    
    private List<Topo> listTopo;
    private Topo topo;
    
    private Boolean nouveauTopo;
    
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
   
    public Integer getCreateurId() {
		return createurId;
	}
	public void setCreateurId(Integer createurId) {
		this.createurId = createurId;
	}
	public List<Exposition> getExpositiontList() {
		return expositiontList;
	}
	public void setExpositiontList(List<Exposition> expositiontList) {
		this.expositiontList = expositiontList;
	}

	public List<Saison> getSaisonList() {
		return saisonList;
	}
	public void setSaisonList(List<Saison> saisonList) {
		this.saisonList = saisonList;
	}
    
	public List<Type> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<Type> typeList) {
		this.typeList = typeList;
	}
	public List<Site> getListSite() {
        return listSite;
    }
	
	public List<Difficulte> getDifficulteList() {
		return difficulteList;
	}
	public void setDifficulteList(List<Difficulte> difficulteList) {
		this.difficulteList = difficulteList;
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
	
	public Boolean getNouveauTopo() {
		return nouveauTopo;
	}
	public void setNouveauTopo(Boolean nouveauTopo) {
		this.nouveauTopo = nouveauTopo;
	}
	// ==================== Méthodes ====================
	
	 /**
     * Action listant les {@link Site}
     * @return success
     */
	@SkipValidation
    public String doMyList() {
    	String vResult = ActionSupport.SUCCESS;
    	
    	Grimpeur utilisateur = (Grimpeur)session.get("user");
    	if(utilisateur == null) {
    		vResult = "loginUser";
    	}
    	
    	listSite = siteService.findAll(createurId);
    	
    	return vResult;
    }
	
    /**
     * Action listant les {@link Site}
     * @return success
     */
	@SkipValidation
    public String doList() {
    	String vResult = ActionSupport.INPUT;
    	if (this.site != null) {
    		listSite = siteService.findAll(this.site);
    		vResult = ActionSupport.SUCCESS;
    	}
        
        return vResult;
    }


    /**
     * Action affichant les détails d'un {@link Site}
     * @return success / error
     */
	@SkipValidation
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
	@SkipValidation
    public String doDelete() {
    	
    	String vResult = null;
    	
    	Grimpeur utilisateur = (Grimpeur)session.get("user");
    	if(utilisateur == null) {
    		vResult = "loginUser";
    	} else {
        
      	if (id == null) {
            this.addActionError("Vous devez indiquer un id de site");
        } else {
            try {
            	
            	// Vérifier si le grimpeur est le créateur du site sinon l'admin
            	if(!utilisateur.getRole().equals(Role.ADMIN) && siteService.findById(id).getCreateur().getId() != utilisateur.getId()) {
            		this.addActionError("Vous n'êtes pas le créateur du site");
            	}else {
            	
                id = siteService.delete(id);
            	}
                
                if(utilisateur.getRole().equals("USER")) {
                	listSite = siteService.findAll(createurId);
                	vResult = "successUser";
                }else {
                	listSite = siteService.findAll();
                	vResult = "successAdmin";
                }
                
                
            } catch (Exception sE) {
                this.addActionError(getText("error.site.notfound", Collections.singletonList(id)));
                vResult = ActionSupport.ERROR;
            }
        }
      	}
      	
        return vResult;
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
    	
        Grimpeur utilisateur = (Grimpeur)session.get("user");
    	if(utilisateur == null) {
    		vResult = "loginUser";
    	}
    	
    	listTopo = topoService.findAll();

        // ===== Validation de l'ajout de site (site != null)
        if (this.site != null) {
            
          // Si pas d'erreur, ajout du projet...
            if (!this.hasErrors()) {
                try {
                	 id = siteService.create(this.site);
                	 
                	 if(nouveauTopo == true) {
                		vResult = "newTopo"; 
                	 }else {
                		 // Si ajout avec succés -> Result "success"
                         vResult = ActionSupport.SUCCESS;
                	 }
                	 
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
        
        Grimpeur utilisateur = (Grimpeur)session.get("user");
    	if(utilisateur == null) {
    		vResult = "loginUser";
    	}
        
        if (id == null) {
        	if (this.site == null) {
        		this.addActionError("Vous devez indiquer un id de site");
        	} else {
       		 // Si pas d'erreur, mise à jour du site...
                if (!this.hasErrors()) {
                    try {
                    	
                    	// Vérifier si le grimpeur est le créateur du site sinon l'admin
                    	if(!utilisateur.getRole().equals(Role.ADMIN) && siteService.findById(site.getId()).getCreateur().getId() != utilisateur.getId()) {
                    		this.addActionError("Vous n'êtes pas le créateur du site");
                    	}else {
                    		siteService.update(this.site);
                        	// Si mise à jour avec succés -> Result "success"
                            vResult = ActionSupport.SUCCESS;
                            this.addActionMessage("Site mis à jour avec succés");
                    	}
                    	
                    	
                    	

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
    
    public void validate(){
    	if(site != null) {
    		// Expositions
    		if (site.getExpositions().isEmpty()) {
                this.addActionError("L'exposition est obligatoire.");
            }
    		
    		// Saisons
    		if (site.getSaisons().isEmpty()) {
    			this.addActionError("La saison est obligatoire.");
            }
    	}
    }    
}
