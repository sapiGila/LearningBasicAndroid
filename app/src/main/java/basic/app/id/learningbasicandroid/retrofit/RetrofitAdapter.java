package basic.app.id.learningbasicandroid.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dell on 1/29/2018.
 */

public class RetrofitAdapter {

    public Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dev.nostratech.com:10093/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}