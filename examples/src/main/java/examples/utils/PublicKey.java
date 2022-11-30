package examples.utils;

import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PublicKey {
    private final RestTemplate restTemplate;

    public PublicKey() {
        restTemplate = new RestTemplate();
    }

    public String getPublicKey() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", String.format("Bearer %s", Config.ApiKey));

        String url = Config.Endpoint + "public_key/";

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.GET, request, String.class, 1);
        String json = new Gson().fromJson(response.getBody(), String.class);

        return json;
    }
}
