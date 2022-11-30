package examples.rest;

import com.chip.PaymentApi;
import com.google.gson.Gson;
import examples.models.PaymentWH;
import examples.utils.Config;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;

@RestController
public class WebhookController {
    private final PaymentApi api;

    public WebhookController() {
        api = new PaymentApi(Config.BrandId, Config.ApiKey, Config.Endpoint);
    }


    @PostMapping("/webhook/payment")
    @ResponseBody
    public ResponseEntity paymentHook(HttpEntity<String> httpEntity) throws IOException, CertificateException, NoSuchAlgorithmException, SignatureException, InvalidKeySpecException, InvalidKeyException {
        String data = httpEntity.getBody();
        String xsignature = httpEntity.getHeaders().getFirst("X-Signature");

        String publicKey = Config.WebhookPublicKey;

        PaymentWH wh = new Gson().fromJson(data, PaymentWH.class);

        Boolean result = api.verify(data, xsignature, publicKey);
        System.out.println(String.format("/webhook/payment EVENT: %s", wh.getEventType()));
        System.out.println(String.format("/webhook/payment VERIFIED: %b", result));

        return ResponseEntity.ok("");
    }
}
