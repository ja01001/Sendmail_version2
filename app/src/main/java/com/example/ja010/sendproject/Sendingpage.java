package com.example.ja010.sendproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class Sendingpage extends AppCompatActivity {
    String password, t1,t2,t3;
    EditText name1,name2,email;
    TextView tname1,tname2,temail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendingpage);
        Intent i2 = getIntent();
        password = i2.getStringExtra("pass");
        name1 = (EditText)findViewById(R.id.name1);
        name2 = (EditText)findViewById(R.id.name2);
        email = (EditText)findViewById(R.id.email);
        tname1 = (TextView) findViewById(R.id.tname1);
        tname2 = (TextView) findViewById(R.id.tname2);
        temail = (TextView) findViewById(R.id.temail);
        t1 = "성 *";
        t2 = "이름 *";
        t3 = "E-mail *";
        int color = Color.parseColor("#45a5fa");
        SpannableStringBuilder s1 = new SpannableStringBuilder(t1);
        s1.setSpan(new ForegroundColorSpan(color),2,3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tname1.append(s1);
        SpannableStringBuilder s2 = new SpannableStringBuilder(t2);
        s2.setSpan(new ForegroundColorSpan(color),3,4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tname2.append(s2);
        SpannableStringBuilder s3 = new SpannableStringBuilder(t3);
        s3.setSpan(new ForegroundColorSpan(color),7,8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        temail.append(s3);
    }//45a5fa
    public void onClick(View v){
        GMailSender sender = new GMailSender("teamhanmail@gmail.com", password); // SUBSTITUTE
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        // HERE
        try{
            sender.sendMail("컨설팅 참가 확인 메일", // subject.getText().toString(),
                    name1.getText().toString()+" "+name2.getText().toString()+"님 컨설팅 참석에 감사드립니다. ", // body.getText().toString(),
                    "user_email@gmail.com", // from.getText().toString(),
                    email.getText().toString() // to.getText().toString()
            );
            toast();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Sendingpage.this,mainpage.class);
                    startActivity(intent);
                    finish();
                }
            },2000);

        } catch (Exception e)
        {
            Log.e("SendMail", e.getMessage(), e);
        }
    }
    public void toast()
    {
        View view = getLayoutInflater().inflate(R.layout.custom_toast,null);
        Toast toastview = new Toast(this);
        toastview.setDuration(Toast.LENGTH_SHORT);
        toastview.setGravity(Gravity.CENTER,0,100);
        //
        toastview.setView(view);
        toastview.show();

    }
}
