/**
 * 
 */
package com.mahelinc.servicegenie.service;

import java.util.List;

import com.mahelinc.servicegenie.entity.Garage;
import com.mahelinc.servicegenie.entity.GarageServiceDetails;
import com.mahelinc.servicegenie.model.GarageDetails;

/**
 * The Interface GarageJobsService.
 *
 * @author surendrane
 */
public interface GarageJobsService {

	/**
	 * Gets the all garages with job.
	 *
	 * @param jobDetails the job details
	 * @return the all garages with job
	 */
	public List<Garage> getAllGaragesWithJob(String jobDetails);
	
	/**
	 * Gets the garage details.
	 *
	 * @param garage the garage
	 * @return the garage details
	 */
	public GarageDetails getGarageDetails(Garage garage);
	
	/**
	 * Gets the all garages with services.
	 *
	 * @return the all garages with services
	 */
	public List<GarageServiceDetails> getAllGaragesWithServices();

}
