/**
 * 
 */
package com.mahelinc.servicegenie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.mahelinc.servicegenie.entity.GarageServiceDetails;

/**
 * The Interface GarageServicesRepository.
 *
 * @author surendrane
 */
@Repository
public interface GarageServicesRepository
		extends JpaRepository<GarageServiceDetails, Long>, JpaSpecificationExecutor<GarageServiceDetails> {

	/**
	 * Find garage service by garage name.
	 *
	 * @param garageName the garage name
	 * @return the garage service details
	 */
	GarageServiceDetails findGarageServiceByGarageName(String garageName);
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<GarageServiceDetails> findAll();
}
