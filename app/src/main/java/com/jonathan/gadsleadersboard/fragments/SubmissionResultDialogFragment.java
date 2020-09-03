package com.jonathan.gadsleadersboard.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jonathan.gadsleadersboard.R;

public class SubmissionResultDialogFragment extends DialogFragment {

    private ImageButton closeButton;
    private TextView resultTextView;
    private SubmissionResultDialogFragmentListener listener;
    private boolean status = false;

    public SubmissionResultDialogFragment() {
    }

    @SuppressLint("ValidFragment")
    public SubmissionResultDialogFragment(SubmissionResultDialogFragmentListener listener) {
        this.listener = listener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_submit_result, null);
        builder.setView(view);
        // define your view here
        closeButton = view.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.dismissDialog();
            }
        });

        resultTextView = view.findViewById(R.id.resultTextView);
        Bundle mArgs = getArguments();
        // submission success
        if (mArgs != null && mArgs.getBoolean("status", false)) {
            resultTextView.setText(R.string.STR_SUBMISSION_SUCCESSFUL);
            resultTextView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_submission_success, 0, 0);
        }
        // submission failed
        else {
            resultTextView.setText(R.string.STR_SUBMISSION_FAILED);
            resultTextView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_submission_failed, 0, 0);
        }
        return builder.create();
    }

    public interface SubmissionResultDialogFragmentListener {
        void dismissDialog();
    }

}
