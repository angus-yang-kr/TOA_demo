package com.example.demo.repositories.models;

import com.example.demo.domains.Scoring;

import java.util.List;

public interface ScoringModel {
    List<Scoring> selectAllScoring();
}
