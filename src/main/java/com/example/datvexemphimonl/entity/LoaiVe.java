package com.example.datvexemphimonl.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum LoaiVe {
    THUONG(1, "THUONG", 1000),
    VIP(2, "VIP", 2000),
    ;

    private final int code;
    private final String type;
    private final double cost;

    LoaiVe(int code, String type, double cost) {
        this.code = code;
        this.type = type;
        this.cost = cost;
    }

    @JsonProperty("code")
    public int getCode() {
        return code;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("cost")
    public double getCost() {
        return cost;
    }
}
