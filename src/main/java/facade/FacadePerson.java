/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import entity.PersonDTO;
import errorhandling.PersonNotFoundException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

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
    public PersonDTO getPersonByPhone(int number) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<PersonDTO> query = em.createQuery("SELECT new entity.PersonDTO(p.firstName, p.lastName, p.email) FROM Person p JOIN p.phones k WHERE k.number = :number" , PersonDTO.class);
            query.setParameter("number", number);
            PersonDTO person = query.getSingleResult();
            em.getTransaction().commit();
            return person;
        } finally {
            em.close();
        }

    }

    @Override
    public List<PersonDTO> getPersonWithHobby(String hobbyName) {
        EntityManager em = emf.createEntityManager();
        List<PersonDTO> persons = null;
        try {
            em.getTransaction().begin();
            TypedQuery<PersonDTO> query = em.createQuery("SELECT NEW entity.PersonDTO(p.firstName, p.lastName, p.email) FROM Hobby.hobbyName =" + hobbyName, PersonDTO.class);
            persons = query.getResultList();
            em.getTransaction().commit();
            return persons;
        } finally {
            em.close();
        }
    }

    @Override
    public List<PersonDTO> getAllPersonsByZip(int zipCode) {
        EntityManager em = emf.createEntityManager();
        List<PersonDTO> persons = null;
        try {
            em.getTransaction().begin();
            TypedQuery<PersonDTO> query = em.createQuery("SELECT NEW entity.PersonDTO(p.firstName, p.lastName, p.email) FROM Person p WHERE CityInfo.zipCode =" + zipCode, PersonDTO.class);
            persons = query.getResultList();
            em.getTransaction().commit();
            return persons;
        } finally {
            em.close();
        }
    }

    @Override
    public int getNumberOfPersonWithHobby(String hobbyName) {
        EntityManager em = emf.createEntityManager();
        int personCount = 0;
        List<PersonDTO> persons = null;
        try {
            em.getTransaction().begin();
            TypedQuery<PersonDTO> query = em.createQuery("SELECT NEW entity.PersonDTO(p.firstName, p.lastName, p.email) FROM Hobby.hobbyName =" + hobbyName, PersonDTO.class);
            persons = query.getResultList();
            em.getTransaction().commit();
            for (int i = 0; i < persons.size(); i++) {
                personCount++;

            }
            return personCount;
        } finally {
            em.close();
        }
    }

    @Override
    public Person addPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } 
        catch (Exception e) {
            throw new PersonNotFoundException("Person not found.");
        } 
        finally {
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
    public void deletePerson(Person person) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(person);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw new PersonNotFoundException("Person not found");
        } finally {
            em.close();
        }
    }

}
