package com.com.busantourisme.helper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.com.busantourisme.R;

public class CustomAppBarActivity extends AppCompatActivity {

    private static final String TAG = "CustomAppBarActivity";

    //자신만 호출
    protected void onAppBarSettings(boolean isBackButton) {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(isBackButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Log.d(TAG, "onOptionsItemSelected: 제목1 클릭");
                return true;

            case R.id.action_favorite:
                Log.d(TAG, "onOptionsItemSelected: 제목2 클릭");
                return true;

            default:

                return super.onOptionsItemSelected(item);
        }

    }
}