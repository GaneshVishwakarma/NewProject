package newproject.example.com.newproject;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

        setContentView(R.layout.activity_main);
        callActivity();

    }



    private void callActivity(){
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(MainActivity.this,HomePageActivity.class);
                startActivity(intent);
                finish();

            }
        }, 3000);
    }
    @Override
    public void onDestroy() {
        /*if (mAdView != null) {
            mAdView.destroy();
        }*/
        super.onDestroy();
        try {
            handler.removeCallbacksAndMessages(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.finish();
    }

}