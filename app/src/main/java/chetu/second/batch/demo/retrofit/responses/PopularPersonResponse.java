package chetu.second.batch.demo.retrofit.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import chetu.second.batch.demo.retrofit.pojos.PopularPersonsResultPojo;

public class PopularPersonResponse {

    @SerializedName("page")
    private int page;

    @SerializedName("result")
    private List<PopularPersonsResultPojo> popularPersonsResultPojoList;


}
