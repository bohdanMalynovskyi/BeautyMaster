package com.example.beautymaster.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.beautymaster.R;

public class AppointmentFragment extends Fragment {

    private static final String PROCEDURE_NAME = "PROCEDURE_NAME";

    TextView tvAppointmentName;
    EditText evClientName;
    EditText evPhoneNumber;
    EditText evEmail;
    EditText evDateTime;
    EditText evComment;
    Button btnCompleteFormFilling;
    AlertDialog completedFormFillingDialog;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_appointment, container, false);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onViewCreated(view, savedInstanceState);
        tvAppointmentName = view.findViewById(R.id.tvAppointmentName);
        evClientName = view.findViewById(R.id.evClientName);
        evPhoneNumber = view.findViewById(R.id.evPhoneNumber);
        evEmail = view.findViewById(R.id.evEmail);
        evDateTime = view.findViewById(R.id.evDateTime);
        evComment = view.findViewById(R.id.evComment);
        btnCompleteFormFilling = view.findViewById(R.id.btnCompleteFormFilling);
        btnCompleteFormFilling.setOnClickListener(l -> {
            completedFormFillingDialog = alertDialog();
            completedFormFillingDialog.show();
        });

        if (getArguments() != null) {
            String appointmentName = getArguments().getString(PROCEDURE_NAME);
            tvAppointmentName.setText(tvAppointmentName.getText().toString() + "\n" + appointmentName);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home && getActivity() != null) {
            getActivity().onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private AlertDialog alertDialog() {
        String dialogMessage = "Ваші дані:\n\n" +
                evClientName.getText().toString() + "\n" +
                evPhoneNumber.getText().toString() + "\n" +
                evEmail.getText().toString() + "\n" +
                evDateTime.getText().toString() + "\n" +
                evComment.getText().toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(getString(R.string.dialog_title));
        builder.setMessage(dialogMessage);
        builder.setPositiveButton("Зберегти", (dialog, which) -> {
            dialog.cancel();
            getActivity().onBackPressed();
        });
        builder.setNegativeButton("Змінити", (dialog, which) -> {
            dialog.cancel();
        });
        return builder.create();
    }
}