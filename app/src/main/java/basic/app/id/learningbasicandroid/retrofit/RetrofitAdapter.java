package basic.app.id.learningbasicandroid.retrofit;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dell on 1/29/2018.
 */

public class RetrofitAdapter {

    private static boolean isDebugMode = false;

    public Retrofit getRetrofit() {
        OkHttpClientFactory okHttpClientFactory = OkHttpClientFactory.getInstance();
        HttpLoggingInterceptor logging = getLoggingLevel(isDebugMode);
        okHttpClientFactory.getOkHttpClientForRestAdapter().addInterceptor(logging);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dev.nostratech.com:10093/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClientFactory.getOkHttpClientForRestAdapter().build())
                .build();
        return retrofit;
    }

    private static HttpLoggingInterceptor getLoggingLevel(boolean isDebugMode) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        if (isDebugMode) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return logging;
    }
}