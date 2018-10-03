/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.PersonDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Oliver
 */
public class FacadePerson implements FacadePersonInterface {

    EntityManagerFactory emf;

    public FacadePerson(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public PersonDTO getPersonByPhone(String number) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            PersonDTO person = em.find(PersonDTO.class, number); //Måske dette skal være PersonDTO..
            em.getTransaction().commit();
            return person;
        } finally {
            em.close();
        }
        
    }

    @Override
    public List<PersonDTO> getPersonWithHobby(String hobbyName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonDTO> getAllPersonsByZip(int zipCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumberOfPersonWithHobby(String hobbyName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonDTO addPerson(PersonDTO person) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return person;
    }

    @Override
    public PersonDTO editPerson(PersonDTO person) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return person;
    }

    @Override
    public void deletePerson(PersonDTO person) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
