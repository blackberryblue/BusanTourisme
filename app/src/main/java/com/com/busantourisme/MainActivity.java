package com.com.busantourisme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.com.busantourisme.R;
import com.com.busantourisme.helper.CustomAppBarActivity;
import com.com.busantourisme.helper.CustomBottomActivity;

public class MainActivity extends CustomBottomActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onAppBarSettings(true);

    }
}