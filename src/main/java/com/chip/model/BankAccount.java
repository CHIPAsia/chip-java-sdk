package com.chip.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class BankAccount {
  @SerializedName("bank_account")
  private String bankAccount;

  @SerializedName("bank_code")
  private String bankCode;

  public BankAccount bankAccount(String bankAccount) {
    
    this.bankAccount = bankAccount;
    return this;
  }

  public String getBankAccount() {
    return bankAccount;
  }

  public void setBankAccount(String bankAccount) {
    this.bankAccount = bankAccount;
  }

  public BankAccount bankCode(String bankCode) {
    
    this.bankCode = bankCode;
    return this;
  }

  public String getBankCode() {
    return bankCode;
  }

  public void setBankCode(String bankCode) {
    this.bankCode = bankCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankAccount bankAccount = (BankAccount) o;
    return Objects.equals(this.bankAccount, bankAccount.bankAccount) &&
        Objects.equals(this.bankCode, bankAccount.bankCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bankAccount, bankCode);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class com.chip.model.BankAccount {\n");
    sb.append("    bankAccount: ").append(toIndentedString(bankAccount)).append("\n");
    sb.append("    bankCode: ").append(toIndentedString(bankCode)).append("\n");
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

