
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.xkou.domain;

/**
 *
 * @author xiaoh
 */
public enum StudentGender {

    /**
     * Represents male gender with label "Boy".
     */
    MAN("Boy"),

    /**
     * Represents female gender with label "Girl".
     */
    WOMAN("Girl");
    
    private String label;

    private StudentGender(String label){
        this.label = label;
    }
    
    /**
     *
     * Retrieves the label associated with the gender.
     * 
     * @return The text label of this gender.
     */
    public String getLabel() {
        return label;
    }
}
