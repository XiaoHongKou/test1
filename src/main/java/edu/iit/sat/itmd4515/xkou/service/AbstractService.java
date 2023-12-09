/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * Abstract service class providing common persistence operations for a specific entity type.
 * 
 * @author xiaoh
 * @param <T> The type of the entity this service works with.
 */
public abstract class AbstractService<T> {
    
    @PersistenceContext(name = "itmd4515PU")
    protected EntityManager em;
    
    protected Class<T> entityClass;

    /**
     * Constructor initializing with a specific entity class.
     * 
     * @param entityClass The class type of the entity this service handles.
     */
    protected AbstractService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    /**
     *
     * Persists the given entity into the database.
     * 
     * @param entity The entity to be persisted.
     */
    public void create(T entity) {
        em.persist(entity);
    }    

    /**
     *
     * Finds an entity by its ID.
     * 
     * @param id The ID of the entity to find.
     * @return The found entity or null if the entity is not found.
     */
    public T read(Long id) {
        return em.find(entityClass, id);
    }

    /**
     * Updates the given entity in the database.
     * 
     * @param entity The entity to be updated.
     */
    public void update(T entity) {
        em.merge(entity);
    }

    /**
     * Removes the given entity from the database.
     * 
     * @param entity The entity to be removed.
     */
    public void delete(T entity) {
        em.remove(em.merge(entity));
    }
    
    /**
     *
     * Retrieves a list of all entities of type T.
     * 
     * @param namedQueryName The name of the named query to execute.
     * @return A list of entities of type T.
     */
    protected List<T> findAll(String namedQueryName) {
        return em.createNamedQuery(namedQueryName, entityClass).getResultList();
    }
    
}
