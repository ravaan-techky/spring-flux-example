package com.ravaan.techky.spring.flux.demo.service.impl;

import java.time.Instant;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravaan.techky.spring.flux.demo.dao.CustomerRepository;
import com.ravaan.techky.spring.flux.demo.dto.Customer;
import com.ravaan.techky.spring.flux.demo.service.CustomerService;

import reactor.core.publisher.Flux;

/**
 * The Class CustomerServiceImpl.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

	/** The customer repository. */
	@Autowired
	CustomerRepository customerRepository;

	/**
	 * Gets the all customer.
	 *
	 * @return the all customer
	 */
	@Override
	public List<Customer> getAllCustomer() {
		Instant start = Instant.now();
		List<Customer> customerList = customerRepository.getAllCustomer();
		Instant end = Instant.now();
		LOGGER.info("Total Execution Time -> " + (end.toEpochMilli() - start.toEpochMilli()));
		return customerList;
	}

	/**
	 * Gets the all customer for stream media.
	 *
	 * @return the all customer for stream media
	 */
	@Override
	public Flux<Customer> getAllCustomerForStreamMedia() {
		Instant start = Instant.now();
		Flux<Customer> customerList = customerRepository.getAllCustomerForStreamMedia();
		Instant end = Instant.now();
		LOGGER.info("Total Execution For Stream Media Time -> " + (end.toEpochMilli() - start.toEpochMilli()));
		return customerList;
	}

}
