package com.example.tehranbus;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.tehranbus.Adapter.TabsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class InformationActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabsPagerAdapter tabsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        // دریافت stationId از Intent
        Intent intent = getIntent();
        String stationId = intent.getStringExtra("stationId"); // دریافت stationId از Intent

        // تنظیم ViewPager و Adapter
        viewPager = findViewById(R.id.pager);
        tabsPagerAdapter = new TabsPagerAdapter(getSupportFragmentManager(), stationId); // ارسال stationId
        viewPager.setAdapter(tabsPagerAdapter);

        // تنظیم TabLayout
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
