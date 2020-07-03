/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unlimitedtech.services;

import com.unlimitedtech.model.PersonDetails;
import com.unlimitedtech.model.PersonGeneralInformation;
import com.unlimitedtech.repository.PersonDetailsRepository;
import com.unlimitedtech.repository.PersonGeneralInformationRepository;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author magar kamal
 */
@Service
public class PersonInfoService {

    @Autowired
    private PersonGeneralInformationRepository personGeneralInformationRepository;

    @Autowired
    private PersonDetailsRepository personDetailsRepository;

    List list = new ArrayList();

    public String readData() {

        String msg = "";
        String file = "src/main/resources/persons.csv";

        if (!personGeneralInformationRepository.findAll().isEmpty() || !personDetailsRepository.findAll().isEmpty()) {

            personGeneralInformationRepository.deleteAll();
            personDetailsRepository.deleteAll();
        }
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String line = null;
            int count = 0;
            String[] header = new String[0];
            String[] body = new String[0];
            while ((line = input.readLine()) != null) {
                if (count == 0) {
                    String[] l = line.split(",");
                    header = new String[l.length];
                    body = new String[l.length];
                    for (int i = 0; i < l.length; i++) {
                        header[i] = l[i];
//                        System.out.println("header:"+header[i]+":i"+l[i]);
                    }
                } else {
                    try {
                        String[] l = line.split(",");

                        for (int j = 0; j < header.length; j++) {
//                       
                            if (l[j] == "") {
                                body[j] = "";
                            } else {
                                body[j] = l[j];
                            }

                        }
                        if (body[16].equalsIgnoreCase("United States")) {
                        PersonGeneralInformation obj1 = new PersonGeneralInformation();
                        PersonDetails obj2 = new PersonDetails();
                        obj1.setId(personGeneralInformationRepository.findNextId());
                        obj1.setFirstName(body[3]);
                        obj1.setMiddleInitial(body[4]);
                        obj1.setLastName(body[5]);
                        obj1.setEmail(body[6]);
                        obj1.setEmail2(body[7]);

                        obj2.setPdId(personDetailsRepository.findNextId());
                        obj2.setAddress1(body[10]);
                        obj2.setAddress2(body[11]);
                        obj2.setAddress3(body[12]);
                        obj2.setCity(body[13]);
                        obj2.setCollateral(body[23]);
                        obj2.setCompany(body[8]);
                        obj2.setCountryId(body[16]);
                        obj2.setEventName(body[0]);
                        obj2.setFaxNumber(body[19]);
                        obj2.setJobTitle(body[9]);
                        obj2.setNote(body[22]);
                        obj2.setPersonGeneralInformation(obj1);
                        obj2.setPhoneNumber(body[17]);
                        obj2.setPhoneNumber2(body[18]);
                        obj2.setQualifiedOrDiqualified(body[24]);
                        obj2.setQuestion(body[20]);
                        obj2.setResponse(body[21]);
                        obj2.setScannedBy(body[25]);
                        obj2.setScannedDate(body[1]);
                        obj2.setScannedTime(body[2]);
                        obj2.setStateId(body[14]);
                        obj2.setZip(body[15]);

                        personGeneralInformationRepository.save(obj1);
                        personDetailsRepository.save(obj2);

                        msg = "success";
                    }
                    } catch (Exception e) {

                    }

                   

                }
                count++;
            }

        } catch (IOException ex) {
            msg = ex.getMessage();
            System.out.println("exp:" + ex.getMessage());
            return msg;
        }

        return msg;
    }

    public List<PersonGeneralInformation> getPersonGeneralInfoList() {

        try {
            list = personGeneralInformationRepository.findAll();
        } catch (Exception e) {
            System.out.println("exp:" + e.getMessage());
        }

        return list;
    }

    public List<PersonDetails> getPersonDetailsList() {

        try {
            list = personDetailsRepository.findAll();
        } catch (Exception e) {
            System.out.println("exp:" + e.getMessage());
        }

        return list;
    }

    public List<PersonDetails> getQualifiedPersonDetails() {

        try {
            list = personDetailsRepository.findQualifiedPersonDetails();
           
        } catch (Exception e) {
            System.out.println("exp:" + e.getMessage());
        }

        return list;
    }

    public List<PersonDetails> getDisqualifiedPersonDetails() {

        try {
            list = personDetailsRepository.findDisqualifiedPersonDetails();
        
        } catch (Exception e) {
            System.out.println("exp:" + e.getMessage());
        }

        return list;
    }

    public List<PersonGeneralInformation> getQualifiedPersonGeneral() {

        try {
            list = personGeneralInformationRepository.findQualifiedGeneral();
         
        } catch (Exception e) {
            System.out.println("exp:" + e.getMessage());
        }

        return list;
    }

    public List<PersonGeneralInformation> getDisqualifiedPersonGeneral() {

        try {
            list = personGeneralInformationRepository.findDisqualifiedGeneral();
          
        } catch (Exception e) {
            System.out.println("exp:" + e.getMessage());
        }
        return personGeneralInformationRepository.findDisqualifiedGeneral();
    }
    
    
    public List getScannedByList() {

        try {
            list = personDetailsRepository.findAll();
           
        } catch (Exception e) {
            System.out.println("exp:" + e.getMessage());
        }

        return list;
    }
    
     public List<PersonDetails> getScannedByGeneral(String scannedName) {
         List<PersonDetails> personDetailsList = new ArrayList<>();
        try {
            List ids = personDetailsRepository.findIsScannedBy(scannedName);
            System.out.println("id:"+ids.size());
            for(int i = 0;i<ids.size();i++){
                System.out.println("id:"+ids.toString());
                list = personGeneralInformationRepository.findScannedByGeneral(Integer.parseInt(ids.toString()));
                personDetailsList.add((PersonDetails) list);
            }
            
           
        } catch (Exception e) {
            System.out.println("exp:" + e.getMessage());
        }

        return personDetailsList;
    }
     
     public List<PersonDetails> getScannedByDetails(String scannedBy) {

        try {
            
            list = personDetailsRepository.findScannedByPersonDetails(scannedBy);
           
        } catch (Exception e) {
            System.out.println("exp:" + e.getMessage());
        }

        return list;
    }
}
