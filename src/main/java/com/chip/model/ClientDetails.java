package com.chip.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClientDetails extends BankAccount {
  private String email;

  private String phone;

  @SerializedName("full_name")
  private String fullName;

  @SerializedName("personal_code")
  private String personalCode;

  @SerializedName("street_address")
  private String streetAddress;

  private String country;

  private String city;

  @SerializedName("zip_code")
  private String zipCode;

  @SerializedName("shipping_street_address")
  private String shippingStreetAddress;

  @SerializedName("shipping_country")
  private String shippingCountry;

  @SerializedName("shipping_city")
  private String shippingCity;

  @SerializedName("shipping_zip_code")
  private String shippingZipCode;

  private List<String> cc = null;

  private List<String> bcc = null;

  @SerializedName("legal_name")
  private String legalName;

  @SerializedName("brand_name")
  private String brandName;

  @SerializedName("registration_number")
  private String registrationNumber;

  @SerializedName("tax_number")
  private String taxNumber;

  public ClientDetails(String email) {
    this.email = email;
  }

  public ClientDetails email(String email) {
    
    this.email = email;
    return this;
  }

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }

  public ClientDetails phone(String phone) {
    
    this.phone = phone;
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public ClientDetails fullName(String fullName) {
    
    this.fullName = fullName;
    return this;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public ClientDetails personalCode(String personalCode) {
    this.personalCode = personalCode;
    return this;
  }

  public String getPersonalCode() {
    return personalCode;
  }

  public void setPersonalCode(String personalCode) {
    this.personalCode = personalCode;
  }

  public ClientDetails streetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
    return this;
  }

  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public ClientDetails country(String country) {
    this.country = country;
    return this;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public ClientDetails city(String city) {
    this.city = city;
    return this;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public ClientDetails zipCode(String zipCode) {
    this.zipCode = zipCode;
    return this;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public ClientDetails shippingStreetAddress(String shippingStreetAddress) {
    this.shippingStreetAddress = shippingStreetAddress;
    return this;
  }

  public String getShippingStreetAddress() {
    return shippingStreetAddress;
  }

  public void setShippingStreetAddress(String shippingStreetAddress) {
    this.shippingStreetAddress = shippingStreetAddress;
  }

  public ClientDetails shippingCountry(String shippingCountry) {
    this.shippingCountry = shippingCountry;
    return this;
  }

  public String getShippingCountry() {
    return shippingCountry;
  }

  public void setShippingCountry(String shippingCountry) {
    this.shippingCountry = shippingCountry;
  }

  public ClientDetails shippingCity(String shippingCity) {
    this.shippingCity = shippingCity;
    return this;
  }

  public String getShippingCity() {
    return shippingCity;
  }

  public void setShippingCity(String shippingCity) {
    this.shippingCity = shippingCity;
  }

  public ClientDetails shippingZipCode(String shippingZipCode) {
    this.shippingZipCode = shippingZipCode;
    return this;
  }

  public String getShippingZipCode() {
    return shippingZipCode;
  }

  public void setShippingZipCode(String shippingZipCode) {
    this.shippingZipCode = shippingZipCode;
  }

  public ClientDetails cc(List<String> cc) {
    this.cc = cc;
    return this;
  }

  public ClientDetails addCcItem(String ccItem) {
    if (this.cc == null) {
      this.cc = new ArrayList<String>();
    }
    this.cc.add(ccItem);
    return this;
  }

  public List<String> getCc() {
    return cc;
  }

  public void setCc(List<String> cc) {
    this.cc = cc;
  }

  public ClientDetails bcc(List<String> bcc) {
    this.bcc = bcc;
    return this;
  }

  public ClientDetails addBccItem(String bccItem) {
    if (this.bcc == null) {
      this.bcc = new ArrayList<String>();
    }
    this.bcc.add(bccItem);
    return this;
  }

  public List<String> getBcc() {
    return bcc;
  }

  public void setBcc(List<String> bcc) {
    this.bcc = bcc;
  }

  public ClientDetails legalName(String legalName) {
    this.legalName = legalName;
    return this;
  }

  public String getLegalName() {
    return legalName;
  }

  public void setLegalName(String legalName) {
    this.legalName = legalName;
  }

  public ClientDetails brandName(String brandName) {
    this.brandName = brandName;
    return this;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public ClientDetails registrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
    return this;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public ClientDetails taxNumber(String taxNumber) {
    this.taxNumber = taxNumber;
    return this;
  }

  public String getTaxNumber() {
    return taxNumber;
  }

  public void setTaxNumber(String taxNumber) {
    this.taxNumber = taxNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClientDetails clientDetails = (ClientDetails) o;
    return Objects.equals(this.email, clientDetails.email) &&
        Objects.equals(this.phone, clientDetails.phone) &&
        Objects.equals(this.fullName, clientDetails.fullName) &&
        Objects.equals(this.personalCode, clientDetails.personalCode) &&
        Objects.equals(this.streetAddress, clientDetails.streetAddress) &&
        Objects.equals(this.country, clientDetails.country) &&
        Objects.equals(this.city, clientDetails.city) &&
        Objects.equals(this.zipCode, clientDetails.zipCode) &&
        Objects.equals(this.shippingStreetAddress, clientDetails.shippingStreetAddress) &&
        Objects.equals(this.shippingCountry, clientDetails.shippingCountry) &&
        Objects.equals(this.shippingCity, clientDetails.shippingCity) &&
        Objects.equals(this.shippingZipCode, clientDetails.shippingZipCode) &&
        Objects.equals(this.cc, clientDetails.cc) &&
        Objects.equals(this.bcc, clientDetails.bcc) &&
        Objects.equals(this.legalName, clientDetails.legalName) &&
        Objects.equals(this.brandName, clientDetails.brandName) &&
        Objects.equals(this.registrationNumber, clientDetails.registrationNumber) &&
        Objects.equals(this.taxNumber, clientDetails.taxNumber) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, phone, fullName, personalCode, streetAddress, country, city, zipCode, shippingStreetAddress, shippingCountry, shippingCity, shippingZipCode, cc, bcc, legalName, brandName, registrationNumber, taxNumber, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class com.chip.model.ClientDetails {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    personalCode: ").append(toIndentedString(personalCode)).append("\n");
    sb.append("    streetAddress: ").append(toIndentedString(streetAddress)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    zipCode: ").append(toIndentedString(zipCode)).append("\n");
    sb.append("    shippingStreetAddress: ").append(toIndentedString(shippingStreetAddress)).append("\n");
    sb.append("    shippingCountry: ").append(toIndentedString(shippingCountry)).append("\n");
    sb.append("    shippingCity: ").append(toIndentedString(shippingCity)).append("\n");
    sb.append("    shippingZipCode: ").append(toIndentedString(shippingZipCode)).append("\n");
    sb.append("    cc: ").append(toIndentedString(cc)).append("\n");
    sb.append("    bcc: ").append(toIndentedString(bcc)).append("\n");
    sb.append("    legalName: ").append(toIndentedString(legalName)).append("\n");
    sb.append("    brandName: ").append(toIndentedString(brandName)).append("\n");
    sb.append("    registrationNumber: ").append(toIndentedString(registrationNumber)).append("\n");
    sb.append("    taxNumber: ").append(toIndentedString(taxNumber)).append("\n");
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

