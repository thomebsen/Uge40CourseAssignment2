/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Andreas
 */
@Entity
public class Hobby implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String hobbyName;
    private String description;

    @ManyToMany(mappedBy = "hobbies")
    private List<Person> persons = new ArrayList();

    public Hobby() {
    }

    public Hobby(String hobbyName, String description) {
        this.hobbyName = hobbyName;
        this.description = description;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void addPersons(Person person) {
        persons.add(person);

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
        return "Hobby{" + "hobbyName=" + hobbyName + ", description=" + description + ", persons=" + persons + '}';
    }

}
