/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Andreas
 */
@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Person_ID;
    private String email;
    private String frirstName;
    private String lastName;
    
    @OneToMany(cascade = ALL, mappedBy = "person")
    private List<Phone> phones = new ArrayList<>();
    
    @ManyToMany(cascade = ALL)
    private List<Hobby> hobbies = new ArrayList<>();
    
    @ManyToOne(cascade = ALL)
    private Address adress;

    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void AddPhones(Phone phone) {
        phones.add(phone);
    }
    
    
  

    public Person() {
    }

    public Person(String email, String frirstName, String lastName) {
        this.email = email;
        this.frirstName = frirstName;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFrirstName() {
        return frirstName;
    }

    public void setFrirstName(String frirstName) {
        this.frirstName = frirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    
    
    
    public Integer getId() {
        return Person_ID;
    }

    public void setId(Integer id) {
        this.Person_ID = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Person_ID != null ? Person_ID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the Person_ID fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.Person_ID == null && other.Person_ID != null) || (this.Person_ID != null && !this.Person_ID.equals(other.Person_ID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Person[ id=" + Person_ID + " ]";
    }
    
}
