<div align="center">
    <a href="https://www.java.com/en/download/">
        <img
            alt="Java"
            src="https://upload.wikimedia.org/wikipedia/en/3/30/Java_programming_language_logo.svg"
            height="100"
            >
    </a>
</div>

---

## Requirements
* Java >= 8

## Prerequisite
You will need to replace the value on file [Config.java](./examples/src/main/java/examples/utils/Config.java) with the configuration on your Developer section by logging-in to Merchant Portal with your account.

```javascript
// ./src/main/java/examples/utils/Config.java
package examples.utils;

public class Config {
    public static String BrandId = "<<BRAND_ID>>";
    public static String ApiKey = "<<API_KEY>>";
    public static String Endpoint = "https://gate.chip-in.asia/api/v1/";
    public static String BasedUrl = "<<DOMAIN_URL>>";
    public static String WebhookPublicKey = "<<WEBHOOK_PUBLIC_KEY>>";
}

```

**BRAND_ID**

Obtain your BRAND_ID from Developer section.

---
**API_KEY**

Obtain your API_KEY from Developer section.

---

**WEBHOOK_PUBLIC_KEY**

Obtain your `WEBHOOK_PUBLIC_KEY` from Developer section. You can register the URL from [API](https://developer.chip-in.asia/api) or from Merchant Portal on Developer section.

---

**DOMAIN_URL**

It is your domain URL

## Run Example
Open `examples` folder on your terminal and run command:
```bash
./gradlew bootRun
```

visit [localhost:8080](http://localhost:8080/) on your browser.

To test `/callback` & `/webhook/payment` to be called from our server, make sure it is connected to internet (exposed to outside). 

We recommend to use [ngrok](https://ngrok.com/) if you want to run locally for debugging. Then You can replace `DOMAIN_URL` with generated URL by `ngrok`. 

`NB: Use it at your own risk. Make sure do not expose your critical port.`