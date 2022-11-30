package examples.rest;

import com.chip.PaymentApi;
import com.chip.model.ClientDetails;
import com.chip.model.Product;
import com.chip.model.Purchase;
import com.chip.model.PurchaseDetails;
import examples.utils.Config;
import examples.utils.PublicKey;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

@RestController
public class PaymentController {
    private final PaymentApi api;

    public PaymentController() {
        api = new PaymentApi(Config.BrandId, Config.ApiKey, Config.Endpoint);
    }

    @GetMapping("/create_purchase")
    @ResponseBody
    public ResponseEntity<String> createPurchase() throws IOException {
        ClientDetails client = new ClientDetails("test@test.com");
        Product product = new Product("Test", 100);
        product.setQuantity(1f);
        PurchaseDetails purchaseDetails = new PurchaseDetails(Arrays.asList(product));
        Purchase purchase = new Purchase(api.getBrandId(), client, purchaseDetails);
        purchase.setSuccessCallback(String.format("%s/callback", Config.BasedUrl));
        purchase.setSuccessRedirect(String.format("%s/redirect?success=1", Config.BasedUrl));
        purchase.setFailureRedirect(String.format("%s/redirect?success=0", Config.BasedUrl));

        Purchase response =
                api.getService()
                        .createPurchase(purchase)
                        .execute()
                        .body();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Location", response.getCheckoutUrl());

        return new ResponseEntity(responseHeaders, HttpStatus.FOUND);
    }

    @PostMapping("/callback")
    @ResponseBody
    public ResponseEntity callback(HttpEntity<String> httpEntity) throws IOException, CertificateException, NoSuchAlgorithmException, SignatureException, InvalidKeySpecException, InvalidKeyException {
        String data = httpEntity.getBody();
        String xsignature = httpEntity.getHeaders().getFirst("X-Signature");

        PublicKey publicKeyUtil = new PublicKey();
        String publicKey = publicKeyUtil.getPublicKey();

        Boolean result = api.verify(data, xsignature, publicKey);
        System.out.println(String.format("/callback VERIFIED: %b", result));

        return ResponseEntity.ok("");
    }
}
