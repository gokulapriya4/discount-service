package com.flightnetwork.ticketbooking.discountService.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flightnetwork.ticketbooking.discountService.models.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "discount_slabs")
@NoArgsConstructor
@Getter
public class DiscountSlab {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_type")
  @Enumerated(EnumType.STRING)
  @JsonProperty(value = "user_type")
  private UserType userType;

  @Column(name = "start_amount")
  @JsonProperty(value = "start_amount")
  private BigDecimal startAmount;

  @Column(name = "end_amount")
  @JsonProperty(value = "end_amount")
  private BigDecimal endAmount;

  @Column(name = "discount_percentage")
  @JsonProperty(value = "discount_percentage")
  private BigDecimal discountPercentage;

}
