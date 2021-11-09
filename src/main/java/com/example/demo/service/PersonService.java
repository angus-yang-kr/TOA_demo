package com.example.demo.service;

import com.example.demo.domains.Creatives;
import com.example.demo.repositories.models.DatesModel;
import com.example.demo.domains.Dates;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

// once again, this is now labeled a bean, same as @component but service is clearly labelled
@Service
public class PersonService {
    private final DatesModel datesModel;
    private final ObjectMapper objectMapper;

    @Autowired
    public PersonService(@Qualifier("dates")
            DatesModel datesModel,
            ObjectMapper objectMapper) {
        this.datesModel = datesModel;
        this.objectMapper = objectMapper;
    }

    public String getSomePeople(String ehhn, String creatives) throws JsonProcessingException {
        List<Dates> from_list = datesModel.selectAllDates();

        List<Creatives> incoming_package = Arrays.asList(objectMapper.readValue(creatives, Creatives[].class));

        for (Creatives newthing: incoming_package) {
            System.out.println("this is from input: " + newthing.getId()
                    + " " + newthing.getClearingPrice()
                    + " " + newthing.getSlotId()
                    + " " + newthing.getPlacementId());
        }

        System.out.println("here is the first date: " + from_list.get(0).getDay_of_week_short_name());
        return "something";
    }
}
