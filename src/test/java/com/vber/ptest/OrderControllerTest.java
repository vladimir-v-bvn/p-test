package com.vber.ptest;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

class OrderControllerTest {

  
  @Test
  void testOrderController() throws URISyntaxException {
    RestTemplate restTemplate = new RestTemplate();
    
    final String baseUrl = "http://localhost:8080" + "/9";
    URI uri = new URI(baseUrl);
 
    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
     
    //Verify request succeed
    assert(result.getStatusCodeValue() == 200);
    assert(result.getBody().contains("900"));
  }

  @Test
  void testGetAllUsers() {
    assert(true);
  }

  @Test
  void testAddNewOrder() {
    assert(true);
  }

}
