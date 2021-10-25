package com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.R;

public class ResetPassword extends AppCompatActivity {

    // Deklarasi variabel editTextCode dengan tipe EditText
    EditText editTextCode;
    // Deklarasi variabel editNewPass dengan tipe EditText
    EditText editNewPass;
    // Deklarasi variabel editConfPass dengan tipe EditText
    EditText editConfPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        // Binding edt_txt_code ke variabel editTextEmail
        editTextCode = findViewById(R.id.edt_txt_code);
        // Binding edt_new_password ke variabel editTextEmail
        editNewPass = findViewById(R.id.edt_new_password);
        // Binding edt_confirm_password ke variabel editTextEmail
        editConfPass = findViewById(R.id.edt_confirm_password);
    }

    public void postChangePassword(View view) {
        // Validasi kosong
        if(TextUtils.isEmpty(editTextCode.getText().toString().trim())
                &&
                TextUtils.isEmpty(editNewPass.getText().toString().trim())
                &&
                TextUtils.isEmpty(editConfPass.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Code dan Password Tidak Boleh Kosong!", Toast.LENGTH_LONG).show();
        }
        // Validasi Code
        else
        if(TextUtils.isEmpty(editTextCode.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Code Tidak Boleh Kosong!", Toast.LENGTH_LONG).show();
        }
        // Validasi new password
        else
        if(TextUtils.isEmpty(editNewPass.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Password Tidak Boleh Kosong!", Toast.LENGTH_LONG).show();
        }
        // Validasi confirm password
        else
        if(TextUtils.isEmpty(editConfPass.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Password Confirm Tidak Boleh Kosong!", Toast.LENGTH_LONG).show();
        }
        // Cek inputan new dan confirm
        else
        if(!editNewPass.getText().toString().trim().equals(editConfPass.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Password Confirm Tidak Sama!", Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(ResetPassword.this, ContentViewActivity.class);
            startActivity(i);
        }
    }
}