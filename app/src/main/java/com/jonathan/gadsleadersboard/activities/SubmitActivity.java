package com.jonathan.gadsleadersboard.activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.jonathan.gadsleadersboard.R;
import com.jonathan.gadsleadersboard.fragments.ConfirmDialogFragment;
import com.jonathan.gadsleadersboard.fragments.ProgressDialogFragment;
import com.jonathan.gadsleadersboard.fragments.SubmissionResultDialogFragment;
import com.jonathan.gadsleadersboard.models.SubmissionRequest;
import com.jonathan.gadsleadersboard.viewModel.SubmitFormViewModel;

public class SubmitActivity extends AppCompatActivity implements ConfirmDialogFragment.ConfirmDialogFragmentListener {

    private ConfirmDialogFragment confirmDialogFragment;
    private ProgressDialogFragment progressDialogFragment;
    private SubmissionResultDialogFragment fragment;
    private EditText firstName, lastName, emailAddress, projectLink;
    private TextView submitButton;
    private String userFName, userLName, userEmail, userProjectLink;

    private SubmitFormViewModel submitFormViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        confirmDialogFragment = new ConfirmDialogFragment(this);
        progressDialogFragment = new ProgressDialogFragment();
        submitFormViewModel = ViewModelProviders.of(this).get(SubmitFormViewModel.class);
        initUI();

    }

    private void initUI() {
        firstName = findViewById(R.id.firstName_editText);
        lastName = findViewById(R.id.lastName_editText);
        emailAddress = findViewById(R.id.email_editText);
        projectLink = findViewById(R.id.projectUrl_editText);
        submitButton = findViewById(R.id.buttonSubmit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isDataValid = true;
                // firstName
                if (TextUtils.isEmpty(firstName.getText().toString())) {
                    firstName.setError(getString(R.string.STR_REQUIRED_FIELD));
                    isDataValid = false;
                }
                // lastName
                if (TextUtils.isEmpty(lastName.getText().toString())) {
                    lastName.setError(getString(R.string.STR_REQUIRED_FIELD));
                    isDataValid = false;
                }
                // emailAddress
                if (TextUtils.isEmpty(emailAddress.getText().toString())) {
                    emailAddress.setError(getString(R.string.STR_REQUIRED_FIELD));
                    isDataValid = false;
                }
                // projectLink
                if (TextUtils.isEmpty(projectLink.getText().toString())) {
                    projectLink.setError(getString(R.string.STR_REQUIRED_FIELD));
                    isDataValid = false;
                }
                if (isDataValid) {
                    // show confirm dialog
                    userFName = firstName.getText().toString();
                    userLName = lastName.getText().toString();
                    userEmail = emailAddress.getText().toString();
                    userProjectLink = projectLink.getText().toString();

                    confirmDialogFragment.show(getFragmentManager(), "confirm-dialog");
                }

            }
        });
    }


    public void handleBack(View view) {
        this.finish();
    }

    @Override
    public void submit() {
        if (confirmDialogFragment != null)
            confirmDialogFragment.dismiss();
        // 1- show progress dialog
        progressDialogFragment.show(getSupportFragmentManager(), "progress-dialog");
        // 2- start request
        SubmissionRequest request = new SubmissionRequest(userFName, userLName, userEmail, userProjectLink);
        submitFormViewModel.submitRequestLiveData(request).observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                progressDialogFragment.dismiss();
                if (integer == SubmitFormViewModel.STATUS_OK) {
                    fragment = new SubmissionResultDialogFragment();
                    Bundle args = new Bundle();
                    args.putBoolean("status", true);
                    fragment.setArguments(args);
                    fragment.show(getFragmentManager(), "dialog");
                    resetView();
                } else {
                    fragment = new SubmissionResultDialogFragment();
                    Bundle args = new Bundle();
                    args.putBoolean("status", false);
                    fragment.setArguments(args);
                    fragment.show(getFragmentManager(), "dialog");
                }
            }
        });
    }

    private void resetView() {
        firstName.setText("");
        lastName.setText("");
        emailAddress.setText("");
        projectLink.setText("");
    }

    @Override
    public void dismiss() {
        if (confirmDialogFragment != null)
            confirmDialogFragment.dismiss();
    }
}