package com.example.alejandro.practica10sheet.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import com.example.alejandro.practica10sheet.R;
import com.example.alejandro.practica10sheet.data.Alumno;
import com.squareup.picasso.Picasso;
import activitystarter.ActivityStarter;
import activitystarter.Arg;
import activitystarter.MakeActivityStarter;

@MakeActivityStarter(includeStartForResult = true) //1er paso: Está actividad es lanzable
public class PhotoActivity extends AppCompatActivity {

    @Arg //2º paso:  Es un argumneto del metodo para iniciar la actividad
    Alumno alumno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStarter.fill(this, savedInstanceState); //3er Paso: Para que me rellene los campos automaticamente
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        setContentView(R.layout.activity_photo);
        initView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ActivityStarter.save(this, outState);//4º Paso: Cualquier atributo que tenga @arg se restaura solo
    }

    private void initView() {
        ImageView imgPhotoAcivity = findViewById(R.id.imgPhotoAcivity);
        Picasso.with(this).load(alumno.getUrlPhoto()).into(imgPhotoAcivity);

    }

}
