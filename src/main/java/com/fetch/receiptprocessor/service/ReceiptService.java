package com.fetch.receiptprocessor.service;

import com.fetch.receiptprocessor.model.Receipt;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ReceiptService {

    private final Map<String, Integer> receiptPoints = new HashMap<>();

    public String processReceipt(Receipt receipt) {
        int points = calculatePoints(receipt);
        String id = UUID.randomUUID().toString();
        receiptPoints.put(id, points);
        return id;
    }

    public int getPoints(String id) {
        return receiptPoints.getOrDefault(id, 0);
    }

    private int calculatePoints(Receipt receipt) {
        int points = 0;
    
        // Rule 1: Alphanumeric characters in retailer name
        points += receipt.getRetailer().replaceAll("[^a-zA-Z0-9]", "").length();
    
        // Rule 2: 50 points if total is a round dollar amount with no cents
        if (receipt.getTotal().matches("\\d+\\.00")) {
            points += 50;
        }
    
        // Rule 3: 25 points if total is multiple of 0.25
        try {
            double total = Double.parseDouble(receipt.getTotal());
            if (total % 0.25 == 0) {
                points += 25;
            }
        } catch (NumberFormatException ignored) {
        }
    
        // Rule 4: 5 points for every two items
        if (receipt.getItems() != null) {
            points += (receipt.getItems().size() / 2) * 5;
    
            // Rule 5: Bonus points for item description
            for (var item : receipt.getItems()) {
                String desc = item.getShortDescription().trim();
                if (desc.length() % 3 == 0) {
                    try {
                        double price = Double.parseDouble(item.getPrice());
                        points += Math.ceil(price * 0.2);
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        }
    
        // Rule 6: 6 points if purchase day is odd
        String[] dateParts = receipt.getPurchaseDate().split("-");
        if (dateParts.length == 3) {
            try {
                int day = Integer.parseInt(dateParts[2]);
                if (day % 2 == 1) {
                    points += 6;
                }
            } catch (NumberFormatException ignored) {
            }
        }
    
        // Rule 7: 10 points if time is between 2:00pm and 4:00pm
        String[] timeParts = receipt.getPurchaseTime().split(":");
        if (timeParts.length == 2) {
            try {
                int hour = Integer.parseInt(timeParts[0]);
                int minute = Integer.parseInt(timeParts[1]);
                if ((hour == 14 && minute >= 0) || (hour == 15)) {
                    points += 10;
                }
            } catch (NumberFormatException ignored) {
            }
        }
    
        return points;
    }
    
}
