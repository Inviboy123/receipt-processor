package com.fetch.receiptprocessor.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Receipt {

    @JsonProperty("retailer")
    private String retailer;

    @JsonProperty("purchaseDate")
    private String purchaseDate;

    @JsonProperty("purchaseTime")
    private String purchaseTime;

    @JsonProperty("items")
    private List<Item> items;

    @JsonProperty("total")
    private String total;

    // Add getters and setters
    public String getRetailer() { return retailer; }
    public void setRetailer(String retailer) { this.retailer = retailer; }

    public String getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(String purchaseDate) { this.purchaseDate = purchaseDate; }

    public String getPurchaseTime() { return purchaseTime; }
    public void setPurchaseTime(String purchaseTime) { this.purchaseTime = purchaseTime; }

    public List<Item> getItems() { return items; }
    public void setItems(List<Item> items) { this.items = items; }

    public String getTotal() { return total; }
    public void setTotal(String total) { this.total = total; }
}
