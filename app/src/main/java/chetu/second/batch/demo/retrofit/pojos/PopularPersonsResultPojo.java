package chetu.second.batch.demo.retrofit.pojos;

import com.google.gson.annotations.SerializedName;

public class PopularPersonsResultPojo {
    @SerializedName("adult")
    private boolean adult;

    @SerializedName("gender")
    private int gender;

    @SerializedName("id")
    private int id;
}
