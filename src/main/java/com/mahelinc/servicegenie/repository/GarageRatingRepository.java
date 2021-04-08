/**
 * 
 */
package com.mahelinc.servicegenie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.mahelinc.servicegenie.entity.GarageRating;

/**
 * @author surendrane
 *
 */
public interface GarageRatingRepository extends JpaRepository<GarageRating, Long> {

	public List<GarageRating> findGarageRatingByGarageNameContainingIgnoreCaseAndLocation(
			@Param("garageName") final String garageName, @Param("location") String location);

}
