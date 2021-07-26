/**
 * 
 */
package com.mahelinc.servicegenie.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mahelinc.servicegenie.entity.Garage;
import com.mahelinc.servicegenie.entity.GarageServiceDetails;
import com.mahelinc.servicegenie.model.GarageCreation;
import com.mahelinc.servicegenie.model.GarageDetails;
import com.mahelinc.servicegenie.model.GarageOverallRating;
import com.mahelinc.servicegenie.model.GarageServices;
import com.mahelinc.servicegenie.model.GarageWithImage;
import com.mahelinc.servicegenie.model.GarageWithRatings;
import com.mahelinc.servicegenie.repository.GarageRepository;
import com.mahelinc.servicegenie.repository.GarageServicesRepository;
import com.mahelinc.servicegenie.service.GarageRatingService;
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

	/** The garage rating service. */
	@Autowired
	private GarageRatingService garageRatingService;

	/** The Constant UPLOAD_LOC. */
	private static final String UPLOAD_LOC = "UploadedPics";

	/**
	 * Find all nearest garages with indistance.
	 *
	 * @param latitude   the latitude
	 * @param longtitude the longtitude
	 * @param distance   the distance
	 * @return the list
	 */
	@Override
	public List<Garage> findAllNearestGaragesWithIndistance(double latitude, double longtitude, double distance) {
		return garageRepository.findGaragesWithNearestLocation(latitude, longtitude, distance);
	}

	/**
	 * Creates the garage with services.
	 *
	 * @param garage    the garage
	 * @param imageFile the image file
	 */
	@Override
	public void createGarageWithServices(GarageCreation garage, MultipartFile imageFile) {
		List<Garage> exsistingGarage = garageRepository
				.findGarageByGarageTitleContainingIgnoreCaseAndLocation(garage.getGarageTitle(), garage.getLocation());
		if (exsistingGarage.size() > 0) {
			GarageServiceDetails garageServiceDetails = garageServicesRepository
					.findGarageServiceByGarageNameAndLocation(garage.getGarageTitle(), garage.getLocation());
			updateGarageDetails(garage, exsistingGarage.get(0), garageServiceDetails, imageFile);
		} else {
			Garage garageEntity = new Garage();
			GarageServiceDetails garageServiceDetails = new GarageServiceDetails();
			updateGarageDetails(garage, garageEntity, garageServiceDetails, imageFile);
		}
	}

	/**
	 * Update garage details.
	 *
	 * @param garage               the garage
	 * @param garageEntity         the garage entity
	 * @param garageServiceDetails the garage service details
	 * @param imageFile            the image file
	 */
	private void updateGarageDetails(GarageCreation garage, Garage garageEntity,
			GarageServiceDetails garageServiceDetails, MultipartFile imageFile) {

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
		garageEntity.setDescription(garage.getGarageDescription());
		garageEntity.setStartingPrice(garage.getStartingPrice());
		garageEntity.setVerified(garage.isVerified());
		garageEntity.setGarageImage(uploadAndSetUUIDForImage(imageFile));
		garageRepository.save(garageEntity);

		GarageServices garageServices = garage.getGarageServices();
		garageServiceDetails.setGarageName(garage.getGarageTitle());
		garageServiceDetails.setAcAndCL(garageServices.isAcAndCL());
		garageServiceDetails.setAcc(garageServices.isAcc());
		garageServiceDetails.setCarWash(garageServices.isCarWash());
		garageServiceDetails.setEngAndEcu(garageServices.isEngAndEcu());
		garageServiceDetails.setGsAndOil(garageServices.isGsAndOil());
		garageServiceDetails.setPbAndT(garageServices.isPbAndT());
		garageServiceDetails.setwAndS(garageServices.iswAndS());
		garageServiceDetails.setLocation(garage.getLocation());
		garageServicesRepository.save(garageServiceDetails);

	}

	/**
	 * Find all garages in specified location.
	 *
	 * @param locationAddress the location address
	 * @return the list
	 */
	@Override
	public List<GarageWithRatings> findAllGaragesInSpecifiedLocation(String locationAddress) {
		List<GarageWithRatings> garageDetailsList = new ArrayList<GarageWithRatings>();
		List<Garage> garages = garageRepository.findGaragesByLocation(locationAddress);
		for (Garage garage : garages) {
			garageDetailsList.add(getGarageWithRatings(garage));
		}
		return garageDetailsList;
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
				.findGarageServiceByGarageNameAndLocation(garage.getGarageTitle(), garage.getLocation());

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
		garageDetails.setGarageDescription(garage.getDescription());
		garageDetails.setStartingPrice(garage.getStartingPrice());
		/*
		 * Get Garage Ratings
		 */
		GarageOverallRating garageOverallRating = garageRatingService
				.findAverageRatingForGarage(garage.getGarageTitle(), garage.getLocation());
		garageDetails.setTotalGarageReviews(garageOverallRating.getTotalGarageReviews());
		garageDetails.setAverageGarageRatings(garageOverallRating.getAverageGarageRatings());
		garageDetails.setVerified(garage.isVerified());
		/*
		 * Get the Garage Image From Server, convert into Base64
		 */
		garageDetails.setGarageImage(getUploadedImageAsBase64String(garage.getGarageImage()));
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
	public List<GarageWithRatings> findAllGaragesWithName(String regexName) {
		List<GarageWithRatings> garageDetailsList = new ArrayList<GarageWithRatings>();
		List<Garage> garages = garageRepository.findGarageByGarageTitleContainingIgnoreCase(regexName);
		for (Garage garage : garages) {
			garageDetailsList.add(getGarageWithRatings(garage));
		}
		return garageDetailsList;
	}

	/**
	 * Gets the garage with ratings.
	 *
	 * @param garage the garage
	 * @return the garage with ratings
	 */
	private GarageWithRatings getGarageWithRatings(Garage garage) {
		GarageWithRatings garageWithRatings = new GarageWithRatings();
		garageWithRatings.setAddress(garage.getAddress());
		garageWithRatings.setGarageTitle(garage.getGarageTitle());
		garageWithRatings.setLatitude(garage.getLatitude());
		garageWithRatings.setLongitude(garage.getLongitude());
		garageWithRatings.setLocation(garage.getLocation());
		garageWithRatings.setOperatingHours(garage.getOperatingHours());
		garageWithRatings.setContact(garage.getContact());
		garageWithRatings.setAltContact(garage.getAltContact());
		garageWithRatings.setDateOfEst(garage.getDateOfEst());
		garageWithRatings.setPaymentMode(garage.getPaymentMode());
		garageWithRatings.setPinCode(garage.getPinCode());
		garageWithRatings.setWeekOff(garage.getWeekOff());
		garageWithRatings.setDescription(garage.getDescription());
		garageWithRatings.setStartingPrice(garage.getStartingPrice());
		/*
		 * Get Garage Ratings
		 */
		GarageOverallRating garageOverallRating = garageRatingService
				.findAverageRatingForGarage(garage.getGarageTitle(), garage.getLocation());
		garageWithRatings.setGarageOverallRating(garageOverallRating);
		garageWithRatings.setVerified(garage.isVerified());
		/*
		 * Get the Garage Image From Server, convert into Base64
		 */
		garageWithRatings.setGarageImage(garage.getGarageImage());
		return garageWithRatings;
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
		mapping.put("General Service & Oil Change", "gsAndOil");
		mapping.put("Painting & Tinkering", "pbAndT");
		mapping.put("CarWash", "carWash");
		mapping.put("AC Reapir & Cleaning", "acAndCL");
		mapping.put("Wheels & Spares", "wAndS");
		mapping.put("ECU Coding", "engAndEcu");
		mapping.put("Accessories", "acc");
		mapping.put("Description", "garageDescription");
		mapping.put("Verified", "verified");
		mapping.put("Starting Price", "startingPrice");
		mapping.put("Image", "garageImage");

		HeaderColumnNameTranslateMappingStrategy<GarageWithImage> mappingStrategy = new HeaderColumnNameTranslateMappingStrategy<GarageWithImage>();
		mappingStrategy.setType(GarageWithImage.class);
		mappingStrategy.setColumnMapping(mapping);

		try (Reader reader = new FileReader(file);) {
			CsvToBean<GarageWithImage> csvToBean = new CsvToBeanBuilder<GarageWithImage>(reader)
					.withType(GarageWithImage.class).withIgnoreLeadingWhiteSpace(true).withIgnoreEmptyLine(true)
					.withMappingStrategy(mappingStrategy).build();

			List<GarageWithImage> garageDetailsList = csvToBean.parse();

			List<Garage> garageList = new ArrayList<Garage>();
			List<GarageServiceDetails> garageServiceDetailsList = new ArrayList<GarageServiceDetails>();
			for (GarageWithImage garage : garageDetailsList) {
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
				garageEntity.setStartingPrice(garage.getStartingPrice());
				garageEntity.setVerified(garage.isVerified());
				garageEntity.setDescription(garage.getGarageDescription());

				/**
				 * Garage - Image
				 */

				garageEntity.setGarageImage(convertBaseStringToImageForUpload(garage.getGarageImage()));
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
				garageServiceDetails.setLocation(garage.getLocation());
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
	 * @param location  the location
	 * @return the list
	 */
	@Override
	public List<GarageDetails> findAllGaragesWithNameAndLocation(String regexName, String location) {
		List<GarageDetails> garageDetailsList = new ArrayList<GarageDetails>();
		List<Garage> garages = garageRepository.findGarageByGarageTitleContainingIgnoreCaseAndLocation(regexName,
				location);
		for (Garage garage : garages) {
			garageDetailsList.add(getGarageWithServices(garage));
		}
		return garageDetailsList;
	}

	/**
	 * Upload and set UUID for image.
	 *
	 * @param imageFile the image file
	 * @return the string
	 */
	private String uploadAndSetUUIDForImage(MultipartFile imageFile) {
		String uuidString = StringUtils.EMPTY;
		try {
			StringBuilder sb = new StringBuilder(System.getProperty("user.dir")).append("/").append(UPLOAD_LOC);
			File uploadPic = new File(sb.toString());
			if (!uploadPic.exists()) {
				uploadPic.mkdir();
			}
			UUID uuid = UUID.nameUUIDFromBytes(imageFile.getBytes());
			StringBuilder lastFileName = sb.append("/").append(uuid.toString());
			imageFile.transferTo(new File(lastFileName.toString()));
			uuidString = uuid.toString();
		} catch (Exception e) {
		}
		return uuidString;
	}

	/**
	 * Gets the uploaded image as base 64 string.
	 *
	 * @param garageImage the garage image
	 * @return the uploaded image as base 64 string
	 */
	private String getUploadedImageAsBase64String(String garageImage) {
		String baseString = StringUtils.EMPTY;
		try {
			StringBuilder sb = new StringBuilder(System.getProperty("user.dir")).append("/").append(UPLOAD_LOC)
					.append("/").append(garageImage);
			File tmpFile = new File(sb.toString());
			byte[] fileContent = FileUtils.readFileToByteArray(tmpFile);
			String encodedString = Base64.getEncoder().encodeToString(fileContent);
			baseString = encodedString;
		} catch (Exception e) {
		}

		return baseString;
	}

	/**
	 * Convert base string to image for upload.
	 *
	 * @param baseString the base string
	 * @return the string
	 */
	private String convertBaseStringToImageForUpload(String baseString) {
		String uuidString = StringUtils.EMPTY;
		try {
			StringBuilder sb = new StringBuilder(System.getProperty("user.dir")).append("/").append(UPLOAD_LOC);
			File uploadPic = new File(sb.toString());
			if (!uploadPic.exists()) {
				uploadPic.mkdir();
			}
			UUID uuid = UUID.nameUUIDFromBytes(baseString.getBytes());
			StringBuilder lastFileName = sb.append("/").append(uuid.toString());
			uuidString = uuid.toString();
			byte[] imageData = Base64.getDecoder().decode(baseString);
			OutputStream outputStream = new FileOutputStream(new File(lastFileName.toString()));
			outputStream.write(imageData);
			outputStream.close();
		} catch (Exception e) {
		}
		return uuidString;
	}

	/**
	 * Gets the garage image.
	 *
	 * @param garageName the garage name
	 * @param location   the location
	 * @return the garage image
	 */
	@Override
	public String getGarageImage(String garageName, String location) {
		Garage garage = garageRepository.findGarageByGarageTitleContainingIgnoreCaseAndLocation(garageName, location)
				.get(0);
		return getUploadedImageAsBase64String(garage.getGarageImage());
	}

	/**
	 * Upload image for garage.
	 *
	 * @param garageName the garage name
	 * @param location   the location
	 * @param multipart  the multipart
	 */
	@Override
	public void uploadImageForGarage(String garageName, String location, MultipartFile multipart) {
		Garage garage = garageRepository.findGarageByGarageTitleContainingIgnoreCaseAndLocation(garageName, location)
				.get(0);
		garage.setGarageImage(uploadAndSetUUIDForImage(multipart));
		garageRepository.save(garage);
	}

	/**
	 * Upload image for garage.
	 *
	 * @param garageID  the garage ID
	 * @param multipart the multipart
	 */
	@Override
	public void uploadImageForGarage(String garageID, MultipartFile multipart) {
		Garage garage = garageRepository.findGarageById(Long.parseLong(garageID));
		garage.setGarageImage(uploadAndSetUUIDForImage(multipart));
		garageRepository.save(garage);

	}
}
