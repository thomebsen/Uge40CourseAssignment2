/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import entity.PersonDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andreas
 */
public class FacadePersonTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("putest");
    EntityManager em = emf.createEntityManager();

    public FacadePersonTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getPersonByPhone method, of class FacadePerson.
     */
    @Test
    public void testGetPersonByPhone() {
        System.out.println("getPersonByPhone");
        String number = "42676936";
        FacadePerson instance = new FacadePerson(emf);
        String expResult = "Andreas";
        String result = instance.getPersonByPhone(number).getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPersonWithHobby method, of class FacadePerson.
     */
    @Test
    public void testGetPersonWithHobby() {
        System.out.println("getPersonWithHobby");
        String hobbyName = "Gladiator";
        FacadePerson instance = new FacadePerson(emf);
        // List<PersonDTO> expResult = new ArrayList<>();
        List<PersonDTO> result = instance.getPersonWithHobby(hobbyName);
        assertThat(result.size(), is(2));
    }

    /**
     * Test of getAllPersonsByZip method, of class FacadePerson.
     */
    @Test
    public void testGetAllPersonsByZip() {
        System.out.println("getAllPersonsByZip");
        String zipCode = "2620";

        FacadePerson instance = new FacadePerson(emf);
        int expResult = 0;
        List<PersonDTO> result = instance.getAllPersonsByZip(zipCode);
        //  int result = Array.size();
        assertTrue(expResult < result.size());
    }

    /**
     * Test of getNumberOfPersonWithHobby method, of class FacadePerson.
     */
    @Test
    public void testGetNumberOfPersonWithHobby() {
        System.out.println("getNumberOfPersonWithHobby");
        String hobbyName = "Football";
        FacadePerson instance = new FacadePerson(emf);
        int expResult = 2;
        int result = instance.getNumberOfPersonWithHobby(hobbyName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testgetPersonById() {
        System.out.println("getPersonById");
        int personid = 1;
        FacadePerson instance = new FacadePerson(emf);
        String expResult = instance.getPersonByPhone("42676936").getFirstName();
        String result = instance.getPersonById(personid).getFirstName();
        assertEquals(result, expResult);

    }

    @Test
    public void testgetPersonHobbies() {
        System.out.println("getPersonHobbies");
        int personid = 1;
        FacadePerson instance = new FacadePerson(emf);

        PersonDTO result = instance.getPersonHobbies(personid);
        assertNotNull(result);

    }

    // getPersonById
    /**
     * Test of addPerson method, of class FacadePerson.
     */
//  @Test
//    public void testAddPerson() {
//        FacadePerson instance = new FacadePerson(emf);
//        System.out.println("addPerson");
//        Person person = new Person("jojojojojjo", "kk", "kk");   
//       instance.addPerson(person);
//        PersonDTO expResult = instance.getPersonById(5);
//        boolean result = false;
//        if(expResult !=null){
//            result = true;
//        }
//        assertTrue(result);  
//    }
//
//    /**
//     * Test of editPerson method, of class FacadePerson.
//     */
//    @Test
//    public void testEditPerson() {
//        System.out.println("editPerson");
//        PersonDTO person = null;
//        String newName = "";
//        FacadePerson instance = null;
//        PersonDTO expResult = null;
//        PersonDTO result = instance.editPerson(person, newName);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deletePerson method, of class FacadePerson.
//     */
//    @Test
//    public void testDeletePerson() {
//        System.out.println("deletePerson");
//        Person person = null;
//        FacadePerson instance = null;
//        instance.deletePerson(person);
//       
//    }
}
