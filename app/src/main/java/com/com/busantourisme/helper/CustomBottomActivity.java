package com.com.busantourisme.helper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.com.busantourisme.R;

public class CustomBottomActivity extends CustomAppBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__bottom);
    }
}