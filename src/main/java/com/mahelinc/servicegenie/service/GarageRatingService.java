/**
 * 
 */
package com.mahelinc.servicegenie.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mahelinc.servicegenie.entity.GarageRating;
import com.mahelinc.servicegenie.model.GarageOverallRating;
import com.mahelinc.servicegenie.model.PostReview;

/**
 * The Interface GarageRatingService.
 *
 * @author surendrane
 */
public interface GarageRatingService {

	/**
	 * Find average rating for garage.
	 *
	 * @param garageName the garage name
	 * @param location   the location
	 * @return the garage overall rating
	 */
	GarageOverallRating findAverageRatingForGarage(final String garageName, final String location);

	/**
	 * Find all reviews for garage.
	 *
	 * @param garageName the garage name
	 * @param location the location
	 * @return the list
	 */
	List<GarageRating> findAllReviewsForGarage(final String garageName, final String location);

	/**
	 * Bulk insert of reviews.
	 *
	 * @param multiPartFile the multi part file
	 */
	boolean bulkInsertOfReviews(final MultipartFile multiPartFile);

	/**
	 * Post review.
	 *
	 * @param postReview the post review
	 */
	void postReview(final PostReview postReview);

}
