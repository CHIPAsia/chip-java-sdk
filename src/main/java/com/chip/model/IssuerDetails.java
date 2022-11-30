package com.chip.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class IssuerDetails {
  public static final String SERIALIZED_NAME_WEBSITE = "website";
  @SerializedName(SERIALIZED_NAME_WEBSITE)
  private String website = null;

  public static final String SERIALIZED_NAME_LEGAL_STREET_ADDRESS = "legal_street_address";
  @SerializedName(SERIALIZED_NAME_LEGAL_STREET_ADDRESS)
  private String legalStreetAddress = null;

  public static final String SERIALIZED_NAME_LEGAL_COUNTRY = "legal_country";
  @SerializedName(SERIALIZED_NAME_LEGAL_COUNTRY)
  private String legalCountry = null;

  public static final String SERIALIZED_NAME_LEGAL_CITY = "legal_city";
  @SerializedName(SERIALIZED_NAME_LEGAL_CITY)
  private String legalCity = null;

  public static final String SERIALIZED_NAME_LEGAL_ZIP_CODE = "legal_zip_code";
  @SerializedName(SERIALIZED_NAME_LEGAL_ZIP_CODE)
  private String legalZipCode = null;

  public static final String SERIALIZED_NAME_BANK_ACCOUNTS = "bank_accounts";
  @SerializedName(SERIALIZED_NAME_BANK_ACCOUNTS)
  private List<BankAccount> bankAccounts = null;

  public static final String SERIALIZED_NAME_LEGAL_NAME = "legal_name";
  @SerializedName(SERIALIZED_NAME_LEGAL_NAME)
  private String legalName;

  public static final String SERIALIZED_NAME_BRAND_NAME = "brand_name";
  @SerializedName(SERIALIZED_NAME_BRAND_NAME)
  private String brandName;

  public static final String SERIALIZED_NAME_REGISTRATION_NUMBER = "registration_number";
  @SerializedName(SERIALIZED_NAME_REGISTRATION_NUMBER)
  private String registrationNumber;

  public static final String SERIALIZED_NAME_TAX_NUMBER = "tax_number";
  @SerializedName(SERIALIZED_NAME_TAX_NUMBER)
  private String taxNumber;

  public String getWebsite() {
    return website;
  }

  public String getLegalStreetAddress() {
    return legalStreetAddress;
  }

  public String getLegalCountry() {
    return legalCountry;
  }

  public String getLegalCity() {
    return legalCity;
  }

  public String getLegalZipCode() {
    return legalZipCode;
  }

  public List<BankAccount> getBankAccounts() {
    return bankAccounts;
  }

  public String getLegalName() {
    return legalName;
  }

  public String getBrandName() {
    return brandName;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public String getTaxNumber() {
    return taxNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssuerDetails issuerDetails = (IssuerDetails) o;
    return Objects.equals(this.website, issuerDetails.website) &&
        Objects.equals(this.legalStreetAddress, issuerDetails.legalStreetAddress) &&
        Objects.equals(this.legalCountry, issuerDetails.legalCountry) &&
        Objects.equals(this.legalCity, issuerDetails.legalCity) &&
        Objects.equals(this.legalZipCode, issuerDetails.legalZipCode) &&
        Objects.equals(this.bankAccounts, issuerDetails.bankAccounts) &&
        Objects.equals(this.legalName, issuerDetails.legalName) &&
        Objects.equals(this.brandName, issuerDetails.brandName) &&
        Objects.equals(this.registrationNumber, issuerDetails.registrationNumber) &&
        Objects.equals(this.taxNumber, issuerDetails.taxNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(website, legalStreetAddress, legalCountry, legalCity, legalZipCode, bankAccounts, legalName, brandName, registrationNumber, taxNumber);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class com.chip.model.IssuerDetails {\n");
    sb.append("    website: ").append(toIndentedString(website)).append("\n");
    sb.append("    legalStreetAddress: ").append(toIndentedString(legalStreetAddress)).append("\n");
    sb.append("    legalCountry: ").append(toIndentedString(legalCountry)).append("\n");
    sb.append("    legalCity: ").append(toIndentedString(legalCity)).append("\n");
    sb.append("    legalZipCode: ").append(toIndentedString(legalZipCode)).append("\n");
    sb.append("    bankAccounts: ").append(toIndentedString(bankAccounts)).append("\n");
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

