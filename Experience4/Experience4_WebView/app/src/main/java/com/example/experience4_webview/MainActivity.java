package com.example.experience4_webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton imageButton_Go,imageButton_Home;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        imageButton_Go = findViewById(R.id.imageButton_Go);
        imageButton_Home = findViewById(R.id.imageButton_Home);

        imageButton_Go.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MyBrowsActivity.class);
            Uri uri = Uri.parse(editText.getText().toString());
            intent.setData(uri);
            startActivity(intent);
        });

    }


}
