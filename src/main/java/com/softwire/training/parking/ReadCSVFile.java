package com.softwire.training.parking;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVFile {

    public static List<SpaceInfo> getInfoFromCSVFile(String filename) throws IOException {

        List<String> csvFile = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
        List<SpaceInfo> allSpaceInfo = new ArrayList<>();

        for (int i = 1; i < csvFile.size(); i++) {
            SpaceInfo currentSpaceInfo = convertLineToSpaceInfo(csvFile.get(i));

            if (currentSpaceInfo != null) {
                allSpaceInfo.add(currentSpaceInfo);
            }
        }

        return allSpaceInfo;
    }


    public static SpaceInfo convertLineToSpaceInfo(String line) {

        String[] csvLine = line.split(",");

        switch (csvLine[4]) {
            case "CAR": {
                SpaceInfo individualSpaceInfo = new SpaceInfo(Integer.parseInt(csvLine[0]), new ParkingSpace(Integer.parseInt(csvLine[1]),
                        Double.parseDouble(csvLine[2]), Double.parseDouble(csvLine[3]), Vehicle.Type.CAR));
                return individualSpaceInfo;
            }
            case "VAN": {
                SpaceInfo individualSpaceInfo = new SpaceInfo(Integer.parseInt(csvLine[0]), new ParkingSpace(Integer.parseInt(csvLine[1]),
                        Double.parseDouble(csvLine[2]), Double.parseDouble(csvLine[3]), Vehicle.Type.VAN));
                return individualSpaceInfo;
            }
            case "MOTORCYCLE": {
                SpaceInfo individualSpaceInfo = new SpaceInfo(Integer.parseInt(csvLine[0]), new ParkingSpace(Integer.parseInt(csvLine[1]),
                        Double.parseDouble(csvLine[2]), Double.parseDouble(csvLine[3]), Vehicle.Type.MOTORCYCLE));
                return individualSpaceInfo;
            }
            default: {
                SpaceInfo individualSpaceInfo = new SpaceInfo(Integer.parseInt(csvLine[0]), new ParkingSpace(Integer.parseInt(csvLine[1]),
                        Double.parseDouble(csvLine[2]), Double.parseDouble(csvLine[3])));
                return individualSpaceInfo;
            }
        }

    }


}

