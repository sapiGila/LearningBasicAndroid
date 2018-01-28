package basic.app.id.learningbasicandroid.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Dell on 1/29/2018.
 */

public interface ContactPhoneRestApi {
    @GET("api/v1/person?limit=100")
    Call<ResultList> getContacts();

    @Headers("Content-Type: application/json")
    @POST("api/v1/person")
    Call<Result> addContact(@Body PhoneBook phoneBook);

    @Headers("Content-Type: application/json")
    @PUT("api/v1/person/{secure_id}")
    Call<Result> updateContact(@Path("secure_id") String contact_id, @Body PhoneBook phoneBook);

    @DELETE("api/v1/person/{secure_id}")
    Call<Result> deleteContact(@Path("secure_id") String contact_id);
}