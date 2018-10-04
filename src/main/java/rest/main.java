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
import facade.FacadeCityInfo;
import facade.FacadePerson;
import java.util.List;
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
        FacadeCityInfo fc = new FacadeCityInfo(emf);

        //System.out.println("All zipCodes: " + fc.getAllZipCodes());
        
        
        System.out.println("Get by phone: " + fp.getPersonByPhone("12345678").getFirstName());
        
        
        person3.addPhones(phone1);
        
        Hobby hobby = new Hobby("Gaming", "Game games, for fun games");
        Hobby hobby2 = new Hobby("Gamingfsdfsdsfs", "Gamesfdsfds games, forsdfdssf fun sdfdsfgames");
        Hobby hobby3 = new Hobby("rrrrrrr", "scription");
        
        hobby3.addPersons(person3);
       
        em.getTransaction().begin();
        em.persist(hobby3);
        em.getTransaction().commit();

      //  System.out.println(person.getHobbies().size());

    }

}
