/**
 * 
 */
package com.mahelinc.servicegenie.model;

import com.opencsv.bean.CsvRecurse;

/**
 * @author surendrane
 *
 */
public class GarageCreation {

	/** The garage name. */
	private String garageTitle;

	/** The latitude. */
	private double latitude;

	/** The longitude. */
	private double longitude;

	/** The phone number. */
	private String contact;

	/** The alt contact. */
	private String altContact;

	/** The payment mode. */
	private String paymentMode;

	/** The date of est. */
	private String dateOfEst;

	/** The location address. */
	private String location;

	/** The address. */
	private String address;

	/** The operating hours. */
	private String operatingHours;

	/** The week off. */
	private String weekOff;

	/** The pin code. */
	private String pinCode;

	/** The garage services. */
	@CsvRecurse
	private GarageServices garageServices;

	/** The garage description. */
	private String garageDescription;

	/** The verified. */
	private boolean verified = false;

	/** The starting price. */
	private int startingPrice;

	/**
	 * Gets the garage description.
	 *
	 * @return the garageDescription
	 */
	public String getGarageDescription() {
		return garageDescription;
	}

	/**
	 * Sets the garage description.
	 *
	 * @param garageDescription the garageDescription to set
	 */
	public void setGarageDescription(String garageDescription) {
		this.garageDescription = garageDescription;
	}

	/**
	 * Checks if is verified.
	 *
	 * @return the verified
	 */
	public boolean isVerified() {
		return verified;
	}

	/**
	 * Sets the verified.
	 *
	 * @param verified the verified to set
	 */
	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	/**
	 * Gets the starting price.
	 *
	 * @return the startingPrice
	 */
	public int getStartingPrice() {
		return startingPrice;
	}

	/**
	 * Sets the starting price.
	 *
	 * @param startingPrice the startingPrice to set
	 */
	public void setStartingPrice(int startingPrice) {
		this.startingPrice = startingPrice;
	}


	/**
	 * Gets the garage title.
	 *
	 * @return the garage title
	 */
	public String getGarageTitle() {
		return garageTitle;
	}

	/**
	 * Sets the garage title.
	 *
	 * @param garageTitle the new garage title
	 */
	public void setGarageTitle(String garageTitle) {
		this.garageTitle = garageTitle;
	}

	/**
	 * Gets the latitude.
	 *
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Sets the latitude.
	 *
	 * @param latitude the new latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Gets the longitude.
	 *
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Sets the longitude.
	 *
	 * @param longitude the new longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Gets the contact.
	 *
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * Sets the contact.
	 *
	 * @param contact the new contact
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * Gets the alt contact.
	 *
	 * @return the alt contact
	 */
	public String getAltContact() {
		return altContact;
	}

	/**
	 * Sets the alt contact.
	 *
	 * @param altContact the new alt contact
	 */
	public void setAltContact(String altContact) {
		this.altContact = altContact;
	}

	/**
	 * Gets the payment mode.
	 *
	 * @return the payment mode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}

	/**
	 * Sets the payment mode.
	 *
	 * @param paymentMode the new payment mode
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	/**
	 * Gets the date of est.
	 *
	 * @return the date of est
	 */
	public String getDateOfEst() {
		return dateOfEst;
	}

	/**
	 * Sets the date of est.
	 *
	 * @param dateOfEst the new date of est
	 */
	public void setDateOfEst(String dateOfEst) {
		this.dateOfEst = dateOfEst;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the operating hours.
	 *
	 * @return the operating hours
	 */
	public String getOperatingHours() {
		return operatingHours;
	}

	/**
	 * Sets the operating hours.
	 *
	 * @param operatingHours the new operating hours
	 */
	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
	}

	/**
	 * Gets the week off.
	 *
	 * @return the week off
	 */
	public String getWeekOff() {
		return weekOff;
	}

	/**
	 * Sets the week off.
	 *
	 * @param weekOff the new week off
	 */
	public void setWeekOff(String weekOff) {
		this.weekOff = weekOff;
	}

	/**
	 * Gets the pin code.
	 *
	 * @return the pin code
	 */
	public String getPinCode() {
		return pinCode;
	}

	/**
	 * Sets the pin code.
	 *
	 * @param pinCode the new pin code
	 */
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	/**
	 * Gets the garage services.
	 *
	 * @return the garage services
	 */
	public GarageServices getGarageServices() {
		return garageServices;
	}

	/**
	 * Sets the garage services.
	 *
	 * @param garageServices the new garage services
	 */
	public void setGarageServices(GarageServices garageServices) {
		this.garageServices = garageServices;
	}

}
