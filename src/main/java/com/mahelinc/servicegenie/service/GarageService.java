/**
 * 
 */
package com.mahelinc.servicegenie.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mahelinc.servicegenie.entity.Garage;
import com.mahelinc.servicegenie.model.GarageDetails;

/**
 * The Interface GarageService.
 *
 * @author surendrane
 */
public interface GarageService {

	/**
	 * Find all nearest garages with indistance.
	 *
	 * @param latitude the latitude
	 * @param longtitude the longtitude
	 * @param distance the distance
	 * @return the list
	 */
	List<Garage> findAllNearestGaragesWithIndistance(double latitude, double longtitude, double distance);

	/**
	 * Find all garages in specified location.
	 *
	 * @param locationAddress the location address
	 * @return the list
	 */
	List<Garage> findAllGaragesInSpecifiedLocation(String locationAddress);

	/**
	 * Find garage details.
	 *
	 * @param garageName the garage name
	 * @return the garage details
	 */
	GarageDetails findGarageDetails(String garageName);

	/**
	 * Creates the garage with services.
	 *
	 * @param garage the garage
	 */
	void createGarageWithServices(GarageDetails garage);

	/**
	 * Gets the unique garage locations.
	 *
	 * @return the unique garage locations
	 */
	List<String> getUniqueGarageLocations();

	/**
	 * Find all garages.
	 *
	 * @return the list
	 */
	List<Garage> findAllGarages();

	/**
	 * Find all garages with name.
	 *
	 * @param regexName the regex name
	 * @return the list
	 */
	List<GarageDetails> findAllGaragesWithName(final String regexName);
	
	/**
	 * Find all garages with name and location.
	 *
	 * @param regexName the regex name
	 * @param Location the location
	 * @return the list
	 */
	List<Garage> findAllGaragesWithNameAndLocation(final String regexName, final String Location);
	
	/**
	 * Bulk upload of garages.
	 *
	 * @param multipart the multipart
	 * @throws Exception the exception
	 */
	void bulkUploadOfGarages(MultipartFile multipart) throws Exception;
}
