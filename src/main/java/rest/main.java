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
import facade.FacadeHobby;
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
        FacadeHobby fh = new FacadeHobby(emf);
        
        Person p1 = new Person("wau@wa.dk", "Ulla", "Thomsen");
        Phone ph1 = new Phone("12345678", "lal");
        Address a1 = new Address("lyngby", "dlasæ");
        
        CityInfo ci = new CityInfo("2800", "Kongens Lyngby");
        
        Person p2 = new Person("jdkas@asd.dk", "Oliver", "Lyl");
        Phone ph2 = new Phone("22222222", "YEET");
        Address a2 = new Address("Nybrovej 107", "HELL YEAH");
        
        
//        p1.addPhones(ph1);
//        a1.setCityInfo(ci);
//        p1.setAddress(a1);
//        
//        p2.addPhones(ph2);
//        p2.setAddress(a2);
//        a2.setCityInfo(ci);
        
        //fp.addPerson(p1);
        //fp.addPerson(p2);
        
//        Hobby hobby = new Hobby("EDB", "EDB ER BARE HERLIGT");
//        Person person = new Person("lul", "olle", "loye");
//        
//        person.addHobbies(hobby);
//        hobby.addPersons(person);
        //System.out.println(hobby);
        //System.out.println(person.getHobbies().toString());
//        
//        fp.addPerson(person);
        //System.out.println(fp.getPersonById(5));
        System.out.println(fp.getPersonWithHobby("Fodbold"));
        //System.out.println("All zipCodes: " + fc.getAllZipCodes());
        //System.out.println(fp.getPersonWithHobby("Fodbold"));
        //System.out.println(fp.getAllPersonsByZip("2800"));
        //System.out.println(fp.getNumberOfPersonWithHobby("Fodbold"));
        
        //System.out.println(fp.getPersonByPhone("87654321"));
        //System.out.println(fp.getPersonByPhone("42676936"));
        //System.out.println(fp.getPersonHobbies(3));
        
        
        //System.out.println(fh.getHobbies(1));
        
        System.out.println(fp.getPersonByPhone("222222213123"));

    }

}
