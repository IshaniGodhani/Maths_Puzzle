package com.example.mathspuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PuzzzleActivity extends AppCompatActivity {
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
        }
        for(int i=0;i<10;i++)
        {
            int id=getResources().getIdentifier("btn"+i,"id",getPackageName());
            button[i]=findViewById(id);

        }
        image.setImageResource(img[level]);
        levelno.setText("Level "+(level+1));




    }
}