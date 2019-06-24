package com.flightnetwork.ticketbooking.discountService.controllers;

import com.flightnetwork.ticketbooking.discountService.models.DiscountedBill;
import com.flightnetwork.ticketbooking.discountService.models.UserType;
import com.flightnetwork.ticketbooking.discountService.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "discount")
public class DiscountController {

  @Autowired
  private DiscountService discountService;

  @GetMapping(value = "/userType/{userType}/amount/{amount}")
  public DiscountedBill getDiscountedPrice(@PathVariable("userType") UserType userType, @PathVariable("amount") BigDecimal amount) {
    return discountService.getDiscountedBill(userType, amount);
  }

}
