package com.example.administrator.homework1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main7Activity extends AppCompatActivity {
    GridView gridView;
    List<Map<String, Object>> act7data;
    SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        gridView = (GridView) findViewById(R.id.Gridview1);
        int[] imgs = {R.drawable.wolf, R.drawable.tiger, R.drawable.riverhorse,
                R.drawable.kolar, R.drawable.elephant, R.drawable.foxmonkey};
        String[] name = {"狼", "老虎", "河马", "考拉", "大象", "狐猴"};
        act7data = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", imgs[i]);
            map.put("text", name[i]);
            act7data.add(map);
        }
        String[] from = {"image", "text"};
        int[] to = {R.id.Act7img, R.id.Act7tex};
        simpleAdapter = new SimpleAdapter(this, act7data, R.layout.act7simple, from, to);
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(), "选中了：" + i, Toast.LENGTH_SHORT).show();
                Log.d("ss", "123123");
                startActivity(new Intent(Main7Activity.this, Main8Activity.class).putExtra("img", i));

            }
        });

    }
}
