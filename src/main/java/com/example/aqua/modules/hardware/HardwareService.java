// package com.example.aqua.modules.hardware;

// import org.springframework.stereotype.Service;
// import com.example.aqua.modules.hardware.dtos.AddHardwareReq;
// import java.util.HashMap;
// import java.util.Map;
// import com.example.aqua.modules.hardware.HardwareRepository;
// import com.example.aqua.models.Hardware;

// @Service
// public class HardwareService {
//     private final HardwareRepository hardwareRepository;
//     public HardwareService() {
//         this.hardwareRepository = hardwareRepository;
//     }

//     public Map<String, Object> addHardware(AddHardwareReq body) {
//         System.out.println("Adding hardware: " + body.getHardwareId() + " for user: " + body.getUserId());

//         Hardware hardware = new Hardware();
//         hardware.setHardwareId(body.getHardwareId());
//         hardware.setHardwareKey(body.getHardwareKey());
//         hardware.setUserId(body.getUserId());
//         hardware.setConfig(body.getConfig());
//         hardware.setMetadata(body.getMetadata());

//         Hardware savedHardware = hardwareRepository.save(hardware);

//         System.out.println("Hardware added with ID: " + savedHardware.getHardwareId());


//         Map<String, Object> response = new HashMap<>();
//         response.put("status", true);
//         response.put("message", "Hardware added successfully");
//         response.put("data", savedHardware);
//         return response;
//     }

// }