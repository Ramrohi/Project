package com.Netinsight.Netinsight.Metamodeler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Netinsight.Netinsight.Exception.AppExceptionhandler;

@RestController
public class DeviceMetaModelRestApis {

	@Autowired
	private DeviceMetaModelRepository deviceMetaModelRepository;
	@Autowired
	private AppExceptionhandler appExceptionhandler;

	Logger logger = LoggerFactory.getLogger(DeviceMetaModelRestApis.class);

	@PostMapping("/add")
	public ResponseEntity<DeviceMetaModel> addDeviceMetaModelAndCards(@RequestBody DeviceMetaModel dto) {
		try {

			deviceMetaModelRepository.insertDeviceMetaModelAndCards(dto.getDeviceModel(), dto.getPartNumber(),
					dto.getVendor(), dto.getHeight(), dto.getDepth(), dto.getWidth(), dto.getShelvesContained(),
					dto.getNumOfRackPositionOccupied(), String.join(",", dto.getAllowedCardList()));

			DeviceMetaModel insertedModel = deviceMetaModelRepository.findTopByOrderByDeviceModelDesc();
			return ResponseEntity.ok(insertedModel);

		} catch (Exception e) {
			logger.error("Error while adding DeviceMetaModel", e);

		}
		return null;
	}

	@GetMapping("/free-iccid")
	public ResponseEntity<List<DeviceMetaModel>> getFreeIccid() {
		List<DeviceMetaModel> devices = deviceMetaModelRepository.getFreeIccid();
		return ResponseEntity.ok(devices);
	}

	@GetMapping("/getmodel")
	public DeviceMetaModel getdevicemodel(@RequestParam(name = "deviceModel") String deviceModel) {
		DeviceMetaModel existDeviceMetaModel = null;
		try {
			logger.info("inside Device Metamode:{}", deviceModel);
			existDeviceMetaModel = deviceMetaModelRepository.findByDeviceModel(deviceModel);
			if (existDeviceMetaModel == null) {
				appExceptionhandler.raiseException("Given Device Meta model not exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return existDeviceMetaModel;
	}

	@GetMapping("/getvendorbyMetamodel")
	public ArrayList<DeviceMetaModel> getdevicemodelbyvendor(@RequestParam(name = "vendor") String vendorValue) {
		ArrayList<DeviceMetaModel> allModels = new ArrayList<>();
		try {
			logger.info("Inside getAllModelsOfVendor for vendor: {}", vendorValue);
			allModels = (ArrayList<DeviceMetaModel>) deviceMetaModelRepository.findByVendor(vendorValue);
		} catch (Exception e) {
			e.printStackTrace();
			appExceptionhandler.raiseException(e.getMessage());
		}
		return allModels;
	}

	@PostMapping("/update")
	public ResponseEntity<DeviceMetaModel> updateDeviceMetaModelAndCards(@RequestBody DeviceMetaModel dto) {
		try {
			// Calling the update stored procedure
			deviceMetaModelRepository.updateDeviceMetaModelAndCards(dto.getDeviceModel(), dto.getPartNumber(),
					dto.getVendor(), dto.getHeight(), dto.getDepth(), dto.getWidth(),
					dto.getNumOfRackPositionOccupied(), String.join(",", dto.getAllowedCardList()));

			// Retrieving the updated model. It assumes that 'findByDeviceModel' exists in
			// your repository.
			DeviceMetaModel updatedModel = deviceMetaModelRepository.findByDeviceModel(dto.getDeviceModel());

			if (updatedModel == null) {
				return ResponseEntity.notFound().build();
			}

			return ResponseEntity.ok(updatedModel);

		} catch (Exception e) {
			logger.error("Error while updating DeviceMetaModel", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/deviceMetaModel")
	public ResponseEntity<?> deleteDeviceMetaModel(@RequestParam(name = "model") String model) {
		try {
			deviceMetaModelRepository.deleteByDeviceModel(model);
			return ResponseEntity.ok("Deleted successfully.");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Error deleting model: " + e.getMessage());
		}
	}

}
