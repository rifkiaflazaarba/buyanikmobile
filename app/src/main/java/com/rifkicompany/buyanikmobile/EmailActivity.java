package com.rifkicompany.buyanikmobile;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import static java.net.Proxy.Type.HTTP;

public class EmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        ImageButton backHome = findViewById(R.id.back);
        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(EmailActivity.this, HomeActivity.class);
                startActivity(backIntent);
            }
        });

        FloatingActionButton sendEmail = findViewById(R.id.send);
        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText subject = findViewById(R.id.subject);
                String sbj = subject.getText().toString();
                EditText from = findViewById(R.id.from);
                String fr = from.getText().toString();
                EditText writeText = findViewById(R.id.writeText);
                String wt = subject.getText().toString();
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"buyanik@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "email subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT,"Email Massage text");
                startActivity(emailIntent);
            }
        });
    }
}
