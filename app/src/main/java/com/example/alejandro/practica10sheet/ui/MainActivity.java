package com.example.alejandro.practica10sheet.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import com.example.alejandro.practica10sheet.R;
import com.example.alejandro.practica10sheet.ui.fragments.DataFragment;
import com.example.alejandro.practica10sheet.ui.fragments.InfoFragment;
import com.example.alejandro.practica10sheet.ui.fragments.PhotoFragment;

public class MainActivity extends AppCompatActivity implements DataFragment.OnFragmentInteractionListener, InfoFragment.OnFragmentInteractionListener, PhotoFragment.OnFragmentInteractionListener {

    //Class Atributtes
    private FrameLayout flHuecoFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        BottomNavigationView navigation = findViewById(R.id.navigation);
        FragmentManager gestorFragmentos = getSupportFragmentManager();

        flHuecoFragments = findViewById(R.id.flHuecoFragments);


        //Listener del NavigationItemSelected
        navigation.setOnNavigationItemSelectedListener(this::actionAfterSelected);

        //Para que siempre este cargado un fragmento
        if (gestorFragmentos.findFragmentById(flHuecoFragments.getId()) == null) {
            getSupportFragmentManager().beginTransaction().replace(flHuecoFragments.getId(), DataFragment.newInstance()).commitNow();
        }
    }

    private boolean actionAfterSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_data:
                getSupportFragmentManager().beginTransaction().replace(flHuecoFragments.getId(), DataFragment.newInstance()).commitNow();
                break;
            case R.id.navigation_photo:
                getSupportFragmentManager().beginTransaction().replace(flHuecoFragments.getId(), PhotoFragment.newInstance()).commitNow();
                break;
            case R.id.navigation_info:
                getSupportFragmentManager().beginTransaction().replace(flHuecoFragments.getId(), InfoFragment.newInstance()).commitNow();
                break;
        }
        return true;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
