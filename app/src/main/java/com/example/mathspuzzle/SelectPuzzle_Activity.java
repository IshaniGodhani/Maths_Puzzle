package com.example.mathspuzzle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SelectPuzzle_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView next,previous;
    String str,page="page1";
    Puzzle_Adapter puzzle_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_puzzle);
        recyclerView=findViewById(R.id.recyclerview);


        if(getIntent().getExtras()!=null)
        {
            page = getIntent().getStringExtra("lable");
            System.out.println("lable"+str);
        }

        puzzle_adapter=new Puzzle_Adapter(SelectPuzzle_Activity.this,page);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,4);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(puzzle_adapter);
        next=findViewById(R.id.next);
        previous=findViewById(R.id.previous);
        if(config.count==3)
        {
            config.count=0;
        }
        config.count++;

        if (config.count==1 ) {
            next.setVisibility(View.VISIBLE);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectPuzzle_Activity.this, SelectPuzzle_Activity.class);
                    intent.putExtra("lable","page2");
                    startActivity(intent);
                   // config.count++;
                    finish();
                }
            });


        }
        if (config.count==2) {
            next.setVisibility(View.VISIBLE);
            previous.setVisibility(View.VISIBLE);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectPuzzle_Activity.this, SelectPuzzle_Activity.class);
                    intent.putExtra("lable","page3");
                    startActivity(intent);
                    //config.count++;
                    finish();
                }
            });
            previous.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectPuzzle_Activity.this, SelectPuzzle_Activity.class);
                    startActivity(intent);
                    finish();

                }
            });


        }
        if (config.count==3) {
            next.setVisibility(View.GONE);
            previous.setVisibility(View.VISIBLE);
            previous.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectPuzzle_Activity.this, SelectPuzzle_Activity.class);
                    startActivity(intent);
                    //config.count++;
                    finish();
                }
            });
        }
    }
}