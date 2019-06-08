package com.example.appcitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void Ingresar(View view){
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
