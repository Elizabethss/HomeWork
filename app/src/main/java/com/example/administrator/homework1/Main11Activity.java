package com.example.administrator.homework1;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.homework1.SQL.Person;
import com.example.administrator.homework1.SQL.SQL;
import com.example.administrator.homework1.Tools.Tos;

import java.util.List;

public class Main11Activity extends AppCompatActivity {
    SQL sql;
    List<Person> persons;
    Button btn1, btn2, btn3, btn4, btn5;
    EditText edit, edit1, edit2, edit3, edit4;
    RadioButton rd1, rd2;
    ListView listView;
    String a, b, c, d, e;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        btn1 = (Button) findViewById(R.id.act11btn);
//        btn2 = (Button) findViewById(R.id.act11btn2);
        btn3 = (Button) findViewById(R.id.act11btn3);
        btn4 = (Button) findViewById(R.id.act11btn4);
        btn5 = (Button) findViewById(R.id.act11btn5);
        listView = (ListView) findViewById(R.id.act11list);
        edit = (EditText) findViewById(R.id.act11edit);
        edit1 = (EditText) findViewById(R.id.act11edit1);
        edit2 = (EditText) findViewById(R.id.act11edit2);
//        edit3 = (EditText) findViewById(R.id.act11edit3);
        rd1 = (RadioButton) findViewById(R.id.act11Rdbtn1);
        rd2 = (RadioButton) findViewById(R.id.act11Rdbtn2);

        edit4 = (EditText) findViewById(R.id.act11edit4);
        sql = new SQL(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tos.showToast(getApplicationContext(), "添加成功");
                a = edit.getText().toString();
                b = edit1.getText().toString();
                c = edit2.getText().toString();
                if (rd1.isChecked()) {
                    d = "男";
                }
                if (rd2.isChecked()) {
                    d = "女";
                }

                e = edit4.getText().toString();
                sql.insert(a, b, c, d, e);
                sqlshow();
            }
        });

//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Tos.showToast(getApplicationContext(), "开始查询");
//                sqlshow();
//            }
//        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tos.showToast(getApplicationContext(), "删除成功");
                sql.delete(edit.getText().toString());
                sqlshow();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tos.showToast(getApplicationContext(), "修改成功");
                a = edit.getText().toString();
                b = edit1.getText().toString();
                c = edit2.getText().toString();
                if (rd1.isChecked()) {
                    d = "男";
                }
                if (rd2.isChecked()) {
                    d = "女";
                }
                e = edit4.getText().toString();
                sql.update(b, c, d, e, a);
                sqlshow();

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlshow();
                Snackbar.make(view, "定向查询中……",
                        Snackbar.LENGTH_LONG).setAction("查看结果", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(((EditText) findViewById(R.id.act11edit)).getText().toString().equals("")){
                                        Tos.showToast(getApplicationContext(),"请输入正确的学号，不要输入空值");
                        }else{
                            Person persons = sql.qqs(((EditText) findViewById(R.id.act11edit)).getText().toString());
                            Tos.showToast(getApplicationContext(), "学号：" + persons.studentID + '\n' + "姓名：" + persons.name + '\n' + "年龄：" + persons.age + '\n' + "性别：" + persons.sex + '\n' + "联系电话：" + persons.tel);

                        }

                    }
                })
                        .show();
            }
        });

    }

    public void sqlshow() {
        persons = sql.getAll();
        sql = new SQL(this);
        listView = (ListView) findViewById(R.id.act11list);
        listView.setAdapter(new BaseAdapter() {

            @Override
            public View getView(int arg0, View arg1, ViewGroup arg2) {
                if (arg1 == null) {
                    arg1 = LayoutInflater.from(getApplicationContext()).inflate(
                            R.layout.sqlsimple, null);
                }
                Person person = getItem(arg0);
                ((TextView) arg1.findViewById(R.id.act11ttex1)).setText(person.studentID);
                ((TextView) arg1.findViewById(R.id.act11ttex2)).setText(person.name);
                ((TextView) arg1.findViewById(R.id.act11ttex3)).setText(person.age);
                ((TextView) arg1.findViewById(R.id.act11ttex4)).setText(person.sex);
                ((TextView) arg1.findViewById(R.id.act11ttex5)).setText(person.tel);

                return arg1;
                        /*
                * String studentID
            ,String name, String age,String sex,String tel
                * */
            }

            @Override
            public long getItemId(int arg0) {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public Person getItem(int position) {
                return persons.get(position);
            }

            @Override
            public int getCount() {
                return persons.size();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Person person = persons.get(i);
                ((EditText) findViewById(R.id.act11edit)).setText(person.studentID);
                ((EditText) findViewById(R.id.act11edit1)).setText(person.name);
                ((EditText) findViewById(R.id.act11edit2)).setText(person.age);
                if (person.sex.equals("男")) {
                    ((RadioButton) findViewById(R.id.act11Rdbtn1)).setChecked(true);
                } else {
                    ((RadioButton) findViewById(R.id.act11Rdbtn2)).setChecked(true);
                }
//                ((EditText) findViewById(R.id.act11edit3)).setText(person.sex);
                ((EditText) findViewById(R.id.act11edit4)).setText(person.tel);
            }
        });


    }
}
