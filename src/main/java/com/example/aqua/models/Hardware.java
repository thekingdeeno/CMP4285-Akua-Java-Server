// package com.example.aqua.models.hardware;
// import jakarta.persistence.*;

// @Entity
// @Table(name = "hardware")
// public class Hardware {
//     private String hardware_id;
//     private String hardware_key;
//     private String user_id;
//     private String config;
//     private String metadata;

//     public Hardware() {
//         this.hardware_id = java.util.UUID.randomUUID().toString().replace("-", "").substring(0, 20);
//     }

//     public String getHardwareId() { return hardware_id; }
//     public String getHardwareKey() { return hardware_key; }
//     public String getUserId() { return user_id; }
//     public String getConfig() { return config; }
//     public String getMetadata() { return metadata; }

//     public void setHardwareId(String hardware_id) { this.hardware_id = hardware_id; }
//     public void setHardwareKey(String hardware_key) { this.hardware_key = hardware_key; }
//     public void setUserId(String user_id) { this.user_id = user_id; }
//     public void setConfig(String config) { this.config = config; }
//     public void setMetadata(String metadata) { this.metadata = metadata; }
// }