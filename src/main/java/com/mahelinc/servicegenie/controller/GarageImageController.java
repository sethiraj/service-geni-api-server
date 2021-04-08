/**
 * 
 */
package com.mahelinc.servicegenie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mahelinc.servicegenie.service.GarageService;

import io.swagger.annotations.Api;

/**
 * The Class GarageImageController.
 *
 * @author surendrane
 */
@RestController
@RequestMapping("/api/v1")
@Api(value = "/api/v1")
@CrossOrigin
public class GarageImageController {

	/** The garage service. */
	@Autowired
	private GarageService garageService;

	/**
	 * Upload source image to garage.
	 *
	 * @param garageID the garage ID
	 * @param multipart the multipart
	 * @return the response entity
	 */
	@PostMapping("/uploadSourceImageToGarageWithID")
	public ResponseEntity<String> uploadSourceImageToGarageWithID(@RequestParam String garageID,
			@RequestPart(value = "image") MultipartFile multipart) {
		garageService.uploadImageForGarage(garageID, multipart);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	/**
	 * Upload source image to garage.
	 *
	 * @param garageName the garage name
	 * @param location the location
	 * @param multipart the multipart
	 * @return the response entity
	 */
	@PostMapping("/uploadSourceImageToGarage")
	public ResponseEntity<String> uploadSourceImageToGarage(@RequestParam String garageName,
			@RequestParam String location, @RequestPart(value = "image") MultipartFile multipart) {
		garageService.uploadImageForGarage(garageName, location, multipart);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
}
