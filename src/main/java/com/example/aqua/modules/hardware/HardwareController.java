package com.example.aqua.modules.hardware;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import com.example.aqua.shared.dtos.ApiResponse;
import com.example.aqua.modules.hardware.dtos.AddHardwareReq;

@RestController
@RequestMapping("/hardware")
public class HardwareController {
    private final HardwareService hardwareService;

    public HardwareController(HardwareService hardwareService) {
        this.hardwareService = hardwareService;
    }

    @PostMapping("/add-device")
    public ResponseEntity<ApiResponse> addHardware(@RequestBody AddHardwareReq body) {
        Map<String, Object> data = hardwareService.addHardware(body);
        return ResponseEntity.ok(new ApiResponse(data));
    }
    
    @GetMapping("/{hardwareId}")
    public ResponseEntity<ApiResponse> getHardware(@PathVariable String hardwareId) {
        Map<String, Object> data = hardwareService.getHardware(hardwareId);
        return ResponseEntity.ok(new ApiResponse(data));
    }

    @GetMapping("/fetch-readings/{hardwareId}")
    public ResponseEntity<ApiResponse> addHardware(@PathVariable String hardwareId) {
        Map<String, Object> data = hardwareService.getReadings(hardwareId);
        return ResponseEntity.ok(new ApiResponse(data));
    }

}