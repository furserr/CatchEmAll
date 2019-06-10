package com.oyunundibi.catchemall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class LevelActivity extends AppCompatActivity {

    int level;
    String levelString;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        mAdView = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        level = 0;
    }

    public void easyLevel(View view) {

        level = 500;
        levelString = Integer.toString(level);
        Intent intent = new Intent(getApplicationContext(), GameActivity.class);
        intent.putExtra("level", levelString);
        startActivity(intent);
        finish();

    }

    public void normalLevel(View view) {

        level = 400;
        levelString = Integer.toString(level);
        Intent intent = new Intent(getApplicationContext(), GameActivity.class);
        intent.putExtra("level", levelString);
        startActivity(intent);
        finish();

    }

    public void hardLevel(View view) {

        level = 300;
        levelString = Integer.toString(level);
        Intent intent = new Intent(getApplicationContext(), GameActivity.class);
        intent.putExtra("level", levelString);
        startActivity(intent);
        finish();

    }

}
