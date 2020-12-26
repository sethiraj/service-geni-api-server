/**
 * 
 */
package com.mahelinc.servicegenie.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mahelinc.servicegenie.entity.Garage;
import com.mahelinc.servicegenie.model.GarageDetails;
import com.mahelinc.servicegenie.service.GarageJobsService;
import com.mahelinc.servicegenie.service.GarageService;

import io.swagger.annotations.Api;

/**
 * @author surendrane
 *
 */
@RestController
@RequestMapping("/api/v1")
@Api(value = "/api/v1")
public class ServiceGenieApiServiceController {

	@Autowired
	GarageService garageService;

	@Autowired
	GarageJobsService garageJobsService;

	@GetMapping("/getGaragesOnLocation")
	public ResponseEntity<List<Garage>> getGaragesOnLocation(@RequestParam("location") String location) {
		List<Garage> garages = garageService.findAllGaragesInSpecifiedLocation(location);
		return new ResponseEntity<List<Garage>>(garages, HttpStatus.OK);
	}

	@GetMapping("/getGarageDetailsByName")
	public ResponseEntity<GarageDetails> getGarageDetailsByName(@RequestParam("garageName") String name) {
		GarageDetails garageDetails = garageService.findGarageDetails(name);
		return new ResponseEntity<GarageDetails>(garageDetails, HttpStatus.OK);
	}

	@PostMapping("/createGarage")
	public ResponseEntity<String> createGarage(@ModelAttribute GarageDetails garageDetails) {
		garageService.createGarageWithServices(garageDetails);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@GetMapping("/getGaragesByLatAndLong")
	public ResponseEntity<List<GarageDetails>> getGaragesOnLatAndLong(@RequestParam("latitude") double latitude,
			@RequestParam("longitude") double longitude, @RequestParam("distanceInKms") double distance) {
		List<GarageDetails> listOfGarages = new ArrayList<GarageDetails>();
		List<Garage> garages = garageService.findAllNearestGaragesWithIndistance(latitude, longitude, distance);
		for (Garage garage : garages) {
			listOfGarages.add(garageJobsService.getGarageDetails(garage));
		}
		return new ResponseEntity<List<GarageDetails>>(listOfGarages, HttpStatus.OK);
	}

}
