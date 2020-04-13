package com.zxy.experience3_uicomponent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button_listView, button_alertDialog,button_xmlMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();
    }

    private void initial() {
        //展示ListView
        button_listView = findViewById(R.id.button_listView);
        button_listView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
            startActivity(intent);
        });

        //展示AlertDialog
        button_alertDialog = findViewById(R.id.button_alertDialog);
        button_alertDialog.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DialogActivity.class);
            startActivity(intent);
        });

        //展示xml菜单
        button_xmlMenu = findViewById(R.id.button_xmlMenu);
        button_xmlMenu.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),XmlMenuActivity.class);
            startActivity(intent);
        });
    }
}
