package com.example.TestProject.controller;

import com.example.TestProject.entity.Warehouse;
import com.example.TestProject.service.WarehouseService;
import com.example.TestProject.service.impl.WarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping("/create_location")
    public ResponseEntity<Warehouse> addNewLocation(@RequestBody Warehouse warehouse)
    {
        System.out.println(warehouse);
        warehouseService.CreateWarehouse(warehouse);
        return ResponseEntity.ok(warehouse);
    }


    @GetMapping("/warehouse/tree")
    public ResponseEntity<Warehouse> getWarehouses(@RequestParam String warehouse_code) {
        System.out.println(warehouse_code);
        return ResponseEntity.ok(warehouseService.getWarehouse(warehouse_code));
    }
}
