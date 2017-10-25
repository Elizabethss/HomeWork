package com.example.administrator.homework1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Main9Activity extends AppCompatActivity {
    Spinner spinner;
    ArrayAdapter adapter, adapter1, adapter2;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        listView = (ListView) findViewById(R.id.listview1);
        spinner = (Spinner) findViewById(R.id.spinnertop);
        String[] insaa={"as","as","ss"};
        final String[] mItems = getResources().getStringArray(R.array.m5);
        adapter = new ArrayAdapter<>(this, R.layout.act5simple, mItems);
        spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] las = mItems;
                Toast.makeText(getApplicationContext(), "选中了：" + las[i], Toast.LENGTH_SHORT).show();
                if (las[i].equals("内蒙古自治区")) {
                    adapter1 = new ArrayAdapter<>(getApplicationContext(), R.layout.act5simple, getResources().getStringArray(R.array.nm));
                    listView.setAdapter(adapter1);

                } else if (las[i].equals("湖北省")) {
                    adapter2 = new ArrayAdapter<>(getApplicationContext(), R.layout.act5simple, getResources().getStringArray(R.array.hb));
                    listView.setAdapter(adapter2);
                } else {
                    Toast.makeText(getApplicationContext(), "选择地方错误，重新选择", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
