package com.flightnetwork.ticketbooking.discountService.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DiscountedBill {
  private UserType userType;
  private BigDecimal originalBillAmount;
  private BigDecimal discountedBillAmount;
}
