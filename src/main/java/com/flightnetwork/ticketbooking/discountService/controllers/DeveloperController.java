package com.flightnetwork.ticketbooking.discountService.controllers;


import com.flightnetwork.ticketbooking.discountService.services.DevelopmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "discount/dev")
public class DeveloperController {

    @Autowired
    private DevelopmentService developmentService;

    @PostMapping(value = "/upload")
    public void uploadDiscountSlabs(@RequestParam("file") MultipartFile uploadedFile) {
        try {
            developmentService.uploadDiscountSlabs(uploadedFile.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("Exception when trying to get input stream from file", e);
        }
    }

}
