package com.entities;

/**
 * Created by Christian on 3/31/2016.
 */
public class Location {
    private int locationID, roomNumber;
    private String name;

    public Location(int locationID, int roomNumber, String name) {
        this.locationID = locationID;
        this.roomNumber = roomNumber;
        this.name = name;
    }
    public Location(){}

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
