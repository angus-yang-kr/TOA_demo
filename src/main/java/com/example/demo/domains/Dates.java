package com.example.demo.domains;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dates {
    private String date;
    private String day_of_week_short_name;
    private String weekend_flag;
    private Integer prev_holiday_week;
    private Integer next_holiday_week;
    private Integer hour;

    public Dates(@JsonProperty("date") String date,
                 @JsonProperty("day_of_week_short_name") String day_of_week_short_name,
                 @JsonProperty("weekend_flag") String weekend_flag,
                 @JsonProperty("prev_holiday_week") Integer prev_holiday_week,
                 @JsonProperty("next_holiday_week") Integer next_holiday_week,
                 @JsonProperty("hour") Integer hour
    ) {
        this.date = date;
        this.day_of_week_short_name = day_of_week_short_name;
        this.weekend_flag = weekend_flag;
        this.prev_holiday_week = prev_holiday_week;
        this.next_holiday_week = next_holiday_week;
        this.hour = hour;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDay_of_week_short_name(String day_of_week_short_name) {
        this.day_of_week_short_name = day_of_week_short_name;
    }

    public void setWeekend_flag(String weekend_flag) {
        this.weekend_flag = weekend_flag;
    }

    public void setPrev_holiday_week(Integer prev_holiday_week) {
        this.prev_holiday_week = prev_holiday_week;
    }

    public void setNext_holiday_week(Integer next_holiday_week) {
        this.next_holiday_week = next_holiday_week;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public String getDate() {
        return date;
    }

    public String getDay_of_week_short_name() {
        return day_of_week_short_name;
    }

    public String getWeekend_flag() {
        return weekend_flag;
    }

    public Integer getPrev_holiday_week() {
        return prev_holiday_week;
    }

    public Integer getNext_holiday_week() {
        return next_holiday_week;
    }

    public Integer getHour() {
        return hour;
    }
}
