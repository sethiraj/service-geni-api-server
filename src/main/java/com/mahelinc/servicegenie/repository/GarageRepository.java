/**
 * 
 */
package com.mahelinc.servicegenie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mahelinc.servicegenie.entity.Garage;

/**
 * @author surendrane
 *
 */
@Repository
public interface GarageRepository extends PagingAndSortingRepository<Garage, Long> {

	static String HAVERSINE_PART = "(6371 * acos(cos(radians(:latitude)) * cos(radians(g.latitude)) * cos(radians(g.longitude) - radians(:longitude)) + sin(radians(:latitude)) * sin(radians(g.latitude))))";

	@Query("SELECT g FROM Garage g WHERE " + HAVERSINE_PART + " < :distance ORDER BY " + HAVERSINE_PART + " DESC")
	public List<Garage> findGaragesWithNearestLocation(@Param("latitude") double latitude,
			@Param("longitude") double longitude, @Param("distance") double distance);

	public List<Garage> findGaragesByLocationAddress(@Param("locationAddress") String locationAddress);

	public Garage findGarageByGarageName(final String garageName);
}
