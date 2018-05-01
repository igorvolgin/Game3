package com.example.igor.game3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_results);
        TextView name = findViewById(R.id.name);
        TextView score = findViewById(R.id.score);
        Button button = findViewById(R.id.button);
        Bundle recieve = intent.getExtras();
        name.setText(recieve.getString("name")+ " your score is:");
        score.setText(Integer.toString(intent.getIntExtra("score", 999)));
        button.setText("Send results to "+recieve.getString("email"));
    }

    public void Send(View v) {
        Intent intentt = getIntent();
        Bundle recieve = intentt.getExtras();

        String[] emaill = {recieve.getString("email")};
        String score = "Your score is "+Integer.toString(intentt.getIntExtra("score", 0));
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plain");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, emaill);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Results");
        intent.putExtra(Intent.EXTRA_TEXT, score);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


        
    }

}
