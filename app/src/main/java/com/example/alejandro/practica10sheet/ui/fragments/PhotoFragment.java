package com.example.alejandro.practica10sheet.ui.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.example.alejandro.practica10sheet.R;
import com.example.alejandro.practica10sheet.data.Alumno;
import com.example.alejandro.practica10sheet.ui.EditActivityStarter;
import com.example.alejandro.practica10sheet.ui.PhotoActivityStarter;
import com.example.alejandro.practica10sheet.viewModels.MainActivityViewModel;
import com.squareup.picasso.Picasso;

public class PhotoFragment extends Fragment {

    private Alumno alumno;
    MainActivityViewModel viewModel;

    public PhotoFragment() {
        // Required empty public constructor
    }

    public static PhotoFragment newInstance() {
        return new PhotoFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_photo, container, false);
    }

    private void initView(View view) {
        Button btnDetails = view.findViewById(R.id.btnDetails);
        ImageView imgPhoto = view.findViewById(R.id.imgPhoto);

        alumno = viewModel.getAlumno();
        Picasso.with(getContext()).load(alumno.getUrlPhoto()).into(imgPhoto);

        btnDetails.setOnClickListener(v -> lanzarActividadDetails());
    }

    private void lanzarActividadDetails() {
        PhotoActivityStarter.startForResult(getActivity(),alumno,1);
    }

}
