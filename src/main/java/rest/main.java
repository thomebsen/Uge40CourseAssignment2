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

        Person p = new Person("Jonas@Hegn.dk", "Jonas", "Hegn");
        Person p2 = new Person("Jens2@Hansen", "Jens", "Hansen");
        Hobby h = new Hobby("Maler", "Hamler hegn");
        Address a = new Address("MorbærHaveb", "HejmHejm");
        CityInfo ci = new CityInfo("2620", "Albertslund");
        a.setCityInfo(ci);
        
        p2.setAddress(a);
        
        p2.addHobbies(h);
        em.getTransaction().begin();
        em.merge(p2);
        em.getTransaction().commit();
        
    }
}
