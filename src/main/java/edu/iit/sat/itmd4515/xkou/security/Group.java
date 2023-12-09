/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.security;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xiaoh
 */
@Entity
@Table(name = "SEC_GROUP")
@NamedQuery(name = "Group.findAll", query = "select g from Group g")
public class Group {

    @Id
    private String groupName;

    private String groupDescription;

    @ManyToMany(mappedBy = "groups")
    private List<User> users = new ArrayList<>();

    /**
     * Default constructor for creating an empty Group instance.
     */
    public Group() {
    }

    /**
     *
     * Constructor for creating a Group instance with a specified name and description.
     * 
     * @param groupName The name of the group.
     * @param groupDescription A brief description of the group.
     */
    public Group(String groupName, String groupDescription) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
    }
    

    /**
     * Get the value of groupName
     *
     * @return the value of groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Set the value of groupName
     *
     * @param groupName new value of groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     *
     * Get the value of groupDescription
     * 
     * @return the value of groupDescription
     */
    public String getGroupDescription() {
        return groupDescription;
    }

    /**
     *
     * Set the value of groupDescription
     * 
     * @param groupDescription new value of groupDescription
     */
    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    /**
     *
     * Get the value of User
     * 
     * @return the value of User
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     *
     * Set the value of users
     * 
     * @param users new value of users
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

}
