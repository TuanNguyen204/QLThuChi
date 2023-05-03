package com.example.quanlythuchiapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavView = findViewById(R.id.bottom_nav_view);
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.item_home:
                        replaceFragment(HomeFragment.newInstance());
                        return true;
                    case R.id.item_hanmuc:
                        replaceFragment(HanmucFragment.newInstance());
                        return true;
                    case R.id.item_themmoi:
                        replaceFragment(ThemmoiFragment.newInstance());
                        return true;
                    case R.id.item_hoadon:
                        replaceFragment(HoadonFragment.newInstance());
                        return true;
                    case R.id.item_bieudo:
                        replaceFragment(BieudoFragment.newInstance());
                        return true;
                }
                return false;
            }
        });

    }

    private void replaceFragment(Fragment f){
        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.main_layout_fragment,f);
        transaction.commit();
    }
}