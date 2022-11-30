package com.chip.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Objects;

public class PaymentDetails {
  public static final String SERIALIZED_NAME_IS_OUTGOING = "is_outgoing";
  @SerializedName(SERIALIZED_NAME_IS_OUTGOING)
  private Boolean isOutgoing = false;

  /**
   * Gets or Sets paymentType
   */
  @JsonAdapter(PaymentTypeEnum.Adapter.class)
  public enum PaymentTypeEnum {
    PURCHASE("purchase"),
    
    PURCHASE_CHARGE("purchase_charge"),
    
    PAYOUT("payout"),
    
    BANK_PAYMENT("bank_payment"),
    
    REFUND("refund"),
    
    CUSTOM("custom");

    private String value;

    PaymentTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PaymentTypeEnum fromValue(String value) {
      for (PaymentTypeEnum b : PaymentTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<PaymentTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PaymentTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PaymentTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return PaymentTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PAYMENT_TYPE = "payment_type";
  @SerializedName(SERIALIZED_NAME_PAYMENT_TYPE)
  private PaymentTypeEnum paymentType;

  public static final String SERIALIZED_NAME_AMOUNT = "amount";
  @SerializedName(SERIALIZED_NAME_AMOUNT)
  private Integer amount;

  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  private String currency;

  public static final String SERIALIZED_NAME_NET_AMOUNT = "net_amount";
  @SerializedName(SERIALIZED_NAME_NET_AMOUNT)
  private Integer netAmount = null;

  public static final String SERIALIZED_NAME_FEE_AMOUNT = "fee_amount";
  @SerializedName(SERIALIZED_NAME_FEE_AMOUNT)
  private Integer feeAmount = null;

  public static final String SERIALIZED_NAME_PENDING_AMOUNT = "pending_amount";
  @SerializedName(SERIALIZED_NAME_PENDING_AMOUNT)
  private Integer pendingAmount = null;

  public static final String SERIALIZED_NAME_PENDING_UNFREEZE_ON = "pending_unfreeze_on";
  @SerializedName(SERIALIZED_NAME_PENDING_UNFREEZE_ON)
  private Integer pendingUnfreezeOn = null;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_PAID_ON = "paid_on";
  @SerializedName(SERIALIZED_NAME_PAID_ON)
  private Integer paidOn = null;

  public static final String SERIALIZED_NAME_REMOTE_PAID_ON = "remote_paid_on";
  @SerializedName(SERIALIZED_NAME_REMOTE_PAID_ON)
  private Integer remotePaidOn = null;


  public PaymentDetails isOutgoing(Boolean isOutgoing) {
    this.isOutgoing = isOutgoing;
    return this;
  }

  public Boolean getIsOutgoing() {
    return isOutgoing;
  }

  public void setIsOutgoing(Boolean isOutgoing) {
    this.isOutgoing = isOutgoing;
  }

  public PaymentTypeEnum getPaymentType() {
    return paymentType;
  }

  public PaymentDetails amount(Integer amount) {
    
    this.amount = amount;
    return this;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public PaymentDetails currency(String currency) {
    
    this.currency = currency;
    return this;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Integer getNetAmount() {
    return netAmount;
  }

  public Integer getFeeAmount() {
    return feeAmount;
  }

  public Integer getPendingAmount() {
    return pendingAmount;
  }

  public Integer getPendingUnfreezeOn() {
    return pendingUnfreezeOn;
  }

  public PaymentDetails description(String description) {
    
    this.description = description;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getPaidOn() {
    return paidOn;
  }

  public Integer getRemotePaidOn() {
    return remotePaidOn;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentDetails paymentDetails = (PaymentDetails) o;
    return Objects.equals(this.isOutgoing, paymentDetails.isOutgoing) &&
        Objects.equals(this.paymentType, paymentDetails.paymentType) &&
        Objects.equals(this.amount, paymentDetails.amount) &&
        Objects.equals(this.currency, paymentDetails.currency) &&
        Objects.equals(this.netAmount, paymentDetails.netAmount) &&
        Objects.equals(this.feeAmount, paymentDetails.feeAmount) &&
        Objects.equals(this.pendingAmount, paymentDetails.pendingAmount) &&
        Objects.equals(this.pendingUnfreezeOn, paymentDetails.pendingUnfreezeOn) &&
        Objects.equals(this.description, paymentDetails.description) &&
        Objects.equals(this.paidOn, paymentDetails.paidOn) &&
        Objects.equals(this.remotePaidOn, paymentDetails.remotePaidOn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isOutgoing, paymentType, amount, currency, netAmount, feeAmount, pendingAmount, pendingUnfreezeOn, description, paidOn, remotePaidOn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class com.chip.model.PaymentDetails {\n");
    sb.append("    isOutgoing: ").append(toIndentedString(isOutgoing)).append("\n");
    sb.append("    paymentType: ").append(toIndentedString(paymentType)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    netAmount: ").append(toIndentedString(netAmount)).append("\n");
    sb.append("    feeAmount: ").append(toIndentedString(feeAmount)).append("\n");
    sb.append("    pendingAmount: ").append(toIndentedString(pendingAmount)).append("\n");
    sb.append("    pendingUnfreezeOn: ").append(toIndentedString(pendingUnfreezeOn)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    paidOn: ").append(toIndentedString(paidOn)).append("\n");
    sb.append("    remotePaidOn: ").append(toIndentedString(remotePaidOn)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

