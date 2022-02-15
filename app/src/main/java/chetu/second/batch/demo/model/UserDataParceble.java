package chetu.second.batch.demo.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserDataParceble implements Parcelable {
    String fName;
    String lName;

    public UserDataParceble(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    protected UserDataParceble(Parcel in) {
        fName = in.readString();
        lName = in.readString();
    }

    public static final Creator<UserDataParceble> CREATOR = new Creator<UserDataParceble>() {
        @Override
        public UserDataParceble createFromParcel(Parcel in) {
            return new UserDataParceble(in);
        }

        @Override
        public UserDataParceble[] newArray(int size) {
            return new UserDataParceble[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fName);
        dest.writeString(lName);
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}
