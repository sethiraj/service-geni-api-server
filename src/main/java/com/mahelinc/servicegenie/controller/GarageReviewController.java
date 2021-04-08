/**
 * 
 */
package com.mahelinc.servicegenie.controller;

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

import com.mahelinc.servicegenie.entity.GarageRating;
import com.mahelinc.servicegenie.model.GarageOverallRating;
import com.mahelinc.servicegenie.model.PostReview;
import com.mahelinc.servicegenie.service.GarageRatingService;

import io.swagger.annotations.Api;

/**
 * The Class GarageReviewController.
 *
 * @author surendrane
 */
@RestController
@RequestMapping("/api/v1")
@Api(value = "/api/v1")
@CrossOrigin
public class GarageReviewController {

	/** The garage rating service. */
	@Autowired
	private GarageRatingService garageRatingService;

	/**
	 * Gets the reviews of garage.
	 *
	 * @param garageName the garage name
	 * @param location the location
	 * @return the reviews of garage
	 */
	@GetMapping("/getReviewsOfGarage")
	public ResponseEntity<List<GarageRating>> getReviewsOfGarage(@RequestParam String garageName,
			@RequestParam String location) {
		List<GarageRating> garageRatings = garageRatingService.findAllReviewsForGarage(garageName, location);
		return new ResponseEntity<List<GarageRating>>(garageRatings, HttpStatus.OK);
	}

	/**
	 * Post review for garage.
	 *
	 * @param postReview the post review
	 * @return the response entity
	 */
	@PostMapping("/postReview")
	public ResponseEntity<String> postReviewForGarage(@ModelAttribute PostReview postReview) {
		garageRatingService.postReview(postReview);
		return new ResponseEntity<String>("Posted", HttpStatus.CREATED);
	}

	/**
	 * Post bulk review for garages.
	 *
	 * @param multiPartFile the multi part file
	 * @return the response entity
	 */
	@PostMapping("/bulkReviews")
	public ResponseEntity<String> postBulkReviewForGarages(
			@RequestPart(value = "reviews") MultipartFile multiPartFile) {

		ResponseEntity<String> responseEntity;
		if (garageRatingService.bulkInsertOfReviews(multiPartFile)) {
			responseEntity = new ResponseEntity<String>("Posted All Reviews", HttpStatus.CREATED);
		} else {
			responseEntity = new ResponseEntity<String>("Please Check the CSV uploaded", HttpStatus.NOT_MODIFIED);
		}

		return responseEntity;
	}

	/**
	 * Gets the overall review ratings of garage.
	 *
	 * @param garageName the garage name
	 * @param location the location
	 * @return the overall review ratings of garage
	 */
	@GetMapping("/getOverallReviewRatingsOfGarage")
	public ResponseEntity<GarageOverallRating> getOverallReviewRatingsOfGarage(@RequestParam String garageName,
			@RequestParam String location) {
		GarageOverallRating garageOverallRating = garageRatingService.findAverageRatingForGarage(garageName, location);
		return new ResponseEntity<GarageOverallRating>(garageOverallRating, HttpStatus.OK);
	}

}
