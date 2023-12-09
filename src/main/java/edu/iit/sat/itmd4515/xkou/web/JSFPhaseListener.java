/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.web;

import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import java.util.logging.Logger;

/**
 *
 * @author xiaoh
 */
public class JSFPhaseListener implements PhaseListener {

    private static final Logger LOG = Logger.getLogger(JSFPhaseListener.class.getName());

    /**
     * Specifies that this listener is interested in all JSF lifecycle phases.
     *
     * @return The phase id for which this listener will be invoked.
     */
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    /**
     * Executed before entering each phase of the JSF lifecycle.
     * Logs the start of a new JSF request and the phase being entered.
     *
     * @param event The PhaseEvent object containing information about the current JSF lifecycle phase.
     */
    @Override
    public void beforePhase(PhaseEvent event) {
        if( event.getPhaseId() == PhaseId.RESTORE_VIEW ){
            LOG.info("######################## NEW JSF REQUEST ######################## ");
        }
        
        LOG.info("Before the JSF Phase ============================ >>>>> " + event.getPhaseId());
    }

    /**
     * Executed after each phase of the JSF lifecycle.
     * Logs the completion of the phase and the completion of a JSF request.
     *
     * @param event The PhaseEvent object containing information about the current JSF lifecycle phase.
     */
    @Override
    public void afterPhase(PhaseEvent event) {
        LOG.info("After the JSF Phase ============================ >>>>> " + event.getPhaseId());

        if( event.getPhaseId() == PhaseId.RENDER_RESPONSE ){
            LOG.info("######################## JSF REQUEST COMPLETED ######################## ");
        }

    }

    
}
