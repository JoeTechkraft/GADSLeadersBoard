package com.jonathan.gadsleadersboard.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.jonathan.gadsleadersboard.R;

public class ConfirmDialogFragment extends DialogFragment {

    private ConfirmDialogFragmentListener listener;

    public ConfirmDialogFragment (){}

    @SuppressLint("ValidFragment")
    public ConfirmDialogFragment (ConfirmDialogFragmentListener listener){
        this.listener = listener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_confirm, null);
        builder.setView(view);
        // define your view here
        view.findViewById(R.id.btnOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.submit();
            }
        });
        view.findViewById(R.id.btnClose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.dismiss();
            }
        });
        return builder.create();
    }
    public interface ConfirmDialogFragmentListener {
        void submit();
        void dismiss();
    }
}
