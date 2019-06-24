package com.flightnetwork.ticketbooking.discountService.controllers;


import com.flightnetwork.ticketbooking.discountService.services.DevelopmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;

@RestController
@RequestMapping(value = "discount/dev")
public class DeveloperController {

  @Autowired
  private DevelopmentService developmentService;

  @PostMapping(value = "/upload", consumes = MediaType)
  public void uploadDiscountSlabs(@RequestBody InputStream inputStream) {
    developmentService.uploadDiscountSlabs(inputStream);
  }

}
