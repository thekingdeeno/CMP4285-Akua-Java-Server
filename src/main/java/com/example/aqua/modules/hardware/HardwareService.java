package com.example.aqua.modules.hardware;

import org.springframework.stereotype.Service;
import com.example.aqua.modules.hardware.dtos.AddHardwareReq;
import java.util.Map;
import com.example.aqua.models.Hardware;
import com.example.aqua.shared.utils.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

@Service
public class HardwareService {
    private final HardwareRepository hardwareRepository;

    public HardwareService(HardwareRepository hardwareRepository) {
        this.hardwareRepository = hardwareRepository;
    }

    public Map<String, Object> addHardware(AddHardwareReq body) {
        try {
        System.out.println("Adding hardware: " + body.getHardwareId() + " for user: " + body.getUserId());

        Hardware hardware = new Hardware();
        hardware.setHardwareId(body.getHardwareId());
        // hardware.setHardwareKey(body.getHardwareKey());
        hardware.setUserId(body.getUserId());
        hardware.setConfig("{}"); 
        hardware.setReadings("{}");


        Hardware savedHardware = hardwareRepository.save(hardware);

        System.out.println("Hardware added with ID: " + savedHardware.getHardwareId());

        return Response.format(true, "Hardware added successfully", savedHardware.toMap());

        } catch (Exception e) {
            return Response.format(false, "User creation failed: " + e.getMessage(), null);
        }
    }

    public Map<String, Object> getHardware(String hardwareId) {
        try {
            Hardware hardware = hardwareRepository.findByHardwareId(hardwareId);
            if (hardware == null) {
                return Response.format(false, "Hardware not found", null);
            }
            return Response.format(true, "Hardware retrieved successfully", hardware.toMap());
        } catch (Exception e) {
            return Response.format(false, "Failed to retrieve hardware: " + e.getMessage(), null);
        }
    }


    public Map<String, Object> setReadings(String hardwareId, JsonNode readings) {
        try {
            Hardware hardware = hardwareRepository.findByHardwareId(hardwareId);
            if (hardware == null) {
                return Response.format(false, "Hardware not found", null);
            }

            // todo... write a middleware function to validate the req.body later
            ObjectMapper mapper = new ObjectMapper();
            String readingsStr = mapper.writeValueAsString(readings);
            hardware.setReadings(readingsStr);

            return Response.format(true, "Reading updated successfully", null);
        } catch (Exception e) {
            return Response.format(false, "Failed to retrieve hardware: " + e.getMessage(), null);
        }
    }


    public Map<String, Object> getReadings(String hardwareId) {
        try {
            String hw_readings = hardwareRepository.getHardwareReadings(hardwareId);

            // String hw_readings = "{\"temp\": 25.5, \"ph\": 7.2, \"turb\": 5, \"tds\": 300}"; // Simulated readings
            

            ObjectMapper mapper = new ObjectMapper();
            JsonNode parsedReadings = mapper.readTree(hw_readings);

            Map<String, Object> readings = mapper.convertValue(parsedReadings, new TypeReference<Map<String, Object>>(){});

            return Response.format(true, "Readings retrieved successfully", readings);
        } catch (Exception e) {
            return Response.format(false, "Failed to retrieve hardware: " + e.getMessage(), null);
        }
    }


}