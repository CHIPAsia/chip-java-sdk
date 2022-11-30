package com.chip.model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;

public class PaymentMethods {
    @SerializedName("available_payment_methods")
    List<String> availablePaymentMethods;

    @SerializedName("by_country")
    HashMap<String, List<String>> byCountry;

    @SerializedName("country_names")
    HashMap<String, String> countryNames;

    @SerializedName("names")
    HashMap<String, String> names;

    @SerializedName("card_methods")
    List<String> cardMethods;

}
