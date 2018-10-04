/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import entity.PersonDTO;
import java.util.List;

/**
 *
 * @author Oliver
 */
public interface FacadePersonInterface {
    public PersonDTO getPersonByPhone(String number);
    public List<PersonDTO> getPersonWithHobby(String hobbyName);
    public List<PersonDTO> getAllPersonsByZip(String zipCode);
    public int getNumberOfPersonWithHobby(String hobbyName);
    public Person addPerson(Person person);
    public PersonDTO editPerson(PersonDTO person);
    public void deletePerson(Person person);
    public PersonDTO getPersonHobbies(Integer id);
}
