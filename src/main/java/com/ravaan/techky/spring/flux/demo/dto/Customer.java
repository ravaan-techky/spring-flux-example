package com.ravaan.techky.spring.flux.demo.dto;

/**
 * The Class Customer.
 */
public class Customer {

	/** The customer id. */
	private Integer customerId;

	/** The customer name. */
	private String customerName;

	/** The customer address. */
	private String customerAddress;

	/**
	 * Instantiates a new customer.
	 *
	 * @param customerId      the customer id
	 * @param customerName    the customer name
	 * @param customerAddress the customer address
	 */
	public Customer(Integer customerId, String customerName, String customerAddress) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
	}

	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * Gets the customer name.
	 *
	 * @return the customer name
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * Gets the customer address.
	 *
	 * @return the customer address
	 */
	public String getCustomerAddress() {
		return customerAddress;
	}
}
