package chetu.second.batch.demo.retrofit.responses;

import com.google.gson.annotations.SerializedName;

import chetu.second.batch.demo.retrofit.pojos.AddressPojo;
import chetu.second.batch.demo.retrofit.pojos.CompanyPojo;

public class UserResponse {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("username")
    private String userName;

    @SerializedName("email")
    private String email;

    @SerializedName("phone")
    private String phone;

    @SerializedName("website")
    private String webSite;

    @SerializedName("address")
    private AddressPojo addressData;

    @SerializedName("company")
    private CompanyPojo companyData;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebSite() {
        return webSite;
    }

    public AddressPojo getAddressData() {
        return addressData;
    }

    public CompanyPojo getCompanyData() {
        return companyData;
    }
}
