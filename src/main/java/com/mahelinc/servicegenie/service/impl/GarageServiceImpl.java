/**
 * 
 */
package com.mahelinc.servicegenie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahelinc.servicegenie.entity.Garage;
import com.mahelinc.servicegenie.model.GarageDetails;
import com.mahelinc.servicegenie.model.GarageServices;
import com.mahelinc.servicegenie.repository.GarageRepository;
import com.mahelinc.servicegenie.repository.GarageServicesRepository;
import com.mahelinc.servicegenie.service.GarageService;

/**
 * @author surendrane
 *
 */
@Service
public class GarageServiceImpl implements GarageService {

	@Autowired
	private GarageRepository garageRepository;

	@Autowired
	private GarageServicesRepository garageServicesRepository;

	@Override
	public List<Garage> findAllNearestGaragesWithIndistance(double latitude, double longtitude, double distance) {
		return garageRepository.findGaragesWithNearestLocation(latitude, longtitude, distance);
	}

	@Override
	public void createGarageWithServices(GarageDetails garage) {
		Garage garageEntity = new Garage();
		garageEntity.setGarageName(garage.getGarageName());
		garageEntity.setLatitude(garage.getLatitude());
		garageEntity.setLongitude(garage.getLongitude());
		garageEntity.setLocationAddress(garage.getLocationAddress());
		garageEntity.setAddress(garage.getAddress());
		garageEntity.setOperatingHours(garage.getOperatingHours());
		garageEntity.setWeekOff(garage.getWeekOff());
		garageEntity.setPhoneNumber(garage.getPhoneNumber());
		garageEntity.setPinCode(garage.getPincode());
		garageRepository.save(garageEntity);

		com.mahelinc.servicegenie.entity.GarageService garageService = new com.mahelinc.servicegenie.entity.GarageService();
		GarageServices garageServices = garage.getGarageServices();
		garageService.setAcService(garageServices.isAcService());
		garageService.setAlloyForWheels(garageServices.isAlloyForWheels());
		garageService.setCarWash(garageServices.isCarWash());
		garageService.setDentAndDamages(garageServices.isDentAndDamages());
		garageService.setGarageName(garage.getGarageName());
		garageService.setGeneralService(garageServices.isGeneralService());
		garageService.setOilChange(garageServices.isOilChange());
		garageService.setPaintBooth(garageServices.isPaintBooth());
		garageServicesRepository.save(garageService);
	}

	@Override
	public List<Garage> findAllGaragesInSpecifiedLocation(String locationAddress) {
		return garageRepository.findGaragesByLocationAddress(locationAddress);
	}

	@Override
	public GarageDetails findGarageDetails(String garageName) {
		Garage garage = garageRepository.findGarageByGarageName(garageName);
		com.mahelinc.servicegenie.entity.GarageService garageService = garageServicesRepository
				.findGarageServiceByGarageName(garageName);

		GarageDetails garageDetails = new GarageDetails();
		garageDetails.setAddress(garage.getAddress());
		garageDetails.setGarageName(garage.getGarageName());
		garageDetails.setLatitude(garage.getLatitude());
		garageDetails.setLongitude(garage.getLongitude());
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
