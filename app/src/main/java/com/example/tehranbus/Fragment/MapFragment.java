package com.example.tehranbus.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.tehranbus.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapFragment extends Fragment {

    // تعریف پارامتر برای نگهداری داده
    private static final String ARG_PARAM1 = "param1";

    // متغیر برای ذخیره‌سازی پارامتر دریافت شده
    private String mParam1;

    public MapFragment() {
        // سازنده خالی برای Fragment
    }

    /**
     * از این متد برای ایجاد نمونه جدیدی از Fragment استفاده کنید
     * با استفاده از پارامترهای ارائه شده.
     *
     * @param param1 پارامتر برای مقداردهی.
     * @return یک نمونه جدید از MapFragment.
     */
    public static MapFragment newInstance(String param1) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false);
    }
}
