package com.chip.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Product {
  public static final String SERIALIZED_NAME_NAME = "name";

  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_QUANTITY = "quantity";
  @SerializedName(SERIALIZED_NAME_QUANTITY)
  private Float quantity = null;

  public static final String SERIALIZED_NAME_PRICE = "price";
  @SerializedName(SERIALIZED_NAME_PRICE)
  private Integer price = null;

  public static final String SERIALIZED_NAME_DISCOUNT = "discount";
  @SerializedName(SERIALIZED_NAME_DISCOUNT)
  private Integer discount = null;

  public static final String SERIALIZED_NAME_TAX_PERCENT = "tax_percent";
  @SerializedName(SERIALIZED_NAME_TAX_PERCENT)
  private Float taxPercent = null;

  public Product(String name, Integer price) {
    this.name = name;
    this.price = price;
  }

  public Product name(String name) {
    
    this.name = name;
    return this;
  }

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public Product quantity(Float quantity) {
    
    this.quantity = quantity;
    return this;
  }

  public Float getQuantity() {
    return quantity;
  }


  public void setQuantity(Float quantity) {
    this.quantity = quantity;
  }


  public Product price(Integer price) {
    
    this.price = price;
    return this;
  }

  public Integer getPrice() {
    return price;
  }


  public void setPrice(Integer price) {
    this.price = price;
  }


  public Product discount(Integer discount) {
    
    this.discount = discount;
    return this;
  }

  public Integer getDiscount() {
    return discount;
  }


  public void setDiscount(Integer discount) {
    this.discount = discount;
  }


  public Product taxPercent(Float taxPercent) {
    
    this.taxPercent = taxPercent;
    return this;
  }

  public Float getTaxPercent() {
    return taxPercent;
  }


  public void setTaxPercent(Float taxPercent) {
    this.taxPercent = taxPercent;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.name, product.name) &&
        Objects.equals(this.quantity, product.quantity) &&
        Objects.equals(this.price, product.price) &&
        Objects.equals(this.discount, product.discount) &&
        Objects.equals(this.taxPercent, product.taxPercent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, quantity, price, discount, taxPercent);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class com.chip.model.Product {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
    sb.append("    taxPercent: ").append(toIndentedString(taxPercent)).append("\n");
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

