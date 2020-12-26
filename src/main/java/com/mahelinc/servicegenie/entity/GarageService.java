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
 * The Entity Class is for GarageServices.
 *
 * @author surendrane
 */
@Entity
@Table(name = "GarageServices")
public class GarageService implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	/** The garage name. */
	@Column(name = "GarageName")
	private String garageName;

	/** The general service. */
	@Column(name = "isGeneralService")
	private boolean generalService;
	
	/** The paint booth. */
	@Column(name = "isPaintBooth")
	private boolean paintBooth;
	
	/** The car wash. */
	@Column(name = "isCarWash")
	private boolean carWash;
	
	/** The oil change. */
	@Column(name = "isOilChange")
	private boolean oilChange;
	
	/** The ac service. */
	@Column(name = "isAcService")
	private boolean acService;
	
	/** The alloy for wheels. */
	@Column(name = "isAlloyForWheels")
	private boolean alloyForWheels;
	
	/** The dent and damages. */
	@Column(name = "isDentAndDamages")
	private boolean dentAndDamages;

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
	 * Checks if is general service.
	 *
	 * @return the generalService
	 */
	public boolean isGeneralService() {
		return generalService;
	}

	/**
	 * Sets the general service.
	 *
	 * @param generalService the generalService to set
	 */
	public void setGeneralService(boolean generalService) {
		this.generalService = generalService;
	}

	/**
	 * Checks if is paint booth.
	 *
	 * @return the paintBooth
	 */
	public boolean isPaintBooth() {
		return paintBooth;
	}

	/**
	 * Sets the paint booth.
	 *
	 * @param paintBooth the paintBooth to set
	 */
	public void setPaintBooth(boolean paintBooth) {
		this.paintBooth = paintBooth;
	}

	/**
	 * Checks if is car wash.
	 *
	 * @return the carWash
	 */
	public boolean isCarWash() {
		return carWash;
	}

	/**
	 * Sets the car wash.
	 *
	 * @param carWash the carWash to set
	 */
	public void setCarWash(boolean carWash) {
		this.carWash = carWash;
	}

	/**
	 * Checks if is oil change.
	 *
	 * @return the oilChange
	 */
	public boolean isOilChange() {
		return oilChange;
	}

	/**
	 * Sets the oil change.
	 *
	 * @param oilChange the oilChange to set
	 */
	public void setOilChange(boolean oilChange) {
		this.oilChange = oilChange;
	}

	/**
	 * Checks if is ac service.
	 *
	 * @return the acService
	 */
	public boolean isAcService() {
		return acService;
	}

	/**
	 * Sets the ac service.
	 *
	 * @param acService the acService to set
	 */
	public void setAcService(boolean acService) {
		this.acService = acService;
	}

	/**
	 * Checks if is alloy for wheels.
	 *
	 * @return the alloyForWheels
	 */
	public boolean isAlloyForWheels() {
		return alloyForWheels;
	}

	/**
	 * Sets the alloy for wheels.
	 *
	 * @param alloyForWheels the alloyForWheels to set
	 */
	public void setAlloyForWheels(boolean alloyForWheels) {
		this.alloyForWheels = alloyForWheels;
	}

	/**
	 * Checks if is dent and damages.
	 *
	 * @return the dentAndDamages
	 */
	public boolean isDentAndDamages() {
		return dentAndDamages;
	}

	/**
	 * Sets the dent and damages.
	 *
	 * @param dentAndDamages the dentAndDamages to set
	 */
	public void setDentAndDamages(boolean dentAndDamages) {
		this.dentAndDamages = dentAndDamages;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "GarageService [id=" + id + ", garageName=" + garageName + ", generalService=" + generalService
				+ ", paintBooth=" + paintBooth + ", carWash=" + carWash + ", oilChange=" + oilChange + ", acService="
				+ acService + ", alloyForWheels=" + alloyForWheels + ", dentAndDamages=" + dentAndDamages + "]";
	}

}
