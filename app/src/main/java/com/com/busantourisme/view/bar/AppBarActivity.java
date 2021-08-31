package com.com.busantourisme.view.bar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.com.busantourisme.R;
import com.com.busantourisme.view.auth.JoinActivity;
import com.com.busantourisme.view.auth.LoginActivity;

public class AppBarActivity extends AppCompatActivity {

    private static final String TAG = "CustomAppBarActivity";
    private Context mContext = this;
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
            case R.id.itLogin:
                    Intent intent1 = new Intent(
                            mContext,
                            LoginActivity.class
                    );
                    startActivity(intent1);
                return true;
            case R.id.itSign:
                Intent intent2 = new Intent(
                        mContext,
                        JoinActivity.class
                );
                startActivity(intent2);
                return true;
            case R.id.itHeaundae:
                Log.d(TAG, "onOptionsItemSelected: 제목2 클릭");
                return true;


            default:

                return super.onOptionsItemSelected(item);
        }

    }
}