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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BusnessFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BusnessFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BusnessFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BusnessFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BusnessFragment newInstance(String param1, String param2) {
        BusnessFragment fragment = new BusnessFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    ApiServices apiServices;
    TextView CatogoryTV;
    RecyclerView rv_contest_by_category;
    NewsAdpter newsAdpter;
    ArrayList<ScienceNewsDTO.Data> newsData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        apiServices = ApiClient.getAPIClient();
        // Inflate the layout for this fragment

        View  v =inflater.inflate(R.layout.fragment_busness, container, false);
        rv_contest_by_category = v.findViewById(R.id.rv_contest_by_category);
        CatogoryTV = v.findViewById(R.id.CatogoryTV);

        getSubject();
        return v;
    }
    public void getSubject(){

        Call<ScienceNewsDTO> call = apiServices.getSubject("business");
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