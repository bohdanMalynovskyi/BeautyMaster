package com.example.beautymaster.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beautymaster.App;
import com.example.beautymaster.R;
import com.example.beautymaster.adapter.PortfolioPhotoAdapter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PortfolioFragment extends Fragment {

    private RecyclerView portfolioPhotoList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_portfolio, container, false);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        portfolioPhotoList = view.findViewById(R.id.recViewPortfolio);

        App.getInstance().getDatabase().portfolioPhotoDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(portfolioPhotos -> portfolioPhotoList.setAdapter(new PortfolioPhotoAdapter(portfolioPhotos, getActivity())));
    }
}