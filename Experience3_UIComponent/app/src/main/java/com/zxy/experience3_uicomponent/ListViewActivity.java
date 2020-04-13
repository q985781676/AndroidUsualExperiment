package com.zxy.experience3_uicomponent;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {

    private static final String TAG = "myTag";

    ListView listView;
    int[] avatars = {R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};//头像集合
    String[] names={"Lion","Tiger","Monkey","Dog","Cat","Elephant"};//名称集合

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        initial();
    }

    /**
     * 初始化
     * a.定义要注入SimpleAdapter的字段
         * 1. Context 环境字段 this
         * 2. List<? extends Map<String, ?>> data 键值对集合
         * 3.int resource 子项目的layout
         * 4. String[] from 注入的键名称集成
         * 5. int[] to 对应的id值
     *
     */
    private void initial(){
        listView = findViewById(R.id.listView);
        //键值对集合
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = null;
        for (int i = 0; i < avatars.length; i++) {
            map = new HashMap<>();
            map.put("avatar",avatars[i]);
            map.put("name",names[i]);
            list.add(map);
        }
        Log.d(TAG, "initial: "+list);
        //注入的键名称集成
        String[] from = {"avatar","name"};
        //键值对应的控件id
        int[] to = {R.id.imageView,R.id.textView};
        //初始化SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,list,R.layout.style_listview,from,to);
        //将完成的SimpleAdapter注入listView
        listView.setAdapter(simpleAdapter);
        //绑定条目选中事件
        listView.setOnItemClickListener((parent, view, position, id) -> {
            //参数：当前环境，显示内容，显示时间
            Toast.makeText(getApplicationContext(),names[position],Toast.LENGTH_SHORT).show();
        });
    }
}
