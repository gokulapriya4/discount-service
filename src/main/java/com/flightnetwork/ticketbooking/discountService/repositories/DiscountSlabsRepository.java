package com.flightnetwork.ticketbooking.discountService.repositories;

import com.flightnetwork.ticketbooking.discountService.domains.DiscountSlab;
import com.flightnetwork.ticketbooking.discountService.models.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DiscountSlabsRepository extends JpaRepository<DiscountSlab, Long> {
  List<DiscountSlab> findByUserTypeAndStartAmountLessThanEqualOrderByEndAmount(UserType userType, BigDecimal endAmount);
}
