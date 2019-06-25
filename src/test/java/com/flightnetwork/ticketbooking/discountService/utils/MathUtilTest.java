package com.flightnetwork.ticketbooking.discountService.utils;

import org.junit.Test;

import java.math.BigDecimal;

import static com.flightnetwork.ticketbooking.discountService.utils.MathUtil.percentageOf;
import static org.junit.Assert.assertEquals;

public class MathUtilTest {

    @Test
    public void shouldReturnProperPercentageOfValue() {
        assertEquals(0, BigDecimal.valueOf(25).compareTo(percentageOf(BigDecimal.valueOf(25), BigDecimal.valueOf(100))));
        assertEquals(0, BigDecimal.valueOf(1).compareTo(percentageOf(BigDecimal.valueOf(10), BigDecimal.valueOf(10))));
        assertEquals(0, BigDecimal.valueOf(12.5).compareTo(percentageOf(BigDecimal.valueOf(25), BigDecimal.valueOf(50))));
        assertEquals(0, BigDecimal.valueOf(7.5).compareTo(percentageOf(BigDecimal.valueOf(30), BigDecimal.valueOf(25))));
    }
}