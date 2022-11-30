package com.chip.model;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class Charge {

    @SerializedName("recurring_token")
    private final UUID recurringToken;

    public Charge(UUID recurringToken) {
        this.recurringToken = recurringToken;
    }
}
