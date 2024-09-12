package com.satendra.testcontainer;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    @GetMapping("/vehicle")
    public List<VehicleEntity> getVehicle(){
            return vehicleRepository.findAll();
    }

    @PostMapping("/vehicle")
    public void insertVehicle(@RequestBody VehicleEntity vehicleEntity){
        vehicleRepository.save(vehicleEntity);
    }
}
