package com.rifkucompany.buyanikmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);

        String dataUsername = getIntent().getStringExtra("KEY_USERNAME");
        String dataPassword = getIntent().getStringExtra("KEY_PASSWORD");

        username.setText(dataUsername);
        password.setText(dataPassword);

    }
}
