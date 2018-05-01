package com.example.igor.game3;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }


    public void Start(View v){
        Intent settings = new Intent(Registration.this, StartActivity.class);
        EditText name = findViewById(R.id.name);
        EditText email = findViewById(R.id.email);
        Bundle persinfo = new Bundle();
        persinfo.putString("name", name.getText().toString());
        persinfo.putString("email", email.getText().toString());
        settings.putExtras(persinfo);
        startActivity(settings);


    }

}
