/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.web;

import edu.iit.sat.itmd4515.xkou.config.Itmd4515SecurityRoles;
import edu.iit.sat.itmd4515.xkou.security.User;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.Password;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xiaoh
 */
@Named
@RequestScoped
public class LoginController {

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());

    private User user;

    @Inject
    SecurityContext securityContext;
    @Inject
    FacesContext facesContext;

    /**
     * Default constructor.
     */
    public LoginController() {
    }

    @PostConstruct
    private void postConstruct() {
        LOG.info("Inside LoginController.postConstruct()");
        user = new User();
    }
    
    //helper method

    /**
     * Retrieves the current logged-in username.
     *
     * @return The username of the current user.
     */
    public String getCurrentUser(){
        return facesContext.getExternalContext().getRemoteUser();
    }
    
    /**
     * Checks if the current user has an admin role.
     *
     * @return True if the user has an admin role, false otherwise.
     */
    public boolean isAdmin() {
        return securityContext.isCallerInRole(Itmd4515SecurityRoles.ADMIN_ROLE);
    }

    /**
     * Checks if the current user has a teacher role.
     *
     * @return True if the user has a teacher role, false otherwise.
     */
    public boolean isTeacher() {
        return securityContext.isCallerInRole(Itmd4515SecurityRoles.TEACHER_ROLE);
    }

    /**
     * Checks if the current user has a book role.
     *
     * @return True if the user has a book role, false otherwise.
     */
    public boolean isBook() {
        return securityContext.isCallerInRole(Itmd4515SecurityRoles.BOOK_ROLE);
    }

    // action methods

    /**
     * Performs the login action.
     *
     * @return The navigation path for the next page based on the login result.
     */
    public String doLogin() {
        LOG.info("LoginController.doLogin() with " + user.getUserName());

        // JSF-375 authN
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

        Credential cred = new UsernamePasswordCredential(this.user.getUserName(), new Password(this.user.getPassword()));

        AuthenticationStatus status
                = securityContext.authenticate(
                        request,
                        response,
                        AuthenticationParameters.withParams().credential(cred)
                );

        switch (status) {
            case SUCCESS:
                LOG.info(status.toString());
                break;
            case SEND_FAILURE:
                LOG.info(status.toString());
                return "/error.xhtml";
            case NOT_DONE:
                LOG.info(status.toString());
                return "/error.xhtml";
            case SEND_CONTINUE:
                LOG.info(status.toString());
                break;
        }

        return "/welcome.xhtml?faces-redirect=true";
    }

    /**
     * Performs the logout action.
     *
     * @return The navigation path for the login page.
     */
    public String doLogout() {

        LOG.info("LoginController.doLogout() with " + this.getCurrentUser() );
        
        try {
            HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
            request.logout();
        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

        return "/login.xhtml?faces-redirect=true";
    }

    /**
     * Gets the User model for this controller.
     *
     * @return The User model.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the User model for this controller.
     *
     * @param user The User to be set.
     */
    public void setUser(User user) {
        this.user = user;
    }
}
