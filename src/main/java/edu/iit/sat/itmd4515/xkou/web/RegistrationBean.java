/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.web;

import edu.iit.sat.itmd4515.xkou.security.User;
import edu.iit.sat.itmd4515.xkou.security.UserService;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;


/**
 *
 * @author xiaoh
 */
@Named
@RequestScoped
public class RegistrationBean {

    @EJB
    private UserService userService;

    private User newUser = new User();

    /**
     * Handles the user registration process.
     *
     * @return The navigation outcome, typically redirects to the login page upon successful registration.
     */
    public String register() {
        userService.createUser(newUser);
        return "login?faces-redirect=true"; //
    }

    // Getters and Setters

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }
}