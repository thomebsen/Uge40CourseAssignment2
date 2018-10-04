/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oliver
 */
public class PersonDTO {
    
    private String firstName;
    private String lastName;
    private String email;
    
    //Address
    private String street;
    private String city;
    
    //CityInfo
    private String zipCode;
    
    //Hobby
    private List<Hobby> hobbies;
    private String hobby;
    
    
    //Phone
    private List<Phone> phones;
    

    public PersonDTO() {
        
    }
    
    public PersonDTO(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public PersonDTO(String firstName, String lastName, String email, String street, String city, String zipCode, String hobby) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.hobby = hobby;
    }
    
    

    public PersonDTO(String firstName, String lastName, String email, String street, String city, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    public PersonDTO(String firstName, String lastName, String email, String street, String city, String zipCode, List<Hobby> hobbies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        //this.hobbies = hobbies;
//        for(Hobby hobby: hobbies) {
//            this.hobbies += hobby.getHobbyName() + ", ";
//        }
        
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PersonDTO{" + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", street=" + street + ", city=" + city + ", zipCode=" + zipCode + ", hobbies=" + hobbies + '}';
    }

    
    
}
