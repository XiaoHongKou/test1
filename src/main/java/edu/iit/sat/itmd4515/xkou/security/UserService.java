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
public class UserService extends AbstractService<User> {

    /**
     * Default constructor initializing with User entity class.
     */
    public UserService() {
        super(User.class);
    }
    
    /**
     *
     * Retrieves a list of all User entities.
     * 
     * @return A list of User entities.
     */
    public List<User> findAll(){
        return super.findAll("User.findAll");
    }
    
    /**
     * Creates a new user entity in the database.
     *
     * @param user The User entity to be persisted.
     */
    public void createUser(User user) {
        em.persist(user); 
    }
}
