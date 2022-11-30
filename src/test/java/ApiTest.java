import com.chip.PaymentApi;
import com.chip.model.*;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ApiTest {

    private MockWebServer mockWebServer = new MockWebServer();

    private final UUID TEST_UUID = UUID.fromString("a0da394b-0e3c-4002-956f-e02b47341db6");

    private final String TEST_TOKEN = "testtoken";

    PaymentApi api;

    @Before
    public void setup() throws IOException {
        mockWebServer.setDispatcher(new Dispatcher() {
            @NotNull
            @Override
            public MockResponse dispatch(@NotNull RecordedRequest recordedRequest) throws InterruptedException {
                return new MockResponse().setResponseCode(HttpURLConnection.HTTP_OK).setBody("{}");
            }
        });
        mockWebServer.start();
        api = new PaymentApi(TEST_UUID.toString(), TEST_TOKEN, mockWebServer.url("/").toString());
    }

    @After
    public void teardown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    public void testGetPurchase() throws InterruptedException, IOException {
        api.getService().getPurchase(TEST_UUID).execute();
        RecordedRequest request = mockWebServer.takeRequest();
        Assert.assertEquals("GET", request.getMethod());
        Assert.assertEquals(String.format("/purchases/%s/", TEST_UUID), request.getPath());
    }

    @Test
    public void testGetPaymentMethods() throws InterruptedException, IOException {
        String currency = "USD";
        api.getService().getPaymentMethods(TEST_UUID, currency).execute();
        RecordedRequest request = mockWebServer.takeRequest();
        Assert.assertEquals("GET", request.getMethod());
        Assert.assertEquals(String.format("/payment_methods/?brand_id=%s&currency=%s", TEST_UUID.toString(), currency), request.getPath());
    }

    @Test
    public void testRefundWithoutAmount() throws IOException, InterruptedException {
        api.getService().refundPurchase(TEST_UUID, new Amount()).execute();
        RecordedRequest request = mockWebServer.takeRequest();
        Assert.assertEquals("POST", request.getMethod());
        Assert.assertEquals(String.format("/purchases/%s/refund/", TEST_UUID), request.getPath());
        Assert.assertEquals("{}", request.getBody().readUtf8());
    }

    @Test
    public void testRefundWithAmount() throws IOException, InterruptedException {
        api.getService().refundPurchase(TEST_UUID, new Amount(123)).execute();
        RecordedRequest request = mockWebServer.takeRequest();
        Assert.assertEquals("POST", request.getMethod());
        Assert.assertEquals(String.format("/purchases/%s/refund/", TEST_UUID), request.getPath());
        Assert.assertEquals("{\"amount\":123}", request.getBody().readUtf8());
    }

    @Test
    public void testCreatePurchase() throws InterruptedException, IOException {
        ClientDetails clientDetails = new ClientDetails("test@test.com");
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Test", 100));
        PurchaseDetails purchaseDetails = new PurchaseDetails(productList);
        Purchase purchase = new Purchase(api.getBrandId(), clientDetails, purchaseDetails);
        purchase.setSuccessRedirect("https://yoursystem.com/?success=1");
        purchase.setFailureRedirect("https://yoursystem.com/?success=1");
        api.getService().createPurchase(purchase).execute();
        RecordedRequest request = mockWebServer.takeRequest();
        Assert.assertEquals("POST", request.getMethod());
        Assert.assertEquals("/purchases/", request.getPath());
    }

    @Test
    public void testCancelPurchase() throws InterruptedException, IOException {
        api.getService().cancelPurchase(TEST_UUID).execute();
        RecordedRequest request = mockWebServer.takeRequest();
        Assert.assertEquals("POST", request.getMethod());
        Assert.assertEquals(String.format("/purchases/%s/cancel/", TEST_UUID), request.getPath());
    }

    @Test
    public void testReleasePurchase() throws InterruptedException, IOException {
        api.getService().releasePurchase(TEST_UUID).execute();
        RecordedRequest request = mockWebServer.takeRequest();
        Assert.assertEquals("POST", request.getMethod());
        Assert.assertEquals(String.format("/purchases/%s/release/", TEST_UUID), request.getPath());
    }

    @Test
    public void testCaptureWithoutAmount() throws IOException, InterruptedException {
        api.getService().capturePurchase(TEST_UUID, new Amount()).execute();
        RecordedRequest request = mockWebServer.takeRequest();
        Assert.assertEquals("POST", request.getMethod());
        Assert.assertEquals(String.format("/purchases/%s/capture/", TEST_UUID), request.getPath());
        Assert.assertEquals("{}", request.getBody().readUtf8());
    }

    @Test
    public void testCaptureWithAmount() throws IOException, InterruptedException {
        api.getService().capturePurchase(TEST_UUID, new Amount(123)).execute();
        RecordedRequest request = mockWebServer.takeRequest();
        Assert.assertEquals("POST", request.getMethod());
        Assert.assertEquals(String.format("/purchases/%s/capture/", TEST_UUID), request.getPath());
        Assert.assertEquals("{\"amount\":123}", request.getBody().readUtf8());
    }

    @Test
    public void testChargePurchase() throws InterruptedException, IOException {
        api.getService().chargePurchase(TEST_UUID, new Charge(TEST_UUID)).execute();
        RecordedRequest request = mockWebServer.takeRequest();
        Assert.assertEquals("POST", request.getMethod());
        Assert.assertEquals(String.format("/purchases/%s/charge/", TEST_UUID), request.getPath());
        Assert.assertEquals(String.format("{\"recurring_token\":\"%s\"}", TEST_UUID.toString()), request.getBody().readUtf8());
    }

    @Test
    public void testDeleteRecurringToken() throws InterruptedException, IOException {
        api.getService().deleteRecurringToken(TEST_UUID).execute();
        RecordedRequest request = mockWebServer.takeRequest();
        Assert.assertEquals("POST", request.getMethod());
        Assert.assertEquals(String.format("/purchases/%s/delete_recurring_token/", TEST_UUID), request.getPath());
    }

    @Test
    public void testVerify() throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException, InvalidKeySpecException {
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

        Assert.assertTrue(api.verify(content, signature, publicKey));
    }
}
