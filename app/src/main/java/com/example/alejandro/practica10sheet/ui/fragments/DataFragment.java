package com.example.alejandro.practica10sheet.ui.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.alejandro.practica10sheet.R;
import com.example.alejandro.practica10sheet.data.Alumno;
import com.example.alejandro.practica10sheet.ui.EditActivityStarter;
import com.example.alejandro.practica10sheet.viewModels.MainActivityViewModel;

public class DataFragment extends Fragment {

    private Alumno alumno;
    MainActivityViewModel viewModel;

    public DataFragment() {
    }

    public static DataFragment newInstance() {
        return new DataFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_data, container, false);
    }

    private void initView(View view) {
        TextView lblName = view.findViewById(R.id.lblName);
        TextView lblNumber = view.findViewById(R.id.lblNumber);
        Button btnEdit = view.findViewById(R.id.btnEdit);

        alumno = viewModel.getAlumno();

        lblName.setText(alumno.getNombre());
        lblNumber.setText(String.valueOf(alumno.getNumero()));

        btnEdit.setOnClickListener(v -> lanzarActividad());
    }

    private void lanzarActividad() {
        EditActivityStarter.startForResult(getActivity(),alumno,1);
    }
}
