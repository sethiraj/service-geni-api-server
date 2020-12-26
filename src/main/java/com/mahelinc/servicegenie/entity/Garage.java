/**
 * 
 */
package com.mahelinc.servicegenie.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * The Entity Class For Garage.
 *
 * @author surendrane
 */
@Entity
@Table(name="Garage")
public class Garage implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	/** The garage name. */
	@Column(name = "GarageName")
	private String garageName;

	/** The latitude. */
	@Column(name = "Latitude")
	private double latitude;

	/** The longitude. */
	@Column(name = "Longitude")
	private double longitude;

	/** The phone number. */
	@Column(name = "PhoneNumber")
	private String phoneNumber;

	/** The location address. */
	@Column(name = "Location")
	private String locationAddress;

	/** The address. */
	@Column(name = "Address")
	private String address;

	/** The operating hours. */
	@Column(name = "OperationHours")
	private String operatingHours;

	/** The week off. */
	@Column(name = "WeekOff")
	private String weekOff;
	
	/** The pin code. */
	@Column(name = "PinCode")
	private String pinCode;

	/**
	 * Gets the pin code.
	 *
	 * @return the pinCode
	 */
	public String getPinCode() {
		return pinCode;
	}

	/**
	 * Sets the pin code.
	 *
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Garage [id=" + id + ", garageName=" + garageName + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", phoneNumber=" + phoneNumber + ", locationAddress=" + locationAddress + ", address=" + address
				+ ", operatingHours=" + operatingHours + ", weekOff=" + weekOff + ", pinCode=" + pinCode + "]";
	}

}
