/**
 * 
 */
package com.mahelinc.servicegenie.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mahelinc.servicegenie.entity.Garage;
import com.mahelinc.servicegenie.model.GarageCreation;
import com.mahelinc.servicegenie.model.GarageDetails;
import com.mahelinc.servicegenie.model.GarageWithRatings;
import com.mahelinc.servicegenie.service.GarageJobsService;
import com.mahelinc.servicegenie.service.GarageRatingService;
import com.mahelinc.servicegenie.service.GarageService;

import io.swagger.annotations.Api;

/**
 * The Class ServiceGenieApiServiceController.
 *
 * @author surendrane
 */
@RestController
@RequestMapping("/api/v1")
@Api(value = "/api/v1")
@CrossOrigin
public class ServiceGenieApiServiceController {

	/** The garage service. */
	@Autowired
	GarageService garageService;

	/** The garage jobs service. */
	@Autowired
	GarageJobsService garageJobsService;
	
	/** The garage rating service. */
	@Autowired
	GarageRatingService garageRatingService;
	
	/**
	 * Gets the garages on location.
	 *
	 * @param location the location
	 * @return the garages on location
	 */
	@GetMapping("/getGaragesOnLocation")
	public ResponseEntity<List<GarageWithRatings>> getGaragesOnLocation(@RequestParam("location") String location) {
		List<GarageWithRatings> garages = garageService.findAllGaragesInSpecifiedLocation(location);
		return new ResponseEntity<List<GarageWithRatings>>(garages, HttpStatus.OK);
	}

	/**
	 * Gets the garage details by name.
	 *
	 * @param name the name
	 * @return the garage details by name
	 */
	@GetMapping("/getGarageDetailsByName")
	public ResponseEntity<GarageDetails> getGarageDetailsByName(@RequestParam("garageName") String name) {
		GarageDetails garageDetails = garageService.findGarageDetails(name);
		return new ResponseEntity<GarageDetails>(garageDetails, HttpStatus.OK);
	}

	/**
	 * Creates the garage.
	 *
	 * @param garageDetails the garage details
	 * @param image the image
	 * @return the response entity
	 */
	@PostMapping("/createGarage")
	public ResponseEntity<String> createGarage(@ModelAttribute GarageCreation garageDetails, @RequestPart(required = false) MultipartFile image) {
		garageService.createGarageWithServices(garageDetails, image);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	/**
	 * Gets the garages on lat and long.
	 *
	 * @param latitude the latitude
	 * @param longitude the longitude
	 * @param distance the distance
	 * @return the garages on lat and long
	 */
	@GetMapping("/getGaragesByLatAndLong")
	public ResponseEntity<List<GarageWithRatings>> getGaragesOnLatAndLong(@RequestParam("latitude") double latitude,
			@RequestParam("longitude") double longitude, @RequestParam("distanceInKms") double distance) {
		List<GarageWithRatings> listOfGarages = new ArrayList<GarageWithRatings>();
		List<Garage> garages = garageService.findAllNearestGaragesWithIndistance(latitude, longitude, distance);
		for (Garage garage : garages) {
			listOfGarages.add(garageRatingService.includeRatingsForGarage(garage));
		}
		return new ResponseEntity<List<GarageWithRatings>>(listOfGarages, HttpStatus.OK);
	}

	/**
	 * Gets the all unique locations.
	 *
	 * @return the all unique locations
	 */
	@GetMapping("/getAllUniqueGarageLocations")
	public ResponseEntity<List<String>> getAllUniqueLocations() {
		List<String> uniqueGarageLocations = garageService.getUniqueGarageLocations();
		return new ResponseEntity<List<String>>(uniqueGarageLocations, HttpStatus.OK);
	}

	/**
	 * Gets the all garages.
	 *
	 * @return the all garages
	 */
	@GetMapping("/getAllGarages")
	public ResponseEntity<List<Garage>> getAllGarages() {
		return new ResponseEntity<List<Garage>>(garageService.findAllGarages(), HttpStatus.OK);
	}

	/**
	 * Gets the all garages with regex name.
	 *
	 * @param regexName the regex name
	 * @return the all garages with regex name
	 */
	@GetMapping("/getAllGaragesUsingRegex")
	public ResponseEntity<List<GarageWithRatings>> getAllGaragesWithRegexName(
			@RequestParam("garageNameContaining") String regexName) {
		return new ResponseEntity<List<GarageWithRatings>>(garageService.findAllGaragesWithName(regexName), HttpStatus.OK);
	}

	/**
	 * Gets the all garages with service.
	 *
	 * @param serviceID the service ID
	 * @return the all garages with service
	 */
	@GetMapping("/getAllGaragesWithService")
	public ResponseEntity<List<Garage>> getAllGaragesWithService(@RequestParam("service") String serviceID) {
		return new ResponseEntity<List<Garage>>(garageJobsService.getAllGaragesWithJob(serviceID), HttpStatus.OK);
	}

	/**
	 * Bulk upload.
	 *
	 * @param multiPartFile the multi part file
	 * @return the response entity
	 */
	@PostMapping("/bulkUpload")
	public ResponseEntity<String> bulkUpload(@RequestPart(value = "file") MultipartFile multiPartFile) {
		try {
			garageService.bulkUploadOfGarages(multiPartFile);
		} catch (Exception e) {
			return new ResponseEntity<String>("Upload Failed", HttpStatus.NOT_MODIFIED);
		}
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	/**
	 * Gets the all garages with name on location.
	 *
	 * @param garageName the garage name
	 * @param location the locationgetAllGaragesWithRegexName 
	 * @return the all garages with name on location
	 */
	@GetMapping("/getAllGaragesWithNameOnLocation")
	public ResponseEntity<List<GarageDetails>> getAllGaragesWithNameOnLocation(@RequestParam("garageName") String garageName,
			@RequestParam("location") String location) {
		return new ResponseEntity<List<GarageDetails>>(garageService.findAllGaragesWithNameAndLocation(garageName, location),
				HttpStatus.OK);
	}
	
}
