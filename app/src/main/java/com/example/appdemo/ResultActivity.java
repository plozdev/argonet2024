package com.example.appdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;


public class ResultActivity extends AppCompatActivity {
    // Mang
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
    //----------------------------
    //String de truyen di qua detail
    //Ten
    private String nhan1,nhan2,nhan3,nhan4;
    //Phan tram
    private String ac1,ac2,ac3,ac4;
    //Anh
    private int img1,img2,img3,img4;
    //Check pho bien or none
    private String check1,check2,check3,check4;
    //---------------------------
    //String de get intent
    //Ten
    private String nhan11,nhan22,nhan33,nhan44;
    //Phan tram
    private String ac11,ac22,ac33,ac44;
    private String check11,check22,check33,check44;
    //---------------------------
    //SHOW
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
//        per1.setText("1");
//        per2.setText("2");
//        per3.setText("3");
//        per4.setText("4");
//        name1.setText("1");
//        name2.setText("2");
//        name3.setText("3");
//        name4.setText("4");
//        anh1.setImageResource(R.drawable.tao);
//        anh2.setImageResource(R.drawable.chuoi);
//        anh3.setImageResource(R.drawable.dua);
//        anh4.setImageResource(R.drawable.dudu);

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

        check11 = i.getStringExtra("check1");
        check22 = i.getStringExtra("check2");
        check33 = i.getStringExtra("check3");
        check44 = i.getStringExtra("check4");

        /*
        nhan11 = "0";
        nhan22 = "1";
        nhan33 = "2";
        nhan44 = "3";

        ac11 = "84.031";
        ac22 = "12.1212424";
        ac33 = "2.00082";
        ac44 = "1.0124";*/
        //after intent ++ Show
        nhan1 = nhanCay[Integer.parseInt(nhan11)];
        nhan2 = nhanCay[Integer.parseInt(nhan22)];
        nhan3 = nhanCay[Integer.parseInt(nhan33)];
        nhan4 = nhanCay[Integer.parseInt(nhan44)];

        ac1 = roundToTwoDecimalPlaces(ac11);
        ac2 = roundToTwoDecimalPlaces(ac22);
        ac3 = roundToTwoDecimalPlaces(ac33);
        ac4 = roundToTwoDecimalPlaces(ac44);

        img1 = nhanImg[Integer.parseInt(nhan11)];
        img2 = nhanImg[Integer.parseInt(nhan22)];
        img3 = nhanImg[Integer.parseInt(nhan33)];
        img4 = nhanImg[Integer.parseInt(nhan44)];

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
                Intent i = new Intent(ResultActivity.this, DetailedActivity.class);
                startActivity(i);
            }
        });

    }

    public static String roundToTwoDecimalPlaces(String myString) {
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