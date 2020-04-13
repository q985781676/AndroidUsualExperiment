package com.zxy.experience3_uicomponent;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * xml菜单
 */
public class XmlMenuActivity extends AppCompatActivity {

    //定义字体大小菜单项的标识
    final int FONT_10 = 0x010;
    final int FONT_16 = 0x011;
    final int FONT_20 = 0x012;
    //定义普通菜单项的标识
    final int PLAN_ITEM = 0x013;
    //定义字体颜色菜单项的标识
    final int FONT_RED = 0x014;
    final int FONT_BLACK = 0x015;
    //文本内容
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlmenu);
        textView = findViewById(R.id.tx_xmlMenu);
    }

    /**
     * 处理菜单
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //定义 字体大小 子菜单
        SubMenu fontMenu = menu.addSubMenu("字体大小");
        fontMenu.setHeaderTitle("请选择字体");
        /**
         * add参数说明：
         * 1. groupId 相同的为一组
         * 2. itemId 选项识别id
         * 3. order 相同按add的顺序排序,否则按order排序
         * 4. title 选项标题
         */
        fontMenu.add(0, FONT_10, 0, "10号字体");
        fontMenu.add(0, FONT_16, 0, "16号字体");
        fontMenu.add(0, FONT_20, 0, "20号字体");

        //定义 普通菜单 选项
        menu.add(0, PLAN_ITEM, 0, "普通菜单");

        //定义字体颜色菜单项
        SubMenu colorMenu = menu.addSubMenu("字体颜色");
        colorMenu.add(0, FONT_RED, 0, "红色");
        colorMenu.add(0, FONT_BLACK, 0, "黑色");

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 选项菜单被单击后回调的方法
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case FONT_10:
                textView.setTextSize(10);
                break;
            case FONT_16:
                textView.setTextSize(16);
                break;
            case FONT_20:
                textView.setTextSize(20);
                break;
            case PLAN_ITEM:
                Toast.makeText(getApplicationContext(),"你点击了普通菜单",Toast.LENGTH_SHORT).show();
                break;
            case FONT_RED:
                textView.setTextColor(Color.RED);
                break;
            case FONT_BLACK:
                textView.setTextColor(Color.BLACK);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}
