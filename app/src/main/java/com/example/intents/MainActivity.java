package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imgViewOfFirst;
    public static final int KEY = 1;
    private static String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgViewOfFirst = findViewById(R.id.IMG1);
    }

    public void setClickOfFirst(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, KEY);
    }

    public void setClickOfFirst2(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, "sayevnur@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intent.putExtra(Intent.EXTRA_TEXT, value);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Send Email"));
        }

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == KEY && resultCode == Activity.RESULT_OK && data != null) {
            imgViewOfFirst.setImageURI(data.getParcelableExtra(SecondActivity.KEYS));
            value = data.getStringExtra("text");
        }

    }


}