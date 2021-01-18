/**
 * 
 */
package com.mahelinc.servicegenie.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mahelinc.servicegenie.entity.Garage;
import com.mahelinc.servicegenie.entity.GarageServiceDetails;
import com.mahelinc.servicegenie.model.GarageDetails;
import com.mahelinc.servicegenie.model.GarageServices;
import com.mahelinc.servicegenie.repository.GarageRepository;
import com.mahelinc.servicegenie.repository.GarageServicesRepository;
import com.mahelinc.servicegenie.service.GarageService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

/**
 * The Class GarageServiceImpl.
 *
 * @author surendrane
 */
@Service
public class GarageServiceImpl implements GarageService {

	/** The garage repository. */
	@Autowired
	private GarageRepository garageRepository;

	/** The garage services repository. */
	@Autowired
	private GarageServicesRepository garageServicesRepository;

	/**
	 * Find all nearest garages with indistance.
	 *
	 * @param latitude the latitude
	 * @param longtitude the longtitude
	 * @param distance the distance
	 * @return the list
	 */
	@Override
	public List<Garage> findAllNearestGaragesWithIndistance(double latitude, double longtitude, double distance) {
		return garageRepository.findGaragesWithNearestLocation(latitude, longtitude, distance);
	}

	/**
	 * Creates the garage with services.
	 *
	 * @param garage the garage
	 */
	@Override
	public void createGarageWithServices(GarageDetails garage) {
		Garage garageEntity = new Garage();
		garageEntity.setGarageTitle(garage.getGarageTitle());
		garageEntity.setAddress(garage.getAddress());
		garageEntity.setGarageTitle(garage.getGarageTitle());
		garageEntity.setLatitude(garage.getLatitude());
		garageEntity.setLongitude(garage.getLongitude());
		garageEntity.setLocation(garage.getLocation());
		garageEntity.setOperatingHours(garage.getOperatingHours());
		garageEntity.setContact(garage.getContact());
		garageEntity.setAltContact(garage.getAltContact());
		garageEntity.setDateOfEst(garage.getDateOfEst());
		garageEntity.setPaymentMode(garage.getPaymentMode());
		garageEntity.setPinCode(garage.getPinCode());
		garageEntity.setWeekOff(garage.getWeekOff());
		garageRepository.save(garageEntity);

		GarageServiceDetails garageServiceDetails = new GarageServiceDetails();
		GarageServices garageServices = garage.getGarageServices();
		garageServiceDetails.setGarageName(garage.getGarageTitle());
		garageServiceDetails.setAcAndCL(garageServices.isAcAndCL());
		garageServiceDetails.setAcc(garageServices.isAcc());
		garageServiceDetails.setCarWash(garageServices.isCarWash());
		garageServiceDetails.setEngAndEcu(garageServices.isEngAndEcu());
		garageServiceDetails.setGsAndOil(garageServices.isGsAndOil());
		garageServiceDetails.setPbAndT(garageServices.isPbAndT());
		garageServiceDetails.setwAndS(garageServices.iswAndS());
		garageServicesRepository.save(garageServiceDetails);
	}

	/**
	 * Find all garages in specified location.
	 *
	 * @param locationAddress the location address
	 * @return the list
	 */
	@Override
	public List<Garage> findAllGaragesInSpecifiedLocation(String locationAddress) {
		return garageRepository.findGaragesByLocationContainingIgnoreCase(locationAddress);
	}

	/**
	 * Find garage details.
	 *
	 * @param garageName the garage name
	 * @return the garage details
	 */
	@Override
	public GarageDetails findGarageDetails(String garageName) {
		Garage garage = garageRepository.findGarageByGarageTitle(garageName);
		return getGarageWithServices(garage);
	}

	/**
	 * Gets the unique garage locations.
	 *
	 * @return the unique garage locations
	 */
	@Override
	public List<String> getUniqueGarageLocations() {
		return (List<String>) garageRepository.findDistinctLocations();
	}

	/**
	 * Find all garages.
	 *
	 * @return the list
	 */
	@Override
	public List<Garage> findAllGarages() {
		return garageRepository.findAll();
	}

	/**
	 * Gets the garage with services.
	 *
	 * @param garage the garage
	 * @return the garage with services
	 */
	private GarageDetails getGarageWithServices(final Garage garage) {
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
	 * Find all garages with name.
	 *
	 * @param regexName the regex name
	 * @return the list
	 */
	@Override
	public List<GarageDetails> findAllGaragesWithName(String regexName) {
		List<GarageDetails> garageDetailsList = new ArrayList<GarageDetails>();
		List<Garage> garages = garageRepository.findGarageByGarageTitleContainingIgnoreCase(regexName);
		for (Garage garage : garages) {
			garageDetailsList.add(getGarageWithServices(garage));
		}
		return garageDetailsList;
	}

	/**
	 * Convert multi part to file.
	 *
	 * @param file the file
	 * @return the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

	/**
	 * Bulk upload of garages.
	 *
	 * @param multipart the multipart
	 * @throws Exception the exception
	 */
	@Override
	public void bulkUploadOfGarages(MultipartFile multipart) throws Exception {
		File file = convertMultiPartToFile(multipart);

		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("GarageTitle", "garageTitle");
		mapping.put("Latitude", "latitude");
		mapping.put("Longitude", "longitude");
		mapping.put("Contact", "contact");
		mapping.put("AltContact", "altContact");
		mapping.put("PaymentMode", "paymentMode");
		mapping.put("YearOfEstablishment", "dateOfEst");
		mapping.put("Location", "location");
		mapping.put("Address", "address");
		mapping.put("OperationHours", "operatingHours");
		mapping.put("WeekOff", "weekOff");
		mapping.put("PinCode", "pinCode");
		mapping.put("isGSAndOil", "gsAndOil");
		mapping.put("isPBAndT", "pbAndT");
		mapping.put("isCarWash", "carWash");
		mapping.put("isACAndCL", "acAndCL");
		mapping.put("isWAndS", "wAndS");
		mapping.put("isEngAndECU", "engAndEcu");
		mapping.put("isACC", "acc");

		HeaderColumnNameTranslateMappingStrategy<GarageDetails> mappingStrategy = new HeaderColumnNameTranslateMappingStrategy<GarageDetails>();
		mappingStrategy.setType(GarageDetails.class);
		mappingStrategy.setColumnMapping(mapping);

		try (Reader reader = new FileReader(file);) {
			CsvToBean<GarageDetails> csvToBean = new CsvToBeanBuilder<GarageDetails>(reader)
					.withType(GarageDetails.class).withIgnoreLeadingWhiteSpace(true).withIgnoreEmptyLine(true)
					.withMappingStrategy(mappingStrategy).build();

			List<GarageDetails> garageDetailsList = csvToBean.parse();

			List<Garage> garageList = new ArrayList<Garage>();
			List<GarageServiceDetails> garageServiceDetailsList = new ArrayList<GarageServiceDetails>();
			for (GarageDetails garage : garageDetailsList) {
				Garage garageEntity = new Garage();
				garageEntity.setGarageTitle(garage.getGarageTitle());
				garageEntity.setAddress(garage.getAddress());
				garageEntity.setGarageTitle(garage.getGarageTitle());
				garageEntity.setLatitude(garage.getLatitude());
				garageEntity.setLongitude(garage.getLongitude());
				garageEntity.setLocation(garage.getLocation());
				garageEntity.setOperatingHours(garage.getOperatingHours());
				garageEntity.setContact(garage.getContact());
				garageEntity.setAltContact(garage.getAltContact());
				garageEntity.setDateOfEst(garage.getDateOfEst());
				garageEntity.setPaymentMode(garage.getPaymentMode());
				garageEntity.setPinCode(garage.getPinCode());
				garageEntity.setWeekOff(garage.getWeekOff());
				garageList.add(garageEntity);

				GarageServiceDetails garageServiceDetails = new GarageServiceDetails();
				GarageServices garageServices = garage.getGarageServices();
				garageServiceDetails.setGarageName(garage.getGarageTitle());
				garageServiceDetails.setAcAndCL(garageServices.isAcAndCL());
				garageServiceDetails.setAcc(garageServices.isAcc());
				garageServiceDetails.setCarWash(garageServices.isCarWash());
				garageServiceDetails.setEngAndEcu(garageServices.isEngAndEcu());
				garageServiceDetails.setGsAndOil(garageServices.isGsAndOil());
				garageServiceDetails.setPbAndT(garageServices.isPbAndT());
				garageServiceDetails.setwAndS(garageServices.iswAndS());
				garageServiceDetailsList.add(garageServiceDetails);
			}
			garageRepository.saveAll(garageList);
			garageServicesRepository.saveAll(garageServiceDetailsList);
		}
	}

	/**
	 * Find all garages with name and location.
	 *
	 * @param regexName the regex name
	 * @param location the location
	 * @return the list
	 */
	@Override
	public List<Garage> findAllGaragesWithNameAndLocation(String regexName, String location) {
		return garageRepository.findGarageByGarageTitleContainingIgnoreCaseAndLocation(regexName, location);
	}
}
