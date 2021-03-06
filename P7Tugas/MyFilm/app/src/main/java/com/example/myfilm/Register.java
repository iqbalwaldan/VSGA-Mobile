package com.example.myfilm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextConfirmPassword;

    public static boolean isValidEmail(CharSequence email) {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextEmail = findViewById(R.id.inp_txt_email);
        editTextPassword = findViewById(R.id.inp_txt_password);
        editTextConfirmPassword = findViewById(R.id.edt_confirm_password);
    }

    public void postRegister(View view) {
        if(TextUtils.isEmpty(editTextEmail.getText().toString().trim()) &&
                TextUtils.isEmpty(editTextPassword.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Email dan Password tidak boleh kosong!",
                    Toast.LENGTH_LONG).show();
        } else if(TextUtils.isEmpty(editTextEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(), "Email tidak boleh kosong!", Toast.LENGTH_LONG).show();
        } else if(!isValidEmail(editTextEmail.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Email tidak valid!", Toast.LENGTH_LONG).show();
        } else if(TextUtils.isEmpty(editTextPassword.getText().toString())) {
            Toast.makeText(view.getContext(), "Password tidak boleh kosong!", Toast.LENGTH_LONG).show();
        } else if (TextUtils.getTrimmedLength(editTextPassword.getText().toString()) > 15){
            Toast.makeText(view.getContext(), "Password melebihi batas!", Toast.LENGTH_LONG).show();
        } else if (!TextUtils.equals(editTextPassword.getText().toString(),editTextConfirmPassword.getText().toString())){
            Toast.makeText(view.getContext(), "Password tidak sama!", Toast.LENGTH_LONG).show();
        }else {
            Intent i = new Intent(Register.this, SuccesRegister.class);
            startActivity(i);
        }
    }
}