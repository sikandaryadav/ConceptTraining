package chetu.second.batch.demo.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class UserDataWithSerilKeys implements Serializable {
    @SerializedName("fname")
    private String firstName;

    @SerializedName("lname")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
