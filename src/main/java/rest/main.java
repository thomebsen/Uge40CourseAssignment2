/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entity.Address;
import entity.Person;
import entity.PersonDTO;
import facade.FacadePerson;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author thoma
 */
public class main {

    public static void main(String[] args) {

        //Oliver tests:
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        FacadePerson fp = new FacadePerson(emf);
        PersonDTO personDTO = new PersonDTO();
        Person person = new Person();
        Address address = new Address("Westside", "This is my homeboy jimmy D's address");

        person.setFrirstName("Jajeet");
        person.setLastName("Jones");
        person.setEmail("test@test1.dk");
        
        person.setAdress(address);

        fp.addPerson(person);

    }

}
