package com.example.administrator.homework1.SQL;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.R.attr.id;

public class SQL extends SQLiteOpenHelper {
    private SQLiteDatabase database;

    // 创建数据库
    public SQL(Context context) {
        /**
         * 第二个参出是数据库名称,这里在应用中创建了名称为data.db的数据库<br/>
         * 第四参数是数据库版本，任意指定的int值，作为后期维护应用中数据的版本判断标志
         */
        super(context, "data.db", null, 1);
        // 通过SQLiteOpenHelper的getWritableDatabase()获取一个可以对数据库进行读写SQLiteDatabase对象
        database = getWritableDatabase();
    }

    /**
     * 创建数据表
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 通过SQLiteDatabase对象可以打开并对数据库进行增删改查的操作
        // 通过SQLiteDatabase的execSQL()方法执行sql语句创建数据表
        db.execSQL("CREATE TABLE IF NOT EXISTS data(id INTEGER PRIMARY KEY AUTOINCREMENT,studentID,name,age,sex,tel)");
    }

    // 插入数据
    public long insert(String studentID
            , String name, String age, String sex, String tel) {
        // 用于封装需要插入表中的数据
        ContentValues values = new ContentValues();
        values.put("studentID", studentID);
        values.put("name", name);
        values.put("age", age);
        values.put("sex", sex);
        values.put("tel", tel);

        // insert()第一个参数是数据表名称 ，第三个参数是需要插入的数据，返回值是插入的数据的id
        long id = database.insert("data", null, values);
        return id;
    }

    // 查询所有数据
    public List<Person> getAll() {
        // 新建list集合用于将从数据库中查询的多个数据装起来
        List<Person> persons = new ArrayList<>();
        // 查询所有的数据
        Cursor cursor = database.query("data", null, null, null, null, null,
                null);
        // 判断是否查询了数据,通过Cursor的moveToFirst()判断数据集中能否获取到第一条数据，返回true代表有数据
        if (cursor.moveToFirst()) {
            do {
                //创建Person对象用于存储从结果集中取出的一条数据
                Person person = new Person();
                //cursor.getString(1)作用是获取一条数据中的name字段值，参数代表想要获取的值在表中的字段索引
                person.studentID = cursor.getString(1);
                person.name = cursor.getString(2);
                person.age = cursor.getString(3);
                /*
                * String studentID
            ,String name, String age,String sex,String tel
                *
                * */
                person.sex = cursor.getString(4);
                person.tel = cursor.getString(5);
                persons.add(person);
            } while (cursor.moveToNext());
        }
        return persons;
    }

    public boolean delete(String studentID) {

        try {
            database.execSQL(" delete from data where studentID=?", new Object[]{studentID});
            return true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

    public boolean update(String name, String age, String sex, String tel, String studentID) {
        try {
            database.execSQL(" update  data set name=?,age=?,sex=?,tel=? where studentID=?", new Object[]{name, age, sex, tel, studentID});
            return true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

    public Person qqs(String stuid) {
        Cursor cursors = database.query("data", null, null, null, null, null,
                null);
        String studentIDs, names, ages, sexs, tels;
        Person k = new Person();
        while (cursors.moveToNext()) {
            studentIDs = cursors.getString(cursors.getColumnIndex("studentID"));
            names = cursors.getString(cursors.getColumnIndex("name"));
            ages = cursors.getString(cursors.getColumnIndex("age"));
            sexs = cursors.getString(cursors.getColumnIndex("sex"));
            tels = cursors.getString(cursors.getColumnIndex("tel"));


            if (studentIDs.equals(stuid)){
                k.studentID = studentIDs;
                k.name = names;
                k.age = ages;
                k.sex=sexs;
                k.tel =tels;

                Log.v("infos", "studentIDs" + studentIDs + "names" + names + "ages"
                    + ages + "sexs" + sexs + "tels" + tels);
                break;
            }
//                if(studentIDs.equals(stuid)){
//                    Log.d("ss","studentIDs" + studentIDs + "names" + names + "ages"
//                            + ages + "sexs" + sexs + "tels" + tels);
//                }
        }
        cursors.close();
        return k;
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }

}
