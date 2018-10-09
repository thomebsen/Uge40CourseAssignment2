/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Oliver
 */
public class PhoneDTO {
    
    private String email;
    private String number;

    public PhoneDTO() {
    }

    public PhoneDTO(String email, String number) {
        this.email = email;
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PhoneDTO{" + "email=" + email + ", number=" + number + '}';
    }
    
    
}
