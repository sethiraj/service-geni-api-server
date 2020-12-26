/**
 * 
 */
package com.mahelinc.servicegenie.service;

import java.util.List;

import com.mahelinc.servicegenie.entity.Garage;
import com.mahelinc.servicegenie.model.GarageDetails;

/**
 * @author surendrane
 *
 */
public interface GarageJobsService {

	public List<Garage> getAllGaragesWithJob(String jobDetails);
	public GarageDetails getGarageDetails(Garage garage);

}
