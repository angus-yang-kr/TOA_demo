package com.example.demo.repositories.models;

import com.example.demo.domains.Households;

import java.util.List;

public interface HouseholdsModel {
    List<Households> selectAllHouseholds();
}
