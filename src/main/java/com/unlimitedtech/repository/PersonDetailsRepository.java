/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unlimitedtech.repository;

import com.unlimitedtech.model.PersonDetails;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author magar kamal
 */
@Repository
public interface PersonDetailsRepository extends JpaRepository<PersonDetails, Integer>{
    
    @Query(value = "SELECT IFNULL(MAX(PD_ID), 0)+1 FROM PERSON_DETAILS ", nativeQuery = true)
    int findNextId();
    
    @Query(value = "SELECT * FROM PERSON_DETAILS WHERE QUALIFIED_OR_DISQUALIFIED ='qualified'", nativeQuery = true)
    public List<PersonDetails> findQualifiedPersonDetails();
    
    @Query(value = "SELECT * FROM PERSON_DETAILS WHERE QUALIFIED_OR_DISQUALIFIED ='disqualified'", nativeQuery = true)
    public List<PersonDetails> findDisqualifiedPersonDetails();
    
    @Query(value = "SELECT * FROM PERSON_DETAILS WHERE SCANNED_BY =?1", nativeQuery = true)
    public List<PersonDetails> findScannedByPersonDetails(String scannedName);
    
    @Query(value = "SELECT SCANNED_BY FROM PERSON_DETAILS GROUP BY SCANNED_BY", nativeQuery = true)
    public List findGroupScannedBy();
    
    @Query(value = "SELECT PERSON_INFO_ID FROM PERSON_DETAILS WHERE SCANNED_BY =?1", nativeQuery = true)
    List findIsScannedBy(String scannedName);
     
    
}
