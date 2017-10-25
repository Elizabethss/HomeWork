package com.example.administrator.homework1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    private EditText editText;
    private Button act3btn1, act3btn2;
    private String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("输入个人签名");
        editText = (EditText) findViewById(R.id.edittext);
        act3btn1 = (Button) findViewById(R.id.act3btn1);
        act3btn2 = (Button) findViewById(R.id.act3btn2);


        act3btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new  Intent();
                setResult(777,intent);
                finish();
            }
        });

        act3btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new  Intent();
                s = editText.getText().toString();
                setResult(888, intent.putExtra("s", s));
                finish();
            }
        });
    }

    @Override
    public String toString() {
        return "Main3Activity{" +
                "editText=" + editText +
                '}';
    }
}
