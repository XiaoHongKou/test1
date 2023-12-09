/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

/**
 *
 * @author xiaoh
 */
@Entity
@NamedQuery(name = "Library.findAll", query = "select li from Library li")
public class Library {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LIB_ID")
    private Long id;

    private String name;

    /**
     * Default constructor for creating an empty Library instance.
     */
    public Library() {
    }

    /**
     *
     * @param name The name of the library.
     */
    public Library(String name) {
        this.name = name;
    }

    
    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the unique identifier of the library.
     * 
     * @return The ID of the library.
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id set library id
     */
    public void setId(Long id) {
        this.id = id;
    }

}
