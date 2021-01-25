package com.example.beautymaster.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beautymaster.R;
import com.example.beautymaster.holder.ServiceHolder;
import com.example.beautymaster.models.Service;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceHolder> {

    List<Service> serviceList;

    public ServiceAdapter(List<Service> serviceList) {
        this.serviceList = serviceList;
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
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }
}

