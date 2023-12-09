/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.security;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xiaoh
 */
@Entity
@Table(name = "SEC_USER")
@NamedQuery(name = "User.findAll", query = "select u from User u")
@EntityListeners(UserPasswordHash.class)
public class User {

    @Id
    @NotBlank(message = "Username can not be empty")
    private String userName;

    @NotBlank(message = "Password can not be empty")
    private String password;

    private Boolean enabled;

    @ManyToMany
    @JoinTable(name = "SEC_USER_GROUPS",
            joinColumns = @JoinColumn(name = "USERNAME"),
            inverseJoinColumns = @JoinColumn(name = "GROUPNAME"))
    private List<Group> groups = new ArrayList<>();

    /**
     * Default constructor for creating an empty User instance.
     */
    public User() {
    }

    /**
     *
     * Constructor for creating a User instance with a specified username, password, and enabled status.
     * 
     * @param userName The username for the user.
     * @param password The password for the user.
     * @param enabled The enabled status of the user.
     */
    public User(String userName, String password, Boolean enabled) {
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
    }

    /**
     *
     * Adds a security group to the user.
     * 
     * @param g The group to be added.
     */
    public void addGroup(Group g) {
        this.groups.add(g);
        g.getUsers().add(this);
    }
    
    /**
     * Removes a security group from the user.
     * 
     * @param g The group to be removed.
     */
    public void removeGroup(Group g) {
        this.groups.remove(g);
        g.getUsers().remove(this);
    }
    
    /**
     * Get the value of userName
     *
     * @return the value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the value of userName
     *
     * @param userName new value of userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * Retrieves the password of the user.
     * 
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * Sets a new password for the user.
     * 
     * @param password The new password to be set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * Checks if the user is enabled.
     * 
     * @return The enabled status of the user.
     */
    public Boolean isEnabled() {
        return enabled;
    }

    /**
     *
     * Sets the enabled status of the user.
     * 
     * @param enabled The new enabled status to be set.
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     *
     * Retrieves the list of security groups associated with the user.
     * 
     * @return A list of groups associated with the user.
     */
    public List<Group> getGroups() {
        return groups;
    }

    /**
     *
     * Sets a new list of security groups for the user.
     * 
     * @param groups The new list of groups to be set for the user.
     */
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

}
