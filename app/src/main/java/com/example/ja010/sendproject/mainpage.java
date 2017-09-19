package com.example.ja010.sendproject;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class mainpage extends AppCompatActivity {
    TextView textmain1,textmain2,textmain3,textmain4;
    EditText et;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        textmain1 = (TextView)findViewById(R.id.text1);
        textmain2 = (TextView)findViewById(R.id.text2);
        textmain3 = (TextView)findViewById(R.id.text3);
        textmain4 = (TextView)findViewById(R.id.text4);
        Intent i = getIntent();
        password = i.getStringExtra("password");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textmain1.setText("욕실은");
            }
        },1000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textmain2.setText("가장 아름다운 방");
            }
        },2000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textmain3.setText("이어야 합니다. ");
            }
        },3000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textmain4.setText("Bathroom should be the most beautiful room.");
            }
        },4000);

    }
    public void clcl(View v){
        Intent i2 = new Intent(mainpage.this,Sendingpage.class);
        i2.putExtra("pass",password);
        startActivity(i2);
    }



}
