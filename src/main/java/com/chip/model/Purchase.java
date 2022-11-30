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
import java.util.UUID;

public class Purchase {

  private UUID id;

  private ClientDetails client = null;

  private PurchaseDetails purchase;

  public static final String SERIALIZED_NAME_PAYMENT = "payment";
  @SerializedName(SERIALIZED_NAME_PAYMENT)
  private PaymentDetails payment = null;

  public static final String SERIALIZED_NAME_ISSUER_DETAILS = "issuer_details";
  @SerializedName(SERIALIZED_NAME_ISSUER_DETAILS)
  private IssuerDetails issuerDetails = null;

  public static final String SERIALIZED_NAME_TRANSACTION_DATA = "transaction_data";
  @SerializedName(SERIALIZED_NAME_TRANSACTION_DATA)
  private Object transactionData;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private PurchaseStatus status = PurchaseStatus.CREATED;

  public static final String SERIALIZED_NAME_STATUS_HISTORY = "status_history";
  @SerializedName(SERIALIZED_NAME_STATUS_HISTORY)
  private List<Object> statusHistory = null;

  public static final String SERIALIZED_NAME_VIEWED_ON = "viewed_on";
  @SerializedName(SERIALIZED_NAME_VIEWED_ON)
  private Integer viewedOn = null;

  public static final String SERIALIZED_NAME_COMPANY_ID = "company_id";
  @SerializedName(SERIALIZED_NAME_COMPANY_ID)
  private UUID companyId;

  public static final String SERIALIZED_NAME_IS_TEST = "is_test";
  @SerializedName(SERIALIZED_NAME_IS_TEST)
  private Boolean isTest;

  public static final String SERIALIZED_NAME_USER_ID = "user_id";
  @SerializedName(SERIALIZED_NAME_USER_ID)
  private UUID userId;

  public static final String SERIALIZED_NAME_BRAND_ID = "brand_id";
  @SerializedName(SERIALIZED_NAME_BRAND_ID)
  private UUID brandId;

  public static final String SERIALIZED_NAME_BILLING_TEMPLATE_ID = "billing_template_id";
  @SerializedName(SERIALIZED_NAME_BILLING_TEMPLATE_ID)
  private UUID billingTemplateId;

  public static final String SERIALIZED_NAME_CLIENT_ID = "client_id";
  @SerializedName(SERIALIZED_NAME_CLIENT_ID)
  private UUID clientId;

  public static final String SERIALIZED_NAME_SEND_RECEIPT = "send_receipt";
  @SerializedName(SERIALIZED_NAME_SEND_RECEIPT)
  private Boolean sendReceipt = false;

  public static final String SERIALIZED_NAME_IS_RECURRING_TOKEN = "is_recurring_token";
  @SerializedName(SERIALIZED_NAME_IS_RECURRING_TOKEN)
  private Boolean isRecurringToken;

  public static final String SERIALIZED_NAME_RECURRING_TOKEN = "recurring_token";
  @SerializedName(SERIALIZED_NAME_RECURRING_TOKEN)
  private UUID recurringToken;

  public static final String SERIALIZED_NAME_SKIP_CAPTURE = "skip_capture";
  @SerializedName(SERIALIZED_NAME_SKIP_CAPTURE)
  private Boolean skipCapture = false;

  public static final String SERIALIZED_NAME_REFERENCE_GENERATED = "reference_generated";
  @SerializedName(SERIALIZED_NAME_REFERENCE_GENERATED)
  private String referenceGenerated;

  public static final String SERIALIZED_NAME_REFERENCE = "reference";
  @SerializedName(SERIALIZED_NAME_REFERENCE)
  private String reference;

  public static final String SERIALIZED_NAME_ISSUED = "issued";
  @SerializedName(SERIALIZED_NAME_ISSUED)
  private java.sql.Timestamp issued = null;

  public static final String SERIALIZED_NAME_DUE = "due";
  @SerializedName(SERIALIZED_NAME_DUE)
  private Integer due = null;

  /**
   * Specifies, if the purchase can be refunded fully and partially, only fully, partially or not at all.
   */
  @JsonAdapter(RefundAvailabilityEnum.Adapter.class)
  public enum RefundAvailabilityEnum {
    ALL("all"),
    
    FULL_ONLY("full_only"),
    
    PARTIAL_ONLY("partial_only"),
    
    NONE("none");

    private String value;

    RefundAvailabilityEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RefundAvailabilityEnum fromValue(String value) {
      for (RefundAvailabilityEnum b : RefundAvailabilityEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RefundAvailabilityEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RefundAvailabilityEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RefundAvailabilityEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RefundAvailabilityEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_REFUND_AVAILABILITY = "refund_availability";
  @SerializedName(SERIALIZED_NAME_REFUND_AVAILABILITY)
  private RefundAvailabilityEnum refundAvailability;

  public static final String SERIALIZED_NAME_REFUNDABLE_AMOUNT = "refundable_amount";
  @SerializedName(SERIALIZED_NAME_REFUNDABLE_AMOUNT)
  private Integer refundableAmount = null;

  public static final String SERIALIZED_NAME_CURRENCY_CONVERSION = "currency_conversion";
  @SerializedName(SERIALIZED_NAME_CURRENCY_CONVERSION)
  private Object currencyConversion;

  public static final String SERIALIZED_NAME_PAYMENT_METHOD_WHITELIST = "payment_method_whitelist";
  @SerializedName(SERIALIZED_NAME_PAYMENT_METHOD_WHITELIST)
  private List<String> paymentMethodWhitelist = null;

  public static final String SERIALIZED_NAME_SUCCESS_REDIRECT = "success_redirect";
  @SerializedName(SERIALIZED_NAME_SUCCESS_REDIRECT)
  private String successRedirect = null;

  public static final String SERIALIZED_NAME_FAILURE_REDIRECT = "failure_redirect";
  @SerializedName(SERIALIZED_NAME_FAILURE_REDIRECT)
  private String failureRedirect = null;

  public static final String SERIALIZED_NAME_CANCEL_REDIRECT = "cancel_redirect";
  @SerializedName(SERIALIZED_NAME_CANCEL_REDIRECT)
  private String cancelRedirect = null;

  public static final String SERIALIZED_NAME_SUCCESS_CALLBACK = "success_callback";
  @SerializedName(SERIALIZED_NAME_SUCCESS_CALLBACK)
  private String successCallback = null;

  public static final String SERIALIZED_NAME_CREATOR_AGENT = "creator_agent";
  @SerializedName(SERIALIZED_NAME_CREATOR_AGENT)
  private String creatorAgent;

  /**
   * Platform this com.chip.model.Purchase was created on.
   */
  @JsonAdapter(PlatformEnum.Adapter.class)
  public enum PlatformEnum {
    WEB("web"),
    
    API("api"),
    
    IOS("ios"),
    
    ANDROID("android"),
    
    MACOS("macos"),
    
    WINDOWS("windows");

    private String value;

    PlatformEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PlatformEnum fromValue(String value) {
      for (PlatformEnum b : PlatformEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<PlatformEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PlatformEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PlatformEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return PlatformEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PLATFORM = "platform";
  @SerializedName(SERIALIZED_NAME_PLATFORM)
  private PlatformEnum platform;

  /**
   * Defines which gateway product was used to create this com.chip.model.Purchase.
   */
  @JsonAdapter(ProductEnum.Adapter.class)
  public enum ProductEnum {
    PURCHASES("purchases"),
    
    BILLING_INVOICES("billing_invoices"),
    
    BILLING_SUBSCRIPTIONS("billing_subscriptions"),
    
    BILLING_SUBSCRIPTIONS_INVOICE("billing_subscriptions_invoice");

    private String value;

    ProductEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ProductEnum fromValue(String value) {
      for (ProductEnum b : ProductEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ProductEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ProductEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ProductEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ProductEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_PRODUCT = "product";
  @SerializedName(SERIALIZED_NAME_PRODUCT)
  private ProductEnum product;

  public static final String SERIALIZED_NAME_CREATED_FROM_IP = "created_from_ip";
  @SerializedName(SERIALIZED_NAME_CREATED_FROM_IP)
  private String createdFromIp;

  public static final String SERIALIZED_NAME_INVOICE_URL = "invoice_url";
  @SerializedName(SERIALIZED_NAME_INVOICE_URL)
  private String invoiceUrl = null;

  public static final String SERIALIZED_NAME_CHECKOUT_URL = "checkout_url";
  @SerializedName(SERIALIZED_NAME_CHECKOUT_URL)
  private String checkoutUrl = null;

  public static final String SERIALIZED_NAME_DIRECT_POST_URL = "direct_post_url";
  @SerializedName(SERIALIZED_NAME_DIRECT_POST_URL)
  private String directPostUrl = null;


  public Purchase client(ClientDetails client) {
    
    this.client = client;
    return this;
  }

  public ClientDetails getClient() {
    return client;
  }

  public void setClient(ClientDetails client) {
    this.client = client;
  }

  public Purchase purchase(PurchaseDetails purchase) {
    
    this.purchase = purchase;
    return this;
  }

  public PurchaseDetails getPurchase() {
    return purchase;
  }


  public void setPurchase(PurchaseDetails purchase) {
    this.purchase = purchase;
  }

  public PaymentDetails getPayment() {
    return payment;
  }

  public IssuerDetails getIssuerDetails() {
    return issuerDetails;
  }

  public Object getTransactionData() {
    return transactionData;
  }

  public Purchase status(PurchaseStatus status) {
    
    this.status = status;
    return this;
  }

  public PurchaseStatus getStatus() {
    return status;
  }

  public void setStatus(PurchaseStatus status) {
    this.status = status;
  }

  public List<Object> getStatusHistory() {
    return statusHistory;
  }

  public Integer getViewedOn() {
    return viewedOn;
  }

  public UUID getCompanyId() {
    return companyId;
  }

  public Boolean getIsTest() {
    return isTest;
  }

  public UUID getUserId() {
    return userId;
  }

  public Purchase brandId(UUID brandId) {
    
    this.brandId = brandId;
    return this;
  }

  public UUID getBrandId() {
    return brandId;
  }

  public void setBrandId(UUID brandId) {
    this.brandId = brandId;
  }

  public UUID getBillingTemplateId() {
    return billingTemplateId;
  }

  public Purchase clientId(UUID clientId) {
    
    this.clientId = clientId;
    return this;
  }

  public UUID getClientId() {
    return clientId;
  }

  public void setClientId(UUID clientId) {
    this.clientId = clientId;
  }

  public Purchase sendReceipt(Boolean sendReceipt) {
    
    this.sendReceipt = sendReceipt;
    return this;
  }

  public Boolean getSendReceipt() {
    return sendReceipt;
  }

  public void setSendReceipt(Boolean sendReceipt) {
    this.sendReceipt = sendReceipt;
  }

  public Boolean getIsRecurringToken() {
    return isRecurringToken;
  }

  public UUID getRecurringToken() {
    return recurringToken;
  }

  public Purchase skipCapture(Boolean skipCapture) {
    
    this.skipCapture = skipCapture;
    return this;
  }

  public Boolean getSkipCapture() {
    return skipCapture;
  }

  public void setSkipCapture(Boolean skipCapture) {
    this.skipCapture = skipCapture;
  }

  public String getReferenceGenerated() {
    return referenceGenerated;
  }

  public Purchase reference(String reference) {
    
    this.reference = reference;
    return this;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public Purchase issued(java.sql.Timestamp issued) {
    this.issued = issued;
    return this;
  }

  public java.sql.Timestamp getIssued() {
    return issued;
  }

  public void setIssued(java.sql.Timestamp issued) {
    this.issued = issued;
  }

  public Purchase due(Integer due) {
    
    this.due = due;
    return this;
  }

  public Integer getDue() {
    return due;
  }

  public void setDue(Integer due) {
    this.due = due;
  }

  public RefundAvailabilityEnum getRefundAvailability() {
    return refundAvailability;
  }

  public Integer getRefundableAmount() {
    return refundableAmount;
  }

  public Object getCurrencyConversion() {
    return currencyConversion;
  }

  public Purchase paymentMethodWhitelist(List<String> paymentMethodWhitelist) {
    
    this.paymentMethodWhitelist = paymentMethodWhitelist;
    return this;
  }

  public Purchase addPaymentMethodWhitelistItem(String paymentMethodWhitelistItem) {
    if (this.paymentMethodWhitelist == null) {
      this.paymentMethodWhitelist = new ArrayList<String>();
    }
    this.paymentMethodWhitelist.add(paymentMethodWhitelistItem);
    return this;
  }

  public List<String> getPaymentMethodWhitelist() {
    return paymentMethodWhitelist;
  }

  public void setPaymentMethodWhitelist(List<String> paymentMethodWhitelist) {
    this.paymentMethodWhitelist = paymentMethodWhitelist;
  }

  public Purchase successRedirect(String successRedirect) {
    
    this.successRedirect = successRedirect;
    return this;
  }

  public String getSuccessRedirect() {
    return successRedirect;
  }

  public void setSuccessRedirect(String successRedirect) {
    this.successRedirect = successRedirect;
  }

  public Purchase failureRedirect(String failureRedirect) {
    this.failureRedirect = failureRedirect;
    return this;
  }

  public String getFailureRedirect() {
    return failureRedirect;
  }

  public void setFailureRedirect(String failureRedirect) {
    this.failureRedirect = failureRedirect;
  }

  public Purchase cancelRedirect(String cancelRedirect) {
    this.cancelRedirect = cancelRedirect;
    return this;
  }

  public String getCancelRedirect() {
    return cancelRedirect;
  }

  public void setCancelRedirect(String cancelRedirect) {
    this.cancelRedirect = cancelRedirect;
  }

  public Purchase successCallback(String successCallback) {
    
    this.successCallback = successCallback;
    return this;
  }

  public String getSuccessCallback() {
    return successCallback;
  }

  public void setSuccessCallback(String successCallback) {
    this.successCallback = successCallback;
  }

  public Purchase creatorAgent(String creatorAgent) {
    
    this.creatorAgent = creatorAgent;
    return this;
  }

  public String getCreatorAgent() {
    return creatorAgent;
  }

  public void setCreatorAgent(String creatorAgent) {
    this.creatorAgent = creatorAgent;
  }

  public Purchase platform(PlatformEnum platform) {
    this.platform = platform;
    return this;
  }

  public PlatformEnum getPlatform() {
    return platform;
  }

  public void setPlatform(PlatformEnum platform) {
    this.platform = platform;
  }

  public ProductEnum getProduct() {
    return product;
  }

  public String getCreatedFromIp() {
    return createdFromIp;
  }

  public String getInvoiceUrl() {
    return invoiceUrl;
  }

  public String getCheckoutUrl() {
    return checkoutUrl;
  }

  public String getDirectPostUrl() {
    return directPostUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Purchase purchase = (Purchase) o;
    return Objects.equals(this.client, purchase.client) &&
        Objects.equals(this.purchase, purchase.purchase) &&
        Objects.equals(this.payment, purchase.payment) &&
        Objects.equals(this.issuerDetails, purchase.issuerDetails) &&
        Objects.equals(this.transactionData, purchase.transactionData) &&
        Objects.equals(this.status, purchase.status) &&
        Objects.equals(this.statusHistory, purchase.statusHistory) &&
        Objects.equals(this.viewedOn, purchase.viewedOn) &&
        Objects.equals(this.companyId, purchase.companyId) &&
        Objects.equals(this.isTest, purchase.isTest) &&
        Objects.equals(this.userId, purchase.userId) &&
        Objects.equals(this.brandId, purchase.brandId) &&
        Objects.equals(this.billingTemplateId, purchase.billingTemplateId) &&
        Objects.equals(this.clientId, purchase.clientId) &&
        Objects.equals(this.sendReceipt, purchase.sendReceipt) &&
        Objects.equals(this.isRecurringToken, purchase.isRecurringToken) &&
        Objects.equals(this.recurringToken, purchase.recurringToken) &&
        Objects.equals(this.skipCapture, purchase.skipCapture) &&
        Objects.equals(this.referenceGenerated, purchase.referenceGenerated) &&
        Objects.equals(this.reference, purchase.reference) &&
        Objects.equals(this.issued, purchase.issued) &&
        Objects.equals(this.due, purchase.due) &&
        Objects.equals(this.refundAvailability, purchase.refundAvailability) &&
        Objects.equals(this.refundableAmount, purchase.refundableAmount) &&
        Objects.equals(this.currencyConversion, purchase.currencyConversion) &&
        Objects.equals(this.paymentMethodWhitelist, purchase.paymentMethodWhitelist) &&
        Objects.equals(this.successRedirect, purchase.successRedirect) &&
        Objects.equals(this.failureRedirect, purchase.failureRedirect) &&
        Objects.equals(this.cancelRedirect, purchase.cancelRedirect) &&
        Objects.equals(this.successCallback, purchase.successCallback) &&
        Objects.equals(this.creatorAgent, purchase.creatorAgent) &&
        Objects.equals(this.platform, purchase.platform) &&
        Objects.equals(this.product, purchase.product) &&
        Objects.equals(this.createdFromIp, purchase.createdFromIp) &&
        Objects.equals(this.invoiceUrl, purchase.invoiceUrl) &&
        Objects.equals(this.checkoutUrl, purchase.checkoutUrl) &&
        Objects.equals(this.directPostUrl, purchase.directPostUrl) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(client, purchase, payment, issuerDetails, transactionData, status, statusHistory, viewedOn, companyId, isTest, userId, brandId, billingTemplateId, clientId, sendReceipt, isRecurringToken, recurringToken, skipCapture, referenceGenerated, reference, issued, due, refundAvailability, refundableAmount, currencyConversion, paymentMethodWhitelist, successRedirect, failureRedirect, cancelRedirect, successCallback, creatorAgent, platform, product, createdFromIp, invoiceUrl, checkoutUrl, directPostUrl, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class com.chip.model.Purchase {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    client: ").append(toIndentedString(client)).append("\n");
    sb.append("    purchase: ").append(toIndentedString(purchase)).append("\n");
    sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
    sb.append("    issuerDetails: ").append(toIndentedString(issuerDetails)).append("\n");
    sb.append("    transactionData: ").append(toIndentedString(transactionData)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    statusHistory: ").append(toIndentedString(statusHistory)).append("\n");
    sb.append("    viewedOn: ").append(toIndentedString(viewedOn)).append("\n");
    sb.append("    companyId: ").append(toIndentedString(companyId)).append("\n");
    sb.append("    isTest: ").append(toIndentedString(isTest)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    brandId: ").append(toIndentedString(brandId)).append("\n");
    sb.append("    billingTemplateId: ").append(toIndentedString(billingTemplateId)).append("\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    sendReceipt: ").append(toIndentedString(sendReceipt)).append("\n");
    sb.append("    isRecurringToken: ").append(toIndentedString(isRecurringToken)).append("\n");
    sb.append("    recurringToken: ").append(toIndentedString(recurringToken)).append("\n");
    sb.append("    skipCapture: ").append(toIndentedString(skipCapture)).append("\n");
    sb.append("    referenceGenerated: ").append(toIndentedString(referenceGenerated)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    issued: ").append(toIndentedString(issued)).append("\n");
    sb.append("    due: ").append(toIndentedString(due)).append("\n");
    sb.append("    refundAvailability: ").append(toIndentedString(refundAvailability)).append("\n");
    sb.append("    refundableAmount: ").append(toIndentedString(refundableAmount)).append("\n");
    sb.append("    currencyConversion: ").append(toIndentedString(currencyConversion)).append("\n");
    sb.append("    paymentMethodWhitelist: ").append(toIndentedString(paymentMethodWhitelist)).append("\n");
    sb.append("    successRedirect: ").append(toIndentedString(successRedirect)).append("\n");
    sb.append("    failureRedirect: ").append(toIndentedString(failureRedirect)).append("\n");
    sb.append("    cancelRedirect: ").append(toIndentedString(cancelRedirect)).append("\n");
    sb.append("    successCallback: ").append(toIndentedString(successCallback)).append("\n");
    sb.append("    creatorAgent: ").append(toIndentedString(creatorAgent)).append("\n");
    sb.append("    platform: ").append(toIndentedString(platform)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    createdFromIp: ").append(toIndentedString(createdFromIp)).append("\n");
    sb.append("    invoiceUrl: ").append(toIndentedString(invoiceUrl)).append("\n");
    sb.append("    checkoutUrl: ").append(toIndentedString(checkoutUrl)).append("\n");
    sb.append("    directPostUrl: ").append(toIndentedString(directPostUrl)).append("\n");
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

  public Purchase(UUID brandId, ClientDetails client, PurchaseDetails purchase) {
    this.brandId = brandId;
    this.client = client;
    this.purchase = purchase;
  }
}

