package com.zxy.experience3_uicomponent;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DialogActivity extends AppCompatActivity {

    Button button_dialog_activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        button_dialog_activity = findViewById(R.id.button_dialog_activity);
        button_dialog_activity.setOnClickListener(v -> {
            createDialog();
        });
    }

    public void createDialog() {
        LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.style_alertdialog, null);
        new AlertDialog.Builder(DialogActivity.this)
                .setTitle("AlertDialog")
                .setView(linearLayout)
                .setPositiveButton("Sign in", (dialog, which) -> {
                    Toast.makeText(getApplicationContext(), "you click the button of Sign in", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancel", (dialog, which) -> {
                    //注意show 否则不显示
                    Toast.makeText(getApplicationContext(), "you click the button of Cancel", Toast.LENGTH_SHORT).show();
                })
                .create().show();
    }


}
