package com.example.intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class SecondActivity extends AppCompatActivity {
    private static final int SELECT_IMAGE = 1;
    private EditText EtText2;
    private ImageView imgView;
    public static final String KEYS = "keys";
    private Uri imageUri;
    private TextView textViewOfSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();
    }

    private void init() {
        EtText2 = findViewById(R.id.Edt);
        imgView = findViewById(R.id.IMG);
        textViewOfSecond = findViewById(R.id.EtText3);
    }

    public void setClick(View view) {
        Intent intent = getIntent();
        intent.putExtra("text", EtText2.getText().toString());
        intent.putExtra(KEYS, imageUri);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void setClick2(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT).setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_IMAGE && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();
            imgView.setImageURI(imageUri);
            textViewOfSecond.setText("");

        }
    }
}