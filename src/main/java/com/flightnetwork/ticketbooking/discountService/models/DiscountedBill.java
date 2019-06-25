package com.flightnetwork.ticketbooking.discountService.models;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class DiscountedBill {
  private UserType userType;
  private BigDecimal originalBillAmount;
  private BigDecimal discountedBillAmount;
}
