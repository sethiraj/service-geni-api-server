/**
 * 
 */
package com.mahelinc.servicegenie.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahelinc.servicegenie.entity.Garage;
import com.mahelinc.servicegenie.entity.GarageServiceDetails;
import com.mahelinc.servicegenie.model.GarageDetails;
import com.mahelinc.servicegenie.model.GarageServices;
import com.mahelinc.servicegenie.model.SearchCriteria;
import com.mahelinc.servicegenie.repository.GarageRepository;
import com.mahelinc.servicegenie.repository.GarageServicesRepository;
import com.mahelinc.servicegenie.service.GarageJobsService;
import com.mahelinc.servicegenie.specification.GarageServiceSpecification;

/**
 * The Class GarageJobsServiceImpl.
 *
 * @author surendrane
 */
@Service
public class GarageJobsServiceImpl implements GarageJobsService {

	/** The garage repository. */
	@Autowired
	private GarageRepository garageRepository;

	/** The garage services repository. */
	@Autowired
	private GarageServicesRepository garageServicesRepository;

	/**
	 * Gets the all garages with job.
	 *
	 * @param service the service
	 * @return the all garages with job
	 */
	@Override
	public List<Garage> getAllGaragesWithJob(String service) {
		GarageServiceSpecification garageServiceSpecification = new GarageServiceSpecification(
				new SearchCriteria(service));
		List<GarageServiceDetails> garageServices = garageServicesRepository.findAll(garageServiceSpecification);
		List<Garage> garages = new ArrayList<Garage>();
		for (GarageServiceDetails garageService : garageServices) {
			garages.add(garageRepository.findGarageByGarageTitle(garageService.getGarageName()));
		}
		return garages;
	}

	/**
	 * Gets the garage details.
	 *
	 * @param garage the garage
	 * @return the garage details
	 */
	@Override
	public GarageDetails getGarageDetails(Garage garage) {
		GarageServiceDetails garageService = garageServicesRepository
				.findGarageServiceByGarageName(garage.getGarageTitle());

		GarageDetails garageDetails = new GarageDetails();
		garageDetails.setAddress(garage.getAddress());
		garageDetails.setGarageTitle(garage.getGarageTitle());
		garageDetails.setLatitude(garage.getLatitude());
		garageDetails.setLongitude(garage.getLongitude());
		garageDetails.setLocation(garage.getLocation());
		garageDetails.setOperatingHours(garage.getOperatingHours());
		garageDetails.setContact(garage.getContact());
		garageDetails.setAltContact(garage.getAltContact());
		garageDetails.setDateOfEst(garage.getDateOfEst());
		garageDetails.setPaymentMode(garage.getPaymentMode());
		garageDetails.setPinCode(garage.getPinCode());
		garageDetails.setWeekOff(garage.getWeekOff());

		GarageServices garageServices = new GarageServices();
		garageServices.setAcAndCL(garageService.isAcAndCL());
		garageServices.setAcc(garageService.isAcc());
		garageServices.setCarWash(garageService.isCarWash());
		garageServices.setEngAndEcu(garageService.isEngAndEcu());
		garageServices.setGsAndOil(garageService.isGsAndOil());
		garageServices.setPbAndT(garageService.isPbAndT());
		garageServices.setwAndS(garageService.iswAndS());

		garageDetails.setGarageServices(garageServices);

		return garageDetails;
	}

	/**
	 * Gets the all garages with services.
	 *
	 * @return the all garages with services
	 */
	@Override
	public List<GarageServiceDetails> getAllGaragesWithServices() {
		return garageServicesRepository.findAll();
	}
}
