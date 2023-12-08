
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
     *
     */
    MAN("Boy"),

    /**
     *
     */
    WOMAN("Girl");
    
    private String label;

    private StudentGender(String label){
        this.label = label;
    }
    
    /**
     *
     * @return
     */
    public String getLabel() {
        return label;
    }
}
