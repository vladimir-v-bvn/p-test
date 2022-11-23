package com.vber.ptest.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vber.ptest.model.Order;
import com.vber.ptest.repository.OrderRepository;

@RestController
@RequestMapping(value = "/")
public class OrderController {
  
  private static final Logger logger = LoggerFactory.getLogger(OrderController.class); 
  
  private final OrderRepository orderRepository;
  public OrderController(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }
  
  @RequestMapping(value = "", method = RequestMethod.GET)
  public List<Order> getAllUsers() {
    logger.info("Getting all users.");
    return orderRepository.findAll();
  }

  @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
  public Optional<Order> getOrder(@PathVariable String orderId) {
    logger.info("Getting order with ID: {}.", orderId);
    return Optional.ofNullable(orderRepository.findById(orderId)).orElseThrow(IllegalArgumentException::new);
  }
  
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public Order addNewOrder(@RequestBody Order order) {

//    Order orderTest = new Order();
//    orderTest.setOrderId("9");
//    orderTest.setUserId("9");
//    orderTest.setOrderAmount(900);
//    logger.info("Saving test order.");
//    orderRepository.save(orderTest);

    logger.info("Saving order.");
    return orderRepository.save(order);
  }  

}
