/**
 * 
 */
package com.mahelinc.servicegenie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mahelinc.servicegenie.entity.Garage;

/**
 * The Interface GarageRepository.
 *
 * @author surendrane
 */
@Repository
public interface GarageRepository extends PagingAndSortingRepository<Garage, Long>, CrudRepository<Garage, Long> {

	/** The haversine part. */
	static String HAVERSINE_PART = "(6371 * acos(cos(radians(:latitude)) * cos(radians(g.latitude)) * cos(radians(g.longitude) - radians(:longitude)) + sin(radians(:latitude)) * sin(radians(g.latitude))))";

	/**
	 * Find garages with nearest location.
	 *
	 * @param latitude the latitude
	 * @param longitude the longitude
	 * @param distance the distance
	 * @return the list
	 */
	@Query("SELECT g FROM Garage g WHERE " + HAVERSINE_PART + " < :distance ORDER BY " + HAVERSINE_PART + " DESC")
	public List<Garage> findGaragesWithNearestLocation(@Param("latitude") double latitude,
			@Param("longitude") double longitude, @Param("distance") double distance);

	/**
	 * Find garages by location containing ignore case.
	 *
	 * @param location the location
	 * @return the list
	 */
	public List<Garage> findGaragesByLocationContainingIgnoreCase(@Param("location") String location);

	/**
	 * Find garage by garage title containing ignore case.
	 *
	 * @param garageTitle the garage title
	 * @return the list
	 */
	public List<Garage> findGarageByGarageTitleContainingIgnoreCase(@Param("garageTitle") final String garageTitle);
	
	/**
	 * Find garage by garage title.
	 *
	 * @param garageTitle the garage title
	 * @return the garage
	 */
	public Garage findGarageByGarageTitle(@Param("garageTitle") final String garageTitle);

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Garage> findAll();
	
	/**
	 * Find garage by garage title containing ignore case and location.
	 *
	 * @param garageTitle the garage title
	 * @param location the location
	 * @return the list
	 */
	public List<Garage> findGarageByGarageTitleContainingIgnoreCaseAndLocation(@Param("garageTitle") final String garageTitle, @Param("location") String location);

	/**
	 * Find distinct locations.
	 *
	 * @return the list
	 */
	@Query("SELECT DISTINCT g.location FROM Garage g")
	public List<String> findDistinctLocations();
	
	
	/**
	 * Find garage by id.
	 *
	 * @param id the id
	 * @return the garage
	 */
	public Garage findGarageById(long id);
}
