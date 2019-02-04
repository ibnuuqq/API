package com.simple.ibnuqarib.api;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.simple.ibnuqarib.api.API.Apiservice;
import com.simple.ibnuqarib.api.Adapter.ListArrayAdapter;
import com.simple.ibnuqarib.api.Model.ModelData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DaftarCategory extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<ModelData> data_category = new ArrayList<>();
    ListView listview;
    ListArrayAdapter adapter;

    LinearLayout layout_loading;
    TextView text_load;
    ImageView icon_load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_category);
        layout_loading = findViewById(R.id.layout_loading);
        text_load = findViewById(R.id.text_load);
        icon_load = findViewById(R.id.icon_load);
        listview = findViewById(R.id.listCategory);
        listview.setOnItemClickListener( DaftarCategory.this);
        listview.setDividerHeight(0);
        setup();
    }

    public void setup() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Apiservice service = retrofit.create(Apiservice.class);

        Call<List<ModelData>> call = service.getSemuaData();
        Log.d("Get Semua ", "onResponse :" + service.getSemuaData());
        call.enqueue(new Callback<List<ModelData>>() {
            @Override
            public void onResponse(Call<List<ModelData>> call, Response<List<ModelData>> response) {

                if (response.isSuccessful()){
                    int jumlah = Objects.requireNonNull(response.body()).size();
                    for (int i = 0; i < jumlah; i++){
                        ModelData data = new ModelData(
                                Objects.requireNonNull(response.body()).get(i).getIdCategory(),
                                Objects.requireNonNull(response.body()).get(i).getNamaCategory());
                        data_category.add(data);
                        Log.d("RESPONSE", "onResponse :" + response.body().get(i).getIdCategory());
                    }
                    listview.setVisibility(View.VISIBLE);
                    adapter = new ListArrayAdapter(DaftarCategory.this,R.layout.row_category, data_category);
                    listview.setAdapter(adapter);

                    if (adapter.getCount() < 1){
                        layout_loading.setVisibility(View.VISIBLE);
                        String error = "Daftar Category kosong";
                        text_load.setText(error);
                        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_data_kosong);
                        icon_load.setImageBitmap(icon);
                    }else {
                        layout_loading.setVisibility(View.GONE);
                    }
                }else {
                    String error = "Error Retrive Data from Server !!!";
                    text_load.setText(error);
                    Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_network);
                    icon_load.setImageBitmap(icon);
                }

            }

            @Override
            public void onFailure(Call<List<ModelData>> call, Throwable t) {
                String error = "Error Retrive Data from Server wwaau!!!\n" + t.getMessage();
                text_load.setText(error);
                Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_network);
                icon_load.setImageBitmap(icon);
            }
        });
    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView ids = view.findViewById(R.id.listID);
        Intent intent = new Intent(DaftarCategory.this ,MainDetail.class);
        intent.putExtra(ModelData.id_category,ids.getText().toString());
        startActivityForResult(intent, 1);
        Log.d("On click", "onResponse :" + ids.getText().toString());
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            adapter.clear();
            setup();
        }
    }
}
