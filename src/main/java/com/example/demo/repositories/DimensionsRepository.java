package com.example.demo.repositories;

import com.example.demo.domains.Dimensions;
import com.example.demo.repositories.models.DimensionsModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Repository("dimensions")
public class DimensionsRepository implements DimensionsModel {

    String jsonString = "/Users/a518215/IdeaProjects/demo/src/main/resources/static/dim_sample.json";
    ObjectMapper mapper = new ObjectMapper();
    List<Dimensions> DB = Arrays.asList(mapper.readValue(Paths.get(jsonString).toFile(), Dimensions[].class));

    public DimensionsRepository() throws IOException {
    }

    @Override
    public List<Dimensions> selectAllDimensions() {
        return DB;
    }
}
