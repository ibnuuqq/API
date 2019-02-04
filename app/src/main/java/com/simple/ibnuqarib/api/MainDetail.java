package com.simple.ibnuqarib.api;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.simple.ibnuqarib.api.API.Apiservice;
import com.simple.ibnuqarib.api.Adapter.ListArrayAdapter;
import com.simple.ibnuqarib.api.Adapter.ListArrayAdapterSub;
import com.simple.ibnuqarib.api.Model.ModelData;
import com.simple.ibnuqarib.api.Model.ModelDataSub;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainDetail extends AppCompatActivity {
    ArrayList<ModelDataSub> data_sub = new ArrayList<>();
    ListView listView;
    ListArrayAdapterSub adapterSub;
    String ID_CATEGORY;
    TextView nama_sub,deskripsi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row_detail);
        ID_CATEGORY = getIntent().getStringExtra(ModelData.id_category);
        Log.d("ID_CATERGORY", "onResponse :" + getIntent().getStringExtra(ModelData.id_category));
        nama_sub = findViewById(R.id.nama_sub);
        deskripsi = findViewById(R.id.deskripsi);
        listView = findViewById(R.id.listSub);

        bindData();

        
    }

    private void bindData() {
        Retrofit retrofit = new  Retrofit.Builder()
                .baseUrl(MainActivity.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Apiservice service = retrofit.create(Apiservice.class);
        Call<List<ModelDataSub>> call = service.getSingleData(ID_CATEGORY);
        Log.d("API", "onResponse :" + service.getSingleData(ID_CATEGORY));
        call.enqueue(new Callback<List<ModelDataSub>>() {
            @Override
            public void onResponse(Call<List<ModelDataSub>> call, @NonNull Response<List<ModelDataSub>> response) {
                if (response.isSuccessful()){
                    for(int i = 0; i < Objects.requireNonNull(response.body()).size(); i++){
                    nama_sub.setText(response.body().get(i).getNamaSubCategory());
                    deskripsi.setText(response.body().get(i).getDeskripsi());


                    }
                }
            }

            @Override
            public void onFailure(Call<List<ModelDataSub>> call, Throwable t) {

            }

        });
    }
}
