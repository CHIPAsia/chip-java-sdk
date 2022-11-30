package examples.rest;

import examples.utils.PublicKey;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class PublicKeyController {
    private final RestTemplate restTemplate;

    public PublicKeyController() {
        restTemplate = new RestTemplate();
    }

    @GetMapping("/public_key")
    @ResponseBody
    public ResponseEntity<String> getPublicKey() throws IOException {
        PublicKey publicKeyUtil = new PublicKey();
        String response = publicKeyUtil.getPublicKey();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type",
                "text/plain; charset=utf-8");

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(response);
    }
}
