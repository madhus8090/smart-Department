package com.example.madhu.management.Notes.Computer_science;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.madhu.management.NoticeActivity;
import com.example.madhu.management.R;

public class CseNotes_8_sem_Activity extends AppCompatActivity implements View.OnClickListener {

    private CardView Sa10, Sms10, web10, St10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_notes_8_sem_);

        Sa10 = (CardView) findViewById(R.id.notes_cse_8_10_sa);
        Sms10 = (CardView) findViewById(R.id.notes_cse_8_10_sms);
        web10 = (CardView) findViewById(R.id.notes_cse_8_10_web);
        St10 = (CardView) findViewById(R.id.notes_cse_8_10_st);


        Sa10.setOnClickListener(this);
        Sms10.setOnClickListener(this);
        web10.setOnClickListener(this);
        St10.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;
        switch (view.getId()) {
            case R.id.notes_cse_8_10_sa:
                i=   opennotessa(this);
                startActivity(i);
                break;
            case R.id.notes_cse_8_10_sms:
                i = opennotessms(this);
                startActivity(i);
                break;
            case R.id.notes_cse_8_10_web:
                i = opennotesweb(this);
                startActivity(i);
                break;
        }
    }

    public static Intent opennotessa(Context context) {
        return new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/bitm-app-2.appspot.com/o/Notes%2Fcse%20notes%2FSA%201st%20IA%20Test%20" +
                "Questions%20ans%20solutions.pdf?alt=media&token=d71100be-8a4c-4342-bc1a-e8d6de20d479"));

    }
    public static Intent opennotessms(Context context){
        return new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/bitm-app-2.appspot.com/o/" +
                "Computer_Architecture.pdf?alt=media&token=d48e2cc5-ba7d-4c33-b6f0-3e8d3c146613"));
    }
    public static Intent opennotesweb(Context context){
        return new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/bitm-app-2.appspot.com/o/" +
                "Computer_Architecture.pdf?alt=media&token=d48e2cc5-ba7d-4c33-b6f0-3e8d3c146613"));
    }
}
