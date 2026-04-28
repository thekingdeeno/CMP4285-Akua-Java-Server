package com.example.aqua.modules.hardware.dtos;


// import com.fasterxml.jackson.databind.JsonNode;


public class AddHardwareReq {
    private String hardwareId;
    private String hardwareKey;
    private String userId;
    // private String config;
    // private String readings;

    public String getHardwareId() { return hardwareId; }
    public String getHardwareKey() { return hardwareKey; }
    public String getUserId() { return userId; }
    // public String getConfig() { return config; }
    // public String getReadings() { return readings; }

    // public void setConfig(String config) { this.config = config; }
    // public void setReadings(String readings) { this.readings = readings; }
}