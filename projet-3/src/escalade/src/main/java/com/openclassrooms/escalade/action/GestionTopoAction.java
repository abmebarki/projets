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
    // ----- Param�tres en entr�e
    private Integer id;

    // ----- El�ments en sortie
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


    // ==================== M�thodes ====================
    /**
     * Action listant les {@link Topo}
     * @return success
     */
    public String doList() {
        listTopo = topoService.findAll();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action affichant les d�tails d'un {@link Topo}
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
}
