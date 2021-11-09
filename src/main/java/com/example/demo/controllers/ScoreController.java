package com.example.demo.controllers;

import com.example.demo.domains.Dates;
import com.example.demo.service.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(
        value = "/api/v1/targeted-online-ads",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@RestController
public class ScoreController {

    private final PersonService personService;
    // this is init PersonController to take in this service
    @Autowired
    public ScoreController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public String getSomePeople(@RequestParam String ehhn, String creatives) throws JsonProcessingException {
        return personService.getSomePeople(ehhn, creatives);
    }

}
