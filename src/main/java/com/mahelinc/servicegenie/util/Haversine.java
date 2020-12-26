/**
 * This Haversine formula is used to calculate the distance between 2 location.
 */
package com.mahelinc.servicegenie.util;

/**
 * The Class Haversine.
 *
 * @author surendrane
 */
public class Haversine {

	/** The Constant EARTH_RADIUS. */
	private static final int EARTH_RADIUS = 6371; // Approx Earth radius in KM
	
	/**
	 * Measure distance.
	 *
	 * @param startLat the start lat
	 * @param startLong the start long
	 * @param endLat the end lat
	 * @param endLong the end long
	 * @return the double
	 */
	public static double measureDistance(double startLat, double startLong, double endLat, double endLong) {

		double dLat = Math.toRadians((endLat - startLat));
		double dLong = Math.toRadians((endLong - startLong));

		startLat = Math.toRadians(startLat);
		endLat = Math.toRadians(endLat);

		double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return EARTH_RADIUS * c; // <-- d
	}

	/**
	 * Haversin.
	 *
	 * @param val the val
	 * @return the double
	 */
	public static double haversin(double val) {
		return Math.pow(Math.sin(val / 2), 2);
	}

}
