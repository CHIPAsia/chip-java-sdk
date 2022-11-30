# Chip Java library

## Requirements

Java 8 or later.

## Building

## Gradle

Copy library to your project

Include library in `settings.gradle`

```groovy
include ':chip-sdk'
```

if there is an error resolving the project, you might need to define the location of the project. i.e:

```groovy
project(':chip-sdk').projectDir = file("../../chip-java-sdk")
```

Add dependency to `build.gradle`

```groovy
dependencies {
    ...
    implementation project(':chip-sdk')
}
```

## Getting Started

Simple usage looks like:


```java
public class App {
    public static void main(String[] args) throws IOException {
        PaymentApi api = new PaymentApi("BRAND_ID",
                "API_KEY",
                "https://gate.chip-in.asia/api/v1/");
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
}
```

## Testing

```bash
./gradlew test
```

## Example
Check our examples [here](./examples).
