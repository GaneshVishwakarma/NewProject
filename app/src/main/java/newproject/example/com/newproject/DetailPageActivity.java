package newproject.example.com.newproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
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
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class DetailPageActivity extends AppCompatActivity {

    //toolbar setup
    private Toolbar toolBar;
    private TextView tv;
    private ImageView toolbarimage;


    private TextView txt_content;
    private ImageView imageView;
    private ImageView img_playvideo;

    //Content
    private String headername,content;
    private int imageID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolbarimage=(ImageView)findViewById(R.id.toolbarimage);
        toolbarimage.setVisibility(View.GONE);


        final Bundle bundle=getIntent().getExtras();
        imageID=bundle.getInt("imageID");
        content=bundle.getString("content");
        headername=bundle.getString("headername");
        
        setSupportActionBar(toolBar);
        tv = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(lp);
        Typeface face = Typeface.createFromAsset(getAssets(),
                "fonts/LucidaCalligraphy.ttf");
        tv.setTypeface(face);
        tv.setText(headername);
        tv.setTextSize(16);
        tv.setTextColor(getResources().getColor(R.color.colorDarkGray));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(tv);


        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            // only for gingerbread and newer versions

            //noinspection RestrictedApi
            @SuppressLint("RestrictedApi") final Drawable upArrow = AppCompatDrawableManager.get().getDrawable(DetailPageActivity.this, R.drawable.abc_ic_ab_back_material);
            upArrow.setColorFilter(getResources().getColor( R.color.colorGray), PorterDuff.Mode.SRC_ATOP);
            ActionBar mActionBar = getSupportActionBar();
            mActionBar.setHomeAsUpIndicator(upArrow);
        }else {
            final Drawable upArrow = ContextCompat.getDrawable(DetailPageActivity.this, R.drawable.abc_ic_ab_back_material);
            upArrow.setColorFilter(ContextCompat.getColor(DetailPageActivity.this, R.color.colorGray), PorterDuff.Mode.SRC_ATOP);
            ActionBar mActionBar = getSupportActionBar();
            mActionBar.setHomeAsUpIndicator(upArrow)    ;

        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        txt_content=findViewById(R.id.txt_content);
        imageView=findViewById(R.id.imageView);
        img_playvideo=findViewById(R.id.img_playvideo);

        if (imageID==0)
            imageView.setImageResource(R.drawable.ic_red);
        else if (imageID==1)
            imageView.setImageResource(R.drawable.ic_blue);
        else if (imageID==2)
            imageView.setImageResource(R.drawable.ic_cyan);
        else if (imageID==3)
            imageView.setImageResource(R.drawable.ic_green);
        else if (imageID==4)
            imageView.setImageResource(R.drawable.ic_orange);
        else if (imageID==5)
            imageView.setImageResource(R.drawable.ic_voilet);
        else if (imageID==6)
            imageView.setImageResource(R.drawable.ic_white);
        else if (imageID==7)
            imageView.setImageResource(R.drawable.ic_yellow);
        else if (imageID==8)
            imageView.setImageResource(R.drawable.ic_red);
        else if (imageID==9)
            imageView.setImageResource(R.drawable.ic_blue);
        else if (imageID==10)
            imageView.setImageResource(R.drawable.ic_cyan);
        else if (imageID==11)
            imageView.setImageResource(R.drawable.ic_green);
        else if (imageID==12)
            imageView.setImageResource(R.drawable.ic_orange);
        else if (imageID==13)
            imageView.setImageResource(R.drawable.ic_voilet);
        else if (imageID==14)
            imageView.setImageResource(R.drawable.ic_white);
        else if (imageID==15)
            imageView.setImageResource(R.drawable.ic_yellow);

        txt_content.setText(content);

        img_playvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Bundle bundle1=new Bundle();
                bundle1.putString("videoID","-m3V8w_7vhk");
                Intent intent=new Intent(DetailPageActivity.this,YoutubeActivity.class);
                intent.putExtras(bundle1);
                startActivity(intent);*/
            }
        });


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
