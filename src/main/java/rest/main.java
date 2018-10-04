/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entity.Address;
import entity.CityInfo;
import entity.Person;
import entity.PersonDTO;
import entity.Phone;
import facade.FacadeCityInfo;
import facade.FacadePerson;
import java.util.List;
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
        FacadePerson fp = new FacadePerson(emf);

        
        Person p = new Person("Andreas@Gmail.com", "Andreas", "Jørgensen");
        Phone phone = new Phone("42676936", "Mobil");
        
        
        p.addPhones(phone);
        
        em.getTransaction().begin();
        em.persist(p);
        
        em.getTransaction().commit();
        
        
        fp.getPersonByPhone("42676936");

        
        
        

    }
}
