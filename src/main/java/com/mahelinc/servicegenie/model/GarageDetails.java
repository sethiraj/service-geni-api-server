/**
 * This Model is the Garage Model describing the Garage's details.
 */
package com.mahelinc.servicegenie.model;

import org.springframework.validation.annotation.Validated;

/**
 * The Class GarageDetails.
 *
 * @author surendrane
 */
@Validated
public class GarageDetails {

	/** The garage name. */
	private String garageName;
	
	/** The latitude. */
	private double latitude;
	
	/** The longitude. */
	private double longitude;
	
	/** The phone number. */
	private String phoneNumber;
	
	/** The location address. */
	private String locationAddress;

	/** The address. */
	private String address;
	
	/** The operating hours. */
	private String operatingHours;
	
	/** The week off. */
	private String weekOff;
	
	/** The garage services. */
	private GarageServices garageServices;

	/**
	 * Gets the garage name.
	 *
	 * @return the garageName
	 */
	public String getGarageName() {
		return garageName;
	}

	/**
	 * Sets the garage name.
	 *
	 * @param garageName the garageName to set
	 */
	public void setGarageName(String garageName) {
		this.garageName = garageName;
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
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Sets the latitude.
	 *
	 * @param latitude the latitude to set
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
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the location address.
	 *
	 * @return the locationAddress
	 */
	public String getLocationAddress() {
		return locationAddress;
	}

	/**
	 * Sets the location address.
	 *
	 * @param locationAddress the locationAddress to set
	 */
	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}

	/**
	 * Gets the pincode.
	 *
	 * @return the pincode
	 */
	public String getPincode() {
		return address;
	}

	/**
	 * Sets the pincode.
	 *
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.address = pincode;
	}

	/**
	 * Gets the operating hours.
	 *
	 * @return the operatingHours
	 */
	public String getOperatingHours() {
		return operatingHours;
	}

	/**
	 * Sets the operating hours.
	 *
	 * @param operatingHours the operatingHours to set
	 */
	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
	}

	/**
	 * Gets the week off.
	 *
	 * @return the weekOff
	 */
	public String getWeekOff() {
		return weekOff;
	}

	/**
	 * Sets the week off.
	 *
	 * @param weekOff the weekOff to set
	 */
	public void setWeekOff(String weekOff) {
		this.weekOff = weekOff;
	}

	/**
	 * Gets the garage services.
	 *
	 * @return the garageServices
	 */
	public GarageServices getGarageServices() {
		return garageServices;
	}

	/**
	 * Sets the garage services.
	 *
	 * @param garageServices the garageServices to set
	 */
	public void setGarageServices(GarageServices garageServices) {
		this.garageServices = garageServices;
	}

}
