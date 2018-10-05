package com.example.madhu.management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.madhu.management.Results.CbcsResultsActivity;
import com.example.madhu.management.Results.NonCbcsResultsActivity;
import com.example.madhu.management.Results.RevalCbcsResultsActivity;
import com.example.madhu.management.Results.RevalNonCbcsResultsActivity;

public class ResultsActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView cbcsresults,noncbcsresults,revalcbcsresults,revalnoncbcsresults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        cbcsresults = (CardView)findViewById(R.id.cbcs);
        noncbcsresults = (CardView) findViewById(R.id.noncbcs);
        revalcbcsresults = (CardView)findViewById(R.id.revalcbcs);
        revalnoncbcsresults = (CardView) findViewById(R.id.revalnoncbcs);

        //setting Onclick listeners to cards

        cbcsresults.setOnClickListener(this);
        noncbcsresults.setOnClickListener(this);
        revalcbcsresults.setOnClickListener(this);
        revalnoncbcsresults.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.cbcs:
                i = new Intent(this, CbcsResultsActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.noncbcs:
                i = new Intent(this, NonCbcsResultsActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.revalcbcs:
                i = new Intent(this, RevalCbcsResultsActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.revalnoncbcs:
                i = new Intent(this, RevalNonCbcsResultsActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            default:
                break;
        }
    }
}
