package com.thiendn.coderschool.democardreader;

import java.sql.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by thiendn on 20/02/2017.
 */

public interface Api {
    @GET("users/profile?term={term}&createDate={createDate}&ticketid={ticketid}")
    Call<List<User>> checkin(@Path("term")String searchTemp,
                            @Path("createDate")Date createDate,
                            @Path("ticketid")String ticketid);
}
