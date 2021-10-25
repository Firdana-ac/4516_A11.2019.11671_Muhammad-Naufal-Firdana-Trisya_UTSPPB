package com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.R;
import com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.models.Register;

public class RegisterActivity extends AppCompatActivity {

    private final String TAG = RegisterActivity.class.getName();
    public static final String Key_RegisterActivity = "Key_RegisterActivity";

    EditText editTextNama, editTextTanggalLahir, editTextUserName, editTextPassword;
    //RadioButton radioButtonLaki, radioButtonPerempuan;
    RadioButton radioButtonJK;
    RadioGroup rgJenisKelamin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextNama = findViewById(R.id.edt_txt_nama);
        editTextTanggalLahir = findViewById(R.id.edt_tanggal_lahir);
        editTextUserName = findViewById(R.id.edt_email);
        editTextPassword = findViewById(R.id.edt_password);
//        radioButtonLaki = findViewById(R.id.rb_laki);
//        radioButtonPerempuan = findViewById(R.id.rb_perempuan);

        rgJenisKelamin = findViewById(R.id.rg_jenis_kelamin);
    }

    public void postSignUp(View view) {
        String password = editTextPassword.getText().toString();
        String username = editTextUserName.getText().toString();
        String nama = editTextNama.getText().toString();
//        String jk = radioButtonPerempuan.isChecked() ? "Perempuan" : "Laki-laki";

        // Ambil id radio button yang dipilih
        int selectedJk = rgJenisKelamin.getCheckedRadioButtonId();
        // Jadikan id radio button sebagai rujukan binding view
        radioButtonJK = findViewById(selectedJk);

        // Hasilnya sama persis dengan baris 40, namun dengan pendekatan yang berbeda
        String jk = radioButtonJK.getText().toString();

        String tanggal_lahir = editTextTanggalLahir.getText().toString();

        Register register = new Register(nama, tanggal_lahir, jk, username, password);

        Intent intent = new Intent(RegisterActivity.this, RegisterResultActivity.class);
        intent.putExtra(Key_RegisterActivity, register);
        startActivity(intent);
    }
}