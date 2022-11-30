package com.chip;

import com.google.gson.Gson;
import com.chip.model.ApiErrors;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.net.ssl.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.UUID;

public class PaymentApi {

    final private UUID brandId;

    final private String apiKey;

    final private String endpoint;

    final private PaymentService service;

    public PaymentApi(String brandId, String apiKey, String endpoint) {
        this.brandId = UUID.fromString(brandId);
        this.apiKey = apiKey;
        this.endpoint = endpoint;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();

        this.service = retrofit
                .create(PaymentService.class);
    }

    private OkHttpClient getClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        client.hostnameVerifier((s, sslSession) -> true);
        client.addInterceptor(chain -> {
            Request request = chain.request().newBuilder().addHeader("Authorization", "Bearer " + apiKey).build();
            return chain.proceed(request);
        });

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.level(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(logging);

        return client.build();
    }

    public UUID getBrandId() {
        return brandId;
    }

    public PaymentService getService() {
        return service;
    }

    public ApiErrors errors(Response response) {
        try {
            return new Gson().fromJson(response.errorBody().string(), ApiErrors.class);
        } catch (IOException e) {
            return null;
        }
    }

    protected static PublicKey getKey(String key) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String publicKeyPEM = key
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replaceAll(System.lineSeparator(), "")
                .replace("-----END PUBLIC KEY-----", "");
        byte[] certBytes = Base64.getDecoder().decode(publicKeyPEM);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        ByteArrayInputStream in = new ByteArrayInputStream(certBytes);
        PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(certBytes));

        return publicKey;
    }

    public boolean verify(String content, String signature, String publicKey) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, InvalidKeySpecException {
        Signature signer = Signature.getInstance("SHA256withRSA");
        signer.initVerify(getKey(publicKey));
        signer.update(content.getBytes());
        return (signer.verify(Base64.getDecoder().decode(signature)));
    }
}
