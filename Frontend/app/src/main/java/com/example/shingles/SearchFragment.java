package com.example.shingles;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;


public class SearchFragment extends Fragment implements View.OnClickListener {
    private StudioAdapter adapter;
    private ImageView search_back_icon;
    private MainActivity mainActivity;
    private ArrayList<StudioData> studiolist = new ArrayList<>();


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StudioData tempStudio = new StudioData();
        tempStudio.setOne_discount("13%");
        tempStudio.setTwo_discount("13%");
        tempStudio.setOne_account("20,000원");
        tempStudio.setTwo_account("40,000원");
        tempStudio.setOne_origin("23,000원");
        tempStudio.setTwo_origin("46,000원");
        tempStudio.setHeart(true);
        studiolist.add(tempStudio);

        tempStudio = new StudioData();
        tempStudio.setOne_discount("13%");
        tempStudio.setTwo_discount("13%");
        tempStudio.setOne_account("20,000원");
        tempStudio.setTwo_account("40,000원");
        tempStudio.setOne_origin("23,000원");
        tempStudio.setTwo_origin("46,000원");
        tempStudio.setHeart(false);
        studiolist.add(tempStudio);

        tempStudio = new StudioData();
        tempStudio.setOne_discount("13%");
        tempStudio.setTwo_discount("13%");
        tempStudio.setOne_account("20,000원");
        tempStudio.setTwo_account("40,000원");
        tempStudio.setOne_origin("23,000원");
        tempStudio.setTwo_origin("46,000원");
        tempStudio.setHeart(false);
        studiolist.add(tempStudio);

        tempStudio = new StudioData();
        tempStudio.setOne_discount("13%");
        tempStudio.setTwo_discount("13%");
        tempStudio.setOne_account("20,000원");
        tempStudio.setTwo_account("40,000원");
        tempStudio.setOne_origin("23,000원");
        tempStudio.setTwo_origin("46,000원");
        tempStudio.setHeart(true);
        studiolist.add(tempStudio);

        tempStudio = new StudioData();
        tempStudio.setOne_discount("13%");
        tempStudio.setTwo_discount("13%");
        tempStudio.setOne_account("20,000원");
        tempStudio.setTwo_account("40,000원");
        tempStudio.setOne_origin("23,000원");
        tempStudio.setTwo_origin("46,000원");
        tempStudio.setHeart(false);
        studiolist.add(tempStudio);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        search_back_icon = view.findViewById(R.id.search_back_icon);

        RecyclerView recyclerView = view.findViewById(R.id.studio_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        adapter = new StudioAdapter(studiolist);
        recyclerView.setAdapter(adapter);

        search_back_icon.setOnClickListener(this);

        adapter.setOnItemClickListener(new StudioAdapter.OnListItemSelected() {
            @Override
            public void onItemSelected(View v, int position) {
                StudioData tempData = new StudioData();
                tempData = studiolist.get(position);
                Intent intent = new Intent(getActivity(), RoomActivity.class);
                startActivity(intent);
            }
        });

        adapter.setOnHeartClickListener(new StudioAdapter.OnListHeartSelected() {
            @Override
            public void onHeartSelected(View v, int position) {
                StudioData tempData = new StudioData();
                tempData = studiolist.get(position);

                if(tempData.isHeart()){
                    tempData.setHeart(false);
                    studiolist.set(position, tempData);
                }
                else{
                    tempData.setHeart(true);
                    studiolist.set(position, tempData);
                }
                adapter.notifyDataSetChanged();
                Log.i("check2", String.valueOf(position));
            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view == search_back_icon){
            mainActivity.onChangeToHomeFragment();
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity)getActivity();
    }

}