package com.mamunsproject.awesomecollege_user_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class Splash_Screen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

                startActivity(new Intent(Splash_Screen.this, MainActivity.class));
                Splash_Screen.this.overridePendingTransition(R.anim.left_to_right,
                        R.anim.right_to_left);
               // overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_bottom);
                onDestroy();
                Log.d("TAG", "run: Executed;");
            }
        }, 5000);


    }


}