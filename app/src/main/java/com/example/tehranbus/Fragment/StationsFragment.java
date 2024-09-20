package com.example.tehranbus.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.tehranbus.Adapter.StationsListAdapter;
import com.example.tehranbus.Database.StationsDBAdapter;
import com.example.tehranbus.Model.Stations;
import com.example.tehranbus.R;

import java.util.ArrayList;


public class StationsFragment extends Fragment {

    ListView lst_data;
    StationsDBAdapter stationsDBAdapter;
    public StationsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.fragment_stations, container, false);
        lst_data=(ListView)RootView.findViewById(R.id.lst_data);
        stationsDBAdapter = new StationsDBAdapter(getActivity());
        ArrayList<Stations> stationsArrayList = stationsDBAdapter.getStations();
        StationsListAdapter stationsListAdapter = new StationsListAdapter(getActivity(),R.layout.stations_row, stationsArrayList);
        lst_data.setAdapter(stationsListAdapter);
        return RootView;
    }
}