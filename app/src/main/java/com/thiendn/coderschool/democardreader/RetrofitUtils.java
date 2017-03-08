package com.thiendn.coderschool.democardreader;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by thiendn on 20/02/2017.
 */

public class RetrofitUtils {


    public static Retrofit get(){

        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

//    private static OkHttpClient client(String api_key){
//        return new OkHttpClient.Builder()
//                .addInterceptor(apiKeyInterceptor(api_key))
//                .build();
//    }

//    private static Interceptor apiKeyInterceptor(final String api_key){
//        return new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                HttpUrl url = chain.request().url()
//                        .newBuilder()
//                        .addQueryParameter("api_key", api_key)
//                        .build();
//                request = request.newBuilder()
//                        .url(url)
//                        .build();
//                return chain.proceed(request);
//            }
//        };
//    }
}