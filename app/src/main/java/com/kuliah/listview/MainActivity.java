package com.kuliah.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String user1= "Pascal", pass1= "iniPascal", nama, password;

    EditText eduser, edpassword;
    Button sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eduser = (EditText) findViewById(R.id.user);
        edpassword = (EditText) findViewById(R.id.password);
        sign = (Button) findViewById(R.id.btSign);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = eduser.getText().toString();
                password = edpassword.getText().toString();

                if (nama.equals(user1) && password.equals(pass1)){
                    Toast t = Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT);
                    t.show();

                    Intent log = new Intent(getApplicationContext(), Home_Activity.class);
                    startActivity(log);
                }
                else if (nama.equals(user1) && !password.equals(pass1)){
                    Toast t = Toast.makeText(getApplicationContext(), "Password Salah", Toast.LENGTH_SHORT);
                    t.show();
                }
                else if(!nama.equals(user1) && password.equals(pass1)){
                    Toast t = Toast.makeText(getApplicationContext(), "Nama Salah", Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    Toast t = Toast.makeText(getApplicationContext(), "User tidak ditemukan", Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu mn) {
        getMenuInflater().inflate(R.menu.menu_utama, mn);
        return super.onCreateOptionsMenu(mn);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnDaftar){
            Intent i = new Intent(MainActivity.this, DaftarActivity.class);
            startActivity(i);
        }
        return true;
    }
}