package com.flightnetwork.ticketbooking.discountService;

import java.math.BigDecimal;

public class MathUtil {

  public static BigDecimal percentageOf(BigDecimal percentage, BigDecimal value) {
    return value.multiply(percentage).multiply(BigDecimal.valueOf(0.01));
  }

}
