package com.example.demo.service;

import com.example.demo.domains.*;
import com.example.demo.repositories.models.DatesModel;
import com.example.demo.repositories.models.DimensionsModel;
import com.example.demo.repositories.models.HouseholdsModel;
import com.example.demo.repositories.models.ScoringModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

// once again, this is now labeled a bean, same as @component but service is clearly labelled
@Service
public class ScoringService {
    private final HouseholdsModel householdsModel;
    private final ScoringModel scoringModel;
    private final DimensionsModel dimensionsModel;
    private final DatesModel datesModel;
    private final ObjectMapper objectMapper;

    @Autowired
    public ScoringService(
            HouseholdsModel householdsModel,
            ScoringModel scoringModel,
            DimensionsModel dimensionsModel,
            DatesModel datesModel,
            ObjectMapper objectMapper) {
        this.householdsModel = householdsModel;
        this.scoringModel = scoringModel;
        this.dimensionsModel = dimensionsModel;
        this.datesModel = datesModel;
        this.objectMapper = objectMapper;
    }

    public Dates getDateContext(List<Dates> dates) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDateTime today = LocalDateTime.now();
        Dates date_context = null;
        for (Dates date: dates) {
            if (date.getDate().equals(today.format(formatter))) {
                date_context = date;
            }
        }
        date_context.setHour(today.getHour());
        return date_context;
    }
    public String getSomePeople(String ehhn, String creatives) throws JsonProcessingException {
        List<Dates> from_list = datesModel.selectAllDates();
        List<Dimensions> from_list_2 = dimensionsModel.selectAllDimensions();
        List<Scoring> from_list_3 = scoringModel.selectAllScoring();
        List<Households> from_list_4 = householdsModel.selectAllHouseholds();
        List<Creatives> incoming_package = Arrays.asList(objectMapper.readValue(creatives, Creatives[].class));

        for (Creatives newthing: incoming_package) {
            System.out.println("this is from input: " + ehhn
                    + " " + newthing.getId()
                    + " " + newthing.getClearingPrice()
                    + " " + newthing.getSlotId()
                    + " " + newthing.getPlacementId());
        }
        System.out.println("here is the hour: " + getDateContext(from_list).getHour());
        System.out.println("here is the first date: " + from_list.get(0).getDay_of_week_short_name());
        System.out.println("here is the dimension: " + from_list_2.get(0).getDestination_upcs()[0]);
        System.out.println("here is the scoring: " + from_list_3.get(0).getFeature_keys()[0]);
        System.out.println("here is the households: " + from_list_4.get(0).getEhhn());
        return "something";
    }
}
