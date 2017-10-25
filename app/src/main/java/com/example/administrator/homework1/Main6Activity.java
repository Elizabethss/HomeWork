package com.example.administrator.homework1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main6Activity extends AppCompatActivity {
    Spinner spinner;
    List<HashMap<String, Object>> dataList;
    HashMap<String, Object> map;
    SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        spinner = (Spinner) findViewById(R.id.spinner2);

        int[] foundimg = {R.drawable.chick, R.drawable.deer, R.drawable.elephant,
                R.drawable.foxmonkey, R.drawable.kolar, R.drawable.riverhorse, R.drawable.tiger, R.drawable.wolf};
        String[] pput = {"img", "text", "per"};
        int[] rres = {R.id.act6img1, R.id.act6tex1,R.id.act6tex3};
        String[] name = {"张三", "李四", "王五", "马六", "周迅", "钱九", "牛十"};
        String[] persionlanguage = {"他还没有个人语录", "他还没有个人语录", "他还没有个人语录", "他还没有个人语录", "他还没有个人语录", "他还没有个人语录", "他还没有个人语录"};
        dataList = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            map = new HashMap<>();//注意:不能在原map中修改, 否则只有一个Map的数据
            map.put("img", foundimg[i]);
//            map.put("img", R.mipmap.ic_launcher);
            map.put("text", name[i]);
            map.put("per", persionlanguage[i]);

            dataList.add(map);
        }

        adapter = new SimpleAdapter(this, dataList, R.layout.act6simple, pput, rres);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(Main6Activity.this, "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
