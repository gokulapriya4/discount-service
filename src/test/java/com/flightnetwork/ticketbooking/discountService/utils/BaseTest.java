package com.flightnetwork.ticketbooking.discountService.utils;

import com.flightnetwork.ticketbooking.discountService.domains.DiscountSlab;
import com.flightnetwork.ticketbooking.discountService.repositories.DiscountSlabsRepository;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static com.flightnetwork.ticketbooking.discountService.models.UserType.PREMIUM;
import static com.flightnetwork.ticketbooking.discountService.models.UserType.STANDARD;

public class BaseTest {

    @Autowired
    public DiscountSlabsRepository discountSlabsRepository;

    @Before
    public void cleanUp() {
        discountSlabsRepository.deleteAll();
    }

    public void addDiscountSlabsTestData() {
        discountSlabsRepository.save(new DiscountSlab(STANDARD, BigDecimal.valueOf(1000), BigDecimal.valueOf(3000), BigDecimal.valueOf(10)));
        discountSlabsRepository.save(new DiscountSlab(STANDARD, BigDecimal.valueOf(3000), BigDecimal.valueOf(5000), BigDecimal.valueOf(15)));
        discountSlabsRepository.save(new DiscountSlab(STANDARD, BigDecimal.valueOf(5000), BigDecimal.valueOf(999999), BigDecimal.valueOf(20)));

        discountSlabsRepository.save(new DiscountSlab(PREMIUM, BigDecimal.valueOf(500), BigDecimal.valueOf(1000), BigDecimal.valueOf(10)));
        discountSlabsRepository.save(new DiscountSlab(PREMIUM, BigDecimal.valueOf(1000), BigDecimal.valueOf(3000), BigDecimal.valueOf(15)));
        discountSlabsRepository.save(new DiscountSlab(PREMIUM, BigDecimal.valueOf(3000), BigDecimal.valueOf(5000), BigDecimal.valueOf(20)));
        discountSlabsRepository.save(new DiscountSlab(PREMIUM, BigDecimal.valueOf(5000), BigDecimal.valueOf(999999), BigDecimal.valueOf(25)));
    }
}

