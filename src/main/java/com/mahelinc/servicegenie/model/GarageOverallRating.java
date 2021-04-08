/**
 * 
 */
package com.mahelinc.servicegenie.model;

/**
 * The Class GarageRating.
 *
 * @author surendrane
 */
public class GarageOverallRating {

	/** The average garage ratings. */
	private String averageGarageRatings;

	/** The total garage reviews. */
	private String totalGarageReviews;

	/**
	 * Gets the average garage ratings.
	 *
	 * @return the average garage ratings
	 */
	public String getAverageGarageRatings() {
		return averageGarageRatings;
	}

	/**
	 * Sets the average garage ratings.
	 *
	 * @param averageGarageRatings the new average garage ratings
	 */
	public void setAverageGarageRatings(String averageGarageRatings) {
		this.averageGarageRatings = averageGarageRatings;
	}

	/**
	 * Gets the total garage reviews.
	 *
	 * @return the total garage reviews
	 */
	public String getTotalGarageReviews() {
		return totalGarageReviews;
	}

	/**
	 * Sets the total garage reviews.
	 *
	 * @param totalGarageReviews the new total garage reviews
	 */
	public void setTotalGarageReviews(String totalGarageReviews) {
		this.totalGarageReviews = totalGarageReviews;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "GarageRating [averageGarageRatings=" + averageGarageRatings + ", totalGarageReviews="
				+ totalGarageReviews + "]";
	}

}
