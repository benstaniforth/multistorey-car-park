package com.softwire.training.parking;

public class SpaceInfo {
    private int floor;
    private ParkingSpace space;

    public SpaceInfo(int floor, ParkingSpace space) {
        this.floor = floor;
        this.space = space;
    }

    public int getFloor() {
        return floor;
    }

    public ParkingSpace getSpace() {
        return space;
    }
}
