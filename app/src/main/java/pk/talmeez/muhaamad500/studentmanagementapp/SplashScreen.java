package pk.talmeez.muhaamad500.studentmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_activity);
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                }catch (Exception e){

                }finally {
                    Intent gotologinactivity = new Intent(SplashScreen.this , Login.class);
                    startActivity(gotologinactivity);
                }

            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
