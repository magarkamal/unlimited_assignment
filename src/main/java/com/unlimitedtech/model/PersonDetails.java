/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unlimitedtech.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author magar kamal
 */
@Entity
@Table(name = "PERSON_DETAILS")
public class PersonDetails {
    
    @Id
    @Column(name = "PD_ID")
    private int pdId;
    @Column(name = "EVENT_NAME")
    private String eventName;
    @Column(name = "SCANNED_DATE")
    private String scannedDate;
    @Column(name = "SCANNED_TIME")
    private String scannedTime;
    @Column(name = "COMPANY")
    private String company;
    @Column(name = "JOB_TITLE")
    private String jobTitle;
    @Column(name = "ADDRESS1")
    private String address1;
    @Column(name = "ADDRESS2")
    private String address2;
    @Column(name = "ADDRESS3")
    private String address3;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE_ID")
    private String stateId;
    @Column(name = "ZIP")
    private String zip;
    @Column(name = "COUNTRY_ID")
    private String countryId;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "PHONE_NUMBER2")
    private String phoneNumber2;
    @Column(name = "FAX_NUMBER")
    private String faxNumber;
    @Column(name = "QUESTION")
    private String question;
    @Column(name = "RESPONSE")
    private String response;
    @Column(name = "NOTE")
    private String note;
    @Column(name = "COLLATERAL")
    private String collateral;
    @Column(name = "QUALIFIED_OR_DISQUALIFIED")
    private String qualifiedOrDisqualified;
    @Column(name = "SCANNED_BY")
    private String scannedBy;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="PERSON_INFO_ID",referencedColumnName = "ID")
    private PersonGeneralInformation personGeneralInformation;

    public int getPdId() {
        return pdId;
    }

    public void setPdId(int pdId) {
        this.pdId = pdId;
    }

    

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getScannedDate() {
        return scannedDate;
    }

    public void setScannedDate(String scannedDate) {
        this.scannedDate = scannedDate;
    }

    public String getScannedTime() {
        return scannedTime;
    }

    public void setScannedTime(String scannedTime) {
        this.scannedTime = scannedTime;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCollateral() {
        return collateral;
    }

    public void setCollateral(String collateral) {
        this.collateral = collateral;
    }

    public String getQualifiedOrDisqualified() {
        return qualifiedOrDisqualified;
    }

    public void setQualifiedOrDiqualified(String qualifiedOrDisqualified) {
        this.qualifiedOrDisqualified = qualifiedOrDisqualified;
    }

    public String getScannedBy() {
        return scannedBy;
    }

    public void setScannedBy(String scannedBy) {
        this.scannedBy = scannedBy;
    }

    public PersonGeneralInformation getPersonGeneralInformation() {
        return personGeneralInformation;
    }

    public void setPersonGeneralInformation(PersonGeneralInformation personGeneralInformation) {
        this.personGeneralInformation = personGeneralInformation;
    }

    @Override
    public String toString() {
        return "PersonDetails{" + "pdId=" + pdId + ", eventName=" + eventName + ", scannedDate=" + scannedDate + ", scannedTime=" + scannedTime + ", company=" + company + ", jobTitle=" + jobTitle + ", address1=" + address1 + ", address2=" + address2 + ", address3=" + address3 + ", city=" + city + ", stateId=" + stateId + ", zip=" + zip + ", countryId=" + countryId + ", phoneNumber=" + phoneNumber + ", phoneNumber2=" + phoneNumber2 + ", faxNumber=" + faxNumber + ", question=" + question + ", response=" + response + ", note=" + note + ", collateral=" + collateral + ", qualifiedOrDisqualified=" + qualifiedOrDisqualified + ", scannedBy=" + scannedBy + ", personGeneralInformation=" + personGeneralInformation + '}';
    }

   

    
    
    
}
