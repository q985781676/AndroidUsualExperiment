package com.example.experience4_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            Intent intent = new Intent();
            Uri uri = Uri.parse(editText.getText().toString());
            intent.setData(uri);
            intent.setAction(Intent.ACTION_VIEW);
            startActivity(intent);
        });
    }
}
