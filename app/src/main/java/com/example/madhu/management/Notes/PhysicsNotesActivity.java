package com.example.madhu.management.Notes;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.madhu.management.R;

public class PhysicsNotesActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView phym1,phyphy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics_notes);


        phym1 = (CardView) findViewById(R.id.notes_10_phy_m1);
        phym1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent notesintent = opennotes(this);
        startActivity(notesintent);
    }


    public static Intent opennotes(Context context){
        return new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/bitm-app-2.appspot.com/o/" +
                "Computer_Architecture.pdf?alt=media&token=d48e2cc5-ba7d-4c33-b6f0-3e8d3c146613"));
    }
}
