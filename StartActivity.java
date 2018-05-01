package com.example.igor.game3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;



public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }
    public void Start(View v){
        Intent intent = new Intent(StartActivity.this, MainActivity.class);

        CheckBox checkbox = findViewById(R.id.sobaka);
        RadioButton largetext = findViewById(R.id.largetext);
        Intent inttobesend = getIntent();
        Bundle tobesend = inttobesend.getExtras();
        intent.putExtras(tobesend);


        if(checkbox.isChecked() == true){
        intent.putExtra("visibility", View.INVISIBLE);
        }
        if(largetext.isChecked()){
            intent.putExtra("largetext", 20);
        }
        //finish();
        startActivity(intent);

    }
}
