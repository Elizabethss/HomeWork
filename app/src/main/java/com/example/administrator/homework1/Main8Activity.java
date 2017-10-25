package com.example.administrator.homework1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main8Activity extends Activity {
    ImageView imageView;
    int[] imgs = {R.drawable.wolf, R.drawable.tiger, R.drawable.riverhorse,
            R.drawable.kolar, R.drawable.elephant, R.drawable.foxmonkey};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        imageView = findViewById(R.id.act8img);
        imageView.setImageResource(imgs[getIntent().getIntExtra("img", 0)]);
    }
}
