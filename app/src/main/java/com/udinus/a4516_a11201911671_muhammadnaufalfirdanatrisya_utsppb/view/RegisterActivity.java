package com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.R;
import com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.models.Register;

public class RegisterActivity extends AppCompatActivity {

    private final String TAG = RegisterActivity.class.getName();
    public static final String Key_RegisterActivity = "Key_RegisterActivity";

    EditText editTextNama, editTextTanggalLahir, editTextUserName, editTextPassword, editTextRePassword;
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
        editTextRePassword = findViewById(R.id.repeat_password);
//        radioButtonLaki = findViewById(R.id.rb_laki);
//        radioButtonPerempuan = findViewById(R.id.rb_perempuan);

        rgJenisKelamin = findViewById(R.id.rg_jenis_kelamin);
    }

    public void postSignUp(View view) {

        // username kosong
        if (TextUtils.isEmpty(editTextUserName.getText().toString().trim())
                &&
                TextUtils.isEmpty(editTextPassword.getText().toString().trim())
                &&
                TextUtils.isEmpty(editTextNama.getText().toString().trim())
                &&
                TextUtils.isEmpty(editTextRePassword.getText().toString().trim())
                &&
                TextUtils.isEmpty(editTextTanggalLahir.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Pastikan semua terisi", Toast.LENGTH_LONG).show();
        }

        //Validasi username
        else if (TextUtils.isEmpty(editTextNama.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Username tidak boleh kosong", Toast.LENGTH_LONG).show();
        }

        //tanngal lahir
        else if (TextUtils.isEmpty(editTextTanggalLahir.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Tanggal lahir tidak boleh kosong", Toast.LENGTH_LONG).show();
        }

        //Validasi jeniskelamin
        //else if (TextUtils.isEmpty(rgJenisKelamin.getCheckedRadioButtonId())){
        //Toast.makeText(view.getContext(), "Jenis kelamin tidak boleh kosong", Toast.LENGTH_LONG).show();
        //}

        //VEmail
        else if (TextUtils.isEmpty(editTextUserName.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Email tidak boleh kosong", Toast.LENGTH_LONG).show();
        } else if (!isValidEmail(editTextUserName.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Email tidak valid!", Toast.LENGTH_LONG).show();
        }

        //validasi Password
        else if (TextUtils.isEmpty(editTextPassword.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Password tidak boleh kosong", Toast.LENGTH_LONG).show();
        }

        //validasi re-password
        else if (TextUtils.isEmpty(editTextRePassword.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Re-password tidak boleh kosong", Toast.LENGTH_LONG).show();
        }

        //cek confirm password
        else if (!editTextPassword.getText().toString().trim().equals(editTextRePassword.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Password Tidak Sama!", Toast.LENGTH_LONG).show();
        } else {
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

    /**
     * Email validation
     *
     * @param email : email input from editText
     * @return
     */
    public static boolean isValidEmail(CharSequence email) {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }


    //String password = editTextPassword.getText().toString();
    //String username = editTextUserName.getText().toString();
    //String nama = editTextNama.getText().toString();
//        String jk = radioButtonPerempuan.isChecked() ? "Perempuan" : "Laki-laki";

    // Ambil id radio button yang dipilih
    //int selectedJk = rgJenisKelamin.getCheckedRadioButtonId();
    // Jadikan id radio button sebagai rujukan binding view
    //radioButtonJK = findViewById(selectedJk);

    // Hasilnya sama persis dengan baris 40, namun dengan pendekatan yang berbeda
    //String jk = radioButtonJK.getText().toString();

    //String tanggal_lahir = editTextTanggalLahir.getText().toString();

    //Register register = new Register(nama, tanggal_lahir, jk, username, password);

    //intent = new Intent(RegisterActivity.this, RegisterResultActivity.class);
    //startActivity(intent);
}
