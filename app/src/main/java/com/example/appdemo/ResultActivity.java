package com.example.appdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdemo.detail.DetailedActivity1;
import com.example.appdemo.detail.DetailedActivity2;
import com.example.appdemo.detail.DetailedActivity3;
import com.example.appdemo.detail.DetailedActivity4;

import java.text.DecimalFormat;


public class ResultActivity extends AppCompatActivity {
    // Mang + CONST
    private int nhanImg[] = {
            R.drawable.tao,
            R.drawable.chuoi,
            R.drawable.dauden,
            R.drawable.dauga,
            R.drawable.dua,
            R.drawable.caphe,
            R.drawable.bong,
            R.drawable.nho,
            R.drawable.day,
            R.drawable.dautay,
            R.drawable.daulang,
            R.drawable.ngo,
            R.drawable.xoai,
            R.drawable.dautam,
            R.drawable.dauxanh,
            R.drawable.dualuoi,
            R.drawable.cam,
            R.drawable.dautrieu,
            R.drawable.luu,
            R.drawable.lua,
            R.drawable.duahau,
    };
    private String nhanCay[] = {
            "Cây Táo",
            "Cây Chuối",
            "Cây Đậu Đen",
            "Cây Đậu Gà",
            "Cây Dừa",
            "Cây Cà Phê",
            "Cây Bông Vải",
            "Cây Nho",
            "Cây Đay",
            "Cây Đậu Tây",
            "Cây Đậu Lăng",
            "Cây Ngô",
            "Cây Xoài",
            "Cây Đậu Tằm",
            "Cây Đậu Xanh",
            "Cây Dưa Lưới",
            "Cây Cam",
            "Cây Đu Đủ",
            "Cây Đậu Triều",
            "Cây Lựu",
            "Lúa",
            "Cây Dưa Hấu"
    };
    private int index1,index2,index3,index4;
    //----------------------------
    //String de truyen di qua detail
    //Ten
    private String nhan1,nhan2,nhan3,nhan4;
    //Phan tram
    private String ac1,ac2,ac3,ac4;
    //Anh
    private int img1,img2,img3,img4;

    //---------------------------
    //String de get intent
    //Ten
    private String nhan11,nhan22,nhan33,nhan44;
    //Phan tram
    private String ac11,ac22,ac33,ac44;

    //---------------------------
    //LAYOUT
    //Nut bam
    public Button btn1,btn2,btn3,btn4;
    //percent
    public TextView per1,per2,per3,per4;
    //ten
    public TextView name1,name2,name3,name4;
    //anh
    public ImageView anh1,anh2,anh3,anh4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //get intent
        Intent i = getIntent();
        nhan11 = i.getStringExtra("nhan1");
        nhan22 = i.getStringExtra("nhan2");
        nhan33 = i.getStringExtra("nhan3");
        nhan44 = i.getStringExtra("nhan4");

        ac11 = i.getStringExtra("ac1");
        ac22 = i.getStringExtra("ac2");
        ac33 = i.getStringExtra("ac3");
        ac44 = i.getStringExtra("ac4");

        //tham chieu len listview
        btn1 = findViewById(R.id.moreInfo1);
        btn2 = findViewById(R.id.moreInfo2);
        btn3 = findViewById(R.id.moreInfo3);
        btn4 = findViewById(R.id.moreInfo4);

        per1 = findViewById(R.id.listPercent1);
        per2 = findViewById(R.id.listPercent2);
        per3 = findViewById(R.id.listPercent3);
        per4 = findViewById(R.id.listPercent4);

        name1 = findViewById(R.id.listName1);
        name2 = findViewById(R.id.listName2);
        name3 = findViewById(R.id.listName3);
        name4 = findViewById(R.id.listName4);

        anh1 = findViewById(R.id.listImage1);
        anh2 = findViewById(R.id.listImage2);
        anh3 = findViewById(R.id.listImage3);
        anh4 = findViewById(R.id.listImage4);

        /*
        nhan11 = "0";
        nhan22 = "1";
        nhan33 = "2";
        nhan44 = "3";

        ac11 = "84.031";
        ac22 = "12.1212424";
        ac33 = "2.00082";
        ac44 = "1.0124";*/

        index1 = Integer.parseInt(nhan11);
        index2 = Integer.parseInt(nhan22);
        index3 = Integer.parseInt(nhan33);
        index4 = Integer.parseInt(nhan44);

        //after intent ++ Show
        nhan1 = nhanCay[index1];
        nhan2 = nhanCay[index2];
        nhan3 = nhanCay[index3];
        nhan4 = nhanCay[index4];

        ac1 = roundToTwoDecimalPlaces(ac11);
        ac2 = roundToTwoDecimalPlaces(ac22);
        ac3 = roundToTwoDecimalPlaces(ac33);
        ac4 = roundToTwoDecimalPlaces(ac44);

        img1 = nhanImg[index1];
        img2 = nhanImg[index2];
        img3 = nhanImg[index3];
        img4 = nhanImg[index4];


        //SHOW
        name1.setText(nhan1);
        name2.setText(nhan2);
        name3.setText(nhan3);
        name4.setText(nhan4);

        per1.setText(ac1 + "%");
        per2.setText(ac2 + "%");
        per3.setText(ac3 + "%");
        per4.setText(ac4 + "%");

        anh1.setImageResource(img1);
        anh2.setImageResource(img2);
        anh3.setImageResource(img3);
        anh4.setImageResource(img4);

        //----------------------BUTTON
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultActivity.this, DetailedActivity1.class);

                i.putExtra("name",nhan1);
                i.putExtra("phantram",ac1);
                i.putExtra("anh",img1);
                i.putExtra("sonhancay",index1);
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultActivity.this, DetailedActivity2.class);

                i.putExtra("name",nhan2);
                i.putExtra("phantram",ac2);
                i.putExtra("anh",img2);
                i.putExtra("sonhancay",index2);

                startActivity(i);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultActivity.this, DetailedActivity3.class);

                i.putExtra("name",nhan3);
                i.putExtra("phantram",ac3);
                i.putExtra("anh",img3);
                i.putExtra("sonhancay",index3);

                startActivity(i);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultActivity.this, DetailedActivity4.class);

                i.putExtra("name",nhan4);
                i.putExtra("phantram",ac4);
                i.putExtra("anh",img4);
                i.putExtra("sonhancay",index4);

                startActivity(i);
            }
        });
    }

    private static String roundToTwoDecimalPlaces(String myString) {
        // Convert the string to a double
        double myDouble = Double.parseDouble(myString);

        // Create a DecimalFormat object with the desired format
        DecimalFormat df = new DecimalFormat("#.##");

        // Apply the format to the double value
        String formattedString = df.format(myDouble);

        // Return the formatted string
        return formattedString;
    }
}