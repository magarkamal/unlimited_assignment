/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unlimitedtech.repository;

import com.unlimitedtech.model.PersonGeneralInformation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author magar kamal
 */
@Repository
public interface PersonGeneralInformationRepository extends JpaRepository<PersonGeneralInformation,Integer>{
    
    

    @Query(value = "SELECT IFNULL(MAX(ID), 0)+1 FROM PERSON_GENERAL_INFORMATION ", nativeQuery = true)
    int findNextId();
    
    
    @Query(value = "SELECT * FROM PERSON_GENERAL_INFORMATION WHERE ID IN (SELECT PD_ID FROM PERSON_DETAILS WHERE QUALIFIED_OR_DISQUALIFIED ='qualified')", nativeQuery = true)
    public List<PersonGeneralInformation> findQualifiedGeneral();
    
    @Query(value = "SELECT * FROM PERSON_GENERAL_INFORMATION WHERE ID IN (SELECT PD_ID FROM PERSON_DETAILS WHERE QUALIFIED_OR_DISQUALIFIED ='disqualified')", nativeQuery = true)
    public List<PersonGeneralInformation> findDisqualifiedGeneral();
    
    @Query(value = "SELECT * FROM PERSON_GENERAL_INFORMATION WHERE ID =?1", nativeQuery = true)
    public List<PersonGeneralInformation> findScannedByGeneral(int ids);
    
}
