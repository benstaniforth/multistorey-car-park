package com.softwire.training.parking;

import java.util.*;

public class MultiStorey {
    private List<Floor> floors;

    public MultiStorey(Collection<Floor> floors) {
        this.floors = new ArrayList<>(floors);
    }

    public MultiStorey(Floor... floors) {
        this(Arrays.asList(floors));
    }

    public Collection<Floor> getFloors() {
        return floors;
    }

    public ParkingSpace getNearestSpaceForVehicle(Vehicle vehicle) {

        floors.sort(Comparator.comparing(Floor::getFloorNumber));

        for (Floor floor: floors) {
            if (floor.getNearestFreeSpaceForVehicle(vehicle) != null) {
                return floor.getNearestFreeSpaceForVehicle(vehicle);
            }
        }
        return null;
    }

    public ParkingSpace getSpaceContainingVehicleWithRegistration(String registration) {

        for (Floor floor: floors) {
            for (ParkingSpace parkingSpace: floor.getParkingSpaces()) {
                if (parkingSpace.isOccupied() && parkingSpace.getParkedVehicle().getRegistration().equals(registration)){
                    return parkingSpace;
                }
            }
        }
        return null;
    }
}
