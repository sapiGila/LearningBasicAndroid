package basic.app.id.learningbasicandroid.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
    private PhoneBook tempPhoneBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        resultTextView = findViewById(R.id.result_text_view);
        gson = new Gson();
        RetrofitAdapter retrofitAdapter = new RetrofitAdapter();
        final ContactPhoneRestApi contactPhoneRestApi = retrofitAdapter
                .getRetrofit()
                .create(ContactPhoneRestApi.class);
        getContacts(contactPhoneRestApi);
        findViewById(R.id.add_person_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addContacts(contactPhoneRestApi);
                    }
                });
        findViewById(R.id.edit_person_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editContacts(contactPhoneRestApi);
                    }
                });
        findViewById(R.id.delete_person_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteContacts(contactPhoneRestApi);
                    }
                });
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
                                tempPhoneBook = phoneBooks.get(phoneBooks.size() - 1);
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

    private void addContacts(ContactPhoneRestApi contactPhoneRestApi) {
        PhoneBook phoneBook = new PhoneBook("test1", "alamat test1", "08123456", "test1@test.com");
        contactPhoneRestApi.addContact(phoneBook)
                .enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        if (response.isSuccessful()) {
                            resultTextView.setText(resultTextView.getText().toString() + "\n\n" + response.body().getResult().toString());
                        } else {
                            try {
                                resultTextView.setText(resultTextView.getText().toString() + "\n\nError : " + response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {
                        resultTextView.setText(resultTextView.getText().toString() + "\n\nError : " + t.getMessage());
                    }
                });
    }

    private void editContacts(ContactPhoneRestApi contactPhoneRestApi) {
        PhoneBook phoneBook = new PhoneBook("testx", "alamat testx", "08654321", "testx@test.com");
        phoneBook.setVersion(tempPhoneBook.getVersion());
        contactPhoneRestApi.updateContact(tempPhoneBook.getId(), phoneBook)
                .enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        if (response.isSuccessful()) {
                            if (response.body().getMessage().equals("OK")) {
                                JsonObject jsonObject = gson.toJsonTree(response.body().getResult()).getAsJsonObject();
                                PhoneBook phoneBook = gson.fromJson(jsonObject.toString(), PhoneBook.class);
                                resultTextView.setText(resultTextView.getText().toString() + "\n\n" + phoneBook.toString());
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
                    public void onFailure(Call<Result> call, Throwable t) {
                        resultTextView.setText(resultTextView.getText().toString() + "\n\nError : " + t.getMessage());
                    }
                });
    }

    private void deleteContacts(ContactPhoneRestApi contactPhoneRestApi) {
        contactPhoneRestApi.deleteContact(tempPhoneBook.getId())
                .enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        if (response.isSuccessful()) {
                            resultTextView.setText(resultTextView.getText().toString() + "\n\n" + response.body().getResult().toString());
                        } else {
                            try {
                                resultTextView.setText(resultTextView.getText().toString() + "\n\nError : " + response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {
                        resultTextView.setText(resultTextView.getText().toString() + "\n\nError : " + t.getMessage());
                    }
                });
    }
}