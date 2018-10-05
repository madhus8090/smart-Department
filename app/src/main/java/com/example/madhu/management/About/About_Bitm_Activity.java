package com.example.madhu.management.About;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.madhu.management.R;

public class About_Bitm_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_bitm);

    }
    public void facebook(View view) {
        Intent facebookintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Bitmballari15/"));
        startActivity(facebookintent);
    }

    public void website(View view) {
        Intent websiteintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bitm.edu.in/"));
        startActivity(websiteintent);
    }

    public void instagram(View view) {
        Intent Instagramintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/bitmcollege/?hl=en"));
        startActivity(Instagramintent);
    }
}