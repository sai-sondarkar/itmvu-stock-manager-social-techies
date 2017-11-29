package xyz.nvrsettle.itmvustockm.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import xyz.nvrsettle.itmvustockm.R;

public class SplashActivity extends AppCompatActivity {

    int splashTime = 3000; // time will be in Milli Seconds. 1 = 1000 ms :. 3 sec = 3000 ms

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // it is a simple class which gives our app a super power to run multiple tasks  at the same time
        // for example downloading image and even shwoing the image at the same time
        //
        Thread splashThread = new Thread(){
            @Override
            public void run() {
                try{
                    int waitTime = 0;
                    while (waitTime < splashTime){
                        sleep(100);
                        waitTime += 100;
                    }
                }catch (Exception e){
                    Log.d("ex",e.toString());
                }finally {
                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            };
        };

        splashThread.start();
    }
}
