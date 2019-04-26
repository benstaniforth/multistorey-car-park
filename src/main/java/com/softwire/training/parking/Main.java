package com.softwire.training.parking;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<SpaceInfo> allSpaces = ReadCSVFile.getInfoFromCSVFile("spaces.csv");
        System.out.println(allSpaces);

    }

}
