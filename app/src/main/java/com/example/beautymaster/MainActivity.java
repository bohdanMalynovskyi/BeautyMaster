package com.example.beautymaster;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.beautymaster.db.AppDatabase;
import com.example.beautymaster.db.dao.PortfolioPhotoDao;
import com.example.beautymaster.db.dao.ServiceDao;
import com.example.beautymaster.models.PortfolioPhoto;
import com.example.beautymaster.models.Service;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String EYEBROW_MODELING_NAME = "Моделювання брів";
    private static final String EYELASH_LAMINATION_NAME = "Ламінування вій";
    private static final String EYELASH_EXTENSION_NAME = "Нарощування вій";

    public NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillDB();

        BottomNavigationView botNavView = findViewById(R.id.botNavView);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.mainpage_fragment, R.id.portfolio_fragment, R.id.services_fragment)
                .build();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(botNavView, navController);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

    @SuppressLint("CheckResult")
    private void fillDB() {

        List<Service> services = new ArrayList<>();
        List<PortfolioPhoto> portfolioPhotos = new ArrayList<>();

        services.add(new Service(
                EYEBROW_MODELING_NAME,
                "Modeling desc"
        ));

        services.add(new Service(
                EYELASH_LAMINATION_NAME,
                "Eyelash lamination descriptionEyelash lamination descriptionEyelash lamination descriptionEyelash lamination descriptionEyelash lamination description"
        ));

        services.add(new Service(
                EYELASH_EXTENSION_NAME,
                "Eyel desc"
        ));


        portfolioPhotos.add(new PortfolioPhoto(
                EYEBROW_MODELING_NAME,
                "https://user-images.githubusercontent.com/77198160/104620822-14dd5780-5698-11eb-97d9-9c6c50706b50.JPG"
        ));

        portfolioPhotos.add(new PortfolioPhoto(
                EYEBROW_MODELING_NAME,
                "https://user-images.githubusercontent.com/77198160/104621120-6b4a9600-5698-11eb-9623-3773fd75c756.JPG"
        ));

        portfolioPhotos.add(new PortfolioPhoto(
                EYEBROW_MODELING_NAME,
                "https://user-images.githubusercontent.com/77198160/104621158-77ceee80-5698-11eb-81eb-52f90e90569b.JPG"
        ));

        portfolioPhotos.add(new PortfolioPhoto(
                EYELASH_LAMINATION_NAME,
                "https://user-images.githubusercontent.com/77198160/104621268-9503bd00-5698-11eb-83fa-7a485a093e9c.JPG"
        ));

        portfolioPhotos.add(new PortfolioPhoto(
                EYELASH_LAMINATION_NAME,
                "https://user-images.githubusercontent.com/77198160/104621311-9fbe5200-5698-11eb-94a9-adbdf9d35298.JPG"
        ));

        portfolioPhotos.add(new PortfolioPhoto(
                EYELASH_LAMINATION_NAME,
                "https://user-images.githubusercontent.com/77198160/104621434-c8464c00-5698-11eb-9e1e-f01245c1de6a.JPG"
        ));

        portfolioPhotos.add(new PortfolioPhoto(
                EYELASH_EXTENSION_NAME,
                "https://user-images.githubusercontent.com/77198160/104621564-eb70fb80-5698-11eb-9e80-b1c6a1a91c6b.JPG"
        ));

        portfolioPhotos.add(new PortfolioPhoto(
                EYELASH_EXTENSION_NAME,
                "https://user-images.githubusercontent.com/77198160/104621611-f9268100-5698-11eb-9cd7-8f3d1c6f1b7d.JPG"
        ));

        portfolioPhotos.add(new PortfolioPhoto(
                EYELASH_EXTENSION_NAME,
                "https://user-images.githubusercontent.com/77198160/104621634-00e62580-5699-11eb-8d93-898b113162fe.JPG"
        ));

        Completable.fromAction(() -> {
            App.getInstance().getDatabase().clearAllTables();

            AppDatabase db = App.getInstance().getDatabase();
            ServiceDao serviceDao = db.serviceDao();
            PortfolioPhotoDao portfolioPhotoDao = db.portfolioPhotoDao();

            serviceDao.insertAll(services);
            portfolioPhotoDao.insertAll(portfolioPhotos);

        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {

                        },
                        error -> {

                        }
                );
    }
}