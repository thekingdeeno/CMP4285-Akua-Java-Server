package com.example.aqua.shared.dtos;
import java.util.Map;

public class ApiResponse {
    private boolean status;
    private String message;
    private Object data;

    public ApiResponse(Map<String, Object> data) {
        this.status = (boolean) data.get("status");
        this.message = (String) data.get("message");
        this.data = data.get("data") != null ? data.get("data") : null;
    }

    public boolean getStatus() { return status; }
    public String getMessage() { return message; }
    public Object getData() { return data; }
}