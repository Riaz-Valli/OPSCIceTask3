package com.example.icetask3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ApiService
        apiService = ApiClient.getApiService();

        // Example GET request
        Call<List<DataModel>> call = apiService.getData();
        call.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                if (response.isSuccessful()) {
                    List<DataModel> data = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
            }
        });


        DataModel newData = new DataModel();
        newData.setName("New Data");

        Call<DataModel> postCall = apiService.postData(newData);
        postCall.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                if (response.isSuccessful()) {
                    DataModel data = response.body();
                }
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
            }
        });
    }
}
