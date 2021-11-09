package com.example.demo.repositories.models;

import com.example.demo.domains.Dimensions;

import java.util.List;

public interface DimensionsModel {
    List<Dimensions> selectAllDimensions();
}
