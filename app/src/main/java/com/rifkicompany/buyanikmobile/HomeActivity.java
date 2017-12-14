package com.rifkicompany.buyanikmobile;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_READ_CONTACT = 4;
    private static final int REQUEST_CODE_ACCESS_FINE_LOCATION = 5;
    private static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE = 6;
    private static final int REQUEST_CODE_FOR_ALL = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //untuk cek baca list kontak
        int checkContact = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS);
        int checkLocation = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        int checkDisk = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        String[] multiple = {Manifest.permission.READ_CONTACTS,
                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        int yangBlm = 0;
        for (int a = 0; a < multiple.length; a++) {
            if (ContextCompat.checkSelfPermission(this,
                    multiple[a]) != PackageManager.PERMISSION_GRANTED) {
                yangBlm++;
            } else {
                Toast.makeText(this, "Aplikasi sudah diizinkan", Toast.LENGTH_SHORT).show();
            }
        }

        if (yangBlm != 0) {
            ActivityCompat.requestPermissions(this, multiple, REQUEST_CODE_FOR_ALL);
        }


        TextView username = findViewById(R.id.username);

        String dataUsername = getIntent().getStringExtra("KEY_USERNAME");

        username.setText(dataUsername);

        FloatingActionButton callMe1 = findViewById(R.id.call);
        callMe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText no = findViewById(R.id.nomor);
                String noTelp = no.getText().toString();

                if (!TextUtils.isEmpty(noTelp)) {
                    //berarti ada karakter
                    Uri number = Uri.parse("tel:" + noTelp);

                    Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                    startActivity(callIntent);
                } else {
                    //kosong
                    Toast.makeText(HomeActivity.this, "Nomor Telepon tidak boleh kosong",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        TextView moreInfo = findViewById(R.id.share);
        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(HomeActivity.this, EmailActivity.class);
                startActivity(emailIntent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_READ_CONTACT) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, getString(R.string.pesan_izin), Toast.LENGTH_SHORT).show();
            } else if (requestCode == REQUEST_CODE_FOR_ALL) {
                if (grantResults.length > 0) {
                    Toast.makeText(this, "waduh kok gak diizinin sih", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
