package com.openclassrooms.escalade.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.openclassrooms.escalade.exceptions.NotFoundException;
import com.openclassrooms.escalade.model.Grimpeur;
import com.openclassrooms.escalade.service.GrimpeurService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Action de gestion de la connexion/déconnexion d'un utilisateur
 */
public class LoginAction extends ActionSupport implements ServletRequestAware, SessionAware {


    // ==================== Attributs ====================
    // ----- Paramètres en entrée
    private String email;
    private String motpasse;
    
    
    private HttpServletRequest servletRequest;

    @Override
    public void setServletRequest(HttpServletRequest pRequest) {
        this.servletRequest = pRequest;
    }
    
    // ----- Eléments Struts
    private Map<String, Object> session;

    @Autowired
	private GrimpeurService grimpeurService;

    // ==================== Getters/Setters ====================
   

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotpasse() {
		return motpasse;
	}

	public void setMotpasse(String motpasse) {
		this.motpasse = motpasse;
	}

	// ==================== Méthodes ====================
    /**
     * Action permettant la connexion d'un utilisateur
     * @return input / success
     */
    public String doLogin() {
        String vResult = ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(email, motpasse)) {
            try {
                Grimpeur vUtilisateur = grimpeurService.findByIdEmailPassword(email, motpasse);
                // Ajout de l'utilisateur en session
                this.session.put("user", vUtilisateur);
                vResult = ActionSupport.SUCCESS;
            } catch (NotFoundException pEx) {
                this.addActionError("Identifiant ou mot de passe invalide !");
            }
        }
        return vResult;
    }


    /**
     * Action de déconnexion d'un utilisateur
     * @return success
     */
    public String doLogout() {
    	
    	 // Suppression de l'utilisateur en session
        this.session.remove("user");
        
        // Invalidation de la session
        this.servletRequest.getSession().invalidate();
        
        return ActionSupport.SUCCESS;
    }
}