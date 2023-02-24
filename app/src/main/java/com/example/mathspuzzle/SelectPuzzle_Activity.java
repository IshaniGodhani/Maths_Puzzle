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
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int count=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_puzzle);
        recyclerView=findViewById(R.id.recyclerview);
        sharedPreferences=getSharedPreferences("myPref",MODE_PRIVATE);
        editor=sharedPreferences.edit();


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
        editor.putInt("count",1);
        editor.commit();
        count++;

        if (count==2) {
            next.setVisibility(View.VISIBLE);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectPuzzle_Activity.this, SelectPuzzle_Activity.class);
//                  intent.putExtra("lable", "page1");
                    intent.putExtra("lable","page2");
                    startActivity(intent);
                    finish();

                }
            });


        }
        if (count==3) {
            next.setVisibility(View.GONE);
            previous.setVisibility(View.VISIBLE);
            previous.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectPuzzle_Activity.this, SelectPuzzle_Activity.class);
                    startActivity(intent);
                    finish();
                }
            });


        }

    }
}