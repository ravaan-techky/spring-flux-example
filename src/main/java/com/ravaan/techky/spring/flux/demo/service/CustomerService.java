package com.ravaan.techky.spring.flux.demo.service;

import java.util.List;

import com.ravaan.techky.spring.flux.demo.dto.Customer;

import reactor.core.publisher.Flux;

/**
 * The Interface CustomerService.
 */
public interface CustomerService {

	/**
	 * Gets the all customer.
	 *
	 * @return the all customer
	 */
	public List<Customer> getAllCustomer();

	/**
	 * Gets the all customer for stream media.
	 *
	 * @return the all customer for stream media
	 */
	public Flux<Customer> getAllCustomerForStreamMedia();
}
