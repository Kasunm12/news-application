package com.orelit.myapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.orelit.myapplication.R;
import com.orelit.myapplication.fragments.BusnessFragment;
import com.orelit.myapplication.fragments.ScienceFragment;
import com.orelit.myapplication.fragments.TechnologyFragment;

public class NewsActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ScienceFragment scienceFragment = new ScienceFragment();
    BusnessFragment busnessFragment = new BusnessFragment();
    TechnologyFragment technologyFragment= new TechnologyFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.orelit.myapplication.R.layout.activity_news);

        bottomNavigationView = findViewById(R.id.Bottom_Nav);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,scienceFragment).commit();

        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.Busness);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(10);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Science:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,scienceFragment).commit();
                        return true;
                    case R.id.Busness:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,busnessFragment).commit();
                        return true;
                    case R.id.Technology:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,technologyFragment).commit();
                        return true;
                }
                return false;
            }
        });


    }
}