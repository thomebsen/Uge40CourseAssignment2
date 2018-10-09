/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entity.Address;
import entity.CityInfo;
import entity.Hobby;
import entity.Person;
import entity.PersonDTO;
import entity.Phone;
import facade.FacadeCityInfo;
import facade.FacadePerson;
import java.util.List;
import javax.persistence.EntityManager;
import facade.FacadeHobby;
import facade.FacadePerson;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author thoma
 */
public class main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        FacadePerson fp = new FacadePerson(emf);
        FacadeCityInfo fc = new FacadeCityInfo(emf);
        FacadeHobby fh = new FacadeHobby(emf);

        System.out.println(fp.getPersonById(4));
        //System.out.println(fp.getPersonWithHobby("Landevejscykling"));
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.email = 'test@2.dk'", Person.class);
//        Person person = query.getSingleResult();
//        System.out.println(person);
//        Address a1 = new Address("Street22", "testSTREET22");
//        CityInfo zipcode = em.find(CityInfo.class, "2830");
//        System.out.println(zipcode.getZipCode());
//        
//        a1.setCityInfo(zipcode);
//        person.setAddress(a1);
//        em.merge(person);
//        
//        em.getTransaction().commit();
    }

}
