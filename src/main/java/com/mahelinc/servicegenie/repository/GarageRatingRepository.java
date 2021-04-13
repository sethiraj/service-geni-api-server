/**
 * 
 */
package com.mahelinc.servicegenie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.mahelinc.servicegenie.entity.GarageRating;

/**
 * The Interface GarageRatingRepository.
 *
 * @author surendrane
 */
public interface GarageRatingRepository extends JpaRepository<GarageRating, Long> {

	/**
	 * Find garage rating by garage name containing ignore case and location.
	 *
	 * @param garageName the garage name
	 * @param location the location
	 * @return the list
	 */
	public List<GarageRating> findGarageRatingByGarageNameContainingIgnoreCaseAndLocation(
			@Param("garageName") final String garageName, @Param("location") String location);

}
