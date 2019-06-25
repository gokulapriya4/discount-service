package com.flightnetwork.ticketbooking.discountService.services;

import com.flightnetwork.ticketbooking.discountService.utils.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static com.flightnetwork.ticketbooking.discountService.models.UserType.PREMIUM;
import static com.flightnetwork.ticketbooking.discountService.models.UserType.STANDARD;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
public class DiscountServiceTest extends BaseTest {

    @Autowired
    private DiscountService discountService;

    @Test
    public void shouldReturnProperDiscountedPrice() {
        addDiscountSlabsTestData();
        assertEquals(0, BigDecimal.valueOf(200).compareTo(discountService.getDiscountedBill(STANDARD, BigDecimal.valueOf(200)).getDiscountedBillAmount()));
        assertEquals(0, BigDecimal.valueOf(1045).compareTo(discountService.getDiscountedBill(STANDARD, BigDecimal.valueOf(1050)).getDiscountedBillAmount()));
        assertEquals(0, BigDecimal.valueOf(3225).compareTo(discountService.getDiscountedBill(STANDARD, BigDecimal.valueOf(3500)).getDiscountedBillAmount()));
        assertEquals(0, BigDecimal.valueOf(5300).compareTo(discountService.getDiscountedBill(STANDARD, BigDecimal.valueOf(6000)).getDiscountedBillAmount()));
        assertEquals(0, BigDecimal.valueOf(50.56).compareTo(discountService.getDiscountedBill(PREMIUM, BigDecimal.valueOf(50.56)).getDiscountedBillAmount()));
        assertEquals(0, BigDecimal.valueOf(1375).compareTo(discountService.getDiscountedBill(PREMIUM, BigDecimal.valueOf(1500)).getDiscountedBillAmount()));
        assertEquals(0, BigDecimal.valueOf(8000).compareTo(discountService.getDiscountedBill(PREMIUM, BigDecimal.valueOf(10000)).getDiscountedBillAmount()));
    }
}