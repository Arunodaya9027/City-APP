package com.fieldproject.cityguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.fieldproject.cityguide.Common.LoginSignup.RetailerStartUpScreen;
import com.fieldproject.cityguide.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.fieldproject.cityguide.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.fieldproject.cityguide.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    //Variables
    static final float END_SCALE = 0.7f;
    RecyclerView featuredRecycler,mostViewedRecycler,categoriesRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1,gradient2,gradient3,gradient4;
    ImageView menuIcon;
    LinearLayout contentView;




    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.mostViewedRecycler);
        categoriesRecycler = findViewById(R.id.categoriesRecycler);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);



        naviagtionDrawer();

        //Recycler View function Call

        featuredRecycler();
        featuredMostViewed();
        featuredCategeory();





    }

    //Navigation Drawer Function

    private void naviagtionDrawer() {

        //Naviagtion Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNaviagtiondrawer();

    }

    private void animateNaviagtiondrawer() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimary));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //Scale the view based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleX(offsetScale);

                //Translate the view, accounting for the scaled width
                final float xoffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xoffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }

        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.nav_all_categories:
                startActivity(new Intent(getApplicationContext(),AllCategories.class));
                break;

        }
        return true;
    }

    //Recycler View Function

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.mcdonald_img,"Mcdonal's","It's Fell good to see you in Mcdonals.Food in our is tasty and delicious."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_1,"Edenrobe","It's Fell good to see you in Mcdonals.Food in our is tasty and delicious."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_2,"Sweets and bakers","It's Fell good to see you in Mcdonals.Food in our is tasty and delicious."));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);



    }
    private void featuredMostViewed() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.mcdonald_img,"Mcdonal's","It's Fell good to see you in Mcdonals.Food in our is tasty and delicious."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_1,"Edenrobe","It's Fell good to see you in Mcdonals.Food in our is tasty and delicious."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_2,"Sweets and bakers","It's Fell good to see you in Mcdonals.Food in our is tasty and delicious."));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);



    }
    private void featuredCategeory() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.mcdonald_img,"Mcdonal's","It's Fell good to see you in Mcdonals.Food in our is tasty and delicious."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_1,"Edenrobe","It's Fell good to see you in Mcdonals.Food in our is tasty and delicious."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_2,"Sweets and bakers","It's Fell good to see you in Mcdonals.Food in our is tasty and delicious."));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);



    }


    //Normal Function


public void  callRetailerScreen(View view){
        startActivity(new Intent(getApplicationContext(),RetailerStartUpScreen.class));

}
    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }






}