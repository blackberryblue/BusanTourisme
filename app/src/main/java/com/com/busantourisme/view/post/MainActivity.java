package com.com.busantourisme.view.post;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.com.busantourisme.InitMethod;
import com.com.busantourisme.R;
import com.com.busantourisme.config.Provider.TourProvider;
import com.com.busantourisme.helper.BottomHelper;
import com.com.busantourisme.view.bar.AppBarActivity;
import com.com.busantourisme.view.post.adapter.MainAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;


//어댑터와 리사이클뷰 연결!
public class MainActivity extends AppBarActivity implements InitMethod {

    //다른 클래스에 메모리 전달
    private MainActivity mContext = this;
    private RecyclerView rvTorus;
    private TourProvider tp;
    private static final int ACTIVITY_NUM = 1;

    //방향 설정
    private RecyclerView.LayoutManager layoutManager;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onAppBarSettings(true);
        setupBottomNavigationView();

        init();
        initAdater();
        initData();

    }



    @Override
    public void init() {
        rvTorus = findViewById(R.id.rvTours);

    }

    @Override
    public void initLr() {


    }

    @Override
    public void initSetting() {

    }

    @Override
    public void initAdater() {
     layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
     rvTorus.setLayoutManager(layoutManager);
     mainAdapter = new MainAdapter(mContext);
     rvTorus.setAdapter(mainAdapter);
    }

    @Override
    public void initData(){
        TourProvider tp = new TourProvider();
        mainAdapter.addItems(tp.findAll());

    }
    private void setupBottomNavigationView() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        BottomHelper.enableBottomNavi(mContext,bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
