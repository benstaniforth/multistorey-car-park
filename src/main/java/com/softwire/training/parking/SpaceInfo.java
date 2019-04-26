package com.softwire.training.parking;

import com.google.common.base.MoreObjects;

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

    public String toString () {
        return MoreObjects.toStringHelper(this.getClass())
                .add("Floor", floor)
                .add("info", space)
                .toString();
    }
}
