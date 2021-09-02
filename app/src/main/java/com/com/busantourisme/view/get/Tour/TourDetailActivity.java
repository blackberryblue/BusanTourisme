package com.com.busantourisme.view.get.Tour;

import android.Manifest;
import android.content.ClipData;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.com.busantourisme.InitMethod;
import com.com.busantourisme.R;
import com.com.busantourisme.controller.Dto.CMRespDto;
import com.com.busantourisme.controller.TourController;
import com.com.busantourisme.helper.BottomHelper;
import com.com.busantourisme.model.tour.Tour;
import com.com.busantourisme.util.GpsTracker;
import com.com.busantourisme.view.bar.AppBarActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TourDetailActivity extends AppBarActivity implements InitMethod {

    private static final String TAG = "TourDetailActivity";
    private TourDetailActivity mContext = TourDetailActivity.this;
    private TourController tourController;
    private ImageView ivImg,ivFav,ivComment;
    private TextView tvTitle,tvCountFav,tvCountCom,tvHomepage;
    private MaterialTextView mtvTraffic,mtvAdd;
    private MaterialButton mbtnCall;
    private View itNavi;
    private static final int ACTIVITY_NUM = 1;
    private int tourId;

////////////////////////////////
    private String destLng;
    private String destLat;

    /////////////
    private static final int GPS_ENABLE_REQUEST_CODE = 2001;
    private static final int PERMISSIONS_REQUEST_CODE = 100;
    String[] REQUIRED_PERMISSIONS  = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
    //kakaomap://route?sp=37.537229,127.005515&ep=37.4979502,127.0276368&by=PUBLICTRANSIT 예제
    //private String testurl = "kakaomap://route?sp=37.537229,127.005515&ep=37.4979502,127.0276368&by=PUBLICTRANSIT";
    private String urlForUsing;
    //내 위치 위,경도
    private GpsTracker gpsTracker;
    double latitude;
    double longitude;
    //필요시 String address = getCurrentAddress(latitude, longitude); 대한민국 서울시 종로구 ~~
    //내 위치 위,경도
    private String[] myCoords = new String[2];

    //도착지 위,경도
    private String[] destCoords = new String[2];
//    //커스텀해서 만드면 됨!
//    private String urlMoreSimle = "kakaomap://route?sp=" + myCoords[0] + "," + myCoords[1] + "&ep=" + destCoords[0] + "," + destCoords[1] + "&by=PUBLICTRANSIT";

    private LocationManager locationManager;




    @Override
    protected void onResume() {
        super.onResume();
        initData();
        Log.d(TAG, "onResume: intitData 실행?");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourdetail);
        onAppBarSettings(true);
        setupBottomNavigationView();


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
        itNavi = findViewById(R.id.itNavi);
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

                    String phoneNum = Arrays.toString(cm.getData().getTel().split("-")).replace(",","");

                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNum));
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