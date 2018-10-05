package com.example.madhu.management.sampledata;

import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.madhu.management.R;
import com.example.madhu.management.ViewPagerAdapter;

public class ChemIntActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chem_int);


        tabLayout = (TabLayout) findViewById(R.id.tablayout3_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager3_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //adding fragments here
        adapter.AddFragment(new Int_10_chem_question_frag(),"2010");
        adapter.AddFragment(new Int_14_chem_question_frag(),"2014");
        adapter.AddFragment(new Int_15_chem_question_frag(),"2015");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this,R.color.backgroundcolor));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this,R.color.colorAccent));

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}
