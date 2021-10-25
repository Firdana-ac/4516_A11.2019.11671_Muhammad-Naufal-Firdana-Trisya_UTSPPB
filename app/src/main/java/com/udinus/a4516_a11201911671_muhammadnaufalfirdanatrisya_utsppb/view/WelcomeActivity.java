package com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void clickLogin(View view) {
        Intent i = new Intent(WelcomeActivity.this, LoginActivity.class);
        startActivity(i);
    }

    public void clickRegister(View view) {
        Intent i = new Intent(WelcomeActivity.this, RegisterActivity.class);
        startActivity(i);
    }

}