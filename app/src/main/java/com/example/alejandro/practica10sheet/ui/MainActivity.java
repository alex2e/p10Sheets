package com.example.alejandro.practica10sheet.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.alejandro.practica10sheet.R;
import com.example.alejandro.practica10sheet.data.Alumno;
import com.example.alejandro.practica10sheet.ui.fragments.DataFragment;
import com.example.alejandro.practica10sheet.ui.fragments.InfoFragment;
import com.example.alejandro.practica10sheet.ui.fragments.PhotoFragment;
import com.example.alejandro.practica10sheet.viewModels.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    public static String EXTRA_ALUNNO_EDITED = "EXTRA_ALUNNO_EDITED";
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
        //if (gestorFragmentos.findFragmentById(flHuecoFragments.getId()) == null) {
            getSupportFragmentManager().beginTransaction().replace(flHuecoFragments.getId(), DataFragment.newInstance()).commitNow();
       // }
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 1) {
            if (data.hasExtra(EXTRA_ALUNNO_EDITED)) {
                Alumno alumno = data.getParcelableExtra(EXTRA_ALUNNO_EDITED);
                ViewModelProviders.of(this).get(MainActivityViewModel.class).setAlumno(alumno);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    //CON ESTO VUELVO A RECARGAR LOS DATOS
    @Override
    protected void onResumeFragments() {
        getSupportFragmentManager().beginTransaction().replace(flHuecoFragments.getId(), DataFragment.newInstance()).commitNow();
        super.onResumeFragments();
    }
}
