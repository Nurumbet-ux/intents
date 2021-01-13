package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.security.Key;

public class MainActivity extends AppCompatActivity {
    private ImageView imgview;
       private Button button1;
       private Button button2;
       public static final int KEY =1;
       private  static String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        button1 = findViewById(R.id.btnofFirst);
        imgview = findViewById(R.id.IMG1);
        button2 = findViewById(R.id.btnofFirst2);
    }

    public void setClickoffirst(View view) {
        Intent intent = new Intent(this,secondActivity.class);
        startActivityForResult(intent,KEY);
    }

    public void setClickoffirst2(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, "sayevnur@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intent.putExtra(Intent.EXTRA_TEXT, "ya zdes body haha");
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(Intent.createChooser(intent, "Send Email"));
        }

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == KEY) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    Bundle bundle = data.getExtras();
                    Bitmap bitmap = (Bitmap) bundle.get(secondActivity.KEYS);
                    imgview.setImageBitmap(bitmap);
                }
            }
        }

}
}