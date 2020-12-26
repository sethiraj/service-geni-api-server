/**
 * 
 */
package com.mahelinc.servicegenie.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahelinc.servicegenie.entity.Garage;
import com.mahelinc.servicegenie.entity.GarageService;
import com.mahelinc.servicegenie.model.GarageDetails;
import com.mahelinc.servicegenie.model.GarageServices;
import com.mahelinc.servicegenie.model.SearchCriteria;
import com.mahelinc.servicegenie.repository.GarageRepository;
import com.mahelinc.servicegenie.repository.GarageServicesRepository;
import com.mahelinc.servicegenie.service.GarageJobsService;
import com.mahelinc.servicegenie.specification.GarageServiceSpecification;

/**
 * @author surendrane
 *
 */
@Service
public class GarageJobsServiceImpl implements GarageJobsService {

	@Autowired
	private GarageRepository garageRepository;

	@Autowired
	private GarageServicesRepository garageServicesRepository;

	@Override
	public List<Garage> getAllGaragesWithJob(String service) {
		GarageServiceSpecification garageServiceSpecification = new GarageServiceSpecification(
				new SearchCriteria(service));
		List<GarageService> garageServices = garageServicesRepository.findAll(garageServiceSpecification);
		List<Garage> garages = new ArrayList<Garage>();
		for (GarageService garageService : garageServices) {
			garages.add(garageRepository.findGarageByGarageName(garageService.getGarageName()));
		}
		return garages;
	}

	@Override
	public GarageDetails getGarageDetails(Garage garage) {
		com.mahelinc.servicegenie.entity.GarageService garageService = garageServicesRepository
				.findGarageServiceByGarageName(garage.getGarageName());

		GarageDetails garageDetails = new GarageDetails();
		garageDetails.setAddress(garage.getAddress());
		garageDetails.setGarageName(garage.getGarageName());
		garageDetails.setLatitude(garage.getLatitude());
		garageDetails.setLocationAddress(garage.getLocationAddress());
		garageDetails.setOperatingHours(garage.getOperatingHours());
		garageDetails.setPhoneNumber(garage.getPhoneNumber());
		garageDetails.setPincode(garage.getPinCode());
		garageDetails.setWeekOff(garage.getWeekOff());

		GarageServices garageServices = new GarageServices();
		garageServices.setAcService(garageService.isAcService());
		garageServices.setAlloyForWheels(garageService.isAlloyForWheels());
		garageServices.setCarWash(garageService.isCarWash());
		garageServices.setDentAndDamages(garageService.isDentAndDamages());
		garageServices.setGeneralService(garageService.isGeneralService());
		garageServices.setOilChange(garageService.isOilChange());
		garageServices.setPaintBooth(garageService.isPaintBooth());

		garageDetails.setGarageServices(garageServices);

		return garageDetails;
	}
}
