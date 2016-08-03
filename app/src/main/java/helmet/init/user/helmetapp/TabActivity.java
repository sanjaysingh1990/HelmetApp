package helmet.init.user.helmetapp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;

public class TabActivity extends AppCompatActivity {

    TabLayout tabs;
    ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_tab);


        pager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(pager);

        tabs=(TabLayout)findViewById(R.id.tablayout);
        tabs.setupWithViewPager(pager);


    }

    private void setupViewPager(ViewPager pager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragments(new OneFragment(), "Glossy");
        adapter.addFragments(new OneFragment(), "Matt");
        pager.setAdapter(adapter);



    }

    class Adapter extends FragmentPagerAdapter{

        ArrayList<String> tit=new ArrayList<>();
        ArrayList<Fragment> frag=new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return frag.get(position);
        }

        @Override
        public int getCount() {
            return frag.size();
        }

        public void addFragments(Fragment fragment,String title){

            tit.add(title);
            frag.add(fragment);

        }
        @Override
        public CharSequence getPageTitle(int position) {
            return tit.get(position);
        }
    }
}
