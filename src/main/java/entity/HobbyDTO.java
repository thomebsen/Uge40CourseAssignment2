/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Oliver
 */
public class HobbyDTO {
    
    private String hobbyName;
    private String description;
    
    //Person
    private String firstName;
    private String lastName;

    public HobbyDTO() {
    }

    public HobbyDTO(String hobbyName, String description) {
        this.hobbyName = hobbyName;
        this.description = description;
    }

    public HobbyDTO(String hobbyName, String description, String firstName, String lastName) {
        this.hobbyName = hobbyName;
        this.description = description;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "HobbyDTO{" + "hobbyName=" + hobbyName + ", description=" + description + '}';
    }
    
}
