package com.json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.*;

public class InventoryControl {
    //variables
    static Double weight, price, amount;

    // Prints to detail of given object typecast as MAP
    public static void printDetails(Map dataDetails) {
        weight=null; price=null;
        Iterator<Map.Entry> itr1 = dataDetails.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry pair = itr1.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
            if (pair.getKey().equals("price")) {
                price = Double.parseDouble(pair.getValue().toString());
            }
            if (pair.getKey().equals("weight")) {
                weight = Double.parseDouble(pair.getValue().toString());
            }
            if (price != null && weight != null) {
                amount = weight * price;
                System.out.println("Total Amount : " + amount);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to JSON Inventory Data Management");
        JSONParser parser = new JSONParser();
        try {
            // reads path to json file
            Object details = parser.parse(new FileReader("src/resources/inventoryDetails.json"));
            // typecasting JSONObject
            JSONObject obj = (JSONObject) details;
            // prints JSONObject
            // printDetails(obj);
            // typecast to Map prints String to console
            Map dataDetails = ((Map) obj.get("Rice"));
            System.out.println("Rice--------");
            printDetails(dataDetails);
            dataDetails = ((Map) obj.get("Wheat"));
            System.out.println("Wheat-------");
            printDetails(dataDetails);
            dataDetails = ((Map) obj.get("Pulses"));
            System.out.println("Pulses------");
            printDetails(dataDetails);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
