package com.carribou.bottomnavigationaesthetics;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.afollestad.aesthetic.Aesthetic;
import com.afollestad.aesthetic.AestheticKeyProvider;
import com.afollestad.aesthetic.BottomNavBgMode;
import com.afollestad.aesthetic.BottomNavIconTextMode;
import com.afollestad.aesthetic.NavigationViewMode;

public class MainActivity extends AppCompatActivity implements AestheticKeyProvider{

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Aesthetic.attach(this);

        super.onCreate(savedInstanceState);

        if (Aesthetic.isFirstTime()) {
            Aesthetic.get()
                    .colorPrimaryRes(R.color.colorPrimary)
                    .colorAccentRes(R.color.colorAccent)
                    .colorStatusBarRes(R.color.colorPrimaryDark)
                    .colorNavigationBarRes(R.color.colorPrimary)
                    .textColorPrimaryRes(android.R.color.black)
                    .textColorPrimaryInverseRes(android.R.color.white)
                    .navigationViewMode(NavigationViewMode.SELECTED_PRIMARY)
                    .bottomNavigationBackgroundMode(BottomNavBgMode.PRIMARY_DARK)
                    .bottomNavigationIconTextMode(BottomNavIconTextMode.SELECTED_ACCENT)
                    .colorNavigationBarRes(R.color.colorPrimaryDark)
                    .apply();
        }

        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Aesthetic.resume(this);
    }

    @Override
    protected void onPause() {
        Aesthetic.pause(this);
        super.onPause();
    }

    @Nullable
    @Override
    public String key() {
        return "MainActivity";
    }
}
