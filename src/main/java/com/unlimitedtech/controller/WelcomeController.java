/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unlimitedtech.controller;

import com.unlimitedtech.repository.PersonDetailsRepository;
import com.unlimitedtech.repository.PersonGeneralInformationRepository;
import com.unlimitedtech.services.PersonInfoService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author magar kamal
 */
@Controller
public class WelcomeController {

    @Autowired
    private PersonInfoService service;

    @Autowired
    private PersonGeneralInformationRepository repository;

    @Autowired
    private PersonDetailsRepository repository1;

    @RequestMapping("/")
    public String welcomepage() throws IOException {
        service.readData();
        return "redirect:/all";

    }

    @RequestMapping("/all")
    public String showAll(Model model) {

        model.addAttribute("generalInfo", service.getPersonGeneralInfoList());
        model.addAttribute("detailsInfo", service.getPersonDetailsList());
        return "findAll";
    }
    
    
    @RequestMapping("/qualifiedcheck")
    public String qualifiedPersonList(Model model, String condition) {

        System.out.println("condition:" + condition);
        if (condition.equalsIgnoreCase("qualified")) {
            model.addAttribute("generalInfo", service.getQualifiedPersonGeneral());
            model.addAttribute("detailsInfo", service.getQualifiedPersonDetails());

        } else {
            model.addAttribute("generalInfo", service.getDisqualifiedPersonGeneral());
            model.addAttribute("detailsInfo", service.getDisqualifiedPersonDetails());
        }

        return "findAll";

    }
    
    @RequestMapping("/scannedby")
    public String scannedByList(Model model){
            
        model.addAttribute("detailsInfo", service.getScannedByList());
        return "scannedby";
    }
    
     @RequestMapping("/listall")
    public String listAllScannedInfo(Model model,String scannedby){
         System.out.println("scannedby:"+scannedby);
         System.out.println("generalsize:"+service.getScannedByGeneral(scannedby).size());    
       model.addAttribute("generalInfo", service.getScannedByGeneral(scannedby));
        model.addAttribute("detailsInfo", service.getScannedByDetails(scannedby));
         System.out.println("detailsize:"+service.getScannedByDetails(scannedby).size()); 
        return "findAll";
    }
    

}
