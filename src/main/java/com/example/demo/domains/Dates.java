package com.example.demo.domains;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dates {
    private final String date;
    private final String day_of_week_short_name;
    private final String weekend_flag;
    private final Integer prev_holiday_week;
    private final Integer next_holiday_week;

    public Dates(@JsonProperty("date") String date,
                 @JsonProperty("day_of_week_short_name") String day_of_week_short_name,
                 @JsonProperty("weekend_flag") String weekend_flag,
                 @JsonProperty("prev_holiday_week") Integer prev_holiday_week,
                 @JsonProperty("next_holiday_week") Integer next_holiday_week
    ) {
        this.date = date;
        this.day_of_week_short_name = day_of_week_short_name;
        this.weekend_flag = weekend_flag;
        this.prev_holiday_week = prev_holiday_week;
        this.next_holiday_week = next_holiday_week;
    }

    public String getDate() {
        return date;
    }

    public Integer getPrev_holiday_week() {
        return prev_holiday_week;
    }

    public String getDay_of_week_short_name() {
        return day_of_week_short_name;
    }

    public String getWeekend_flag() {
        return weekend_flag;
    }

    public Integer getNext_holiday_week() {
        return next_holiday_week;
    }
}
