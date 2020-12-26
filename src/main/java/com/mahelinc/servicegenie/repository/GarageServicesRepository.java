/**
 * 
 */
package com.mahelinc.servicegenie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.mahelinc.servicegenie.entity.GarageService;

/**
 * The Interface GarageServicesRepository.
 *
 * @author surendrane
 */
@Repository
public interface GarageServicesRepository
		extends JpaRepository<GarageService, Long>, JpaSpecificationExecutor<GarageService> {

	GarageService findGarageServiceByGarageName(String garageName);
}
