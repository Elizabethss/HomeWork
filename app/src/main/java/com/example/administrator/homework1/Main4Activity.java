package com.example.administrator.homework1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    private Button act4btn1, act4btn2;
    private RadioButton Radiogrp1, Radiogrp2;
    private String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        setTitle("选择头像");
        act4btn1 = (Button) findViewById(R.id.act4btn1);
        act4btn2 = (Button) findViewById(R.id.act4btn2);
        Radiogrp1 = (RadioButton) findViewById(R.id.Radiogrp1);
        Radiogrp2 = (RadioButton) findViewById(R.id.Radiogrp2);

        act4btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new  Intent();
                setResult(777, intent);
                finish();

            }
        });
        act4btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder img = new StringBuilder();

                if (Radiogrp1.isChecked()) {
                    img.append("1");
                }
                if (Radiogrp2.isChecked()) {
                    img.append("2");
                }
                if (!(Radiogrp2.isChecked() && Radiogrp1.isChecked())) {
                    Toast.makeText(Main4Activity.this, "没有选中什么东西！！", Toast.LENGTH_SHORT).show();
                }
                Intent intent=new Intent();
                setResult(888, intent.putExtra("a",img.toString()));

                finish();
            }
        });
    }
}
