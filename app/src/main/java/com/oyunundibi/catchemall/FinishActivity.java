package com.oyunundibi.catchemall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class FinishActivity extends AppCompatActivity {

    String score;
    TextView scoreText;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        mAdView = (AdView) findViewById(R.id.adView4);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        scoreText = findViewById(R.id.scoreText);

        score = getIntent().getStringExtra("score");

        scoreText.setText(score);

    }

    public void restartGame(View view) {

        Intent intent = new Intent(getApplicationContext(),LevelActivity.class);
        startActivity(intent);
        finish();

    }

    public void mainMenu(View view) {

        Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
        startActivity(intent);
        finish();

    }

}
