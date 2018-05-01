package com.example.igor.game3;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.graphics.Color;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    boolean state;
    int score = 0;

    public ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        state = engine();

        pb = findViewById(R.id.progressBar);
        CountDownTimer start = new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                pb.setProgress((int)(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                Intent result = new Intent(MainActivity.this, results.class);
                result.putExtra("score", score);
                Intent inttobesend = getIntent();
                Bundle tobesend = inttobesend.getExtras();
                result.putExtras(tobesend);
                startActivity(result);
                //finish();
            }
        }.start();

    }

    public boolean engine(){



        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        Intent intent = getIntent();
        textView2.setTextSize(intent.getIntExtra("largetext", 14));
        textView3.setTextSize(intent.getIntExtra("largetext", 14));
        TextView scor = findViewById(R.id.result);
        TextView top = findViewById(R.id.rules);
        top.setVisibility(intent.getIntExtra("visibility", View.VISIBLE));
        scor.setText(String.valueOf(score));
        //scor.setText(String.valueOf(score));
        String[] text = {"Красный", "Желтый", "Зеленый", "Голубой", "Лиловый", "Черный"};
        String[] colors = { "#960000", "#c8cc00", "#009b24", "#00d4ff", "#4d1996", "#000000"};
        final Random rand = new Random();
        int textid1, colorid1, textid2, colorid2;
        textid1 = rand.nextInt(6);
        colorid1 = rand.nextInt(6);
        textid2 = rand.nextInt(6);
        colorid2 = rand.nextInt(6);
        textView2.setText(text[textid1]);
        textView2.setTextColor(Color.parseColor(colors[colorid1]));
        textView3.setText(text[textid2]);
        textView3.setTextColor(Color.parseColor(colors[colorid2]));
        if(textid1==colorid2){ return true;}
        else {return false;}

    }

    public void yes_clicked(View v){
        if(state == true) score++;
        state = engine();
    }
    public void no_clicked(View v){
        if(state == false) score++;
        state = engine();
    }





}