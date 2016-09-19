package com.sattar.fciblog;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.sattar.fciblog.Fragments.ProfileFragment;
import com.sattar.fciblog.Helpers.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
   Toolbar toolbar;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.tabs)
    TabLayout tabLayout;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initUI();
    }

    void initUI() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setupViewPager();
    }

    private void setupViewPager() {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ProfileFragment(), "Home");
        adapter.addFragment(new ProfileFragment(), "Profile");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
//
//    void anot() {
//
//        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(viewPagerAdapter);
//        setSupportActionBar(toolbar);
//
//        /*
//        TabLayout.newTab() method creates a tab view, Now a Tab view is not the view
//        which is below the tabs, its the tab itself.
//         */
//
//        final TabLayout.Tab home = tabLayout.newTab();
//        final TabLayout.Tab inbox = tabLayout.newTab();
//        final TabLayout.Tab star = tabLayout.newTab();
//
//        /*
//        Setting Title text for our tabs respectively
//         */
//
//        home.setText("Home");
//        inbox.setText("Inbox");
//        star.setText("Star");
//
//        /*
//        Adding the tab view to our tablayout at appropriate positions
//        As I want home at first position I am passing home and 0 as argument to
//        the tablayout and like wise for other tabs as well
//         */
//        tabLayout.addTab(home, 0);
//        tabLayout.addTab(inbox, 1);
//        tabLayout.addTab(star, 2);
//
//        /*
//        TabTextColor sets the color for the title of the tabs, passing a ColorStateList here makes
//        tab change colors in different situations such as selected, active, inactive etc
//
//        TabIndicatorColor sets the color for the indiactor below the tabs
//         */
//
//        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.tab_selector));
//        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.indicator));
//
//        /*
//        Adding a onPageChangeListener to the viewPager
//        1st we add the PageChangeListener and pass a TabLayoutPageChangeListener so that Tabs Selection
//        changes when a viewpager page changes.
//         */
//
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//
//    }
}
