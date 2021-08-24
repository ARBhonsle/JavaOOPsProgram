package com.json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

public class StockManagement {
    // variables
    static Double numberOfShares, sharePrice, stockValue, totalStockValue = 0.0;

    // Prints to detail of given object typecast as MAP
    public static void printDetails(Map dataDetails) {
        numberOfShares = null;
        numberOfShares = null;
        Iterator<Map.Entry> itr1 = dataDetails.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry pair = itr1.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
            if (pair.getKey().equals("numberOfShares")) {
                numberOfShares = Double.parseDouble(pair.getValue().toString());
            }
            if (pair.getKey().equals("sharePrice")) {
                sharePrice = Double.parseDouble(pair.getValue().toString());
            }
            if (numberOfShares != null && sharePrice != null) {
                stockValue = numberOfShares * sharePrice;
                System.out.println("Total Amount : " + stockValue);
                totalStockValue += stockValue;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Stock Account Management Report");
        JSONParser parser = new JSONParser();
        try {
            // reads & writes to json file
            String pathInput = "src/resources/stockDetails.json";

            Object details = parser.parse(new FileReader(pathInput));
            // typecasting JSONObject
            JSONObject obj = (JSONObject) details;
            System.out.println("----------------------- Stock Report ----------------");
            // AAA- Group
            System.out.println("AAA-Group Stock: ");
            Map dataDetails = ((Map) obj.get("AAA-Group"));
            printDetails(dataDetails);
            // ABB-Group
            System.out.println("ABB-Group Stock: ");
            dataDetails = ((Map) obj.get("ABB-Group"));
            printDetails(dataDetails);
            // ABC-Group
            System.out.println("ABC-Group Stock: ");
            dataDetails = ((Map) obj.get("ABC-Group"));
            printDetails(dataDetails);
            // SSS-Group
            System.out.println("SSS-Group Stock: ");
            dataDetails = ((Map) obj.get("SSS-Group"));
            printDetails(dataDetails);
            // total stock value
            System.out.println("Total Stock value: " + totalStockValue);
            System.out.println("----------------------- End of Report ----------------");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
