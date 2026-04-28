package com.example.aqua.models;

import jakarta.persistence.*;

@Entity
@Table(name = "hardware")
public class Hardware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hw_id;
    private String hw_key;
    private String user_id;
    private String config;
    private String readings;

    public Hardware() {
        this.hw_id = java.util.UUID.randomUUID().toString().replace("-", "").substring(0, 20);
    }

    public String getHardwareId() { return hw_id; }
    public String getHardwareKey() { return hw_key; }
    public String getUserId() { return user_id; }
    public String getConfig() { return config; }
    public String getReadings() { return readings; }

    public void setHardwareId(String hw_id) { this.hw_id = hw_id; }
    public void setHardwareKey(String hw_key) { this.hw_key = hw_key; }
    public void setUserId(String user_id) { this.user_id = user_id; }
    public void setConfig(String config) { this.config = config; }
    public void setReadings(String readings) { this.readings = readings; }

    public java.util.Map<String, Object> toMap() {
        java.util.Map<String, Object> map = new java.util.HashMap<>();
        map.put("id", id);
        map.put("hw_id", hw_id);
        map.put("user_id", user_id);
        map.put("config", config);
        map.put("readings", readings);
        return map;
    }
}