/**
 * 
 */
package com.mahelinc.servicegenie.service;

import java.util.List;

import com.mahelinc.servicegenie.entity.Garage;
import com.mahelinc.servicegenie.model.GarageDetails;

/**
 * @author surendrane
 *
 */
public interface GarageService {

	List<Garage> findAllNearestGaragesWithIndistance(double latitude, double longtitude, double distance);
	List<Garage> findAllGaragesInSpecifiedLocation(String locationAddress);
	GarageDetails findGarageDetails(String garageName);
	void createGarageWithServices(GarageDetails garage);
}
