package com.example.alejandro.practica10sheet.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.alejandro.practica10sheet.R;
import com.example.alejandro.practica10sheet.data.Alumno;
import com.example.alejandro.practica10sheet.ui.EditActivity;

public class MenuBottomSheetDialogFragment extends BottomSheetDialogFragment implements NavigationView.OnNavigationItemSelectedListener {

    private static final String ARG_STUDENT = "ARG_STUDENT";
    private static final int SHEET_PEAK_HEIGHT = 650;
    private Alumno alumno;
    private NavigationView navigationView;
    private OnFragmentInteractionListener mListener;

    public static MenuBottomSheetDialogFragment newInstance(Alumno alumno) {
        MenuBottomSheetDialogFragment frg = new MenuBottomSheetDialogFragment();
        Bundle arguments = new Bundle();
        arguments.putParcelable(ARG_STUDENT, alumno);
        frg.setArguments(arguments);
        return frg;
    }

    private final BottomSheetBehavior.BottomSheetCallback mBottomSheetBehaviorCallback = new
            BottomSheetBehavior.BottomSheetCallback() {

                @Override
                public void onStateChanged(@NonNull View bottomSheet, int newState) {
                    if (newState == BottomSheetBehavior.STATE_HIDDEN || newState == BottomSheetBehavior.STATE_SETTLING) {
                        dismiss();
                    }

                }

                @Override
                public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                }

            };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bottomsheet, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        obtainArguments();
        initViews(getView());
    }

    private void initViews(View view) {
        navigationView = view.findViewById(R.id.navigationView);
        setupBottomSheet(view);
    }

    private void setupBottomSheet(View view) {
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) view.getParent()).getLayoutParams();
        CoordinatorLayout.Behavior behavior = params.getBehavior();
        if (behavior != null && behavior instanceof BottomSheetBehavior) {
            BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) behavior;
            bottomSheetBehavior.setBottomSheetCallback(mBottomSheetBehaviorCallback);
            // To assure sheet is completely shown.
            bottomSheetBehavior.setPeekHeight(SHEET_PEAK_HEIGHT);//get the height dynamically
        }
        setupNavigationView();
    }

    private void setupNavigationView() {
        navigationView.setNavigationItemSelectedListener(this);
        if (alumno != null) {
            navigationView.getMenu().findItem(R.id.mnuTitle).setTitle(alumno.getNombre());
        }
    }

    private void obtainArguments() {
        if (getArguments() != null) {
            alumno = getArguments().getParcelable(ARG_STUDENT);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuCall:
                call();
                dismiss();
                return true;
            case R.id.mnuSaveChanges:
                saveChanges();
                dismiss();
                return true;
        }
        return false;
    }

    private void call() {
        Toast.makeText(getContext(), "Calling", Toast.LENGTH_SHORT).show();
    }

    private void saveChanges() {
        Toast.makeText(getContext(), "Saving", Toast.LENGTH_SHORT).show();
        mListener.guardarAlumno(alumno);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MenuBottomSheetDialogFragment.OnFragmentInteractionListener) {
            mListener = (MenuBottomSheetDialogFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void guardarAlumno(Alumno alumno);
    }
}