package com.com.busantourisme.helper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.SearchEvent;

import com.com.busantourisme.R;
import com.com.busantourisme.config.fragment.FragSearch;
import com.com.busantourisme.config.fragment.FragUserInfo;
import com.com.busantourisme.config.fragment.FragBusanEvent;
import com.com.busantourisme.view.fragmentView.BusanEventActivity;
import com.com.busantourisme.view.fragmentView.SearchActivity;
import com.com.busantourisme.view.fragmentView.UserInfoActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomHelper {


    public static void enableBottomNavi(Context context, BottomNavigationView bottomNavigation) {
        bottomNavigation.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    //클릭시 화면이동
                    if(item.getItemId()==R.id.navSearch){
                        Intent intent1 = new Intent(
                                context,
                                SearchActivity.class
                        );
                        intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent1);
                    }else if(item.getItemId() == R.id.navSetting){
                        Intent intent2 = new Intent(
                                context,
                                BusanEventActivity.class
                        );
                        intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent2);


                    }else if (item.getItemId() == R.id.navMenu){
                        Intent intent3 = new Intent(context, UserInfoActivity.class);
                        intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent3);
                    }

                return true;
            }
        });
    }



}