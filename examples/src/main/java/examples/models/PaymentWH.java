package examples.models;

import com.google.gson.annotations.SerializedName;

public class PaymentWH {
    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private String type;

    @SerializedName("event_type")
    private String eventType;

    public String getID() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getEventType() {
        return eventType;
    }
}
