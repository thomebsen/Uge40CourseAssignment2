/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Address;
import entity.CityInfo;
import entity.Person;
import entity.PersonDTO;
import entity.Phone;
import errorhandling.PersonNotFoundException;
import errorhandling.InternalException;
import errorhandling.ParamaterNoMatchException;
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
    public PersonDTO getPersonHobbies(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            //"SELECT new entity.PersonDTO(p.firstName, p.lastName, p.email, p.address.street, p.address.cityInfo.city, p.address.cityInfo.zipCode) FROM Person p JOIN p.hobbies h WHERE p.id = :id", PersonDTO.class)
            TypedQuery<PersonDTO> query = em.createQuery("SELECT new entity.PersonDTO(p) FROM Person p WHERE p.id = :id", PersonDTO.class);
            query.setParameter("id", id);
            PersonDTO person = query.getSingleResult();
            em.getTransaction().commit();
            System.out.println("personHobby: " + person);
            return person;
        } finally {
            em.close();
        }
    }

    @Override
    public PersonDTO getPersonById(Integer id) throws PersonNotFoundException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<PersonDTO> query = em.createQuery("SELECT new entity.PersonDTO(p) FROM Person p WHERE p.id = :id", PersonDTO.class);
            query.setParameter("id", id);
            PersonDTO person = query.getSingleResult();
            em.getTransaction().commit();
            return person;

        } catch (Exception e) {
            throw new PersonNotFoundException("Person not found, try entering another ID");
        } finally {
            em.close();
        }
    }

    @Override
    public PersonDTO getPersonByPhone(String number) throws PersonNotFoundException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<PersonDTO> query = em.createQuery("SELECT new entity.PersonDTO(p) FROM Person p JOIN p.phones k WHERE k.number = :number", PersonDTO.class);
            query.setParameter("number", number);
            PersonDTO person = query.getSingleResult();
            em.getTransaction().commit();
            return person;
        } catch (Exception e) {
            throw new PersonNotFoundException("Person not found, please make sure that you entered a correct phonenumber.");
        } finally {
            em.close();
        }

    }

    @Override
    public Person getPersonByEmail(String email) throws PersonNotFoundException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<Person> query = em.createQuery("SELECT new entity.PersonDTO(p) FROM Person p WHERE p.email = :email", Person.class);
            query.setParameter("email", email);
            Person person = query.getSingleResult();
            em.getTransaction().commit();
            return person;
        } catch (Exception e) {
            throw new PersonNotFoundException("Person not found, please make sure that you entered a correct email.");
        } finally {
            em.close();
        }

    }

    @Override
    public List<PersonDTO> getPersonWithHobby(String hobbyName) throws PersonNotFoundException {
        EntityManager em = emf.createEntityManager();
        List<PersonDTO> persons = null;
        try {
            em.getTransaction().begin();
            TypedQuery<PersonDTO> query = em.createQuery("SELECT new entity.PersonDTO(p) FROM Person p JOIN p.hobbies k WHERE k.hobbyName = :hobbyName", PersonDTO.class);
            query.setParameter("hobbyName", hobbyName);
            persons = query.getResultList();
            em.getTransaction().commit();
            return persons;
        } catch (Exception e) {
            throw new PersonNotFoundException("Could not find any user with that hobby.");
        } finally {
            em.close();
        }
    }

    @Override
    public List<PersonDTO> getAllPersonsByZip(String zipCode) throws ParamaterNoMatchException {
        EntityManager em = emf.createEntityManager();
        List<PersonDTO> persons = null;
        try {
            em.getTransaction().begin();
            TypedQuery<PersonDTO> query = em.createQuery("SELECT new entity.PersonDTO(p) FROM Person p JOIN p.address k WHERE k.cityInfo.zipCode = :zipCode", PersonDTO.class);
            query.setParameter("zipCode", zipCode);
            persons = query.getResultList();
            em.getTransaction().commit();
            return persons;
        } finally {
            em.close();
        }
    }

    @Override
    public int getNumberOfPersonWithHobby(String hobbyName) throws PersonNotFoundException {
        EntityManager em = emf.createEntityManager();
        int personCount = 0;
        List<PersonDTO> persons = null;
        try {
            em.getTransaction().begin();
            TypedQuery<PersonDTO> query = em.createQuery("SELECT new entity.PersonDTO(p) FROM Person p JOIN p.hobbies k WHERE k.hobbyName = :hobbyName", PersonDTO.class);
            query.setParameter("hobbyName", hobbyName);
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
    public Person addPerson(Person person) throws InternalException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PersonNotFoundException("Person not found.");
        } finally {
            em.close();
        }

        return person;
    }

    @Override
    public PersonDTO editPerson(PersonDTO person, String newName) throws PersonNotFoundException {
        EntityManager em = emf.createEntityManager();

        person.setFirstName(newName);

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
    public void deletePerson(Person person) throws PersonNotFoundException {
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

    @Override
    public void addPhone(String email, String number) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.email = :email", Person.class);
            query.setParameter("email", email);
            Person person = query.getSingleResult();
            
            Phone phone = new Phone();
            phone.setNumber(number);
            
            person.addPhones(phone);
            em.merge(person);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }
}
