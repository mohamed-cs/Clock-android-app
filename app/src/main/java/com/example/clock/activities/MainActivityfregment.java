package com.example.clock.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.clock.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivityfregment extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private reminder remind;
    private MainActivity mainActivity;
    private MainActivity3 mainActivity3;
    private WorldClockActivity worldClockActivity;
    private MainActivityalarm activityalarm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityfragment);

        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tablayout);

        mainActivity= new MainActivity();
        mainActivity3= new MainActivity3();
        worldClockActivity=new WorldClockActivity();
        activityalarm=new MainActivityalarm();

        remind=new reminder();
        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(activityalarm, "Alarm");
        viewPagerAdapter.addFragment(worldClockActivity, "WorldClock");
        viewPagerAdapter.addFragment(mainActivity3, "Stopwatch");
        viewPagerAdapter.addFragment(mainActivity, "Timer");
        viewPagerAdapter.addFragment(remind,"Reminder");
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.getTabAt(0).setIcon(R.drawable.icons8_alarm_25px);
        tabLayout.getTabAt(1).setIcon(R.drawable.icons8_worldwide_delivery_25px);
        tabLayout.getTabAt(2).setIcon(R.drawable.icons8_timer_50px);
        tabLayout.getTabAt(3).setIcon(R.drawable.icons8_stopwatch_26px);
        tabLayout.getTabAt(4).setIcon(R.drawable.icons8_alarm_clock_25px);

    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            fragmentTitle.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }
    }
}
