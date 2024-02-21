package com.example.appdemo.detail;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdemo.R;

public class DetailedActivity1 extends AppCompatActivity {
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
        setContentView(R.layout.activity_detailed);
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
        PHANTRAM.setText(phantram);
        //Pho bien
        if (index==0 || index==3 || index==6 || index==7 || index==8 || index==9 || index==10 || index==13 || index==18 || index==19) {
            //khong pho bien
            PHOBIEN.setText("Có");
            NOTEPHOBIEN.setText(getString(R.string.phobien_true));
            NOTEPHOBIEN.setTextColor(Color.parseColor("#43A047"));

        } else if (index == 1 || index==2 || index==4 || index==5 || index==11 || index==12 || index==14 || index==15 || index==16 || index==17 || index==20 || index==21) {
            //pho bien
            PHOBIEN.setText("Không");
            NOTEPHOBIEN.setText(getString(R.string.phobien_false));
            NOTEPHOBIEN.setTextColor(Color.parseColor("#E53935"));

        } else {
            PHOBIEN.setText("Chưa rõ");
            NOTEPHOBIEN.setText("Chưa rõ");
            NOTEPHOBIEN.setTextColor(Color.parseColor("#FFFFFF"));
            Log.e("flag","ERROR");
        }

        //Time sinh truong + Mua thich hop







    }
}