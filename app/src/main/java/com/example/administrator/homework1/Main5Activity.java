package com.example.administrator.homework1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Main5Activity extends AppCompatActivity {
    Spinner spinner;
    TextView textView;
    ArrayAdapter adapter;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        spinner = (Spinner) findViewById(R.id.spinner1);
        textView= (TextView) findViewById(R.id.act5tex1);
        button= (Button) findViewById(R.id.act5btn1);
        String[] mItems = getResources().getStringArray(R.array.las);
        adapter = new ArrayAdapter<>(this, R.layout.act5simple, mItems);
        spinner.setAdapter(adapter);
//
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] las = getResources().getStringArray(R.array.las);
                textView.setText("选中了：" + las[i]);
                Toast.makeText(getApplicationContext(),"选中了：" + las[i],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
//                Toast.makeText(getApplicationContext(),"什么都没有选中" ,Toast.LENGTH_SHORT).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main5Activity.this,Main6Activity.class));
                finish();
            }
        });
    }


}
