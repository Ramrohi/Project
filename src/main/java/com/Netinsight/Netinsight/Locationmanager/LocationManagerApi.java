package com.Netinsight.Netinsight.Locationmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.exception.GenericJDBCException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Netinsight.Netinsight.Exception.AppExceptionhandler;
import com.Netinsight.Netinsight.Exception.ExceptionDetails;
import com.Netinsight.Netinsight.Exception.ServiceException;

@RestController
public class LocationManagerApi {
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private AppExceptionhandler appExceptionhandler;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private RackRepository rackRepository;
	Logger logger = LoggerFactory.getLogger(LocationManagerApi.class);

	@PostMapping("/createcountry")
	public ResponseEntity<Map<String, Object>> addCountry(@RequestBody Country dto) {
		Map<String, Object> response = new HashMap<>();
		long startTime = System.currentTimeMillis();
		try {
			countryRepository.insertCountry(dto.getCountryName().toLowerCase(), dto.getNotes());
			Country insertedModel = countryRepository.findTopByOrderByIdDesc();
			response.put("status", "success");
			response.put("country", insertedModel);
			return ResponseEntity.ok(response);
		} catch (JpaSystemException e) {
			Throwable cause = e.getCause();
			if (cause instanceof GenericJDBCException && "45000".equals(((GenericJDBCException) cause).getSQLState())) {
				response.put("status", "error");
				response.put("message", ((GenericJDBCException) cause).getSQLException().getMessage());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}

			response.put("status", "error");
			response.put("message", "An internal error occurred.");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

		} catch (Exception e) {
			logger.error("Error while adding Country", e);
			response.put("status", "error");
			response.put("message", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		} finally {
			long endTime = System.currentTimeMillis(); // Record end time
			long executionTime = endTime - startTime; // Calculate execution time
			response.put("executionTimeMs", executionTime);
		}
	}

	@PostMapping("/createstate")
	public ResponseEntity<Map<String, Object>> addState(@RequestBody StateDto dto) {
		Map<String, Object> response = new HashMap<>();
		long startTime = System.currentTimeMillis();
		try {
			stateRepository.createState(dto.getCountryName(), dto.getStateName());
			State insertedModel = stateRepository.findTopByOrderByIdDesc();
			response.put("status", "success");
			response.put("state", insertedModel);
			return ResponseEntity.ok(response);
		} catch (JpaSystemException e) {
			Throwable cause = e.getCause();
			if (cause instanceof GenericJDBCException && "45000".equals(((GenericJDBCException) cause).getSQLState())) {
				response.put("status", "error");
				response.put("message", ((GenericJDBCException) cause).getSQLException().getMessage());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}

			response.put("status", "error");
			response.put("message", "An internal error occurred.");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		} catch (Exception e) {
			logger.error("Error while adding State", e);
			response.put("status", "error");
			response.put("message", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		} finally {
			long endTime = System.currentTimeMillis(); // Record end time
			long executionTime = endTime - startTime; // Calculate execution time
			response.put("executionTimeMs", executionTime);
		}
	}

	@PostMapping("/createcity")
	public ResponseEntity<Map<String, Object>> addState(@RequestBody CityDto dto) {
		Map<String, Object> response = new HashMap<>();

		try {
			cityRepository.createCity(dto.getStateName(), dto.getCityName());
			City insertedModel = cityRepository.findTopByOrderByIdDesc();
			response.put("status", "success");
			response.put("city", insertedModel);
			return ResponseEntity.ok(response);
		} catch (JpaSystemException e) {
			Throwable cause = e.getCause();
			if (cause instanceof GenericJDBCException && "45000".equals(((GenericJDBCException) cause).getSQLState())) {
				response.put("status", "error");
				response.put("message", ((GenericJDBCException) cause).getSQLException().getMessage());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}

			response.put("status", "error");
			response.put("message", "An internal error occurred.");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		} catch (Exception e) {
			logger.error("Error while adding City", e);
			response.put("status", "error");
			response.put("message", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}

	}

	@PostMapping("/createBuilding")
	public ResponseEntity<Map<String, Object>> addBuilding(@RequestBody BuildingDto dto) {
		Map<String, Object> response = new HashMap<>();

		try {
			buildingRepository.createBuilding(dto.getCityName(), dto.getBuildingName());
			Building insertedModel = buildingRepository.findTopByOrderByIdDesc();
			response.put("status", "success");
			response.put("Building", insertedModel);
			return ResponseEntity.ok(response);
		} catch (JpaSystemException e) {
			Throwable cause = e.getCause();
			if (cause instanceof GenericJDBCException && "45000".equals(((GenericJDBCException) cause).getSQLState())) {
				response.put("status", "error");
				response.put("message", ((GenericJDBCException) cause).getSQLException().getMessage());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}

			response.put("status", "error");
			response.put("message", "An internal error occurred.");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		} catch (Exception e) {
			logger.error("Error while adding Building", e);
			response.put("status", "error");
			response.put("message", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}

	}

	@PostMapping("/createRack")
	public ResponseEntity<Map<String, Object>> createRack(@RequestBody RackDto dto) {
		Map<String, Object> response = new HashMap<>();

		// Check for null or empty values
		if (dto.getRackName() == null || dto.getBuildingName() == null) {
			response.put("status", "error");
			response.put("message", "Rack or Building name cannot be null or empty.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		try {
			rackRepository.createRack(dto.getBuildingName(), dto.getRackName());
			Rack insertedModel = rackRepository.findTopByOrderByIdDesc();

			response.put("status", "success");
			response.put("rack", insertedModel);
			return ResponseEntity.ok(response);

		} catch (JpaSystemException e) {
			Throwable cause = e.getCause();
			if (cause instanceof GenericJDBCException && "45000".equals(((GenericJDBCException) cause).getSQLState())) {
				response.put("status", "error");
				response.put("message", ((GenericJDBCException) cause).getSQLException().getMessage());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
			response.put("status", "error");
			response.put("message", "Internal Server Error. Please try again later.");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		} catch (Exception e) {
			response.put("status", "error");
			response.put("message", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	@GetMapping("/getCountry")
	public Country getCountry(@RequestParam(name = "countryName") String countryName) {
		Country existCountry = null;
		try {
			logger.info("inside Device Metamode:{}", countryName.toLowerCase());
			existCountry = countryRepository.findByCountry(countryName.toLowerCase());
			if (existCountry == null) {
				appExceptionhandler.raiseException("Given Country not exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return existCountry;
	}

	@GetMapping("/getAllCountry")
	public ArrayList<Country> getAllContry() {
		logger.info("Inside getAllCityInState");
		ArrayList<Country> country = null;
		try {
			country = countryRepository.getAllcountry();
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return country;
	}

	@GetMapping("/getState")
	public State getState(@RequestParam(name = "stateName") String stateName) {
		State existState = null;
		try {
			logger.info("inside Device Metamode:{}", stateName.toLowerCase());
			existState = stateRepository.findByState(stateName.toLowerCase());
			if (existState == null) {
				appExceptionhandler.raiseException("Given State not exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return existState;
	}

	@GetMapping("/getStateincountry")
	public ArrayList<State> getStateincountry(@RequestParam(name = "countryName") String countryName) {
		ArrayList<State> states = null;
		try {
			logger.info("inside Device Metamode:{}", countryName.toLowerCase());
			Country country = countryRepository.findByCountry(countryName.toLowerCase());
			if (country == null) {
				appExceptionhandler.raiseException("Given Country not exist");
			}
			states = stateRepository.findAllStateincountry(countryName.toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return states;
	}

	@GetMapping("/getallState")
	public ArrayList<State> getallState() {
		ArrayList<State> states = null;
		try {
			states = stateRepository.findAllState();
			logger.info("inside Device Metamode:{}", states.toString());
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return states;
	}

	@GetMapping("/getCity")
	public City getCity(@RequestParam(name = "cityName") String cityName) {
		City existCity = null;
		try {
			logger.info("inside Device Metamode:{}", cityName.toLowerCase());
			existCity = cityRepository.findByCity(cityName.toLowerCase());
			if (existCity == null) {
				appExceptionhandler.raiseException("Given City not exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return existCity;
	}

	@GetMapping("/findAllStateincity")
	public ArrayList<City> findAllStateincity(@RequestParam(name = "stateName") String stateName) {
		ArrayList<City> cities = null;
		try {
			logger.info("inside Device Metamode:{}", stateName.toLowerCase());
			State state = stateRepository.findByState(stateName.toLowerCase());
			if (state == null) {
				appExceptionhandler.raiseException("Given State not exist");
			}
			cities = cityRepository.findAllStateincity(stateName.toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return cities;
	}

	@GetMapping("/getallCity")
	public ArrayList<City> getallCity() {
		ArrayList<City> cities = null;
		try {
			cities = cityRepository.findAllCity();
			logger.info("inside Device Metamode:{}", cities.toString());
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return cities;
	}

	@GetMapping("/getallBuilding")
	public ArrayList<Building> getallBuilding() {
		ArrayList<Building> buildings = null;
		try {
			buildings = buildingRepository.findAllBuilding();
			logger.info("inside Device Metamode:{}", buildings.toString());
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return buildings;
	}

	@GetMapping("/getBuilding")
	public Building getBuilding(@RequestParam(name = "buildingName") String buildingName) {
		Building existbuilding = null;
		try {
			logger.info("inside Device Metamode:{}", buildingName.toLowerCase());
			existbuilding = buildingRepository.findByBuilding(buildingName.toLowerCase());
			if (existbuilding == null) {
				appExceptionhandler.raiseException("Given Building not exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return existbuilding;
	}

	@GetMapping("/findAllBuldingincity")
	public ArrayList<Building> findAllBuldingincity(@RequestParam(name = "cityName") String cityName) {
		ArrayList<Building> buildings = null;
		try {
			logger.info("inside Device Metamode:{}", cityName.toLowerCase());
			City city = cityRepository.findByCity(cityName.toLowerCase());
			if (city == null) {
				appExceptionhandler.raiseException("Given City not exist");
			}
			buildings = buildingRepository.findAllBuldingincity(cityName.toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return buildings;
	}

	@GetMapping("/getRack")
	public ArrayList<Rack> getRack(@RequestParam(name = "rackName") String rackName) {
		ArrayList<Rack> existRack = null;
		try {
			logger.info("inside Device Metamode:{}", rackName.toLowerCase());
			existRack = rackRepository.findByRack(rackName.toLowerCase());
			if (existRack == null) {
				appExceptionhandler.raiseException("Given Rack not exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return existRack;
	}

	@GetMapping("/getallRack")
	public ArrayList<Rack> getallRack() {
		ArrayList<Rack> racks = null;
		try {
			racks = rackRepository.findAllRack();
			logger.info("inside Device Metamode:{}", racks.toString());
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return racks;
	}

	@GetMapping("/findAllRackinbuilding")
	public ArrayList<Rack> findAllRackinbuilding(@RequestParam(name = "buildingName") String buildingName) {
		ArrayList<Rack> racks = null;
		try {
			logger.info("inside Device Metamode:{}", buildingName.toLowerCase());
			Building building = buildingRepository.findByBuilding(buildingName.toLowerCase());
			if (building == null) {
				appExceptionhandler.raiseException("Given Building not exist");
			}
			racks = rackRepository.findAllRackinbuilding(buildingName.toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return racks;
	}

	@GetMapping("/findRackinbuilding")
	public ArrayList<Rack> findRackinbuilding(@RequestParam("buildingName") String buildingName,
			@RequestParam("rackName") String rackName) {
		ArrayList<Rack> racks = null;
		try {
			logger.info("inside Device Metamode:{}", buildingName.toLowerCase());
			Building building = buildingRepository.findByBuilding(buildingName.toLowerCase());
			if (building == null) {
				appExceptionhandler.raiseException("Given Building not exist");
			}
			ArrayList<Rack> existRack = null;
			existRack = rackRepository.findAllRackinbuilding(buildingName.toLowerCase());
			if (building == null) {
				appExceptionhandler.raiseException("Given Rack not exist");
			}
			racks = rackRepository.findRackinbuilding(buildingName.toLowerCase(), rackName.toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return racks;
	}

	@DeleteMapping("/deleteCountry")
	public JSONObject deleteCountry(@RequestParam(name = "countryName") String countryName) {
		countryName = countryName.toLowerCase();
		JSONObject response = new JSONObject();
		try {
			logger.info("Inside deleteDeviceMetaModel for model: {}", countryName);
			Country existingCountry = countryRepository.findByCountry(countryName.toLowerCase());
			if (existingCountry == null) {
				appExceptionhandler.raiseException("Given Country Model doesn't Exist");
			}
			countryRepository.deleteByCountry(countryName.toLowerCase());
			response.put("status", "Success");
			response.put("DeletedDeviceModel", existingCountry);
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return response;
	}

	@DeleteMapping("/deleteByState")
	public JSONObject deleteByState(@RequestParam(name = "stateName") String stateName) {
		stateName = stateName.toLowerCase();
		JSONObject response = new JSONObject();
		try {
			logger.info("Inside deleteDeviceMetaModel for model: {}", stateName);
			State existingCountry = stateRepository.findByState(stateName.toLowerCase());
			if (existingCountry == null) {
				appExceptionhandler.raiseException("Given Country Model doesn't Exist");
			}
			stateRepository.deleteByState(stateName);
			response.put("status", "Success");
			response.put("DeletedDeviceModel", existingCountry);
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return response;
	}

	@DeleteMapping("/deleteByCity")
	public JSONObject deleteByCity(@RequestParam(name = "cityName") String cityName) {
		cityName = cityName.toLowerCase();
		JSONObject response = new JSONObject();
		try {
			logger.info("Inside deleteDeviceMetaModel for model: {}", cityName);
			City existingCountry = cityRepository.findByCity(cityName.toLowerCase());
			if (existingCountry == null) {
				appExceptionhandler.raiseException("Given Country Model doesn't Exist");
			}
			cityRepository.deleteByCity(cityName.toLowerCase());
			response.put("status", "Success");
			response.put("DeletedDeviceModel", existingCountry);
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return response;
	}

	@DeleteMapping("/deleteByBuilding")
	public JSONObject deleteByBuilding(@RequestParam(name = "buildingName") String buildingName) {
		buildingName = buildingName.toLowerCase();
		JSONObject response = new JSONObject();
		try {
			logger.info("Inside deleteDeviceMetaModel for model: {}", buildingName);
			Building existingCountry = buildingRepository.findByBuilding(buildingName.toLowerCase());
			if (existingCountry == null) {
				appExceptionhandler.raiseException("Given Country Model doesn't Exist");
			}
			buildingRepository.deleteByBuilding(buildingName.toLowerCase());
			response.put("status", "Success");
			response.put("DeletedDeviceModel", existingCountry);
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return response;
	}

	@DeleteMapping("/deleteRackBybuilding")
	public JSONObject deleteRackBybuilding(@RequestParam("buildingName") String buildingName,
			@RequestParam("rackName") String rackName) {
		buildingName = buildingName.toLowerCase();
		rackName = rackName.toLowerCase();

		JSONObject response = new JSONObject();
		try {
			logger.info("Inside deleteDeviceMetaModel for model: {}", buildingName);
			Building existingCountry = buildingRepository.findByBuilding(buildingName.toLowerCase());
			if (existingCountry == null) {
				appExceptionhandler.raiseException("Given Country Model doesn't Exist");
			}
			ArrayList<Rack> existingRack = rackRepository.findAllRackinbuilding(rackName.toLowerCase());
			if (existingRack == null) {
				appExceptionhandler.raiseException("Given Country Model doesn't Exist");
			}

			rackRepository.deleteRackBybuilding(buildingName, rackName);
			response.put("status", "Success");
			response.put("DeletedDeviceModel", existingRack);
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return response;
	}

	public static void checkName(String Name) throws ServiceException {
		if (Name == null || Name.trim().isEmpty()) {
			throw new ServiceException("Name cannot be empty or null",
					new ExceptionDetails("Name cannot be empty or null", "Name cannot be empty or null"));
		}
	}
}
