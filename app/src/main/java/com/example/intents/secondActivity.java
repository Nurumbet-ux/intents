package com.example.intents;
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

public class secondActivity extends AppCompatActivity {
    private static final int SELECT_IMAGE = 1;
    private EditText EtText2;
    private ImageView imgView;
    private TextView textVie;
    private Button btn;
    public Bitmap bitmap;
    private Uri imageuri;
    public static final String KEYS = "keys";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();
    }

    private void init() {
        EtText2 = findViewById(R.id.Edt);
        imgView = findViewById(R.id.IMG);
        btn = findViewById(R.id.buttonOfSecond);
        textVie = findViewById(R.id.textView);
    }

    public void setClick(View view) {
        Intent intent = getIntent();
        intent.putExtra("text", EtText2.getText().toString());
        try {
           intent.putExtra(KEYS,imageuri);
        }catch (Exception e){
        }
        setResult(RESULT_OK, intent);
        finish();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    imageuri = data.getData();
                    imgView.setImageURI(imageuri);
                    textVie.setText("");
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void setClick1(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_IMAGE);
    }
}