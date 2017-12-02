package com.rifkucompany.buyanikmobile;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final TextInputEditText usernameEd = findViewById(R.id.username_ed);
        final TextInputEditText passwordEd = findViewById(R.id.password_ed);
        Button buttonEd = findViewById(R.id.button_ed);

        buttonEd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dataUsername = usernameEd.getText().toString();
                String dataPassword = passwordEd.getText().toString();

                if (dataPassword.equalsIgnoreCase("123456")) {
                    //perintah next activity home
                    Intent nextHome =  new Intent(LoginActivity.this ,HomeActivity.class);
                    nextHome.putExtra("KEY_USERNAME", dataUsername);
                    nextHome.putExtra("KEY_PASSWORD", dataPassword);
                    startActivity(nextHome);
                }else {
                    //perintah jika pw salah
                    Toast.makeText(LoginActivity.this, "Password salah!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
