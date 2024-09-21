package com.example.tehranbus.Fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tehranbus.Adapter.StationsListAdapter;
import com.example.tehranbus.Database.StationsDBAdapter;
import com.example.tehranbus.InformationActivity;
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
        View rootView = inflater.inflate(R.layout.fragment_stations, container, false);
        lst_data = rootView.findViewById(R.id.lst_data);

        // دریافت اطلاعات ایستگاه‌ها از دیتابیس
        stationsDBAdapter = new StationsDBAdapter(getActivity());
        ArrayList<Stations> stationsArrayList = stationsDBAdapter.getStations();

        // تنظیم آداپتر برای ListView
        StationsListAdapter stationsListAdapter = new StationsListAdapter(getActivity(), R.layout.stations_row, stationsArrayList);
        lst_data.setAdapter(stationsListAdapter);

        // لیسنر برای کلیک روی هر آیتم
        lst_data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // ایستگاه انتخاب‌شده
                Stations selectedStation = stationsArrayList.get(position);

                // ارسال اطلاعات ایستگاه به InformationActivity
                Intent intent = new Intent(getActivity(), InformationActivity.class);
                intent.putExtra("station_id", selectedStation.getId()); // ارسال ID ایستگاه
                intent.putExtra("station_title", selectedStation.getTitle()); // ارسال عنوان ایستگاه
                startActivity(intent);
            }
        });

        return rootView;
    }
}
