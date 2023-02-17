package com.orelit.myapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orelit.myapplication.R;
import com.orelit.myapplication.adapter.NewsAdpter;
import com.orelit.myapplication.api.ApiClient;
import com.orelit.myapplication.api.ApiServices;
import com.orelit.myapplication.dto.ScienceNewsDTO;

import java.util.ArrayList;

import retrofit2.Callback;


import retrofit2.Call;
import retrofit2.Response;

public class ScienceFragment extends Fragment {

    ApiServices apiServices;
    RecyclerView rv_contest_by_category;
    NewsAdpter newsAdpter;
    ArrayList<ScienceNewsDTO.Data> newsData;

    TextView CatogoryTV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        apiServices = ApiClient.getAPIClient();

        View  v = inflater.inflate(R.layout.fragment_science, container, false);
        rv_contest_by_category = v.findViewById(R.id.rv_contest_by_category);
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
                    newsData = response.body().getData();
                    CatogoryTV.setText(response.body().getCategory());
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                    rv_contest_by_category.setLayoutManager(layoutManager);
                    newsAdpter = new NewsAdpter(getContext(),newsData);
                    rv_contest_by_category.setAdapter(newsAdpter);

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