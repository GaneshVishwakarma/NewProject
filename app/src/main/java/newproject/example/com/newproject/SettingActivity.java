package newproject.example.com.newproject;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {

    //toolbar setup
    private Toolbar toolBar;
    private TextView tv;
    private ImageView toolbarimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolbarimage=(ImageView)findViewById(R.id.toolbarimage);
        toolbarimage.setVisibility(View.GONE);
        setSupportActionBar(toolBar);
        tv = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(lp);
        Typeface face = Typeface.createFromAsset(getAssets(),
                "fonts/LucidaCalligraphy.ttf");
        tv.setTypeface(face);
        tv.setText("Setting");
        tv.setTextSize(16);
        tv.setTextColor(getResources().getColor(R.color.colorDarkGray));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(tv);


        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            // only for gingerbread and newer versions

            //noinspection RestrictedApi
            @SuppressLint("RestrictedApi") final Drawable upArrow = AppCompatDrawableManager.get().getDrawable(SettingActivity.this, R.drawable.abc_ic_ab_back_material);
            upArrow.setColorFilter(getResources().getColor( R.color.colorGray), PorterDuff.Mode.SRC_ATOP);
            ActionBar mActionBar = getSupportActionBar();
            mActionBar.setHomeAsUpIndicator(upArrow);
        }else {
            final Drawable upArrow = ContextCompat.getDrawable(SettingActivity.this, R.drawable.abc_ic_ab_back_material);
            upArrow.setColorFilter(ContextCompat.getColor(SettingActivity.this, R.color.colorGray), PorterDuff.Mode.SRC_ATOP);
            ActionBar mActionBar = getSupportActionBar();
            mActionBar.setHomeAsUpIndicator(upArrow)    ;

        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
