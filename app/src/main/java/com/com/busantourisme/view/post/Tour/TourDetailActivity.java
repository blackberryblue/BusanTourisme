package com.com.busantourisme.view.post.Tour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.com.busantourisme.InitMethod;
import com.com.busantourisme.R;
import com.com.busantourisme.controller.Dto.CMRespDto;
import com.com.busantourisme.controller.TourController;
import com.com.busantourisme.helper.BottomHelper;
import com.com.busantourisme.model.tour.Tour;
import com.com.busantourisme.view.bar.AppBarActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TourDetailActivity extends AppBarActivity implements InitMethod {

    private static final String TAG = "TourDetailActivity";
    private TourDetailActivity mContext = TourDetailActivity.this;
    private ImageView ivImg,ivFav,ivComment;
    private TextView tvTitle,tvCountFav,tvCountCom,tvHomepage;
    private MaterialTextView mtvTraffic,mtvAdd;
    private MaterialButton mbtnCall;
    private static final int ACTIVITY_NUM = 1;
    private TourController tourController;
    private static int callNum;
    private int tourId;


    @Override
    protected void onResume() {
        super.onResume();
        initData();
        Log.d(TAG, "onResume: intitData 실행?");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        init();
        Log.d(TAG, "onCreate: init실행?");
        initLr();
        Log.d(TAG, "onCreate: initLr실행?");
        initSetting();
        Log.d(TAG, "onCreate: initSetting실행?");






    }

    @Override
    public void init() {
        tourController = new TourController();
        ivImg = findViewById(R.id.ivImg);
        ivFav = findViewById(R.id.ivFav);
        ivComment = findViewById(R.id.ivComment);
        tvTitle = findViewById(R.id.tvTitle);
        mtvTraffic = findViewById(R.id.mtvTraffic);
        tvCountCom = findViewById(R.id.tvCounCom);
        mbtnCall = findViewById(R.id.mbtnCall);
        tvHomepage = findViewById(R.id.tvHomePage);
        mtvAdd = findViewById(R.id.mtvAdd);
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
        onAppBarSettings(true);
        setupBottomNavigationView();

        Intent getIntent = getIntent();
        tourId = getIntent.getIntExtra("tourId",0);
        if(tourId == 0) finish();
    }

    @Override
    public void initData() {
        tourController.findById(tourId).enqueue(new Callback<CMRespDto<Tour>>() {

            @Override
            public void onResponse(Call<CMRespDto<Tour>> call, Response<CMRespDto<Tour>> response) {

                CMRespDto<Tour> cm = response.body();
                tvTitle.append(cm.getData().getTourTitle());
                mtvTraffic.append(cm.getData().getTraffic());
                mtvAdd.append(cm.getData().getTourAddr());
                tvHomepage.append(cm.getData().getHomepage());
                mbtnCall.setOnClickListener(v->{
                    Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse(cm.getData().getTel()));
                    startActivity(intentCall);
                });


                Glide.with(mContext)
                        .load(cm.getData().getThumb())
                        .centerCrop()
                        .placeholder(R.drawable.haeundae)
                        .into(ivImg);
            }

            @Override
            public void onFailure(Call<CMRespDto<Tour>> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }

    private void setupBottomNavigationView() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        BottomHelper.enableBottomNavi(mContext,bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}