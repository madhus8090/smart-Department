package com.example.madhu.management;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.madhu.management.Notes.ChemistryNotesActivity;
import com.example.madhu.management.Notes.Computer_science.CseNotes_8_sem_Activity;
import com.example.madhu.management.Notes.PhysicsNotesActivity;

public class NotesActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar = null;
    // Declaring cards for on clock

    private CardView physics, chemistry, cse8sem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This Functionality is available only in DashBoard", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        physics = (CardView) findViewById(R.id.notes_phy_Id);
        chemistry = (CardView) findViewById(R.id.notes_che_Id);
        /*cse3 = (CardView) findViewById(R.id.notes_cse_sem_3_Id);
        cse4 = (CardView) findViewById(R.id.notes_civ_sem_4_Id);
        cse5 = (CardView) findViewById(R.id.notes_civ_sem_5_Id);
        cse6 = (CardView) findViewById(R.id.notes_civ_sem_6_Id);
        cse7 = (CardView) findViewById(R.id.notes_civ_sem_7_Id);*/
        cse8sem = (CardView) findViewById(R.id.notes_cse_sem_8_Id);


  physics.setOnClickListener(this);
        chemistry.setOnClickListener(this);
        cse8sem.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dash_board, menu);
        return true;
    }

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
        int id = item.getItemId();
        switch (id) {

            case R.id.nav_notice:
                Intent h = new Intent(NotesActivity.this, NoticeActivity.class);
                startActivity(h);
                break;
            case R.id.nav_notes:
                Intent i = new Intent(NotesActivity.this, NotesActivity.class);
                startActivity(i);
                break;
            case R.id.nav_question_papers:
                Intent g = new Intent(NotesActivity.this, QuestionPaperActivity.class);
                startActivity(g);
                break;
            case R.id.nav_update:
                Intent s = new Intent(NotesActivity.this, UpdatesActivity.class);
                startActivity(s);
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }

    @Override
    public void onClick(View view) {

        Intent i;
        switch (view.getId()) {
            case R.id.notes_phy_Id:
                i = new Intent(this, PhysicsNotesActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.notes_che_Id:
                i = new Intent(this, ChemistryNotesActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.notes_cse_sem_8_Id:
                i = new Intent(this, CseNotes_8_sem_Activity.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
        }

    }
}