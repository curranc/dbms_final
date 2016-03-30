package com.entities;

/**
 * Created by abatewongc on 3/30/2016.
 */
public class TimeSlot {
    private int timeStart, timeEnd, day;

    public TimeSlot(int timeStart, int timeEnd, int day) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.day = day;
    }

    public int getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(int timeStart) {
        this.timeStart = timeStart;
    }

    public int getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(int timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
