/**
 * This is a Model For Respective Garage's Service Offerings.
 */
package com.mahelinc.servicegenie.model;

import org.springframework.validation.annotation.Validated;

/**
 * @author surendrane
 *
 */
@Validated
public class GarageServices {

	private boolean generalService;
	private boolean paintBooth;
	private boolean carWash;
	private boolean oilChange;
	private boolean acService;
	private boolean alloyForWheels;
	private boolean dentAndDamages;

	/**
	 * @return the generalService
	 */
	public boolean isGeneralService() {
		return generalService;
	}

	/**
	 * @param generalService the generalService to set
	 */
	public void setGeneralService(boolean generalService) {
		this.generalService = generalService;
	}

	/**
	 * @return the paintBooth
	 */
	public boolean isPaintBooth() {
		return paintBooth;
	}

	/**
	 * @param paintBooth the paintBooth to set
	 */
	public void setPaintBooth(boolean paintBooth) {
		this.paintBooth = paintBooth;
	}

	/**
	 * @return the carWash
	 */
	public boolean isCarWash() {
		return carWash;
	}

	/**
	 * @param carWash the carWash to set
	 */
	public void setCarWash(boolean carWash) {
		this.carWash = carWash;
	}

	/**
	 * @return the oilChange
	 */
	public boolean isOilChange() {
		return oilChange;
	}

	/**
	 * @param oilChange the oilChange to set
	 */
	public void setOilChange(boolean oilChange) {
		this.oilChange = oilChange;
	}

	/**
	 * @return the acService
	 */
	public boolean isAcService() {
		return acService;
	}

	/**
	 * @param acService the acService to set
	 */
	public void setAcService(boolean acService) {
		this.acService = acService;
	}

	/**
	 * @return the alloyForWheels
	 */
	public boolean isAlloyForWheels() {
		return alloyForWheels;
	}

	/**
	 * @param alloyForWheels the alloyForWheels to set
	 */
	public void setAlloyForWheels(boolean alloyForWheels) {
		this.alloyForWheels = alloyForWheels;
	}

	/**
	 * @return the dentAndDamages
	 */
	public boolean isDentAndDamages() {
		return dentAndDamages;
	}

	/**
	 * @param dentAndDamages the dentAndDamages to set
	 */
	public void setDentAndDamages(boolean dentAndDamages) {
		this.dentAndDamages = dentAndDamages;
	}
}
