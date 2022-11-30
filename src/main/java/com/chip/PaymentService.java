package com.chip;

import com.chip.model.Amount;
import com.chip.model.Charge;
import com.chip.model.PaymentMethods;
import com.chip.model.Purchase;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.UUID;

public interface PaymentService {
    @GET("payment_methods/")
    Call<PaymentMethods> getPaymentMethods(@Query("brand_id") UUID brandId, @Query("currency") String currency);

    @GET("purchases/{id}/")
    Call<Purchase> getPurchase(@Path("id") UUID purchaseId);

    @POST("purchases/{id}/refund/")
    Call<Purchase> refundPurchase(@Path("id") UUID purchaseId, @Body Amount amount);

    @POST("purchases/{id}/capture/")
    Call<Purchase> capturePurchase(@Path("id") UUID purchaseId, @Body Amount amount);

    @POST("purchases/{id}/cancel/")
    Call<Purchase> cancelPurchase(@Path("id") UUID purchaseId);

    @POST("purchases/{id}/release/")
    Call<Purchase> releasePurchase(@Path("id") UUID purchaseId);

    @POST("purchases/{id}/charge/")
    Call<Purchase> chargePurchase(@Path("id") UUID purchaseId, @Body Charge charge);

    @POST("purchases/{id}/delete_recurring_token/")
    Call<Purchase> deleteRecurringToken(@Path("id") UUID purchaseId);

    @POST("purchases/")
    Call<Purchase> createPurchase(@Body Purchase purchase);
}
