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
public class GarageServiceDetails implements Serializable {

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
	@Column(name = "isGSAndOil")
	private boolean gsAndOil;
	
	/** The paint booth. */
	@Column(name = "isPBAndT")
	private boolean pbAndT;
	
	/** The car wash. */
	@Column(name = "isCarWash")
	private boolean carWash;
	
	/** The oil change. */
	@Column(name = "isACAndCL")
	private boolean acAndCL;
	
	/** The ac service. */
	@Column(name = "isWAndS")
	private boolean wAndS;
	
	/** The alloy for wheels. */
	@Column(name = "isEngAndECU")
	private boolean engAndEcu;
	
	/** The dent and damages. */
	@Column(name = "isACC")
	private boolean acc;

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
	 * Checks if is gs and oil.
	 *
	 * @return true, if is gs and oil
	 */
	public boolean isGsAndOil() {
		return gsAndOil;
	}

	/**
	 * Sets the gs and oil.
	 *
	 * @param gsAndOil the new gs and oil
	 */
	public void setGsAndOil(boolean gsAndOil) {
		this.gsAndOil = gsAndOil;
	}

	/**
	 * Checks if is pb and T.
	 *
	 * @return true, if is pb and T
	 */
	public boolean isPbAndT() {
		return pbAndT;
	}

	/**
	 * Sets the pb and T.
	 *
	 * @param pbAndT the new pb and T
	 */
	public void setPbAndT(boolean pbAndT) {
		this.pbAndT = pbAndT;
	}

	/**
	 * Checks if is car wash.
	 *
	 * @return true, if is car wash
	 */
	public boolean isCarWash() {
		return carWash;
	}

	/**
	 * Sets the car wash.
	 *
	 * @param carWash the new car wash
	 */
	public void setCarWash(boolean carWash) {
		this.carWash = carWash;
	}

	/**
	 * Checks if is ac and CL.
	 *
	 * @return true, if is ac and CL
	 */
	public boolean isAcAndCL() {
		return acAndCL;
	}

	/**
	 * Sets the ac and CL.
	 *
	 * @param acAndCL the new ac and CL
	 */
	public void setAcAndCL(boolean acAndCL) {
		this.acAndCL = acAndCL;
	}

	/**
	 * Checks if is w and S.
	 *
	 * @return true, if is w and S
	 */
	public boolean iswAndS() {
		return wAndS;
	}

	/**
	 * Sets the w and S.
	 *
	 * @param wAndS the new w and S
	 */
	public void setwAndS(boolean wAndS) {
		this.wAndS = wAndS;
	}

	/**
	 * Checks if is eng and ecu.
	 *
	 * @return true, if is eng and ecu
	 */
	public boolean isEngAndEcu() {
		return engAndEcu;
	}

	/**
	 * Sets the eng and ecu.
	 *
	 * @param engAndEcu the new eng and ecu
	 */
	public void setEngAndEcu(boolean engAndEcu) {
		this.engAndEcu = engAndEcu;
	}

	/**
	 * Checks if is acc.
	 *
	 * @return true, if is acc
	 */
	public boolean isAcc() {
		return acc;
	}

	/**
	 * Sets the acc.
	 *
	 * @param acc the new acc
	 */
	public void setAcc(boolean acc) {
		this.acc = acc;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "GarageService [id=" + id + ", garageName=" + garageName + ", gsAndOil=" + gsAndOil + ", pbAndT="
				+ pbAndT + ", carWash=" + carWash + ", acAndCL=" + acAndCL + ", wAndS=" + wAndS + ", engAndEcu="
				+ engAndEcu + ", acc=" + acc + "]";
	}
	
}
