package com.example.mathspuzzle;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Puzzle_Adapter extends RecyclerView.Adapter<Puzzle_Adapter.View_Holder> {
    Activity activity;
    public Puzzle_Adapter(Activity activity) {
        this.activity=activity;

    }

    @NonNull
    @Override
    public Puzzle_Adapter.View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.selectpuzzle_item,parent,false);
        View_Holder view_holder=new View_Holder(view);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Puzzle_Adapter.View_Holder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 24;
    }

    public class View_Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public View_Holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.item_img);
            textView=itemView.findViewById(R.id.text);
        }
    }
}
