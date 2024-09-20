package com.example.tehranbus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tehranbus.Database.DatabaseAssets;
import com.example.tehranbus.Fragment.StationsFragment;
import com.google.android.material.navigation.NavigationView;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DatabaseAssets mydatabase;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);
        mydatabase = new DatabaseAssets(getApplicationContext());

        try {
            mydatabase.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mydatabase.openDataBase();


        if (savedInstanceState == null)
        {

            getSupportFragmentManager().beginTransaction().add(R.id.container,new StationsFragment()).commit();


        }
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation);

        // اضافه کردن این خط برای اتصال لیسنر
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.action_home) {
            // کد مربوط به خانه
            Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_LONG).show();
        } else if (id == R.id.action_setting) {
            // کد مربوط به تنظیمات
            Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_LONG).show();
        }
        // می‌توانید شرایط بیشتری اضافه کنید
        else {
            // برای مواردی که با هیچکدام از شرایط بالا مطابقت ندارند
            Toast.makeText(getApplicationContext(), "Unknown option", Toast.LENGTH_LONG).show();
        }

        // مقدار true را برگردانید تا انتخاب آیتم تایید شود
        return true;
    }
    }