package com.example.ja010.sendproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
public class Primepage extends AppCompatActivity {
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primepage);
        et = (EditText)findViewById(R.id.password);


    }
    public void onCl(View v){
        Intent i = new Intent(Primepage.this,mainpage.class);
        i.putExtra("password",et.getText().toString());
        startActivity(i);
        finish();
    }
}
