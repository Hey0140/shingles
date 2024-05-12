package com.example.shingles;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private View search_map, search_date;
    private TextView search_map_text, search_calender_text;
    private MainActivity mainActivity;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        search_date = view.findViewById(R.id.search_date);
        search_map = view.findViewById(R.id.search_map);
        search_map_text = view.findViewById(R.id.search_map_text);
        search_calender_text = view.findViewById(R.id.search_calender_text);

        search_map.setOnClickListener(this);
        search_date.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view == search_map){
            search_map_text.setText("이수/사당");
        }
        if(view == search_date){
            search_calender_text.setText("5.11 (토) 20:00 ~ 22:00");
            mainActivity.onChangeToSearchFragment();
        }
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity)getActivity();
    }

}