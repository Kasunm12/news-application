package com.orelit.myapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orelit.myapplication.R;
import com.orelit.myapplication.api.ApiClient;
import com.orelit.myapplication.api.ApiServices;
import com.orelit.myapplication.dto.ScienceNewsDTO;

import retrofit2.Callback;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ScienceFragment extends Fragment {

    ApiServices apiServices;

    TextView CatogoryTV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        apiServices = ApiClient.getAPIClient();

        View  v = inflater.inflate(R.layout.fragment_science, container, false);
        CatogoryTV = v.findViewById(R.id.CatogoryTV);

        // Inflate the layout for this fragment

        getSubject();
        return v;
    }

    public void getSubject(){

        Call<ScienceNewsDTO> call = apiServices.getSubject("science");
        call.enqueue(new Callback<ScienceNewsDTO>() {
            @Override
            public void onResponse(Call<ScienceNewsDTO> call, Response<ScienceNewsDTO> response) {
                if(response.isSuccessful()){
                    System.out.println("Success");
                    CatogoryTV.setText(response.body().getCategory());

                }else{
                    System.out.println("Unsuccessful");
                }
            }

            @Override
            public void onFailure(Call<ScienceNewsDTO> call, Throwable t) {

                System.out.println(t);
            }
        });

    }
}