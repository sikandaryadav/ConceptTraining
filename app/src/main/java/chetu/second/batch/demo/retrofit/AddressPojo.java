package chetu.second.batch.demo.retrofit;

import com.google.gson.annotations.SerializedName;

public class AddressPojo {
    @SerializedName("street")
    private String street;

    @SerializedName("suite")
    private String suite;

    @SerializedName("city")
    private String city;

    @SerializedName("zipcode")
    private String zipCode;

    @SerializedName("geo")
    private GeoPojo geoData;

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public GeoPojo getGeoData() {
        return geoData;
    }
}
