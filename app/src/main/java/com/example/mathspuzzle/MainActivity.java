package com.example.mathspuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Continue,puzzles,buypro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Continue=findViewById(R.id.continu);
        puzzles=findViewById(R.id.puzzles);
        buypro=findViewById(R.id.buy);

        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,PuzzzleActivity.class);
                startActivity(intent);
            }
        });
        puzzles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SelectPuzzle_Activity.class);
                startActivity(intent);
            }
        });

    }
}