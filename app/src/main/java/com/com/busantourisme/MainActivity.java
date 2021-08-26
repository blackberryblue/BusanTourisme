package com.com.busantourisme;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.com.busantourisme.helper.BottomHelper;
import com.com.busantourisme.view.bar.AppBarActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppBarActivity implements InitMethod {


    private Context mContext = MainActivity.this;
    private static final int ACTIVITY_NUM = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onAppBarSettings(true);
        setupBottomNavigationView();

        init();
        initLr();

    }



    @Override
    public void init() {

    }

    @Override
    public void initLr() {

    }

    @Override
    public void initSetting() {

    }

    private void setupBottomNavigationView() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        BottomHelper.enableBottomNavi(mContext,bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}