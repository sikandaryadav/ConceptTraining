package chetu.second.batch.demo.retrofit.pojos;

import com.google.gson.annotations.SerializedName;

public class GeoPojo {
    @SerializedName("lat")
    private String latitude;

    @SerializedName("lng")
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
