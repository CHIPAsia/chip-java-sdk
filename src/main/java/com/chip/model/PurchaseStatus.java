package com.chip.model;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * com.chip.model.Purchase status. Can have the following values:   &#x60;created&#x60;: com.chip.model.Purchase was created using POST /purchases/ or Billing API capabilities.  ---  &#x60;sent&#x60;: Invoice for this purchase was sent over email using Billing API capabilities.  ---  &#x60;viewed&#x60;: The client has viewed the payform and/or invoice details for this purchase.  ---  &#x60;error&#x60;: There was a failed payment attempt for this purchase because of a problem with customer&#39;s payment instrument (e.g. low account balance). You can analyze the &#x60;.transaction_data&#x60; to get information on reason of the failure.  ---  &#x60;cancelled&#x60;: com.chip.model.Purchase was cancelled using the &#x60;POST /purchases/{id}/cancel/&#x60; endpoint; payment for it is not possible anymore.  ---  &#x60;overdue&#x60;: com.chip.model.Purchase is past its&#39; &#x60;.due&#x60;, but payment for it is still possible (unless e.g. POST /purchases/{id}/cancel/ is used).  ---  &#x60;expired&#x60;: com.chip.model.Purchase is past its&#39; &#x60;.due&#x60; and payment for it isn&#39;t possible anymore (as a result of &#x60;purchase.due_strict&#x60; having been set to &#x60;true&#x60;).  ---  &#x60;blocked&#x60;: Like &#x60;error&#x60;, but payment attempt was blocked due to fraud scoring below threshold or other security checks not passing.  ---  &#x60;hold&#x60;: Funds are on hold for this com.chip.model.Purchase (&#x60;.skip_capture: true&#x60; was used). You can now run &#x60;POST /capture/&#x60; or &#x60;POST /release/&#x60; for this payment to capture the payment or return funds to the client, respectively.  ---  &#x60;released&#x60;: This com.chip.model.Purchase previously had &#x60;hold&#x60; status, but funds have since been released and returned to the customer&#39;s card.  ---  &#x60;preauthorized&#x60;: A preauthorization of a card (authorization of card data without a financial transaction) was executed successfully using this com.chip.model.Purchase. See the description of the &#x60;.skip_capture&#x60; field for more details.  ---  &#x60;paid&#x60;: com.chip.model.Purchase was successfully paid for.  ---  &#x60;cleared&#x60;: Funds for this com.chip.model.Purchase (that was already &#x60;paid&#x60;) have been transferred for clearing in payment card network. All non-card payment methods and some card payment methods (depends on configuration) don&#39;t use this status and Purchases paid using them stay in &#x60;paid&#x60; status instead.  ---  &#x60;settled&#x60;: Settlement was issued for funds for this com.chip.model.Purchase (that was already &#x60;paid&#x60;). All non-card payment methods and some card payment methods (depends on configuration) don&#39;t use this status and Purchases paid using them stay in &#x60;paid&#x60; status instead.  ---  &#x60;chargeback&#x60;: A chargeback was registered for this, previously paid, com.chip.model.Purchase.  ---  &#x60;refunded&#x60;: This com.chip.model.Purchase had its payment refunded, fully or partially.
 */
@JsonAdapter(PurchaseStatus.Adapter.class)
public enum PurchaseStatus {
  
  CREATED("created"),
  
  SENT("sent"),
  
  VIEWED("viewed"),
  
  ERROR("error"),
  
  CANCELLED("cancelled"),
  
  OVERDUE("overdue"),
  
  EXPIRED("expired"),
  
  BLOCKED("blocked"),
  
  HOLD("hold"),
  
  RELEASED("released"),
  
  PREAUTHORIZED("preauthorized"),
  
  PAID("paid"),
  
  CLEARED("cleared"),
  
  SETTLED("settled"),
  
  CHARGEBACK("chargeback"),
  
  REFUNDED("refunded");

  private String value;

  PurchaseStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static PurchaseStatus fromValue(String value) {
    for (PurchaseStatus b : PurchaseStatus.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<PurchaseStatus> {
    @Override
    public void write(final JsonWriter jsonWriter, final PurchaseStatus enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public PurchaseStatus read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return PurchaseStatus.fromValue(value);
    }
  }
}

