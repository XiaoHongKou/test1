/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.service;

import edu.iit.sat.itmd4515.xkou.domain.Library;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author xiaoh
 */
@Stateless
public class LibraryService extends AbstractService<Library>{

    /**
     * Default constructor initializing with Library entity class.
     */
    public LibraryService() {
        super(Library.class);
    }
    
    /**
     *
     * Retrieves a list of all Library entities.
     * 
     * @return A list of Library entities.
     */
    public List<Library> findAll() {
        return super.findAll("Library.findAll");
    }
}
