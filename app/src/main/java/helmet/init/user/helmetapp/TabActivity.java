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

int categoryno=getIntent().getIntExtra("category",1);
        pager = (ViewPager) findViewById(R.id.viewpager);

        if(categoryno==2)
            setupViewPager1(pager);

      else  if(categoryno==3)
            setupViewPager2(pager);

        else  if(categoryno==4)
            setupViewPager3(pager);

        else  if(categoryno==5)
            setupViewPager4(pager);

        else  if(categoryno==6)
            setupViewPager5(pager);

        else  if(categoryno==7)
            setupViewPager6(pager);

        else  if(categoryno==8)
            setupViewPager7(pager);

        else  if(categoryno==9)
            setupViewPager8(pager);

        else  if(categoryno==10)
            setupViewPager9(pager);

        else  if(categoryno==11)
            setupViewPager10(pager);

        else  if(categoryno==12)
            setupViewPager11(pager);

        else if(categoryno==13)
            setupViewPager12(pager);

        else
        setupViewPager(pager);

        tabs=(TabLayout)findViewById(R.id.tablayout);
        tabs.setupWithViewPager(pager);



    }

    private void setupViewPager12(ViewPager pager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());

        adapter.addFragments(new dash_glossy(), "Glossy");
        adapter.addFragments(new dash_matt(), "Matt");
        pager.setAdapter(adapter);
    }

    private void setupViewPager11(ViewPager pager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());

        adapter.addFragments(new storm_glossy(), "Glossy");
        adapter.addFragments(new storm_matt(), "Matt");
        pager.setAdapter(adapter);
    }

    private void setupViewPager10(ViewPager pager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());

        adapter.addFragments(new youth_glossy(), "Glossy");
        adapter.addFragments(new youth_matt(), "Matt");
        pager.setAdapter(adapter);
    }

    private void setupViewPager9(ViewPager pager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());

        adapter.addFragments(new essex_wave_glossy(), "Glossy");
        adapter.addFragments(new essex_wave_matt(), "Matt");
        pager.setAdapter(adapter);
    }

    private void setupViewPager8(ViewPager pager) {

        Adapter adapter = new Adapter(getSupportFragmentManager());

        adapter.addFragments(new essex_hot_glossy(), "Glossy");
        adapter.addFragments(new essex_hot_matt(), "Matt");
        pager.setAdapter(adapter);
    }

    private void setupViewPager7(ViewPager pager) {

        Adapter adapter = new Adapter(getSupportFragmentManager());

        adapter.addFragments(new essex_hit_glossy(), "Glossy");
        adapter.addFragments(new essex_hot_matt(), "Matt");
        pager.setAdapter(adapter);
    }

    private void setupViewPager6(ViewPager pager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());

        adapter.addFragments(new z_way_super_glossy(), "Glossy");
        adapter.addFragments(new z_way_super_matt(), "Matt");
        pager.setAdapter(adapter);
    }

    private void setupViewPager5(ViewPager pager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());

        adapter.addFragments(new z_way_glossy(), "Glossy");
        adapter.addFragments(new z_way_matt(), "Matt");
        pager.setAdapter(adapter);
    }

    private void setupViewPager4(ViewPager pager) {

        Adapter adapter = new Adapter(getSupportFragmentManager());

        adapter.addFragments(new HostGlossy(), "Glossy");
        adapter.addFragments(new HostMatt(), "Matt");
        pager.setAdapter(adapter);
    }

    private void setupViewPager2(ViewPager pager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());

        adapter.addFragments(new LeoGlossy(), "Glossy");
        adapter.addFragments(new LeoMatt(), "Matt");
        pager.setAdapter(adapter);
    }

    private void setupViewPager3(ViewPager pager) {

        Adapter adapter = new Adapter(getSupportFragmentManager());

        adapter.addFragments(new WalterGlossy(), "Glossy");
        adapter.addFragments(new WalterMatt(), "Matt");
        pager.setAdapter(adapter);

    }

    private void setupViewPager1(ViewPager pager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());

        adapter.addFragments(new ElexGlossy(), "Glossy");
        adapter.addFragments(new ElexMatt(), "Matt");
        pager.setAdapter(adapter);


    }

    private void setupViewPager(ViewPager pager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());

        adapter.addFragments(new OneFragment(), "Glossy");
        adapter.addFragments(new TwoFragment(), "Matt");
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
