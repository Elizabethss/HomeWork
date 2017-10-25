package com.example.administrator.homework1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private ToggleButton TGBTN1, TGBTN2;
    private EditText username, passwd1, passwd2;
    private RadioButton man, woman;
    private CheckBox STF, BR;
    private String a, b, d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("注册");
        login = (Button) findViewById(R.id.login);
        TGBTN1 = (ToggleButton) findViewById(R.id.TGBtn1);
        TGBTN2 = (ToggleButton) findViewById(R.id.TGBtn2);
        username = (EditText) findViewById(R.id.username);
        passwd1 = (EditText) findViewById(R.id.passwd1);
        passwd2 = (EditText) findViewById(R.id.passwd2);
        man = (RadioButton) findViewById(R.id.man);
        woman = (RadioButton) findViewById(R.id.woman);
        STF = (CheckBox) findViewById(R.id.QBS);
        BR = (CheckBox) findViewById(R.id.BRGC);
        TGBTN1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (TGBTN1.isChecked()) {
                    passwd1.setInputType(InputType.TYPE_CLASS_TEXT);
                } else {
                    passwd1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }

            }
        });
        TGBTN2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (TGBTN2.isChecked()) {
                    passwd2.setInputType(InputType.TYPE_CLASS_TEXT);
                } else {
                    passwd2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (man.isChecked()) {
                    a = man.getText().toString();
                } else {
                    a = woman.getText().toString();
                }
                if (STF.isChecked()) {
                    b = STF.getText().toString();
                } else {
                    b = "";
                }
                if (BR.isChecked()) {
                    d = BR.getText().toString();
                } else {
                    d = "";
                }
                if (username.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "请输入你的用户名！", Toast.LENGTH_SHORT).show();
                } else {
                    if (passwd1.getText().toString().equals("") || passwd1.getText().toString().equals("")) {

                        Toast.makeText(MainActivity.this, "密码那个不能为空！", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!passwd1.getText().toString().equals(passwd2.getText().toString())) {
                            Toast.makeText(MainActivity.this, "请检查两次输入的密码是否一致！", Toast.LENGTH_SHORT).show();
                            passwd1.setInputType(InputType.TYPE_CLASS_TEXT);
                            passwd2.setInputType(InputType.TYPE_CLASS_TEXT);
                        } else {
                            Toast.makeText(MainActivity.this, "恭喜你，注册成功！！\n请注意保存你的登录密码" + "\n" + "用户名：" + username.getText().toString() + "\n" + "性别：" + a + "\n" + "偶像：" + b + d + "\n", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            }
        });

    }
}
