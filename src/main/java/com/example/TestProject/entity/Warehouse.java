package com.example.TestProject.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Warehouse {
    @Id
    private String location_code;

    @Nullable
    private String parent_location_code;

    @OneToMany(mappedBy = "location_code", cascade = CascadeType.ALL)
    @Nullable
    private List<Warehouse> child;

    public String getLocation_code() {
        return location_code;
    }

    public void setLocation_code(String location_code) {
        this.location_code = location_code;
    }

    public String getParent_location_code() {
        return parent_location_code;
    }

    public void setParent_location_code(String parent_location_code) {
        this.parent_location_code = parent_location_code;
    }

    @Nullable
    public List<Warehouse> getChild() {
        return child;
    }

    public void setChild(@Nullable List<Warehouse> child) {
        this.child = child;
    }
}
