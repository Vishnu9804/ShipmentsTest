package com.example.TestProject.service.impl;

import com.example.TestProject.entity.Warehouse;
import com.example.TestProject.repository.WarehouseRepository;
import com.example.TestProject.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    WarehouseRepository warehouseRepository;
    @Override
    public void CreateWarehouse(Warehouse warehouse) {
        System.out.println("Inside Service"+warehouse);
        String parentLocationCode = warehouse.getParent_location_code();
        if(parentLocationCode == null)
        {
            System.out.println("Parent location code is null");
            warehouseRepository.save(warehouse);
        }
        else
        {
            System.out.println("Parent location code is notnull");
            Optional<Warehouse> warehouseOptional = warehouseRepository.findById(parentLocationCode);
            if(warehouseOptional.isPresent())
            {
                warehouseRepository.save(warehouse);
            }
        }
    }
}
