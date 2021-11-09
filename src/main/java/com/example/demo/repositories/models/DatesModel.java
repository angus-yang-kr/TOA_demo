package com.example.demo.repositories.models;

import com.example.demo.domains.Dates;

import java.util.List;

public interface DatesModel {
    List<Dates> selectAllDates();
}
