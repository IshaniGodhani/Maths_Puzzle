package com.example.mathspuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PuzzzleActivity extends AppCompatActivity implements View.OnClickListener {
    int[] img={R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,
            R.drawable.p6,R.drawable.p7,R.drawable.p8,R.drawable.p9,R.drawable.p10,
            R.drawable.p11,R.drawable.p12,R.drawable.p13,R.drawable.p14,R.drawable.p15,
            R.drawable.p16,R.drawable.p17,R.drawable.p18,R.drawable.p19,R.drawable.p20,
            R.drawable.p21,R.drawable.p22,R.drawable.p23,R.drawable.p24,R.drawable.p25,
            R.drawable.p26,R.drawable.p27,R.drawable.p28,R.drawable.p29,R.drawable.p30};
    String[] ans={"10","20","30","40","50","60","70","10","20","30","40","50","60","70"};
    Button[] button=new Button[10];
    Button submit;
    TextView txtAns;
    String temp,a;
    ImageView imageView,image,skip;
    TextView levelno;
    int level=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzzle);
        txtAns=findViewById(R.id.txtAns);
        image=findViewById(R.id.img);
        levelno=findViewById(R.id.levelno);
        submit=findViewById(R.id.submit);
        skip=findViewById(R.id.skip);
        imageView=findViewById(R.id.erase);

        if(getIntent().getExtras()!=null)
        {
            level=getIntent().getIntExtra("level",0);
            System.out.println("Level="+level);
        }
        for(int i=0;i<10;i++)
        {
            int id=getResources().getIdentifier("btn"+i,"id",getPackageName());
            button[i]=findViewById(id);

        }
        image.setImageResource(img[level]);
        levelno.setText("Level "+(level+1));
        for (int i=0;i<button.length;i++)
        {
            button[i].setOnClickListener(this);
        }
        submit.setOnClickListener(this);
        imageView.setOnClickListener(this);
        skip.setOnClickListener(view -> {


            Intent intent=new Intent(this,PuzzzleActivity.class);
            intent.putExtra("level",level);
            startActivity(intent);
            finish();
        });


    }

    @Override
    public void onClick(View view) {
        for (int i=0;i<button.length;i++)
        {
            if(view.getId()==button[i].getId())
            {
                temp=txtAns.getText().toString();
                a=temp+String.valueOf(i);
                txtAns.setText(""+a);
            }
        }
        if (view.getId()==imageView.getId())
        {
            temp=txtAns.getText().toString().substring(0,txtAns.length()-1);
            txtAns.setText(""+temp);

        }
        if (view.getId()==submit.getId()) {

            if (txtAns.getText().toString().equals(ans[level])) {
                level++;
                Intent intent = new Intent(this, PuzzzleActivity.class);
                intent.putExtra("level", level);
                startActivity(intent);
                finish();
            }
        }
    }
}