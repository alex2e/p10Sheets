package com.example.alejandro.practica10sheet.ui;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.alejandro.practica10sheet.R;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView navigation;
    private FrameLayout flBottonShet;
    private ConstraintLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this::actionAfterSelected);

    }

    private void initView() {
        navigation = findViewById(R.id.navigation);
        flBottonShet = findViewById(R.id.flBottonShet);
        container = findViewById(R.id.container);
    }

    private boolean actionAfterSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_data:
                return true;
            case R.id.navigation_photo:
                return true;
            case R.id.navigation_info:
                return true;
        }
        return false;
    }



}
