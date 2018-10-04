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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
        EntityManager em = emf.createEntityManager();

        Person person = new Person("AndreasJ54@gmail.com", "2321321Andreas", "Jøgensen");
        Person person2 = new Person("sadhsakjdhsajk", "Asadas", "Jlkasdklas");
        Person person3 = new Person("ggggk", "gggggg", "ggggg");
        Phone phone = new Phone("42676936", "Mobile");
        Phone phone1 = new Phone("9832y983", "Mobile");
        Address address = new Address("Morbærhaven 3-42", "Fedeste hjem");
        
        
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
