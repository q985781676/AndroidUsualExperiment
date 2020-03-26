package com.zxy.layoutexperiment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_linearlayout,btn_relativelayout,btn_tablelayout,btn_constraintlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化按钮
     */
    private void initView(){
        btn_linearlayout = findViewById(R.id.linearly);
        btn_relativelayout = findViewById(R.id.relatively);
        btn_tablelayout = findViewById(R.id.tableau);
        btn_constraintlayout=findViewById(R.id.constraint);

        btn_linearlayout.setOnClickListener(this);
        btn_relativelayout.setOnClickListener(this);
        btn_tablelayout.setOnClickListener(this);
        btn_constraintlayout.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ConstraintLayoutActivity.class);
            startActivity(intent);});
    }

    /**
     * 方法单击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.linearly:
                intent = new Intent(MainActivity.this, LinearLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.relatively:
                intent = new Intent(MainActivity.this, RelativeLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.tableau:
                intent = new Intent(MainActivity.this, TableLayoutActivity.class);
                startActivity(intent);
                break;

            default:break;
        }
    }
}
