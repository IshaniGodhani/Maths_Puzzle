package com.example.mathspuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity {
    TextView label;
    Button btncontinue,btnmainmenu,btnbuypro;
    ImageView share;
    int level;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        label=findViewById(R.id.completed);
        btncontinue=findViewById(R.id.btncon);
        btnmainmenu=findViewById(R.id.btnmenu);
        btnbuypro=findViewById(R.id.btnbuypro);
        share=findViewById(R.id.share);

        level=getIntent().getIntExtra("LastLevel",0);//1

        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(WinActivity.this, PuzzzleActivity.class);
                intent.putExtra("LastLevel", level);
                startActivity(intent);
                finish();

            }
        });
        btnmainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(WinActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}