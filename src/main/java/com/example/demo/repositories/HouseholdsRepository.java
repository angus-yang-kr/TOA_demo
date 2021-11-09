package com.example.demo.repositories;

import com.example.demo.domains.Households;
import com.example.demo.repositories.models.HouseholdsModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Repository("households")
public class HouseholdsRepository implements HouseholdsModel {

    String jsonString = "/Users/a518215/IdeaProjects/demo/src/main/resources/static/household_features_sample.json";
    ObjectMapper mapper = new ObjectMapper();
    List<Households> DB = Arrays.asList(mapper.readValue(Paths.get(jsonString).toFile(), Households[].class));

    public HouseholdsRepository() throws IOException {
    }

    @Override
    public List<Households> selectAllHouseholds() {
        return DB;
    }
}
