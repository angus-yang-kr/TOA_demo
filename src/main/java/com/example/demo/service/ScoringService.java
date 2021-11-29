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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


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

    // put error check if dates not found
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

    public Map<String, Float> get_household_attributes(String ehhn, List<Households> householdsRepository, Scoring scoringRepository) {
        // finds ehhn in household repo and
        String[] feature_keys = scoringRepository.getFeature_keys();
        Float[] features = new Float[13];
        for (Households household: householdsRepository) {
            System.out.println("this is household: " + household.getEhhn());
            if (household.getEhhn().equals(ehhn)) {
                System.out.println("we have a match");
                features = household.getFeatures();
            }
        }
        Float[] finalFeatures = features;
        Map<String, Float>  household_attributes = IntStream.range(0, feature_keys.length).boxed()
                .collect(Collectors.toMap(i -> feature_keys[i], i -> finalFeatures[i]));

        return household_attributes;
    }

    public Float get_score_based_on_weights_only(Creatives creative, Scoring scoringRepository) {
        float score = (float)creative.getClearingPrice() / 1000000;
        Integer placementId = Integer.parseInt(creative.getPlacementId());
        boolean score_boost = Arrays.stream(scoringRepository.getPremium_placements()).anyMatch(num -> num.equals(placementId));
        float score_boost_final = score_boost ? 1.0f : 0.0f;
        return score + score_boost_final;
    }

    public String getSomePeople(String ehhn, String creatives) throws JsonProcessingException {
        List<Dates> dateRepository = datesModel.selectAllDates();
        List<Dimensions> creativeDimensionsRepository = dimensionsModel.selectAllDimensions();
        List<Scoring> scoringRepository = scoringModel.selectAllScoring();
        List<Households> householdsRepository = householdsModel.selectAllHouseholds();
        List<Creatives> incoming_package = Arrays.asList(objectMapper.readValue(creatives, Creatives[].class));

        // this will loop through the incoming creatives and score individually
        for (Creatives newthing: incoming_package) {
            System.out.println("this is from input: " + ehhn
                    + " " + newthing.getId()
                    + " " + newthing.getClearingPrice()
                    + " " + newthing.getSlotId()
                    + " " + newthing.getPlacementId());
        }
        System.out.println("here is the hour: " + getDateContext(dateRepository).getHour());
        System.out.println("here is the first date: " + dateRepository.get(0).getDay_of_week_short_name());
        System.out.println("here is the dimension: " + creativeDimensionsRepository.get(0).getDestination_upcs());
        System.out.println("here is the scoring: " + Arrays.stream(scoringRepository.get(0).getPremium_placements()).anyMatch(num -> num.equals(55)));
        System.out.println("here is the households: " + householdsRepository.get(0).getEhhn());

        // retrieve the fake score
        float output = get_score_based_on_weights_only(incoming_package.get(0), scoringRepository.get(0));
        System.out.println("here is the fake score: " + output);

        // retrieve household features
        Map<String, Float> household_attributes = get_household_attributes(ehhn, householdsRepository, scoringRepository.get(0));
        household_attributes.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

        return "something";
    }
}
