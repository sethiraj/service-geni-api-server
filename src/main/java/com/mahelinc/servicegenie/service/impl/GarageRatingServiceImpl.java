/**
 * 
 */
package com.mahelinc.servicegenie.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mahelinc.servicegenie.entity.GarageRating;
import com.mahelinc.servicegenie.model.GarageOverallRating;
import com.mahelinc.servicegenie.model.PostReview;
import com.mahelinc.servicegenie.repository.GarageRatingRepository;
import com.mahelinc.servicegenie.service.GarageRatingService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

/**
 * The Class GarageRatingServiceImpl.
 *
 * @author surendrane
 */
@Service
public class GarageRatingServiceImpl implements GarageRatingService {

	/** The garage rating repository. */
	@Autowired
	private GarageRatingRepository garageRatingRepository;

	/** The Constant NOT_APPLICABLE. */
	private final static String NOT_APPLICABLE = "N/A";

	/**
	 * Find average rating for garage.
	 *
	 * @param garageName the garage name
	 * @param location   the location
	 * @return the garage overall rating
	 */
	@Override
	public GarageOverallRating findAverageRatingForGarage(String garageName, String location) {

		GarageOverallRating garageOverallRating = new GarageOverallRating();
		List<GarageRating> garageReviews = garageRatingRepository
				.findGarageRatingByGarageNameContainingIgnoreCaseAndLocation(garageName, location);
		garageOverallRating.setTotalGarageReviews(Integer.toString(garageReviews.size()));
		double avgRating = 0;
		for (GarageRating garageRating : garageReviews) {
			avgRating = avgRating + garageRating.getRating();
		}
		double avgScore = avgRating / garageReviews.size();
		if (avgScore == 0) {
			garageOverallRating.setAverageGarageRatings(NOT_APPLICABLE);
		} else {
			garageOverallRating.setAverageGarageRatings(Double.toString(avgScore));
		}

		System.out.println("In Here");
		return garageOverallRating;
	}

	/**
	 * Find all reviews for garage.
	 *
	 * @param garageName the garage name
	 * @param location   the location
	 * @return the list
	 */
	@Override
	public List<GarageRating> findAllReviewsForGarage(String garageName, String location) {
		return garageRatingRepository.findGarageRatingByGarageNameContainingIgnoreCaseAndLocation(garageName, location);
	}

	/**
	 * Bulk insert of reviews.
	 *
	 * @param multiPartFile the multi part file
	 * @return true, if successful
	 */
	@Override
	public boolean bulkInsertOfReviews(MultipartFile multiPartFile) {
		boolean status = true;
		try {
			File convFile = new File(multiPartFile.getOriginalFilename());
			FileOutputStream fos = new FileOutputStream(convFile);
			fos.write(multiPartFile.getBytes());
			fos.close();
			Map<String, String> mapping = new HashMap<String, String>();
			mapping.put("GarageTitle", "garageName");
			mapping.put("Rating", "rating");
			mapping.put("ReviewComments", "review");
			mapping.put("ReviewerName", "reviewerName");
			mapping.put("Location", "location");

			HeaderColumnNameTranslateMappingStrategy<PostReview> mappingStrategy = new HeaderColumnNameTranslateMappingStrategy<PostReview>();
			mappingStrategy.setType(PostReview.class);
			mappingStrategy.setColumnMapping(mapping);

			try (Reader reader = new FileReader(convFile);) {
				CsvToBean<PostReview> csvToBean = new CsvToBeanBuilder<PostReview>(reader).withType(PostReview.class)
						.withIgnoreLeadingWhiteSpace(true).withIgnoreEmptyLine(true)
						.withMappingStrategy(mappingStrategy).build();
				List<PostReview> reviews = csvToBean.parse();
				List<GarageRating> garageRatingList = new ArrayList<GarageRating>();
				for (PostReview postReview : reviews) {
					garageRatingList.add(convertReviewToEntity(postReview));
				}
				garageRatingRepository.saveAll(garageRatingList);
			} catch (Exception e) {
				status = false;
			}
		} catch (Exception e) {
			status = false;
		}
		return status;
	}

	/**
	 * Post review.
	 *
	 * @param postReview the post review
	 */
	@Override
	public void postReview(PostReview postReview) {
		garageRatingRepository.save(convertReviewToEntity(postReview));
	}

	/**
	 * Convert review to entity.
	 *
	 * @param postReview the post review
	 * @return the garage rating
	 */
	private GarageRating convertReviewToEntity(PostReview postReview) {
		GarageRating garageRating = new GarageRating();
		garageRating.setGarageName(postReview.getGarageName());
		garageRating.setLocation(postReview.getLocation());
		garageRating.setRating(Double.parseDouble(postReview.getRating()));
		garageRating.setReview(postReview.getReview());
		garageRating.setReviewerName(postReview.getReviewerName());
		System.out.println(garageRating.getGarageName());
		return garageRating;
	}
}
