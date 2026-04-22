package com.example.aqua.shared.utils;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import com.example.aqua.shared.dtos.ApiResponse;

public class Response {

    public static ResponseEntity<ApiResponse> success(String message, Map<String, Object> payload) {

        Map<String, Object> data = new HashMap<>();
        data.put("status", true);
        data.put("message", message);
        data.put("data", payload);
        return ResponseEntity.ok(new ApiResponse(data));    
    }

    public static ResponseEntity<ApiResponse> error( String message,  Map<String, Object> payload) {

        Map<String, Object> data = new HashMap<>();
        data.put("status", false);
        data.put("message", message);
        data.put("data", payload);
        return ResponseEntity.badRequest().body(new ApiResponse(data));
    }

    public static ResponseEntity<ApiResponse> generic( Map<String, Object> data) {
        Boolean status = (Boolean) data.get("status");
        String message = (String) data.get("message");
        @SuppressWarnings("unchecked")
        Map<String, Object> payload = (Map<String, Object>) data.get("data");
        if (status) {
            return success(message, payload);
        } else {
            return error(message, payload);
        }
    }

    public static Map<String, Object> format(Boolean status, String message,  Map<String, Object> payload) {
        Map<String, Object> data = new HashMap<>();
        data.put("status", status);
        data.put("message", message);
        data.put("data", payload != null ? payload : null);
        return data;
    }

}