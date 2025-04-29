package com.fetch.receiptprocessor.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {

    @JsonProperty("shortDescription")
    private String shortDescription;

    @JsonProperty("price")
    private String price;

    public String getShortDescription() { return shortDescription; }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }
}
