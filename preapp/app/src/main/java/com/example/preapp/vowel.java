package com.example.preapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayOutputStream;

import androidx.appcompat.app.AppCompatActivity;

public class vowel extends AppCompatActivity {

    Button[] vowelBtn = new Button[17];
    Intent[] intent = new Intent[17];
    String[] yolocompare = {"k", "i", "j", "u", "h", "y", "n", "b", "m", "l", "o", "p", "hl", "nl","oo","pp","ml"};
    Integer[] vowelBtnId = {R.id.k, R.id.i, R.id.j, R.id.u, R.id.h, R.id.y, R.id.n,
            R.id.b, R.id.m, R.id.l, R.id.o, R.id.p, R.id.hl, R.id.nl, R.id.oo, R.id.pp, R.id.ml};
    int[] imgs = new int[]{R.drawable.k, R.drawable.i, R.drawable.j, R.drawable.u, R.drawable.h, R.drawable.y,
            R.drawable.n, R.drawable.b, R.drawable.m, R.drawable.l, R.drawable.o, R.drawable.p, R.drawable.hl, R.drawable.nl,R.drawable.oo,R.drawable.pp,R.drawable.ml};


    void init() {
        for (int i = 0; i < vowelBtn.length; i++) {
            vowelBtn[i] = (Button) findViewById(vowelBtnId[i]);
        }

    }

    void Click_Btn(int i) {
        vowelBtn[i].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent[i] = new Intent(getApplicationContext(), practice_camera.class);
                intent[i].putExtra("id", yolocompare[i]);
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs[i]);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                intent[i].putExtra("image", byteArray);
                startActivity(intent[i]);
            }
        });
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vowel);
        setTitle("자음");
        init();
        for (int i = 0; i < vowelBtn.length; i++) {
            Click_Btn(i);
        }
    }


//    void colorchange() {
//        String colorid = colorintent.getExtras().getString("colorid");
//        System.out.println(colorid+"/////////////");
//        for (int i = 0; i < yolocompare.length; i++) {
//
//            if (colorid.equals(yolocompare)) {
//                consonantBtn[i].setBackgroundColor(Color.YELLOW);
//            }
//        }
//    }

}
