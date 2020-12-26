/**
 * 
 */
package com.mahelinc.servicegenie.model;

/**
 * The Class SearchCriteria.
 *
 * @author surendrane
 */
public class SearchCriteria {

	/** The key. */
	private String key;
	
	/** The value. */
	private boolean value = true;

	/**
	 * Instantiates a new search criteria.
	 *
	 * @param key the key
	 */
	public SearchCriteria(final String key) {
		this.setKey(key);
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Checks if is value.
	 *
	 * @return the value
	 */
	public boolean isValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the value to set
	 */
	public void setValue(boolean value) {
		this.value = value;
	}

}
