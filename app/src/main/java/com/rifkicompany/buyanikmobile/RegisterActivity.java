package com.rifkicompany.buyanikmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView loginNow = findViewById(R.id.lgn_now);

        ImageButton back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backLogin = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(backLogin);
            }
        });

        loginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextHome =  new Intent(RegisterActivity.this ,LoginActivity.class);
                startActivity(nextHome);
            }
        });

    }
}
