package com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.R;

public class LoginActivity extends AppCompatActivity {

    // Deklarasi variabel editTextEmail dengan tipe EditText
    EditText editTextEmail;
    // Deklarasi variabel editTextPassword dengan tipe EditText
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Binding edt_txt_email ke variabel editTextEmail
        editTextEmail = findViewById(R.id.edt_txt_nama);
        // Binding edt_txt_password ke variabel editTextPassword
        editTextPassword = findViewById(R.id.edt_txt_password);

    }

    public void clickForgot(View view) {
        Intent i = new Intent(LoginActivity.this, ForgotPassword.class);
        startActivity(i);
    }

    public void clickSignUp(View view) {
        Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(i);
    }

    public void Login(View view) {
        // Validasi input email dan password kosong
        if (TextUtils.isEmpty(editTextEmail.getText().toString().trim()) &&
                TextUtils.isEmpty(editTextPassword.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Email dan Password tidak boleh kosong!",
                    Toast.LENGTH_LONG).show();
        }
        // Validasi input email kosong
        else if (TextUtils.isEmpty(editTextEmail.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Email tidak boleh kosong!", Toast.LENGTH_LONG).show();
        }
        // Validasi inputan tipe email
        else if (!isValidEmail(editTextEmail.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Email tidak valid!", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(editTextPassword.getText().toString())) {
            Toast.makeText(view.getContext(), "Password tidak boleh kosong!", Toast.LENGTH_LONG).show();
        } else {
            Intent i = new Intent(LoginActivity.this, ContentViewActivity.class);
            startActivity(i);
        }
    }

    /**
     * Email validation
     *
     * @param email : email input from editText
     * @return
     */
    public static boolean isValidEmail(CharSequence email) {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}