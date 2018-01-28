package basic.app.id.learningbasicandroid.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import basic.app.id.learningbasicandroid.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    private Gson gson;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        resultTextView = findViewById(R.id.result_text_view);
        gson = new Gson();
        RetrofitAdapter retrofitAdapter = new RetrofitAdapter();
        ContactPhoneRestApi contactPhoneRestApi = retrofitAdapter
                .getRetrofit()
                .create(ContactPhoneRestApi.class);
        getContacts(contactPhoneRestApi);
    }

    private void getContacts(ContactPhoneRestApi contactPhoneRestApi) {
        resultTextView.setText("Get Contacts Started...");
        contactPhoneRestApi.getContacts()
                .enqueue(new Callback<ResultList>() {
                    @Override
                    public void onResponse(Call<ResultList> call, Response<ResultList> response) {
                        if (response.isSuccessful()) {
                            if (response.body().getMessage().equals("OK")) {
                                JsonArray jsonArray = gson.toJsonTree(response.body().getResult()).getAsJsonArray();
                                Type phoneBookType = new TypeToken<ArrayList<PhoneBook>>() {
                                }.getType();
                                List<PhoneBook> phoneBooks = gson.fromJson(jsonArray, phoneBookType);
                                for (PhoneBook phoneBook : phoneBooks) {
                                    resultTextView.setText(resultTextView.getText().toString() + "\n\n" + phoneBook.toString());
                                }
                            } else {
                                resultTextView.setText(resultTextView.getText().toString() + "\n\nError : " + response.body().getResult().toString());
                            }
                        } else {
                            try {
                                resultTextView.setText(resultTextView.getText().toString() + "\n\nError : " + response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResultList> call, Throwable t) {
                        resultTextView.setText(resultTextView.getText().toString() + "\n\nError : " + t.getMessage());
                    }
                });
    }
}