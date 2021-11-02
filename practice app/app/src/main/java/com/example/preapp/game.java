package com.example.preapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class game extends AppCompatActivity {
    Button o_btn , x_btn;
    ImageView hand_flag;
    Random r;
    int turn = 1;
    List<CountryItem> list;  // 다른 코드에 구현

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        r = new Random();

        hand_flag = findViewById(R.id.hand);
        o_btn = (Button) findViewById(R.id.o);
        x_btn = (Button) findViewById(R.id.x);

        list = new ArrayList<>();

        //랜덤
        Collections.shuffle(list);

        newQuestion(turn);

        o_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //정답 체크
                if(o_btn){
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(game.this, "퀴즈를 끝마치셨습니다!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }else{
                    Toast.makeText(game.this, "틀렸습니다!", Toast.LENGTH_SHORT).show();
                    //마지막 문제 체크
                    if(turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(game.this, "게임에서 지셨습니다!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });

        x_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //정답 체크
                if(x_btn){
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(game.this, "퀴즈를 끝마치셨습니다!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }else{
                    Toast.makeText(game.this, "틀렸습니다!", Toast.LENGTH_SHORT).show();
                    //마지막 문제 체크
                    if(turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(game.this, "게임에서 지셨습니다!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });

    }

    private void newQuestion(int number) {
        //손 이미지를 스크린에 세팅한다.
        hand_flag.setImageResource(list.get(number - 1).getImage());

        int correct_answer = r.nextInt(4) + 1;

        int firstButton = number -1;
        int secondButton;

        switch (correct_answer) {
            case 1:
                o_btn.setText(list.get(firstButton).getName());
                do{
                    secondButton = r.nextInt(list.size());
                }
        }
    }
}
