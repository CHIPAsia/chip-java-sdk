package com.chip.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PurchaseDetails {
  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  private String currency;

  public static final String SERIALIZED_NAME_PRODUCTS = "products";
  @SerializedName(SERIALIZED_NAME_PRODUCTS)
  private List<Product> products = new ArrayList<Product>();

  public static final String SERIALIZED_NAME_TOTAL = "total";
  @SerializedName(SERIALIZED_NAME_TOTAL)
  private Integer total = null;

  public static final String SERIALIZED_NAME_LANGUAGE = "language";
  @SerializedName(SERIALIZED_NAME_LANGUAGE)
  private String language = null;

  public static final String SERIALIZED_NAME_NOTES = "notes";
  @SerializedName(SERIALIZED_NAME_NOTES)
  private String notes;

  public static final String SERIALIZED_NAME_DEBT = "debt";
  @SerializedName(SERIALIZED_NAME_DEBT)
  private Integer debt = null;

  public static final String SERIALIZED_NAME_SUBTOTAL_OVERRIDE = "subtotal_override";
  @SerializedName(SERIALIZED_NAME_SUBTOTAL_OVERRIDE)
  private Integer subtotalOverride = null;

  public static final String SERIALIZED_NAME_TOTAL_TAX_OVERRIDE = "total_tax_override";
  @SerializedName(SERIALIZED_NAME_TOTAL_TAX_OVERRIDE)
  private Integer totalTaxOverride = null;

  public static final String SERIALIZED_NAME_TOTAL_DISCOUNT_OVERRIDE = "total_discount_override";
  @SerializedName(SERIALIZED_NAME_TOTAL_DISCOUNT_OVERRIDE)
  private Integer totalDiscountOverride = null;

  public static final String SERIALIZED_NAME_TOTAL_OVERRIDE = "total_override";
  @SerializedName(SERIALIZED_NAME_TOTAL_OVERRIDE)
  private Integer totalOverride = null;

  public PurchaseDetails(List<Product> products) {
    this.products = products;
  }

  /**
   * Gets or Sets requestClientDetails
   */
  @JsonAdapter(RequestClientDetailsEnum.Adapter.class)
  public enum RequestClientDetailsEnum {
    EMAIL("email"),
    
    PHONE("phone"),
    
    FULL_NAME("full_name"),
    
    PERSONAL_CODE("personal_code"),
    
    BRAND_NAME("brand_name"),
    
    LEGAL_NAME("legal_name"),
    
    REGISTRATION_NUMBER("registration_number"),
    
    TAX_NUMBER("tax_number"),
    
    COUNTRY("country"),
    
    CITY("city"),
    
    STREET_ADDRESS("street_address"),
    
    ZIP_CODE("zip_code"),
    
    BANK_ACCOUNT("bank_account"),
    
    BANK_CODE("bank_code"),
    
    SHIPPING_COUNTRY("shipping_country"),
    
    SHIPPING_CITY("shipping_city"),
    
    SHIPPING_STREET_ADDRESS("shipping_street_address"),
    
    SHIPPING_ZIP_CODE("shipping_zip_code");

    private String value;

    RequestClientDetailsEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RequestClientDetailsEnum fromValue(String value) {
      for (RequestClientDetailsEnum b : RequestClientDetailsEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RequestClientDetailsEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RequestClientDetailsEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RequestClientDetailsEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RequestClientDetailsEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_REQUEST_CLIENT_DETAILS = "request_client_details";
  @SerializedName(SERIALIZED_NAME_REQUEST_CLIENT_DETAILS)
  private List<RequestClientDetailsEnum> requestClientDetails = null;

  public static final String SERIALIZED_NAME_TIMEZONE = "timezone";
  @SerializedName(SERIALIZED_NAME_TIMEZONE)
  private String timezone;

  public static final String SERIALIZED_NAME_DUE_STRICT = "due_strict";
  @SerializedName(SERIALIZED_NAME_DUE_STRICT)
  private Boolean dueStrict;

  public static final String SERIALIZED_NAME_EMAIL_MESSAGE = "email_message";
  @SerializedName(SERIALIZED_NAME_EMAIL_MESSAGE)
  private String emailMessage;


  public PurchaseDetails currency(String currency) {
    
    this.currency = currency;
    return this;
  }

  public String getCurrency() {
    return currency;
  }


  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public PurchaseDetails products(List<Product> products) {
    
    this.products = products;
    return this;
  }

  public PurchaseDetails addProductsItem(Product productsItem) {
    this.products.add(productsItem);
    return this;
  }
  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public Integer getTotal() {
    return total;
  }

  public PurchaseDetails language(String language) {
    
    this.language = language;
    return this;
  }

  public String getLanguage() {
    return language;
  }


  public void setLanguage(String language) {
    this.language = language;
  }


  public PurchaseDetails notes(String notes) {
    
    this.notes = notes;
    return this;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public PurchaseDetails debt(Integer debt) {
    
    this.debt = debt;
    return this;
  }

  public Integer getDebt() {
    return debt;
  }

  public void setDebt(Integer debt) {
    this.debt = debt;
  }

  public PurchaseDetails subtotalOverride(Integer subtotalOverride) {
    
    this.subtotalOverride = subtotalOverride;
    return this;
  }

  public Integer getSubtotalOverride() {
    return subtotalOverride;
  }


  public void setSubtotalOverride(Integer subtotalOverride) {
    this.subtotalOverride = subtotalOverride;
  }


  public PurchaseDetails totalTaxOverride(Integer totalTaxOverride) {
    
    this.totalTaxOverride = totalTaxOverride;
    return this;
  }

  public Integer getTotalTaxOverride() {
    return totalTaxOverride;
  }


  public void setTotalTaxOverride(Integer totalTaxOverride) {
    this.totalTaxOverride = totalTaxOverride;
  }


  public PurchaseDetails totalDiscountOverride(Integer totalDiscountOverride) {
    
    this.totalDiscountOverride = totalDiscountOverride;
    return this;
  }

  public Integer getTotalDiscountOverride() {
    return totalDiscountOverride;
  }

  public void setTotalDiscountOverride(Integer totalDiscountOverride) {
    this.totalDiscountOverride = totalDiscountOverride;
  }

  public PurchaseDetails totalOverride(Integer totalOverride) {
    
    this.totalOverride = totalOverride;
    return this;
  }

  public Integer getTotalOverride() {
    return totalOverride;
  }

  public void setTotalOverride(Integer totalOverride) {
    this.totalOverride = totalOverride;
  }

  public PurchaseDetails requestClientDetails(List<RequestClientDetailsEnum> requestClientDetails) {
    
    this.requestClientDetails = requestClientDetails;
    return this;
  }

  public PurchaseDetails addRequestClientDetailsItem(RequestClientDetailsEnum requestClientDetailsItem) {
    if (this.requestClientDetails == null) {
      this.requestClientDetails = new ArrayList<RequestClientDetailsEnum>();
    }
    this.requestClientDetails.add(requestClientDetailsItem);
    return this;
  }

  public List<RequestClientDetailsEnum> getRequestClientDetails() {
    return requestClientDetails;
  }

  public void setRequestClientDetails(List<RequestClientDetailsEnum> requestClientDetails) {
    this.requestClientDetails = requestClientDetails;
  }


  public PurchaseDetails timezone(String timezone) {
    
    this.timezone = timezone;
    return this;
  }

  public String getTimezone() {
    return timezone;
  }


  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }


  public PurchaseDetails dueStrict(Boolean dueStrict) {
    
    this.dueStrict = dueStrict;
    return this;
  }

  public Boolean getDueStrict() {
    return dueStrict;
  }

  public void setDueStrict(Boolean dueStrict) {
    this.dueStrict = dueStrict;
  }

  public String getEmailMessage() {
    return emailMessage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PurchaseDetails purchaseDetails = (PurchaseDetails) o;
    return Objects.equals(this.currency, purchaseDetails.currency) &&
        Objects.equals(this.products, purchaseDetails.products) &&
        Objects.equals(this.total, purchaseDetails.total) &&
        Objects.equals(this.language, purchaseDetails.language) &&
        Objects.equals(this.notes, purchaseDetails.notes) &&
        Objects.equals(this.debt, purchaseDetails.debt) &&
        Objects.equals(this.subtotalOverride, purchaseDetails.subtotalOverride) &&
        Objects.equals(this.totalTaxOverride, purchaseDetails.totalTaxOverride) &&
        Objects.equals(this.totalDiscountOverride, purchaseDetails.totalDiscountOverride) &&
        Objects.equals(this.totalOverride, purchaseDetails.totalOverride) &&
        Objects.equals(this.requestClientDetails, purchaseDetails.requestClientDetails) &&
        Objects.equals(this.timezone, purchaseDetails.timezone) &&
        Objects.equals(this.dueStrict, purchaseDetails.dueStrict) &&
        Objects.equals(this.emailMessage, purchaseDetails.emailMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currency, products, total, language, notes, debt, subtotalOverride, totalTaxOverride, totalDiscountOverride, totalOverride, requestClientDetails, timezone, dueStrict, emailMessage);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class com.chip.model.PurchaseDetails {\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    debt: ").append(toIndentedString(debt)).append("\n");
    sb.append("    subtotalOverride: ").append(toIndentedString(subtotalOverride)).append("\n");
    sb.append("    totalTaxOverride: ").append(toIndentedString(totalTaxOverride)).append("\n");
    sb.append("    totalDiscountOverride: ").append(toIndentedString(totalDiscountOverride)).append("\n");
    sb.append("    totalOverride: ").append(toIndentedString(totalOverride)).append("\n");
    sb.append("    requestClientDetails: ").append(toIndentedString(requestClientDetails)).append("\n");
    sb.append("    timezone: ").append(toIndentedString(timezone)).append("\n");
    sb.append("    dueStrict: ").append(toIndentedString(dueStrict)).append("\n");
    sb.append("    emailMessage: ").append(toIndentedString(emailMessage)).append("\n");
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

