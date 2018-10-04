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
        //System.out.println(fp.getPersonWithHobby("Fodbold"));
        //System.out.println(fp.getAllPersonsByZip("2800"));
        //System.out.println(fp.getNumberOfPersonWithHobby("Fodbold"));
        
        System.out.println(fp.getPersonByPhone("12345678"));

    }

}
