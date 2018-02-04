package com.example.alejandro.practica10sheet.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.alejandro.practica10sheet.R;
import com.example.alejandro.practica10sheet.data.Alumno;
import com.example.alejandro.practica10sheet.ui.fragments.MenuBottomSheetDialogFragment;

import activitystarter.ActivityStarter;
import activitystarter.Arg;
import activitystarter.MakeActivityStarter;

@MakeActivityStarter(includeStartForResult = true) //1er paso: Está actividad es lanzable
public class EditActivity extends AppCompatActivity implements MenuBottomSheetDialogFragment.OnFragmentInteractionListener {

    @Arg //2º paso:  Es un argumneto del metodo para iniciar la actividad
    public Alumno alumno;
    private TextInputEditText txtImputName;
    private TextInputEditText txtInputNumer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ActivityStarter.fill(this, savedInstanceState); //3er Paso: Para que me rellene los campos automaticamente
        initView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ActivityStarter.save(this, outState);//4º Paso: Cualquier atributo que tenga @arg se restaura solo
    }

    private void showBottomSheetDialogFragment(Alumno alumno) {
        String TAG_BOTTOMSHEET_FRAGMENT = "TAG_BOTTOMSHEET_FRAGMENT";
        alumno.setNombre(txtImputName.getText().toString());
        alumno.setNumero(txtInputNumer.getText().toString());

        MenuBottomSheetDialogFragment dialogFragment = MenuBottomSheetDialogFragment.newInstance(alumno);
        dialogFragment.show(getSupportFragmentManager(), TAG_BOTTOMSHEET_FRAGMENT);
    }

    private void initView() {
        Button btnOpciones = findViewById(R.id.btnOpciones);
        txtImputName = findViewById(R.id.txtImputName);
        txtInputNumer = findViewById(R.id.txtInputNumer);

        txtImputName.setText(alumno.getNombre());
        txtInputNumer.setText(String.valueOf(alumno.getNumero()));

        btnOpciones.setOnClickListener(v -> showBottomSheetDialogFragment(alumno));
    }

    /**
     * Al darle a la flecha de la ActionBar actua como el botón de retroceso
     * @return Boolean si ha usado.
     */
    @Override //He decidido quitar la ActionBar por cuestiones estéticas.
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void guardarAlumno(Alumno alumno) {
        Intent resultado = new Intent();
        resultado.putExtra(MainActivity.EXTRA_ALUNNO_EDITED, alumno);
        setResult(RESULT_OK, resultado);
        finish();
    }
}


