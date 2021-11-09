package com.example.demo.repositories;

import com.example.demo.domains.Dates;
import com.example.demo.repositories.models.DatesModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Repository("dates")
public class DatesRepository implements DatesModel {

    String jsonString = "/Users/a518215/IdeaProjects/demo/src/main/resources/static/dates.json";
    ObjectMapper mapper = new ObjectMapper();
    List<Dates> DB = Arrays.asList(mapper.readValue(Paths.get(jsonString).toFile(), Dates[].class));

    public DatesRepository() throws IOException {
    }

    @Override
    public List<Dates> selectAllDates() {
        return DB;
    }
}
