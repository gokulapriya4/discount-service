package com.flightnetwork.ticketbooking.discountService.services;

import com.flightnetwork.ticketbooking.discountService.domains.DiscountSlab;
import com.flightnetwork.ticketbooking.discountService.repositories.DiscountSlabsRepository;
import com.flightnetwork.ticketbooking.discountService.utils.CSVUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class DevelopmentService {

  @Autowired
  private DiscountSlabsRepository discountSlabsRepository;

  public void uploadDiscountSlabs(InputStream inputStream) {
    discountSlabsRepository.deleteAll();
    discountSlabsRepository.saveAll(CSVUtil.loadObjectList(DiscountSlab.class, inputStream));
  }
}
