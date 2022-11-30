package com.chip;

import com.google.gson.Gson;
import com.chip.model.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class App {

    private static final UUID SAMPLE_BRAND_ID = UUID.fromString("a0da394b-0e3c-4002-956f-e02b47341db6");

    private static final String SAMPLE_API_KEY = "";

    private static final String SAMPLE_ENDPOINT = "https://gate.chip-in.asia/api/v1/";

    public static void main(String[] args) throws IOException {
        PaymentApi api = new PaymentApi(SAMPLE_BRAND_ID.toString(),
                SAMPLE_API_KEY,
                SAMPLE_ENDPOINT);

        createPurchase(api);
//        verify(api);
    }

    private static void createPurchase(PaymentApi api) {
        ClientDetails clientDetails = new ClientDetails("test@test.com");
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Test", 100));
        PurchaseDetails purchaseDetails = new PurchaseDetails(productList);
        Purchase purchase = new Purchase(api.getBrandId(), clientDetails, purchaseDetails);
        purchase.setSuccessRedirect("https://yoursystem.com/?success=1");
        purchase.setFailureRedirect("https://yoursystem.com/?success=0");
        Call<Purchase> purchaseCall = api.getService().createPurchase(purchase);
        purchaseCall.enqueue(new Callback<Purchase>() {
            @Override
            public void onResponse(Call<Purchase> call, Response<Purchase> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.body().getCheckoutUrl());
                } else {
                    System.out.println(api.errors(response));
                }
            }

            @Override
            public void onFailure(Call<Purchase> call, Throwable t) {

            }
        });
    }

    private static void getPurchase(PaymentApi api) {
        Call<Purchase> purchaseCall = api.getService().getPurchase(UUID.fromString("PURCHASE_ID"));
        purchaseCall.enqueue(new Callback<Purchase>() {
            @Override
            public void onResponse(Call<Purchase> call, Response<Purchase> response) {
                if (response.isSuccessful()) {
                    System.out.println(new Gson().toJson(response.body()));
                } else {
                    System.out.println(api.errors(response));
                }
            }

            @Override
            public void onFailure(Call<Purchase> call, Throwable t) {

            }
        });
    }

    private static void getPaymentMethods(PaymentApi api) {
        Call<PaymentMethods> paymentMethodsCall = api.getService().getPaymentMethods(api.getBrandId(), "EUR");
        paymentMethodsCall.enqueue(new Callback<PaymentMethods>() {
            @Override
            public void onResponse(Call<PaymentMethods> call, Response<PaymentMethods> response) {
                if (response.isSuccessful()) {
                    System.out.println(new Gson().toJson(response.body()));
                } else {
                    System.out.println(api.errors(response));
                }
            }

            @Override
            public void onFailure(Call<PaymentMethods> call, Throwable t) {

            }
        });
    }

    private static void chargePurchase(PaymentApi api) {
        Call<Purchase> purchaseCall = api.getService().chargePurchase(UUID.fromString("PURCHASE_ID"), new Charge(UUID.fromString("RECURRING_TOKEN")));
        purchaseCall.enqueue(new Callback<Purchase>() {
            @Override
            public void onResponse(Call<Purchase> call, Response<Purchase> response) {
                if (response.isSuccessful()) {
                    System.out.println(new Gson().toJson(response.body()));
                } else {
                    System.out.println(api.errors(response));
                }
            }

            @Override
            public void onFailure(Call<Purchase> call, Throwable t) {
            }
        });
    }

    private static void refundPurchase(PaymentApi api) {
        Call<Purchase> purchaseCall = api.getService().refundPurchase(UUID.fromString("PURCHASE_ID"), new Amount(100));
        purchaseCall.enqueue(new Callback<Purchase>() {
            @Override
            public void onResponse(Call<Purchase> call, Response<Purchase> response) {
                if (response.isSuccessful()) {
                    System.out.println(new Gson().toJson(response.body()));
                } else {
                    System.out.println(api.errors(response));
                }
            }

            @Override
            public void onFailure(Call<Purchase> call, Throwable t) {
            }
        });
    }

    private static void cancelPurchase(PaymentApi api) {
        Call<Purchase> purchaseCall = api.getService().cancelPurchase(UUID.fromString("PURCHASE_ID"));
        purchaseCall.enqueue(new Callback<Purchase>() {
            @Override
            public void onResponse(Call<Purchase> call, Response<Purchase> response) {
                if (response.isSuccessful()) {
                    System.out.println(new Gson().toJson(response.body()));
                } else {
                    System.out.println(api.errors(response));
                }
            }

            @Override
            public void onFailure(Call<Purchase> call, Throwable t) {
            }
        });
    }

    private static void releasePurchase(PaymentApi api) {
        Call<Purchase> purchaseCall = api.getService().releasePurchase(UUID.fromString("PURCHASE_ID"));
        purchaseCall.enqueue(new Callback<Purchase>() {
            @Override
            public void onResponse(Call<Purchase> call, Response<Purchase> response) {
                if (response.isSuccessful()) {
                    System.out.println(new Gson().toJson(response.body()));
                } else {
                    System.out.println(api.errors(response));
                }
            }

            @Override
            public void onFailure(Call<Purchase> call, Throwable t) {
            }
        });
    }

    private static void capturePurchase(PaymentApi api) {
        Call<Purchase> purchaseCall = api.getService().capturePurchase(UUID.fromString("PURCHASE_ID"), new Amount(100));
        purchaseCall.enqueue(new Callback<Purchase>() {
            @Override
            public void onResponse(Call<Purchase> call, Response<Purchase> response) {
                if (response.isSuccessful()) {
                    System.out.println(new Gson().toJson(response.body()));
                } else {
                    System.out.println(api.errors(response));
                }
            }

            @Override
            public void onFailure(Call<Purchase> call, Throwable t) {
            }
        });
    }

    private static void deleteRecurringToken(PaymentApi api) {
        Call<Purchase> purchaseCall = api.getService().deleteRecurringToken(UUID.fromString("PURCHASE_ID"));
        purchaseCall.enqueue(new Callback<Purchase>() {
            @Override
            public void onResponse(Call<Purchase> call, Response<Purchase> response) {
                if (response.isSuccessful()) {
                    System.out.println(new Gson().toJson(response.body()));
                } else {
                    System.out.println(api.errors(response));
                }
            }

            @Override
            public void onFailure(Call<Purchase> call, Throwable t) {
            }
        });
    }

    private static void verify(PaymentApi api) {
        String content = "{\"id\": \"\", \"due\": 1642060235, \"type\": \"purchase\", \"client\": {\"cc\": [], \"bcc\": [], \"city\": \"\", \"email\": \"\", \"phone\": \"\", \"country\": \"\", \"zip_code\": \"\", \"bank_code\": \"\", \"full_name\": \"\", \"brand_name\": \"\", \"legal_name\": \"\", \"tax_number\": \"\", \"client_type\": null, \"bank_account\": \"\", \"personal_code\": \"\", \"shipping_city\": \"\", \"street_address\": \"\", \"shipping_country\": \"\", \"shipping_zip_code\": \"\", \"registration_number\": \"\", \"shipping_street_address\": \"\"}, \"issued\": \"\", \"status\": \"created\", \"is_test\": true, \"payment\": null, \"product\": \"purchases\", \"user_id\": null, \"brand_id\": \"\", \"order_id\": null, \"platform\": \"api\", \"purchase\": {\"debt\": 0, \"notes\": \"\", \"total\": 100, \"currency\": \"EUR\", \"language\": \"en\", \"products\": [{\"name\": \"test\", \"price\": 100, \"category\": \"\", \"discount\": 0, \"quantity\": \"1.0000\", \"tax_percent\": \"0.00\"}], \"timezone\": \"UTC\", \"due_strict\": false, \"email_message\": \"\", \"total_override\": null, \"shipping_options\": [], \"subtotal_override\": null, \"total_tax_override\": null, \"payment_method_details\": {}, \"request_client_details\": [], \"total_discount_override\": null}, \"client_id\": null, \"reference\": \"\", \"viewed_on\": null, \"company_id\": \"\", \"created_on\": 1642056635, \"event_type\": \"purchase.created\", \"updated_on\": 1642056635, \"invoice_url\": null, \"checkout_url\": \"\", \"send_receipt\": false, \"skip_capture\": false, \"creator_agent\": \"\", \"issuer_details\": {\"website\": \"\", \"brand_name\": \"\", \"legal_city\": \"\", \"legal_name\": \"\", \"tax_number\": \"\", \"bank_accounts\": [{\"bank_code\": \"\", \"bank_account\": \"\"}], \"legal_country\": \"\", \"legal_zip_code\": \"\", \"registration_number\": \"\", \"legal_street_address\": \"\"}, \"marked_as_paid\": false, \"status_history\": [{\"status\": \"created\", \"timestamp\": 1642056635}], \"cancel_redirect\": \"\", \"created_from_ip\": \"\", \"direct_post_url\": null, \"force_recurring\": false, \"recurring_token\": null, \"failure_redirect\": \"\", \"success_callback\": \"\", \"success_redirect\": \"\", \"transaction_data\": {\"flow\": \"payform\", \"extra\": {}, \"country\": \"\", \"attempts\": [], \"payment_method\": \"\"}, \"refundable_amount\": 0, \"is_recurring_token\": false, \"billing_template_id\": null, \"currency_conversion\": null, \"reference_generated\": \"\", \"refund_availability\": \"none\", \"payment_method_whitelist\": null}";
        String signature = "dHgVBR7qLldrgjMAM0exDnDIBsUU0ZpQC4lkPhAjmjZjkFlRoIYcaC4fR03avykxujZwakM1mGjvInFvCHE8zrrUemeJhHSHN+8n54zecQQ0U84JhdDufr0bSXvSduaqLW1cbBEOHKXm4UCVkMp3bRKzPGEYLM0L6PYd00x3yY53gDeOm05HWlXb5UG8hpKHJPhhr5S58r+hStlM0yAI7tkeTTy6neIin7WKS8imeiGGRh6n46mXEtIcwMzmOaRmQ7me3GAxvD8gDEPY6JV6r3eQZpTF7iX/rU0pod0P35XTvQ3pO2HMBCeRm5zfFCva9JGEVvtiJ1ZDZO/4/UfPEQ==";
        String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArzedRaG/aa191+f3/Syf\n" +
                "ye4lbwaVDngwBpsV/JidZ3T/27oEAPtwZ3oqhmhsBQcVB/f94ecFdj49NTG1DZZN\n" +
                "fkWjSZEViL22oEGBryK2MjkUrW30kY1Yh0vCa/e0nIG/+9b1TLfzHIwjm54hw1R/\n" +
                "Ri/m/tf1nLMEm06ogDNV/AUyg6uyNLqp21NxKP7+xV6yfPkfX1s+qSjciyCPzO6r\n" +
                "+TsG3GTqopG1FSaWx+R0+bmsOEmV5YQKMUlLKlf0wJUD7mjsNioFomEp5QBpASbE\n" +
                "LfNDO13L5FiUgLtWcz+ZazCZmNUdhstLvrEVt8NhvPWBy96YWm4GfXx7xr8F11yH\n" +
                "pQIDAQAB\n" +
                "-----END PUBLIC KEY-----";

        try {
            System.out.println(api.verify(content, signature, publicKey));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}
