package com.example.demo.repositories;

import com.example.demo.domains.Scoring;
import com.example.demo.repositories.models.ScoringModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Repository("scoring")
public class ScoringRepository implements ScoringModel {

    String jsonString = "/Users/a518215/IdeaProjects/demo/src/main/resources/static/scoring.json";
    ObjectMapper mapper = new ObjectMapper();
    List<Scoring> DB = Arrays.asList(mapper.readValue(Paths.get(jsonString).toFile(), Scoring[].class));

    public ScoringRepository() throws IOException {
    }

    @Override
    public List<Scoring> selectAllScoring() {
        return DB;
    }
}
