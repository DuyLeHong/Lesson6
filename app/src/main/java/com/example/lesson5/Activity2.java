package com.example.lesson5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Activity2 extends AppCompatActivity {

    public static final String AC2_KEY_DATA1 = "AC2_KEY_DATA1";
    public static final String AC2_KEY_DATA2 = "AC2_KEY_DATA2";
    public static final String AC2_KEY_DATA3 = "AC2_KEY_DATA3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity2);

        demoCollectionPagerAdapter = new DemoCollectionPagerAdapter(Activity2.this);
        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(demoCollectionPagerAdapter);

        //TabLayout tabLayout = findViewById(R.id.tab_layout);
        //tabLayout.setupWithViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, findViewById(R.id.pager),
                (tab, position) -> tab.setText("Trang " + (position + 1))
        ).attach();

        //lay du lieu tu Main Activity va log ra
        String sData1 = getIntent().getStringExtra(MainActivity.KEY_DATA1);
        int iData2 = getIntent().getIntExtra(MainActivity.KEY_DATA2, 0);
        Student student = (Student) getIntent().getSerializableExtra(MainActivity.KEY_DATA3);

        Log.d("Activity2", sData1);
        Log.d("Activity2", iData2 + "");
        Log.d("Activity2", student.toString());



    }

    @Override
    public void onBackPressed() {

        Intent in = getIntent();
        in.putExtra(AC2_KEY_DATA1, "Du lieu truyen ve tu Activity2");

        setResult(RESULT_OK, in);

        super.onBackPressed();
    }

    DemoCollectionPagerAdapter demoCollectionPagerAdapter;
    ViewPager2 viewPager;


    public class DemoCollectionPagerAdapter extends androidx.viewpager2.adapter.FragmentStateAdapter {
        public DemoCollectionPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }
//        public DemoCollectionPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }


//        @Override
//        public Fragment getItem(int i) {
//            Fragment fragment = new DemoObjectFragment();
//            Bundle args = new Bundle();
//            // Our object is just an integer :-P
//            args.putInt(DemoObjectFragment.ARG_OBJECT, i + 1);
//            fragment.setArguments(args);
//            return fragment;
//        }

//        @Override
//        public int getCount() {
//            return 5;
//        }

//        @Override
//        public CharSequence getPageTitle(int position) {
//            return "TRANG " + (position + 1);
//        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            Fragment fragment = new DemoObjectFragment();
            Bundle args = new Bundle();
            // Our object is just an integer :-P
            args.putInt(DemoObjectFragment.ARG_OBJECT, position + 1);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }


}