package com.com.busantourisme.view.post.festival;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.com.busantourisme.InitMethod;
import com.com.busantourisme.R;
import com.com.busantourisme.helper.BottomHelper;
import com.com.busantourisme.view.bar.AppBarActivity;
import com.com.busantourisme.view.post.adapter.FestivalAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FestivalActivity extends AppBarActivity implements InitMethod {


    private static final String TAG = "EventActivity";
    private FestivalActivity mContext = this;
    private RecyclerView rvEvent;
    private RecyclerView.LayoutManager rvLayoutManager;
    private FestivalAdapter eventAdapter;
    private static final int ACTIVITY_NUM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busan_event);

        onAppBarSettings(true);
        setupBottomNavigationView();

    }


    @Override
    public void init() {
        rvEvent = findViewById(R.id.rvEvent);

    }

    @Override
    public void initLr() {

    }

    @Override
    public void initSetting() {
        onAppBarSettings(true);
        setupBottomNavigationView();
    }

    @Override
    public void initAdater() {
        rvLayoutManager = new LinearLayoutManager(mContext,RecyclerView.VERTICAL,false);
        rvEvent.setLayoutManager(rvLayoutManager);
        eventAdapter = new FestivalAdapter(mContext);
        rvEvent.setAdapter(eventAdapter);
    }


    @Override
    public void initData() {

    }

    private void setupBottomNavigationView() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        BottomHelper.enableBottomNavi(mContext,bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}