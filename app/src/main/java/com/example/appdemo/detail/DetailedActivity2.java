package com.example.appdemo.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdemo.R;

public class DetailedActivity2 extends AppCompatActivity {
    private ImageView IMG;
    private TextView TEN;
    private TextView PHANTRAM;
    private TextView PHOBIEN;
    private TextView NOTEPHOBIEN;
    private TextView TIMESINHTRUONG;
    private TextView MUATHICHHOP;

    private String PHOBIENTRUE,PHOBIENFALSE;
    private String nhan;
    private String phantram;
    private int anh,index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed1);

        //GET INTENT---------------------------
        Intent i = getIntent();
        nhan = i.getStringExtra("name");
        phantram = i.getStringExtra("phantram");
        anh = i.getIntExtra("anh",-1);
        index = i.getIntExtra("sonhancay",-1);

        //GAN STRING-------------------
        PHOBIENTRUE = getString(R.string.phobien_true);
        PHOBIENFALSE = getString(R.string.phobien_false);

        //THAM CHIEU LEN LAYOUT---------------------
        IMG = findViewById(R.id.detailImage);
        TEN = findViewById(R.id.detailName);
        PHANTRAM = findViewById(R.id.detailPercent);
        PHOBIEN = findViewById(R.id.detailPhoBien);
        NOTEPHOBIEN = findViewById(R.id.detailNotePhoBien);
        TIMESINHTRUONG = findViewById(R.id.detailTGSinhTruong);
        MUATHICHHOP = findViewById(R.id.detailMuaThichHop);

        //CODE SOLVE--------------------------
        TEN.setText(nhan);
        IMG.setImageResource(anh);
        PHANTRAM.setText(phantram + "%");
        //Pho bien
        if (index==0 || index==3 || index==6 || index==7 || index==8 || index==9 || index==10 || index==13 || index==18 || index==19) {
            //khong pho bien
            PHOBIEN.setText("Không");
            NOTEPHOBIEN.setText(getString(R.string.phobien_false));
            NOTEPHOBIEN.setTextColor(Color.parseColor("#E53935"));


        } else if (index == 1 || index==2 || index==4 || index==5 || index==11 || index==12 || index==14 || index==15 || index==16 || index==17 || index==20 || index==21) {
            //pho bien
            PHOBIEN.setText("Có");
            NOTEPHOBIEN.setText(getString(R.string.phobien_true));
            NOTEPHOBIEN.setTextColor(Color.parseColor("#43A047"));

        } else {
            PHOBIEN.setText("Chưa rõ");
            NOTEPHOBIEN.setText("Chưa rõ");
            NOTEPHOBIEN.setTextColor(Color.parseColor("#000000"));
            Log.e("flag","ERROR");
        }

        //Time sinh truong + Mua thich hop
        if (index==0) {
            TIMESINHTRUONG.setText("Khoảng 1,5 – 2 năm");
            MUATHICHHOP.setText(getText(R.string.first));
        } else if (index==1) {
            TIMESINHTRUONG.setText("Khoảng 9 - 12 tháng");
            MUATHICHHOP.setText(getText(R.string.mot));
        } else if (index==2) {
            TIMESINHTRUONG.setText("Khoảng 80 – 90 ngày");
            MUATHICHHOP.setText(getText(R.string.hai));
        } else if (index==3) {
            TIMESINHTRUONG.setText("Khoảng 90 – 100 ngày");
            MUATHICHHOP.setText(getText(R.string.ba));
        } else if (index==4) {
            TIMESINHTRUONG.setText("Khoảng 3 – 6 năm");
            MUATHICHHOP.setText(getText(R.string.bon));
        } else if (index==5) {
            TIMESINHTRUONG.setText("Khoảng 3 – 4 năm");
            MUATHICHHOP.setText(getText(R.string.nam));
        } else if (index==6) {
            TIMESINHTRUONG.setText("Khoảng 100 – 115 ngày");
            MUATHICHHOP.setText(getText(R.string.sau));
        } else if (index==7) {
            TIMESINHTRUONG.setText("Khoảng 2 – 4 năm");
            MUATHICHHOP.setText(getText(R.string.bay));
        } else if (index==8) {
            TIMESINHTRUONG.setText("Khoảng 180 - 230 ngày");
            MUATHICHHOP.setText(getText(R.string.tam));
        } else if (index==9) {
            TIMESINHTRUONG.setText("Khoảng 100 – 140 ngày");
            MUATHICHHOP.setText(getText(R.string.chin));
        } else if (index==10) {
            TIMESINHTRUONG.setText("Khoảng 110 ngày");
            MUATHICHHOP.setText(getText(R.string.motko));
        } else if (index==11) {
            TIMESINHTRUONG.setText("- Bắp tươi: Khoảng 66 – 68 ngày\n" +
                    "- Bắp khô: Khoảng 95 – 100 ngày");
            MUATHICHHOP.setText(getText(R.string.motmot));
        } else if (index==12) {
            TIMESINHTRUONG.setText("Khoảng 3 năm");
            MUATHICHHOP.setText(getText(R.string.mothai));
        } else if (index==13) {
            TIMESINHTRUONG.setText("Khoảng 75 – 90 ngày");
            MUATHICHHOP.setText(getText(R.string.motba));
        } else if (index==14) {
            TIMESINHTRUONG.setText("Khoảng 50 – 60 ngày");
            MUATHICHHOP.setText(getText(R.string.motbon));
        } else if (index==15) {
            TIMESINHTRUONG.setText("Khoảng 80 – 95 ngày");
            MUATHICHHOP.setText(getText(R.string.motnam));
        } else if (index==16) {
            TIMESINHTRUONG.setText("Khoảng 18 – 22 tháng ");
            MUATHICHHOP.setText(getText(R.string.motsau));
        } else if (index==17) {
            TIMESINHTRUONG.setText("Khoảng 9 – 10 tháng");
            MUATHICHHOP.setText(getText(R.string.motbay));
        } else if (index==18) {
            TIMESINHTRUONG.setText("Khoảng 3 – 4 tháng");
            MUATHICHHOP.setText(getText(R.string.mottam));
        } else if (index==19) {
            TIMESINHTRUONG.setText("- Gieo hạt: Khoảng 2 năm\n" +
                    "- Chiết cành: Khoảng 1 năm");
            MUATHICHHOP.setText(getText(R.string.motchin));
        } else if (index==20) {
            TIMESINHTRUONG.setText("Khoảng 80 – 150 ngày ");
            MUATHICHHOP.setText(getText(R.string.haiko));
        } else if (index==21) {
            TIMESINHTRUONG.setText("Khoảng 55 – 60 ngày");
            MUATHICHHOP.setText(getText(R.string.haimot));
        }  else {
            TIMESINHTRUONG.setText("Chưa rõ");
            MUATHICHHOP.setText("Chưa rõ");
            Log.e("fatal","ERROR");
        }
    }
}