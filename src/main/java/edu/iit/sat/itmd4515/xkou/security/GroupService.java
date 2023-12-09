/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.security;

import edu.iit.sat.itmd4515.xkou.service.AbstractService;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author xiaoh
 */
@Stateless
public class GroupService extends AbstractService<Group> {

    /**
     * Default constructor initializing with Group entity class.
     */
    public GroupService() {
        super(Group.class);
    }
    
    /**
     *
     * Retrieves a list of all Group entities.
     * 
     * @return A list of Group entities.
     */
    public List<Group> findAll(){
        return super.findAll("Group.findAll");
    }
}
