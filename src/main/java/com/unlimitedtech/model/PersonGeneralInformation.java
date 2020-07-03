/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unlimitedtech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author magar kamal
 */
@Entity
@Table(name = "PERSON_GENERAL_INFORMATION")
public class PersonGeneralInformation {

    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "MIDDLE_INITIAL")
    private String middleInitial;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "EMAIL2")
    private String email2;
 
    @OneToOne(mappedBy = "personGeneralInformation")
    private PersonDetails personaDetails;
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public PersonDetails getPersonaDetails() {
        return personaDetails;
    }

    public void setPersonaDetails(PersonDetails personaDetails) {
        this.personaDetails = personaDetails;
    }

    @Override
    public String toString() {
        return "PersonGeneralInformation{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleInitial=" + middleInitial + ", email=" + email + ", email2=" + email2 + ", personaDetails=" + personaDetails + '}';
    }
   

}
