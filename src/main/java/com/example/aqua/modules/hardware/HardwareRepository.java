package com.example.aqua.modules.hardware;

import com.example.aqua.models.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HardwareRepository extends JpaRepository<Hardware, String> {
    @Query("SELECT hw FROM Hardware hw WHERE hw.hw_id = :hw_id")
    Hardware findByHardwareId(@Param("hw_id") String hw_id);

    @Query("SELECT hw.readings FROM Hardware hw WHERE hw.hw_id = :hw_id")
    String getHardwareReadings(@Param("hw_id") String hw_id);
}