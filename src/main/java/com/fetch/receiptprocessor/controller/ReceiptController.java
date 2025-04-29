package com.fetch.receiptprocessor.controller;

import com.fetch.receiptprocessor.model.Receipt;
import com.fetch.receiptprocessor.service.ReceiptService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @PostMapping("/process")
    public Map<String, String> processReceipt(@RequestBody Receipt receipt) {
        try {
            System.out.println("Retailer: " + receipt.getRetailer());
            System.out.println("Date: " + receipt.getPurchaseDate());
            System.out.println("Time: " + receipt.getPurchaseTime());
            System.out.println("Total: " + receipt.getTotal());
            System.out.println("Items: " + receipt.getItems());

            String id = receiptService.processReceipt(receipt);
            return Map.of("id", id);
        } catch (Exception e) {
            e.printStackTrace();  // This will print the full error to your console
            return Map.of("error", "Something went wrong: " + e.getMessage());
        }
    }

    @GetMapping("/{id}/points")
    public Map<String, Integer> getPoints(@PathVariable String id) {
        int points = receiptService.getPoints(id);
        return Map.of("points", points);
    }
}
