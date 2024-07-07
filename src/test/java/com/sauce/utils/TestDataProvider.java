package com.sauce.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public static Iterator<Object[]> provideData() throws IOException {
        List<Object[]> records = new ArrayList<>();
        String csvFile = "src/test/resources/testdata/testdata.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read the first line to skip headers
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                String username = data[0].trim();
                String password = data[1].trim();
                String expectedTitle = data[2].trim();
                records.add(new Object[]{username, password, expectedTitle});
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return records.iterator();
    }
}
