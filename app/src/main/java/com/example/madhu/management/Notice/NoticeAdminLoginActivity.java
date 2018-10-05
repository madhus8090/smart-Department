package com.example.madhu.management.Notice;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madhu.management.R;

public class NoticeAdminLoginActivity extends AppCompatActivity {

    EditText admin_id, admin_pin;
    TextView attempts;
    Button access;
    private ProgressDialog progressDialog;

    int attempt_count = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_admin);
        progressDialog = new ProgressDialog(this);
        admin_id = (EditText) findViewById(R.id.login_input_admin_id);
        admin_pin = (EditText) findViewById(R.id.login_input_admin_pin);
        attempts = (TextView) findViewById(R.id.text_attempts);
        access = (Button) findViewById(R.id.login_btn_admin_login);
        attempts.setText(Integer.toString(attempt_count));
        verification();
    }
    public void verification() {

        access.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Verifying please wait...");
                progressDialog.show();
                if(admin_id.getText().toString().equals("Admin@bitm.com") &&
                         admin_pin.getText().toString().equals("@Bitm123")) {
                    progressDialog.dismiss();
                    Toast.makeText(NoticeAdminLoginActivity.this, "Access granted.", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(NoticeAdminLoginActivity.this,CseNoticeAdminActivity.class));

                }else {
                    progressDialog.dismiss();
                    Toast.makeText(NoticeAdminLoginActivity.this,"Invalid Admin Id or Pin..! Retry!", Toast.LENGTH_LONG).show();
                    attempt_count--;
                    attempts.setText(Integer.toString(attempt_count));
                if(attempt_count == 0)
                {
                    access.setEnabled(false);
                }

                }
            }
        });
    }

}
