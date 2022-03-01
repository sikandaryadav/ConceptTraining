package chetu.second.batch.demo.retrofit;

import com.google.gson.annotations.SerializedName;

public class CompanyPojo {
    @SerializedName("name")
    private String companyName;

    @SerializedName("catchPhrase")
    private String catchPhrase;

    @SerializedName("bs")
    private String bs;

    public String getCompanyName() {
        return companyName;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }
}
