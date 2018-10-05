package com.example.madhu.management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class LogoutActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtlogout;
    private Button btnLogout;
    private RelativeLayout activity_logout;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);



        txtlogout = (TextView)findViewById(R.id.textlogout);
        btnLogout = (Button)findViewById(R.id.logout_btn);
        btnLogout.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();

        if(auth.getCurrentUser() != null);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.logout_btn)
            logoutUser();

    }
    private void logoutUser() {
        auth.signOut();
        if(auth.getCurrentUser() == null)
        {
            startActivity(new Intent(LogoutActivity.this,MainActivity.class));
            finish();
        }
    }


}
