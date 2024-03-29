package com.oyunundibi.catchemall;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    TextView scoreText;
    TextView timeText;
    int score;
    String skor;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;
    int success;
    int level;
    String levelString;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mAdView = (AdView) findViewById(R.id.adView3);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        hideImages();

        scoreText = (TextView) findViewById(R.id.scoreText);
        timeText = (TextView) findViewById(R.id.timeText);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);

        imageArray = new ImageView[] {imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9};

        score = 0;
        levelString = getIntent().getStringExtra("level");

        level = Integer.parseInt(levelString);


        new CountDownTimer(15000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

                timeText.setText("Time: " + ((millisUntilFinished/1000)+1));

            }

            @Override
            public void onFinish() {

                timeText.setText("Time Off");

                handler.removeCallbacks(runnable);

                for (ImageView image : imageArray) {

                    image.setVisibility(View.INVISIBLE);

                }

                skor = Integer.toString(score);

                Intent intent = new Intent(getApplicationContext(),FinishActivity.class);
                intent.putExtra("score", skor);
                startActivity(intent);
                finish();


                /*
                AlertDialog.Builder alert = new AlertDialog.Builder(GameActivity.this);
                alert.setTitle("Your Score : " + score );
                alert.setMessage("Do you want to restart game?");
                alert.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);

                    }
                });
                alert.setNegativeButton("Home", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                        startActivity(intent);

                    }
                });

                alert.show(); */



            }
        }.start();
    }

    public void increaseScore (View view) {
        score++;

        scoreText.setText("Score: " + score);

    }

    public void hideImages() {

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {

                for (ImageView image : imageArray) {

                    image.setVisibility(View.INVISIBLE);

                }

                Random random = new Random();
                int i = random.nextInt(9);

                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this, level);


            }
        };

        handler.post(runnable);



    }
}
