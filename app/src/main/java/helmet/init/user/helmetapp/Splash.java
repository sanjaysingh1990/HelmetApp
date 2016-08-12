package helmet.init.user.helmetapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class Splash extends AppCompatActivity {
    private ViewPager viewPager;
    LinearLayout dots;
    ArrayList<ImageView> dot = new ArrayList<>();

     AppAdapter AppAdapter;
    ArrayList<Integer> im = new ArrayList<>();
    AutoScrollViewPager mViewFlipper;

    int[] layouts = new int[]{
            R.layout.splash1,
            R.layout.splash2,
    };

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
     /*   viewPager = (ViewPager) findViewById(R.id.view_pager);
        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
*/


        // layouts of all welcome sliders
        // add few more layouts if you want



        im.add(R.drawable.splash);
        im.add(R.drawable.splash2);


        dots = (LinearLayout) findViewById(R.id.dots);
        addDots(dots, im.size(), getApplicationContext());
        mViewFlipper = (AutoScrollViewPager) findViewById(R.id.view_flipper);

        AppAdapter = new AppAdapter(im, this);
        mViewFlipper.setAdapter(AppAdapter);
        mViewFlipper.startAutoScroll();
        mViewFlipper.setInterval(4000);
        mViewFlipper.setAutoScrollDurationFactor(3);

        mViewFlipper.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dot.size(); i++) {
                    if (i == position)

                        dot.get(i).setColorFilter(Color.WHITE);
                    else

                        dot.get(i).setColorFilter(Color.parseColor("#303F9F"));


                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {


                try {
                    Thread.sleep(3000);
                    Intent activity = new Intent(Splash.this, CategoryActivity.class);
                    startActivity(activity);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        th.start();
        }

    private void addDots(LinearLayout view, int NUM_PAGES, Context context) {

        for (int i = 0; i < NUM_PAGES; i++) {
            ImageView dots = new ImageView(context);
            dots.setLayoutParams(new FrameLayout.LayoutParams(20, 20));
            dots.setPadding(3, 3, 3, 3);
            dots.setImageResource(R.drawable.dot);
            view.addView(dots);
            dot.add(dots);
        }
        dot.get(0).setColorFilter(Color.WHITE);
    }

    public class AppAdapter extends PagerAdapter {


        public List<Integer> parkingList;
        public Context context;
        LayoutInflater mLayoutInflater;

        private AppAdapter(List<Integer> apps, Context context) {
            this.parkingList = apps;
            this.context = context;
            mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public int getCount() {
            return parkingList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return  view == ((LinearLayout) object);
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.item_imageview, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.image);
            //imageView.setImageResource(mResources[position])
            // ;
            //imageView.setImageResource(parkingList.get(position));
            // imageView.setImageResource(R.drawable.matrimonial);
            imageView.setImageResource(im.get(position));
            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }

}



