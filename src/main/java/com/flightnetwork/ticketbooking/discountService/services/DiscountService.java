package com.flightnetwork.ticketbooking.discountService.services;

import com.flightnetwork.ticketbooking.discountService.domains.DiscountSlab;
import com.flightnetwork.ticketbooking.discountService.models.DiscountedBill;
import com.flightnetwork.ticketbooking.discountService.models.UserType;
import com.flightnetwork.ticketbooking.discountService.repositories.DiscountSlabsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static com.flightnetwork.ticketbooking.discountService.utils.MathUtil.percentageOf;

@Service
public class DiscountService {

  @Autowired
  private DiscountSlabsRepository discountSlabsRepository;

  public DiscountedBill getDiscountedBill(UserType userType, BigDecimal amount) {
    List<DiscountSlab> discountSlabs = discountSlabsRepository.findByUserTypeAndStartAmountLessThanEqualOrderByEndAmount(userType, amount);
    BigDecimal totalDiscount = discountSlabs.stream()
            .map(discountSlab -> percentageOf(discountSlab.getDiscountPercentage(), amountWithinTheSlab(amount, discountSlab)))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    BigDecimal finalBillAmount = amount.subtract(totalDiscount);
    return new DiscountedBill(userType, amount, finalBillAmount);
  }

  private BigDecimal amountWithinTheSlab(BigDecimal amount, DiscountSlab discountSlab) {
    BigDecimal endAmountFallingInSlab = amount.min(discountSlab.getEndAmount());
    return endAmountFallingInSlab.subtract(discountSlab.getStartAmount());
  }
}
