package examples.rest;

import com.chip.PaymentApi;
import com.chip.model.PaymentMethods;
import com.google.gson.Gson;
import examples.utils.Config;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PaymentMethodController {
    private final PaymentApi api;

    public PaymentMethodController() {
        api = new PaymentApi(Config.BrandId, Config.ApiKey, Config.Endpoint);
    }

    @GetMapping("/payment_methods")
    @ResponseBody
    public ResponseEntity<String> paymentMethods() throws IOException {
        PaymentMethods response =
                api.getService()
                        .getPaymentMethods(api.getBrandId(), "MYR")
                        .execute()
                        .body();

        Gson gson = new Gson();
        String json = gson.toJson(response);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type",
                "application/json");

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(json);
    }
}
