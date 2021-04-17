/**
 * 
 */
package com.mahelinc.servicegenie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.mahelinc.servicegenie.entity.Garage;
import com.mahelinc.servicegenie.model.GarageCreation;
import com.mahelinc.servicegenie.model.GarageDetails;
import com.mahelinc.servicegenie.model.GarageWithRatings;

/**
 * The Interface GarageService.
 *
 * @author surendrane
 */
public interface GarageService {

	/**
	 * Find all nearest garages with indistance.
	 *
	 * @param latitude   the latitude
	 * @param longtitude the longtitude
	 * @param distance   the distance
	 * @return the list
	 */
	List<Garage> findAllNearestGaragesWithIndistance(double latitude, double longtitude, double distance);

	/**
	 * Find all garages in specified location.
	 *
	 * @param locationAddress the location address
	 * @return the list
	 */
	List<GarageWithRatings> findAllGaragesInSpecifiedLocation(String locationAddress);

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
	 * @param imageFile the image file
	 */
	void createGarageWithServices(GarageCreation garage, Optional<MultipartFile> imageFile);

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
	List<GarageWithRatings> findAllGaragesWithName(final String regexName);

	/**
	 * Find all garages with name and location.
	 *
	 * @param regexName the regex name
	 * @param location the location
	 * @return the list
	 */
	List<GarageDetails> findAllGaragesWithNameAndLocation(final String regexName, final String location);

	/**
	 * Bulk upload of garages.
	 *
	 * @param multipart the multipart
	 * @throws Exception the exception
	 */
	void bulkUploadOfGarages(MultipartFile multipart) throws Exception;

	/**
	 * Gets the garage image.
	 *
	 * @param garageName the garage name
	 * @param location the location
	 * @return the garage image
	 */
	String getGarageImage(final String garageName, final String location);
	
	/**
	 * Upload image for garage.
	 *
	 * @param garageName the garage name
	 * @param location the location
	 * @param multipart the multipart
	 */
	void uploadImageForGarage(String garageName, String location, MultipartFile multipart);
	
	/**
	 * Upload image for garage.
	 *
	 * @param garageID the garage ID
	 * @param multipart the multipart
	 */
	void uploadImageForGarage(String garageID, MultipartFile multipart);
		
}
