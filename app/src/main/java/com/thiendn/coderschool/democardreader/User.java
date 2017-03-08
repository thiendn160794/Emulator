package com.thiendn.coderschool.democardreader;

import com.google.gson.annotations.SerializedName;

/**
 * Created by thiendn on 20/02/2017.
 */

public class User {
    @SerializedName("userId")
    private String userId;
    @SerializedName("fullname")
    private String fullname;

    public String getFullname() {
        return fullname;
    }

    public String getUserId() {

        return userId;
    }
}
