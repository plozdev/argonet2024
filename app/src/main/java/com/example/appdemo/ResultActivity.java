package com.example.appdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.database.Cursor;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appdemo.database.FarmDataDbHelper;
import com.example.appdemo.database.Model;
import com.example.appdemo.detail.DetailedActivity1;
import com.example.appdemo.detail.DetailedActivity2;
import com.example.appdemo.detail.DetailedActivity3;
import com.example.appdemo.detail.DetailedActivity4;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class ResultActivity extends AppCompatActivity {
    private final String url = "https://ca4e-2402-800-623f-1071-6d92-a2dc-df0c-4848.ngrok-free.app/predict";
    // Mang + CONST
    private final int nhanImg[] = {
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
            R.drawable.dudu,
            R.drawable.dautrieu,
            R.drawable.luu,
            R.drawable.lua,
            R.drawable.duahau,
    };
    private final String nhanCay[] = {
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
    // POSITION OF TREE
    private int index1,index2,index3,index4;
    //----------------------------
    //4yeutocambien
    private String temp,humid,ph,rainfall;
    //Ten
    private String nhan1,nhan2,nhan3,nhan4;
    //Phan tram
    private String ac1,ac2,ac3,ac4;
    //Anh
    private int img1,img2,img3,img4;
    //-----------------------------
    //STRING GET INTENT
    private String N,P,K;
    //---------------------------
    //String de get data from server
    //Ten
    private String nhan11,nhan22,nhan33,nhan44;
    //Phan tram
    private String ac11,ac22,ac33,ac44;

    //---------------------------
    //LAYOUT
    //Button
    public Button btn1,btn2,btn3,btn4;
    //percent
    public TextView per1,per2,per3,per4;
    //ten
    public TextView name1,name2,name3,name4;
    //anh
    public ImageView anh1,anh2,anh3,anh4;
    //--------------------------------------
    //FAB
    private FloatingActionButton fab,fabCancel;
    private ExtendedFloatingActionButton fabSave;
    private Animation fabOpen, fabClose, rotateForward, rotateBackward;
    private Boolean isFabOpen = false;

    //---------------------------------------------
    //DATABASE
    protected FarmDataDbHelper dbHelper = new FarmDataDbHelper(this);
    protected int rowsUpdated; //Update
    protected long newRowId; //Add
    protected Cursor cursor; // Read
    protected Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
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

//        //Tham chieu fab
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fabSave = findViewById(R.id.fab_save);
        fabCancel = findViewById(R.id.fab_cancel);

        //Animtion
        fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close);
        rotateForward = AnimationUtils.loadAnimation(this, R.anim.rotate_foward);
        rotateBackward = AnimationUtils.loadAnimation(this, R.anim.rotate_backward);

        //GET INTENT
        Intent it = getIntent();
        N = it.getStringExtra("N");
        P = it.getStringExtra("P");
        K = it.getStringExtra("K");

        //GET DATA FROM SERVER
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            temp = jsonObject.getString("Nhiet do");
                            ph = jsonObject.getString("pH");
                            humid = jsonObject.getString("Do am");
                            rainfall = jsonObject.getString("Luong mua");


                            //Ket qua nhan
                            nhan11 = jsonObject.getString("Nhan 1");
                            nhan22 = jsonObject.getString("Nhan 2");
                            nhan33 = jsonObject.getString("Nhan 3");
                            nhan44 = jsonObject.getString("Nhan 4");
//                          ket qua accuracy
                            ac11 = jsonObject.getString("Acc 1");
                            ac22 = jsonObject.getString("Acc 2");
                            ac33 = jsonObject.getString("Acc 3");
                            ac44 = jsonObject.getString("Acc 4");

                            //INDEX CAY
                            index1 = Integer.parseInt(nhan11);
                            index2 = Integer.parseInt(nhan22);
                            index3 = Integer.parseInt(nhan33);
                            index4 = Integer.parseInt(nhan44);

                            ac1 = roundToTwoDecimalPlaces(ac11);
                            ac2 = roundToTwoDecimalPlaces(ac22);
                            ac3 = roundToTwoDecimalPlaces(ac33);
                            ac4 = roundToTwoDecimalPlaces(ac44);

                            //after get data from server
                            nhan1 = nhanCay[index1];
                            nhan2 = nhanCay[index2];
                            nhan3 = nhanCay[index3];
                            nhan4 = nhanCay[index4];


                            img1 = nhanImg[index1];
                            img2 = nhanImg[index2];
                            img3 = nhanImg[index3];
                            img4 = nhanImg[index4];


                            //------------------------------



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


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                      Toast.makeText(ResultActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("N", N);
                params.put("P", P);
                params.put("K", K);
                return params;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(ResultActivity.this);
        queue.add(stringRequest);



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

    //------------------------FAB

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFabOpen) {
                    fab.startAnimation(rotateBackward);
                    fabSave.startAnimation(fabClose);
                    fabCancel.startAnimation(fabClose);
                    fabSave.setClickable(false);
                    fabCancel.setClickable(false);
                    isFabOpen = false;
                } else {
                    fab.startAnimation(rotateForward);
                    fabSave.startAnimation(fabOpen);
                    fabCancel.startAnimation(fabOpen);
                    fabSave.setClickable(true);
                    fabCancel.setClickable(true);
                    isFabOpen = true;
                }
            }
        });
        fabCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFabOpen) {
                    fab.startAnimation(rotateBackward);
                    fabSave.startAnimation(fabClose);
                    fabCancel.startAnimation(fabClose);
                    fabSave.setClickable(false);
                    fabCancel.setClickable(false);
                    isFabOpen = false;
                } else {
                    fab.startAnimation(rotateForward);
                    fabSave.startAnimation(fabOpen);
                    fabCancel.startAnimation(fabOpen);
                    fabSave.setClickable(true);
                    fabCancel.setClickable(true);
                    isFabOpen = true;
                }
            }
        });
        fabSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFabOpen) {
                    //FAB MAIN
//                    newRowId = dbHelper.addData(N, P, K, temp, humid, ph, rainfall, nhan11,ac1, nhan22,ac2, nhan33,ac3, nhan44,ac4);
                    newRowId = dbHelper.addData(model);
                    if (newRowId != -1) {
                        // Dữ liệu đã được thêm thành công
                        Toast.makeText(ResultActivity.this, "Luu database duoc roi nha kkk", Toast.LENGTH_SHORT).show();
                        Log.d("Database", "Dữ liệu đã được thêm vào với ID: " + newRowId);
                    } else {
                        // Đã xảy ra lỗi khi thêm dữ liệu
                        Log.e("Database", "Đã xảy ra lỗi khi thêm dữ liệu");
                    }
                } else {
                    fab.startAnimation(rotateForward);
                    fabSave.startAnimation(fabOpen);
                    fabCancel.startAnimation(fabOpen);
                    fabSave.setClickable(true);
                    fabCancel.setClickable(true);
                    isFabOpen = true;
                }
            }
        });

    }
    //VOID
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