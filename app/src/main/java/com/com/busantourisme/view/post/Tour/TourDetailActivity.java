package com.com.busantourisme.view.post.Tour;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.com.busantourisme.InitMethod;
import com.com.busantourisme.R;
import com.com.busantourisme.helper.BottomHelper;
import com.com.busantourisme.view.bar.AppBarActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TourDetailActivity extends AppBarActivity implements InitMethod {

    private static final String TAG = "DetailActivity";
    private TourDetailActivity mContext = TourDetailActivity.this;
    private ImageView ivImg,ivFav,ivComment;
    private TextView tvTitle,tvContnet,tvCountFav,tvCountCom;
    private static final int ACTIVITY_NUM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        onAppBarSettings(true);
        setupBottomNavigationView();

        init();
        initLr();
        initSetting();

    }

    @Override
    public void init() {
        ivImg = findViewById(R.id.ivImg);
        ivFav = findViewById(R.id.ivFav);
        ivComment = findViewById(R.id.ivComment);
        tvTitle = findViewById(R.id.tvTitle);
        tvContnet = findViewById(R.id.tvContent);
        tvCountCom = findViewById(R.id.tvCounCom);
    }

    @Override
    public void initLr() {
        ivComment.setOnClickListener(v->{

            Intent intent = new Intent(
                    mContext,
                    TourCommentActivity.class
            );
           startActivity(intent);
        });
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