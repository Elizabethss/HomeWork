package com.example.administrator.homework1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {

    private TextView texiview;
    private ImageView imageView;
    private Button btns1, btns2, btn3,btn4,btn5,btn6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("完善你的信息");
        btns1 = (Button) findViewById(R.id.page2);
        btns2 = (Button) findViewById(R.id.page3);
        btn3 = (Button) findViewById(R.id.page4);
        btn4 = (Button) findViewById(R.id.page5);
        btn5= (Button) findViewById(R.id.page6);
        btn6= (Button) findViewById(R.id.page7);
        imageView = (ImageView) findViewById(R.id.act2Image1);
        texiview = (TextView) findViewById(R.id.act2tex1);

        btns1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);

                startActivityForResult(intent, 111);
            }
        });
        btns2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, Main4Activity.class);

                startActivityForResult(intent, 222);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,Main5Activity.class);
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main2Activity.this,Main7Activity.class);
                startActivity(intent);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Main2Activity.this,Main9Activity.class));
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Main2Activity.this,Main10Activity.class));
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case 777:
                if (requestCode == 111) {
                    Toast.makeText(Main2Activity.this, "在Main3activity中点击777（失败按钮）返回", Toast.LENGTH_SHORT).show();
                }
                if (requestCode == 222) {
                    Toast.makeText(Main2Activity.this, "在Main4activity中点击777（失败按钮）返回", Toast.LENGTH_SHORT).show();
                }
                break;
            case 888:
                if (requestCode == 111) {
                    Toast.makeText(Main2Activity.this, "在Main3activity中点击888（成功按钮）返回", Toast.LENGTH_SHORT).show();

                    String s = data.getStringExtra("s");
                    Log.i("ss", s);
                    texiview.setText(s);
                }
                if (requestCode == 222) {
                    Toast.makeText(Main2Activity.this, "在Main4activity中点击888（成功按钮）返回", Toast.LENGTH_SHORT).show();
                    String a = data.getStringExtra("a");
                    if (a.equals("1")) {
                        imageView.setImageResource(R.drawable.elephant);
                    }
                    if (a.equals("2")) {
                        imageView.setImageResource(R.drawable.chick);
                    }

                }
                break;

        }
    }
}
