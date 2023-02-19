package com.example.mathspuzzle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SelectPuzzle_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView imageView;
    String str;
    Puzzle_Adapter puzzle_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_puzzle);
        recyclerView=findViewById(R.id.recyclerview);
        puzzle_adapter=new Puzzle_Adapter(SelectPuzzle_Activity.this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,4);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(puzzle_adapter);
        imageView=findViewById(R.id.next);
        config.count++;
        if (config.count==1) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SelectPuzzle_Activity.this, SelectPuzzle_Activity.class);
                    intent.putExtra("lable", "page1");
                    startActivity(intent);
                    finish();
                }
            });
            str = getIntent().getStringExtra("lable");
            if (getIntent().getExtras() != null) {
                recyclerView.setAdapter(puzzle_adapter);
            }
        }
        else
        {
            imageView.setVisibility(View.INVISIBLE);
        }

    }
}