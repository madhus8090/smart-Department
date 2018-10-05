package com.example.madhu.management;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madhu.management.About.AboutDeveloperActivity;
import com.example.madhu.management.About.About_Bitm_Activity;
import com.example.madhu.management.Messages.ChatActivity;
import com.example.madhu.management.Messages.ChatMessage;
import com.example.madhu.management.Notice.NoticeAdminLoginActivity;
import com.google.firebase.auth.FirebaseAuth;

public class DashBoard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar = null;
    private CardView notice, notes, updates, questionpapers, results;
    private FirebaseAuth auth;
    private TextView txtWelcome;

    final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBoard.this, ChatActivity.class));
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        txtWelcome = (TextView)findViewById(R.id.textView);
        notice = (CardView) findViewById(R.id.noticecardId);
        notes = (CardView) findViewById(R.id.notescardId);
        questionpapers = (CardView) findViewById(R.id.questioncardId);
        updates = (CardView) findViewById(R.id.updatescardId);
        results = (CardView) findViewById(R.id.resultscardId);
        // add click listeners to cards
        notice.setOnClickListener(this);
        notes.setOnClickListener(this);
        questionpapers.setOnClickListener(this);
        results.setOnClickListener(this);
        updates.setOnClickListener(this);
// initialize firebase auth
        auth = FirebaseAuth.getInstance();
//check login status
        if(auth.getCurrentUser() == null){
      //  txtWelcome.setText(" welcome");
            startActivity(new Intent(DashBoard.this,MainActivity.class));
            finish();
    }
    }
boolean twice;
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
           //super.onBackPressed();
            //finish();
            Log.d(TAG, "Click");

            if(twice == true)
            {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                System.exit(0);
            }
            twice = true;
            Log.d(TAG, "Twice:" + twice);
            Toast.makeText(DashBoard.this,"Press again to exit",Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                twice = false;
                    Log.d(TAG, "Twice:" + twice);

                }
            },3000);


        }
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dash_board, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_upload) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        //here is the main place where we need to work on.
        int id=item.getItemId();
        switch (id) {

            case R.id.nav_notice:
                Intent h = new Intent(DashBoard.this, NoticeActivity.class);
                startActivity(h);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.nav_notes:
                Intent i = new Intent(DashBoard.this, NotesActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.nav_question_papers:
                Intent g = new Intent(DashBoard.this, QuestionPaperActivity.class);
                startActivity(g);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.nav_update:
                Intent s = new Intent(DashBoard.this, UpdatesActivity.class);
                startActivity(s);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.nav_logout:
                Intent k = new Intent(DashBoard.this,LogoutActivity.class);
                startActivity(k);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.nav_bitm:
                Intent l = new Intent(DashBoard.this,About_Bitm_Activity.class);
                startActivity(l);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.nav_info:
                Intent m = new Intent(DashBoard.this,AboutDeveloperActivity.class);
                startActivity(m);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.noticecardId:
                i = new Intent(this, NoticeActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.notescardId:
                i = new Intent(this, NotesActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.questioncardId:
                i = new Intent(this, QuestionPaperActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.updatescardId:
                i = new Intent(this, UpdatesActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.resultscardId:
                i = new Intent(this, ResultsActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }

    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }


}


