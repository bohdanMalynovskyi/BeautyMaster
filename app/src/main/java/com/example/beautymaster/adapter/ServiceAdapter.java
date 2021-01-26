package com.example.beautymaster.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beautymaster.MainActivity;
import com.example.beautymaster.R;
import com.example.beautymaster.holder.ServiceHolder;
import com.example.beautymaster.models.Service;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceHolder> {

    private static final String PROCEDURE_NAME = "PROCEDURE_NAME";

    List<Service> serviceList;
    FragmentActivity activity;

    public ServiceAdapter(List<Service> serviceList, FragmentActivity activity) {
        this.serviceList = serviceList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ServiceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.services_item, parent, false);
        return new ServiceHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceHolder holder, int position) {
        Service service = serviceList.get(position);

        holder.getTvServiceName().setText(service.getName());
        holder.getTvServiceDescription().setText(service.getDescription());
        holder.getAppointmentBtn().setOnClickListener(l -> {
            Bundle bundle = new Bundle();
            bundle.putString(PROCEDURE_NAME, service.getName());
            ((MainActivity) activity).navController.navigate(R.id.appointment_fragment, bundle);
        });
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }
}

