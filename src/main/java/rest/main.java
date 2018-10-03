/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entity.Address;
import entity.Hobby;
import entity.Person;
import entity.PersonDTO;
import entity.Phone;
import facade.FacadePerson;
import javax.persistence.EntityManager;
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
        EntityManager em = emf.createEntityManager();
        
        
        Person person = new Person("AndreasJ54@gmail.com", "Andreas", "Jøgensen");
        Phone phone = new Phone(42676936, "Mobile");
        Address address = new Address("Morbærhaven 3-42", "Fedeste hjem");
        Hobby hobby = new Hobby("Gaming", "Game games, for fun games");
        
        
        
        
        
        
        
    }
    
}
