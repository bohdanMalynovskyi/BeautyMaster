package com.example.beautymaster.holder;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beautymaster.R;

public class ServiceHolder extends RecyclerView.ViewHolder {
    private final TextView tvServiceName;
    private final TextView tvServiceDescription;
    private final Button appointmentBtn;

    public ServiceHolder(@NonNull View itemView) {
        super(itemView);
        tvServiceName = itemView.findViewById(R.id.tvServiceName);
        tvServiceDescription = itemView.findViewById(R.id.tvServiceDescription);
        appointmentBtn = itemView.findViewById(R.id.btnAppointment);
    }

    public TextView getTvServiceName() {
        return tvServiceName;
    }

    public TextView getTvServiceDescription() {
        return tvServiceDescription;
    }

    public Button getAppointmentBtn() {
        return appointmentBtn;
    }
}
