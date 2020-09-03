package com.jonathan.gadsleadersboard.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;

import com.jonathan.gadsleadersboard.R;


public class ProgressDialogFragment extends DialogFragment {

    public ProgressDialogFragment() {
        setCancelable(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_progress, container, false);
        return view;
    }
}
