package com.example.mathspuzzle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Puzzle_Adapter extends RecyclerView.Adapter<Puzzle_Adapter.View_Holder> {
    Activity activity;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public Puzzle_Adapter(Activity activity) {
        this.activity=activity;
        sharedPreferences= activity.getSharedPreferences("myPref", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
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

         String str = activity.getIntent().getStringExtra("lable");
        if (str.equals("page1"))
        {
            String status=sharedPreferences.getString("LevelStatus"+position,"pending");
            int level=sharedPreferences.getInt("LastLevel",-1);
            if(status.equals("win"))
            {
                holder.imageView.setImageResource(R.drawable.tick);
                holder.textView.setText(""+(holder.getAdapterPosition()+1));
                holder.textView.setVisibility(View.VISIBLE);
            }
            if(status.equals("skip")||position==level+1)
            {
                holder.imageView.setImageResource(0);
                holder.textView.setText(""+(holder.getAdapterPosition()+1));
                holder.textView.setVisibility(View.VISIBLE);
            }
            if(status.equals("win")||status.equals("skip")||position==level+1)
            {
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(activity,PuzzzleActivity.class);
                        intent.putExtra("LastLevel",holder.getAdapterPosition());
                        activity.startActivity(intent);
                        activity.finish();
                    }
                });
            }

        }
        else  if (str.equals("page2"))
        {
            String status=sharedPreferences.getString("LevelStatus"+position,"pending");
            int level=sharedPreferences.getInt("LastLevel",-1);
            if(status.equals("win"))
            {
                holder.imageView.setImageResource(R.drawable.tick);
                holder.textView.setText(""+(holder.getAdapterPosition()+23));
                holder.textView.setVisibility(View.VISIBLE);
            }
            if(status.equals("skip")||position==level+1)
            {
                holder.imageView.setImageResource(0);
                holder.textView.setText(""+(holder.getAdapterPosition()+23));
                holder.textView.setVisibility(View.VISIBLE);
            }
            if(status.equals("win")||status.equals("skip")||position==level+1)
            {
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(activity,PuzzzleActivity.class);
                        intent.putExtra("LastLevel",holder.getAdapterPosition());
                        activity.startActivity(intent);
                        activity.finish();
                    }
                });
            }

        }



    }

    @Override
    public int getItemCount() {
        return 23;
    }

    public class View_Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public View_Holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.lock);
            textView=itemView.findViewById(R.id.level);
        }
    }
}
