package com.json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.*;

public class InventoryControl {
    // Prints to detail of given object typecast as MAP
    public static void printDetails(Map dataDetails){
        Iterator<Map.Entry> itr1 = dataDetails.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry pair = itr1.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to JSON Inventory Data Management");
        JSONParser parser = new JSONParser();
        try {
            // reads path to json file
            Object details = parser.parse(new FileReader("src/resources/inventoryDetails.json"));
            // typecasting JSONObject
            JSONObject obj=(JSONObject) details;
            // prints JSONObject
            // printDetails(obj);
            // typecast to Map prints String to console
            // Rice
            Map dataDetails = ((Map)obj.get("Rice"));
            System.out.println("Rice--------");
            printDetails(dataDetails);
            // Wheat

            dataDetails = ((Map)obj.get("Wheat"));
            System.out.println("Wheat-------");
            printDetails(dataDetails);

            //Pulses
            dataDetails = ((Map)obj.get("Pulses"));
            System.out.println("Pulses------");
            printDetails(dataDetails);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
