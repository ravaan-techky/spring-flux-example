package com.ravaan.techky.spring.flux.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ravaan.techky.spring.flux.demo.dto.Customer;
import com.ravaan.techky.spring.flux.demo.service.CustomerService;

import reactor.core.publisher.Flux;

/**
 * The Class CustomerController.
 */
@RestController
public class CustomerController {

	/** The customer service. */
	@Autowired
	CustomerService customerService;

	/**
	 * Gets the customers.
	 *
	 * @return the customers
	 */
	@GetMapping("/api/customers")
	public List<Customer> getCustomers() {
		return this.customerService.getAllCustomer();
	}
	
	@GetMapping(value = "/api/customers/stream", produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
	public Flux<Customer> getCustomerWithStreamMedia() {
		return this.customerService.getAllCustomerForStreamMedia();
	}
}
