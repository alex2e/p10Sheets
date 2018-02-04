package com.example.alejandro.practica10sheet.viewModels;

import android.arch.lifecycle.ViewModel;
import com.example.alejandro.practica10sheet.data.Alumno;

public class MainActivityViewModel extends ViewModel {

    private Alumno alumno;

    public Alumno getAlumno() {
        if (alumno == null){
            alumno = new Alumno("Baldomero Nome Entero", 600200200, "http://www.glitztvla.com/wp-content/uploads/2016/03/6-caminos-para-volverte-una-persona-menos-toxica.jpg");
        }
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}