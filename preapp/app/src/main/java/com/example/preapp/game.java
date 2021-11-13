package com.example.preapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import android.widget.Toast;


public class game extends AppCompatActivity {


    String[] question = {"위의 지문자가\n지문자'ㄱ'입니까?", "위의 지문자가\n지문자'ㄴ'입니까?", "위의 지문자가\n지문자'ㄷ'입니까?", "위의 지문자가\n지문자'ㄹ'입니까?",
            "위의 지문자가\n지문자'ㅁ'입니까?", "위의 지문자가\n지문자'ㅂ'입니까?", "위의 지문자가\n지문자'ㅅ'입니까?", "위의 지문자가\n지문자'ㅇ'입니까?", "위의 지문자가\n지문자'ㅈ'입니까?",
            "위의 지문자가\n지문자'ㅊ'입니까?", "위의 지문자가\n지문자'ㅋ'입니까?",
            "위의 지문자가\n지문자'ㅌ'입니까?", "위의 지문자가\n지문자'ㅍ'입니까?", "위의 지문자가\n지문자'ㅎ'입니까?","위의 지문자가\n지문자'ㅏ'입니까?","위의 지문자가\n지문자'ㅑ'입니까?","위의 지문자가\n지문자'ㅓ'입니까?",
            "위의 지문자가\n지문자'ㅕ'입니까?","위의 지문자가\n지문자'ㅗ'입니까?","위의 지문자가\n지문자'ㅛ'입니까?","위의 지문자가\n지문자'ㅜ'입니까?","위의 지문자가\n지문자'ㅠ'입니까?","위의 지문자가\n지문자'ㅡ'입니까?",
            "위의 지문자가\n지문자'ㅣ'입니까?","위의 지문자가\n지문자'ㅐ'입니까?","위의 지문자가\n지문자'ㅔ'입니까?","위의 지문자가\n지문자'ㅚ'입니까?","위의 지문자가\n지문자'ㅟ'입니까?","위의 지문자가\n지문자'ㅒ'입니까?",
            "위의 지문자가\n지문자'ㅖ'입니까?","위의 지문자가\n지문자'ㅢ'입니까?"};

    int[] imgs = new int[]{R.drawable.r, R.drawable.s,R.drawable.e,R.drawable.f,R.drawable.a,R.drawable.q,
            R.drawable.t,R.drawable.d,R.drawable.w,R.drawable.c,R.drawable.z,R.drawable.x,R.drawable.v,R.drawable.g,R.drawable.k, R.drawable.i, R.drawable.j, R.drawable.u, R.drawable.h, R.drawable.y,
            R.drawable.n, R.drawable.b, R.drawable.m, R.drawable.l, R.drawable.o, R.drawable.p, R.drawable.hl, R.drawable.nl,R.drawable.oo,R.drawable.pp,R.drawable.ml};

    ImageView mImageView;
    ImageView LifeImage;
    ImageView LifeImage2;
    ImageView LifeImage3;
    TextView textView;
    TextView textView2;
    ImageButton imageButton;
    ImageButton imageButton2;
    ImageButton imageButton3;


    int life = 3;
    int turn = 1;
    int max_turn = 20;
    int torf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        Init();
        Game();
    }

    void Init() {
        mImageView = (ImageView) findViewById(R.id.imageView);
        LifeImage = (ImageView) findViewById(R.id.LifeImage);
        LifeImage2 = (ImageView) findViewById(R.id.LifeImage2);
        LifeImage3 = (ImageView) findViewById(R.id.LifeImage3);
        textView = (TextView) findViewById(R.id.text);
        textView2 = (TextView) findViewById(R.id.text2);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton2.setEnabled(false);
                imageButton3.setEnabled(false);
                Iscorrect(1);
                countturn();
                Game();
                imageButton2.setEnabled(true);
                imageButton3.setEnabled(true);
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton2.setEnabled(false);
                imageButton3.setEnabled(false);
                Iscorrect(0);
                countturn();
                Game();
                imageButton2.setEnabled(true);
                imageButton3.setEnabled(true);
            }

        });

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backbutton();
            }
        });
    }

    //질문 만들어줌
    void Game() {


        //1.랜덤 -> 옳은 값으로 간다/ 다른 값으로 간다.
        torf = (int) (Math.random() * 2);
        int imgIdx;
        int questIdx;

        //2. 조건d
        // 옳은 값은
        if (torf == 1) {
            imgIdx = (int) (Math.random() * 31);
            questIdx = imgIdx;
        }
        //다르게 할 때 값은
        else {
            do
            {imgIdx = (int) (Math.random() * 31);
            questIdx = (int) (Math.random() * 31);}
            while(imgIdx==questIdx);
        }
        //3.ui

        mImageView.setBackgroundResource(imgs[imgIdx]);
        textView.setText(question[questIdx]);


    }

    void Iscorrect(int userchoice) {

        //사용자 정답 판정 해주는 애
        if (userchoice != torf) {
            //오답
            life -= 1;
            if (life==2)
            {
                LifeImage3.setColorFilter(Color.parseColor("#99999999"), PorterDuff.Mode.SRC_IN);

            }
            else if(life==1)
            {
                LifeImage2.setColorFilter(Color.parseColor("#99999999"), PorterDuff.Mode.SRC_IN);
            }
            else
            {
                LifeImage.setColorFilter(Color.parseColor("#99999999"), PorterDuff.Mode.SRC_IN);
                exitbutton();
            }
        }
    }

    void countturn ()
    {

        if (turn == 19) {
            //끝내 bbye~
            exitbutton();
        }
        turn += 1;

        textView2.setText(Integer.toString(turn));
    }


    void backbutton()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(game.this);
        builder.setTitle("뒤로 가기");
        builder.setMessage("뒤로 가시겠습니까?");
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                finish();
                startActivity(intent);
            }
        });
        builder.setNegativeButton("아니오", null);
        builder.create().show();

    }

    void exitbutton()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(game.this);
        builder.setTitle("게임 종료");
        builder.setMessage(((turn)+1)+"/ 20 입니다.");
        builder.setPositiveButton("종료", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                finish();
                startActivity(intent);

            }
        })
                .setCancelable(false);
        builder.setNegativeButton("다시 하기", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), game.class);
                finish();
                startActivity(intent);
            }
        })
                .setCancelable(false);

        builder.create().show();
    }

}





