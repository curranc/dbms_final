package com.entities;

import java.sql.Time;

/**
 * Created by abatewongc on 3/30/2016.
 */
public class TimeSlot {
    private int day;
    private String timeStart, timeEnd;

    public TimeSlot(String timeStart, String timeEnd, int day) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.day = day;
    }
    public TimeSlot(){}

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
