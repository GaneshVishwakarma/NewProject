package newproject.example.com.newproject;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

import newproject.example.com.newproject.model.HomePageModel;

public class HomePageActivity extends AppCompatActivity {

    //toolbar setup
    private Toolbar toolBar;
    private TextView tv;

    //Homepage Content
    private RecyclerView recycler_view;
    private ImageView img_setting;
    private CheckBox check_activate;
    private HomepageAdapter homepageAdapter;

    private NestedScrollView scrollView;
    private LinearLayout lay_header,lay_parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        //set toolbar
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        tv = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(lp);
        Typeface face = Typeface.createFromAsset(getAssets(),
                "fonts/LucidaCalligraphy.ttf");
        tv.setTypeface(face);
        tv.setText(getString(R.string.app_name_header));
        tv.setTextSize(16);
        tv.setTextColor(getResources().getColor(R.color.colorDarkGray));

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(tv);
        //end of toolbar setup

        init();

        img_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePageActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });


    }

    public void init(){
        recycler_view=findViewById(R.id.recycler_view);
        img_setting=findViewById(R.id.img_setting);
        check_activate=findViewById(R.id.check_activate);
        scrollView=findViewById(R.id.scrollView);
        lay_header=findViewById(R.id.lay_header);
        lay_parent=findViewById(R.id.lay_parent);

        CountDownTimer countDownTimer=new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                setTempView();
            }
        }.start();

    }


    private class HomepageAdapter extends RecyclerView.Adapter<HomepageAdapter.HomepageViewHolder> {

        private ArrayList<HomePageModel> homePageModelArrayList;

        public HomepageAdapter(ArrayList<HomePageModel> homePageModelArrayList) {
            this.homePageModelArrayList = homePageModelArrayList;
        }

        @Override
        public HomepageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.card_layout_homepage, parent, false);
            return new HomepageViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final HomepageViewHolder holder, final int position) {

            final HomePageModel homePageModel=homePageModelArrayList.get(position);



            if (position==0) {
                holder.img_view.setImageResource(R.mipmap.ic_red);
                GradientDrawable gd = (GradientDrawable) holder.lay_parent.getBackground().getCurrent();
                gd.setColor(getResources().getColor(R.color.color_item_8_bg));
                gd.setCornerRadii(new float[]{5, 5, 5, 5, 5, 5, 5, 5});
                gd.setStroke(2, getResources().getColor(R.color.color_item_8), 0, 0);
            }
            else if (position==1) {
                holder.img_view.setImageResource(R.mipmap.ic_blue);
                GradientDrawable gd = (GradientDrawable) holder.lay_parent.getBackground().getCurrent();
                gd.setColor(getResources().getColor(R.color.color_item_4_bg));
                gd.setCornerRadii(new float[]{5, 5, 5, 5, 5, 5, 5, 5});
                gd.setStroke(2, getResources().getColor(R.color.color_item_4), 0, 0);
            }
            else if (position==2) {
                holder.img_view.setImageResource(R.mipmap.ic_cyan);
                GradientDrawable gd = (GradientDrawable) holder.lay_parent.getBackground().getCurrent();
                gd.setColor(getResources().getColor(R.color.color_item_7_bg));
                gd.setCornerRadii(new float[]{5, 5, 5, 5, 5, 5, 5, 5});
                gd.setStroke(2, getResources().getColor(R.color.color_item_7), 0, 0);
            }
            else if (position==3) {
                holder.img_view.setImageResource(R.mipmap.ic_green);
                GradientDrawable gd = (GradientDrawable) holder.lay_parent.getBackground().getCurrent();
                gd.setColor(getResources().getColor(R.color.color_item_4_bg));
                gd.setCornerRadii(new float[]{5, 5, 5, 5, 5, 5, 5, 5});
                gd.setStroke(2, getResources().getColor(R.color.color_item_4), 0, 0);
            }
            else if (position==4) {
                holder.img_view.setImageResource(R.mipmap.ic_orange);
                GradientDrawable gd = (GradientDrawable) holder.lay_parent.getBackground().getCurrent();
                gd.setColor(getResources().getColor(R.color.color_item_5_bg));
                gd.setCornerRadii(new float[]{5, 5, 5, 5, 5, 5, 5, 5});
                gd.setStroke(2, getResources().getColor(R.color.color_item_5), 0, 0);
            }
            else if (position==5) {
                holder.img_view.setImageResource(R.mipmap.ic_voilet);
                GradientDrawable gd = (GradientDrawable) holder.lay_parent.getBackground().getCurrent();
                gd.setColor(getResources().getColor(R.color.color_item_6_bg));
                gd.setCornerRadii(new float[]{5, 5, 5, 5, 5, 5, 5, 5});
                gd.setStroke(2, getResources().getColor(R.color.color_item_6), 0, 0);
            }
            else if (position==6) {
                holder.img_view.setImageResource(R.mipmap.ic_white);
                GradientDrawable gd = (GradientDrawable) holder.lay_parent.getBackground().getCurrent();
                gd.setColor(getResources().getColor(R.color.color_item_7_bg));
                gd.setCornerRadii(new float[]{5, 5, 5, 5, 5, 5, 5, 5});
                gd.setStroke(2, getResources().getColor(R.color.color_item_7), 0, 0);
            }
            else if (position==7) {
                holder.img_view.setImageResource(R.mipmap.ic_yellow);
                GradientDrawable gd = (GradientDrawable) holder.lay_parent.getBackground().getCurrent();
                gd.setColor(getResources().getColor(R.color.color_item_8_bg));
                gd.setCornerRadii(new float[]{5, 5, 5, 5, 5, 5, 5, 5});
                gd.setStroke(2, getResources().getColor(R.color.color_item_8), 0, 0);
            }
            else if (position==8) {
                holder.img_view.setImageResource(R.mipmap.ic_red);
                GradientDrawable gd = (GradientDrawable) holder.lay_parent.getBackground().getCurrent();
                gd.setColor(getResources().getColor(R.color.color_item_1_bg));
                gd.setCornerRadii(new float[]{5, 5, 5, 5, 5, 5, 5, 5});
                gd.setStroke(2, getResources().getColor(R.color.color_item_1), 0, 0);
            }
            else if (position==9) {
                holder.img_view.setImageResource(R.mipmap.ic_blue);
                GradientDrawable gd = (GradientDrawable) holder.lay_parent.getBackground().getCurrent();
                gd.setColor(getResources().getColor(R.color.color_item_2_bg));
                gd.setCornerRadii(new float[]{5, 5, 5, 5, 5, 5, 5, 5});
                gd.setStroke(2, getResources().getColor(R.color.color_item_2), 0, 0);
            }
            else if (position==10) {
                holder.img_view.setImageResource(R.mipmap.ic_cyan);
                GradientDrawable gd = (GradientDrawable) holder.lay_parent.getBackground().getCurrent();
                gd.setColor(getResources().getColor(R.color.color_item_3_bg));
                gd.setCornerRadii(new float[]{5, 5, 5, 5, 5, 5, 5, 5});
                gd.setStroke(2, getResources().getColor(R.color.color_item_3), 0, 0);
            }
            else if (position==11) {
                holder.img_view.setImageResource(R.mipmap.ic_green);
                GradientDrawable gd = (GradientDrawable) holder.lay_parent.getBackground().getCurrent();
                gd.setColor(getResources().getColor(R.color.color_item_4_bg));
                gd.setCornerRadii(new float[]{5, 5, 5, 5, 5, 5, 5, 5});
                gd.setStroke(2, getResources().getColor(R.color.color_item_4), 0, 0);
            }
            else if (position==12) {
                holder.img_view.setImageResource(R.mipmap.ic_orange);
                GradientDrawable gd = (GradientDrawable) holder.lay_parent.getBackground().getCurrent();
                gd.setColor(getResources().getColor(R.color.color_item_5_bg));
                gd.setCornerRadii(new float[]{5, 5, 5, 5, 5, 5, 5, 5});
                gd.setStroke(2, getResources().getColor(R.color.color_item_5), 0, 0);
            }
            else if (position==13) {
                holder.img_view.setImageResource(R.mipmap.ic_voilet);
                GradientDrawable gd = (GradientDrawable) holder.lay_parent.getBackground().getCurrent();
                gd.setColor(getResources().getColor(R.color.color_item_6_bg));
                gd.setCornerRadii(new float[]{5, 5, 5, 5, 5, 5, 5, 5});
                gd.setStroke(2, getResources().getColor(R.color.color_item_6), 0, 0);
            }
            else if (position==14) {
                holder.img_view.setImageResource(R.mipmap.ic_white);
                GradientDrawable gd = (GradientDrawable) holder.lay_parent.getBackground().getCurrent();
                gd.setColor(getResources().getColor(R.color.color_item_7_bg));
                gd.setCornerRadii(new float[]{5, 5, 5, 5, 5, 5, 5, 5});
                gd.setStroke(2, getResources().getColor(R.color.color_item_7), 0, 0);
            }
            else if (position==15) {
                holder.img_view.setImageResource(R.mipmap.ic_yellow);
                GradientDrawable gd = (GradientDrawable) holder.lay_parent.getBackground().getCurrent();
                gd.setColor(getResources().getColor(R.color.color_item_8_bg));
                gd.setCornerRadii(new float[]{5, 5, 5, 5, 5, 5, 5, 5});
                gd.setStroke(2, getResources().getColor(R.color.color_item_8), 0, 0);
            }


            holder.lay_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle=new Bundle();
                    bundle.putInt("imageID",position);
                    bundle.putString("headername",homePageModel.getName());
                    bundle.putString("content","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
                    Intent intent=new Intent(HomePageActivity.this,DetailPageActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

            holder.img_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle=new Bundle();
                    bundle.putInt("imageID",position);
                    bundle.putString("headername",homePageModel.getName());
                    bundle.putString("content","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
                    Intent intent=new Intent(HomePageActivity.this,DetailPageActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

            holder.txt_name.setText(homePageModel.getName());
            holder.txt_duration.setText("Duration: "+homePageModel.getDuration());
            holder.txt_time.setText("Time: "+homePageModel.getTime());

        }

        @Override
        public int getItemCount() {
            return homePageModelArrayList.size();
        }

        public class HomepageViewHolder extends RecyclerView.ViewHolder {

            ImageView img_view;
            TextView txt_duration,txt_name,txt_time;
            LinearLayout lay_parent;

            public HomepageViewHolder(View itemView) {
                super(itemView);
                img_view=itemView.findViewById(R.id.img_view);
                txt_duration=itemView.findViewById(R.id.txt_duration);
                txt_name=itemView.findViewById(R.id.txt_name);
                txt_time=itemView.findViewById(R.id.txt_time);
                lay_parent=itemView.findViewById(R.id.lay_parent);

            }
        }
    }

    public void setTempView(){
        ArrayList<HomePageModel> homePageModels=new ArrayList<>();

        homepageAdapter =new HomepageAdapter(homePageModels);


        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(HomePageActivity.this, 2);
        recycler_view.setLayoutManager(mLayoutManager);
        recycler_view.setNestedScrollingEnabled(false);
        recycler_view.setItemViewCacheSize(10);
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        recycler_view.setAdapter(homepageAdapter);


            HomePageModel  homePageModel=new HomePageModel();
            homePageModel.setName("Joy");
            homePageModel.setImageID(1);
            homePageModel.setTime("6:00 AM");
            homePageModel.setDuration("2:30");
            homePageModels.add(homePageModel);

        homePageModel=new HomePageModel();
        homePageModel.setName("Love");
        homePageModel.setImageID(2);
        homePageModel.setTime("7:00 AM");
        homePageModel.setDuration("2:30");
        homePageModels.add(homePageModel);

        homePageModel=new HomePageModel();
        homePageModel.setName("Determination");
        homePageModel.setImageID(3);
        homePageModel.setTime("8:00 AM");
        homePageModel.setDuration("2:30");
        homePageModels.add(homePageModel);

        homePageModel=new HomePageModel();
        homePageModel.setName("Politeness");
        homePageModel.setImageID(4);
        homePageModel.setTime("9:00 AM");
        homePageModel.setDuration("2:30");
        homePageModels.add(homePageModel);

        homePageModel=new HomePageModel();
        homePageModel.setName("Introversion");
        homePageModel.setImageID(5);
        homePageModel.setTime("10:00 AM");
        homePageModel.setDuration("2:30");
        homePageModels.add(homePageModel);

        homePageModel=new HomePageModel();
        homePageModel.setName("Power to Face");
        homePageModel.setImageID(6);
        homePageModel.setTime("11:00 AM");
        homePageModel.setDuration("2:30");
        homePageModels.add(homePageModel);

        homePageModel=new HomePageModel();
        homePageModel.setName("Power to discriminate");
        homePageModel.setImageID(7);
        homePageModel.setTime("12:00 AM");
        homePageModel.setDuration("2:30");
        homePageModels.add(homePageModel);

        homePageModel=new HomePageModel();
        homePageModel.setName("Power to co-operate");
        homePageModel.setImageID(8);
        homePageModel.setTime("1:00 PM");
        homePageModel.setDuration("2:30");
        homePageModels.add(homePageModel);

        homePageModel=new HomePageModel();
        homePageModel.setName("Power to Tolerate");
        homePageModel.setImageID(9);
        homePageModel.setTime("2:00 PM");
        homePageModel.setDuration("2:30");
        homePageModels.add(homePageModel);

        homePageModel=new HomePageModel();
        homePageModel.setName("Peace");
        homePageModel.setImageID(10);
        homePageModel.setTime("3:00 PM");
        homePageModel.setDuration("2:30");
        homePageModels.add(homePageModel);

        homePageModel=new HomePageModel();
        homePageModel.setName("Purity");
        homePageModel.setImageID(11);
        homePageModel.setTime("4:00 PM");
        homePageModel.setDuration("2:30");
        homePageModels.add(homePageModel);

        homePageModel=new HomePageModel();
        homePageModel.setName("Power");
        homePageModel.setImageID(12);
        homePageModel.setTime("5:00 PM");
        homePageModel.setDuration("2:30");
        homePageModels.add(homePageModel);

        homePageModel=new HomePageModel();
        homePageModel.setName("Bliss");
        homePageModel.setImageID(13);
        homePageModel.setTime("6:00 PM");
        homePageModel.setDuration("2:30");
        homePageModels.add(homePageModel);

        homePageModel=new HomePageModel();
        homePageModel.setName("Mind");
        homePageModel.setImageID(14);
        homePageModel.setTime("7:00 PM");
        homePageModel.setDuration("2:30");
        homePageModels.add(homePageModel);

        homePageModel=new HomePageModel();
        homePageModel.setName("Impressions");
        homePageModel.setImageID(15);
        homePageModel.setTime("8:00 PM");
        homePageModel.setDuration("2:30");
        homePageModels.add(homePageModel);

        homePageModel=new HomePageModel();
        homePageModel.setName("Intellect");
        homePageModel.setImageID(16);
        homePageModel.setTime("9:00 PM");
        homePageModel.setDuration("2:30");
        homePageModels.add(homePageModel);


        homepageAdapter.notifyDataSetChanged();


    }
}
