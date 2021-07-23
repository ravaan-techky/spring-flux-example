package com.ravaan.techky.spring.flux.demo.dao;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ravaan.techky.spring.flux.demo.dto.Customer;

import reactor.core.publisher.Flux;

/**
 * The Class CustomerRepository.
 */
@Component
public class CustomerRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRepository.class);

	/** The customer list. */
	private List<Customer> customerList;

	/**
	 * Instantiates a new customer repository.
	 */
	public CustomerRepository() {
		// DUMMY
	}

	/**
	 * Gets the all customer.
	 *
	 * @return the all customer
	 */
	public List<Customer> getAllCustomer() {
		customerList = IntStream.rangeClosed(1, 50).peek(index -> {
			try {
				Thread.sleep(200);
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}).peek(index -> LOGGER.debug("Fetching customer object for index " + index)).mapToObj(index -> {
			return new Customer(index, "Customer-" + index, "Address-" + index);
		}).collect(Collectors.toList());
		return this.customerList;
	}

	/**
	 * Gets the all customer for stream media.
	 *
	 * @return the all customer for stream media
	 */
	public Flux<Customer> getAllCustomerForStreamMedia() {
		return Flux.range(1, 50).doOnNext(index -> {
			try {
				Thread.sleep(200);
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}).doOnNext(index -> {
			LOGGER.debug("Fetching customer object for index " + index);
		}).map(index -> {
			return new Customer(index, "Customer-" + index, "Address-" + index);
		});
	}
}
