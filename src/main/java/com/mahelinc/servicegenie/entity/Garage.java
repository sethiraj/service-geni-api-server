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
@Table(name = "Garage")
public class Garage implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	/** The garage name. */
	@Column(name = "GarageName")
	private String garageTitle;

	/** The latitude. */
	@Column(name = "Latitude")
	private double latitude;

	/** The longitude. */
	@Column(name = "Longitude")
	private double longitude;

	/** The phone number. */
	@Column(name = "Contact")
	private String contact;

	/** The alt contact. */
	@Column(name = "AltContact")
	private String altContact;

	/** The payment mode. */
	@Column(name = "PaymentMode")
	private String paymentMode;

	/** The date of est. */
	@Column(name = "YearOfEstablishment")
	private String dateOfEst;

	/** The location address. */
	@Column(name = "Location")
	private String location;

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

	/** The description. */
	@Lob
	@Column(name = "Description")
	private String description;

	/** The verified. */
	@Column(name = "Verified")
	private boolean verified = false;

	/** The starting price. */
	@Column(name = "StartingPrice")
	private int startingPrice;

	/** The garage image. */
	@Column(name = "GarageImage")
	private String garageImage;

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
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Checks if is verified.
	 *
	 * @return true, if is verified
	 */
	public boolean isVerified() {
		return verified;
	}

	/**
	 * Sets the verified.
	 *
	 * @param verified the new verified
	 */
	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	/**
	 * Gets the starting price.
	 *
	 * @return the starting price
	 */
	public int getStartingPrice() {
		return startingPrice;
	}

	/**
	 * Sets the starting price.
	 *
	 * @param l the new starting price
	 */
	public void setStartingPrice(int l) {
		this.startingPrice = l;
	}

	/**
	 * Gets the garage image.
	 *
	 * @return the garage image
	 */
	public String getGarageImage() {
		return garageImage;
	}

	/**
	 * Sets the garage image.
	 *
	 * @param garageImage the new garage image
	 */
	public void setGarageImage(String garageImage) {
		this.garageImage = garageImage;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Garage [id=" + id + ", garageTitle=" + garageTitle + ", latitude=" + latitude + ", longitude="
				+ longitude + ", contact=" + contact + ", altContact=" + altContact + ", paymentMode=" + paymentMode
				+ ", dateOfEst=" + dateOfEst + ", location=" + location + ", address=" + address + ", operatingHours="
				+ operatingHours + ", weekOff=" + weekOff + ", pinCode=" + pinCode + ", description=" + description
				+ ", verified=" + verified + ", startingPrice=" + startingPrice + ", garageImage=" + garageImage + "]";
	}

}
