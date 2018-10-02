/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import java.util.List;

/**
 *
 * @author Oliver
 */
public interface FacadePersonInterface {
    public Person getPersonByPhone(String number);
    public List<Person> getPersonWithHobby(String hobbyName);
    public List<Person> getAllPersonsByZip(int zipCode);
    public int getNumberOfPersonWithHobby(String hobbyName);
    public Person addPerson(Person person);
    public Person editPerson(Person person);
    public Person deletePerson(Person person);
}
