package com.example.toshiba.airbnb.Profile.BecomeAHost.BasicQuestions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toshiba.airbnb.Explore.Homes.HomeDescFragment;
import com.example.toshiba.airbnb.R;

import java.util.ArrayList;

/**
 * Created by TOSHIBA on 08/08/2017.
 */

public class AmenitiesIconMoreFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_amenities_icon_more, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        if(getArguments() != null) {
            //Load data from database
            if (getArguments().containsKey(HomeDescFragment.AMENITIES_FROM_DATABASE)) {

                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(new AmenitiesIconMoreAdapter(getActivity(), true,
                        getArguments().getStringArrayList(HomeDescFragment.AMENITIES_FROM_DATABASE)));
            }
        }else {
            //Load data from shared preferences
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(new AmenitiesIconMoreAdapter(getActivity(),false, new ArrayList<String>()));
        }
    }
}
