package com.example.demo.controllers;

import com.example.demo.service.ScoringService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RequestMapping(
        value = "/api/v1/targeted-online-ads",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@RestController
public class ScoreController {

    private final ScoringService scoringService;
    // this is init ScoringController to take in this service
    @Autowired
    public ScoreController(ScoringService scoringService) {
        this.scoringService = scoringService;
    }

    @GetMapping()
    public String getSomePeople(@RequestParam String ehhn, String creatives) throws JsonProcessingException {
        return scoringService.getSomePeople(ehhn, creatives);
    }

}
