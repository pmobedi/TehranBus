package com.example.tehranbus.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tehranbus.Fragment.DescriptionFragment;
import com.example.tehranbus.Fragment.MapFragment;
import com.example.tehranbus.Fragment.MovesFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter {
    private String stationId;

    public TabsPagerAdapter(@NonNull FragmentManager fm, String stationId) {
        super(fm);
        this.stationId = stationId;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return DescriptionFragment.newInstance(stationId);
            case 1:
                return MapFragment.newInstance(stationId);
            case 2:
                return MovesFragment.newInstance(stationId);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3; // تعداد تب‌ها
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Info";
            case 1:
                return "Map";
            case 2:
                return "Moves";
            default:
                return null;
        }
    }
}
