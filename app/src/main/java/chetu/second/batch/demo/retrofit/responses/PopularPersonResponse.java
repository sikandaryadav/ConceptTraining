package chetu.second.batch.demo.retrofit.responses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import chetu.second.batch.demo.retrofit.pojos.PopularPersonsResultPojo;

public class PopularPersonResponse {

    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private List<PopularPersonsResultPojo> popularPersonsResultPojoList;

    public int getPage() {
        return page;
    }

    public List<PopularPersonsResultPojo> getPopularPersonsResultPojoList() {
        return popularPersonsResultPojoList;
    }
}
