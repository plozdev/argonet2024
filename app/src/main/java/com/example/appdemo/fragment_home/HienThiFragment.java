package com.example.appdemo.fragment_home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appdemo.MainActivity;
import com.example.appdemo.R;
import com.example.appdemo.ResultActivity;
import com.example.appdemo.loading.LoadingAlert;

import org.json.JSONException;
import org.json.JSONObject;

import javax.xml.transform.Result;

public class HienThiFragment extends Fragment {

    TextView ph,rainfall,temp,doam;
    Button reload;
    TextView string1,string2,string3,string4;
    private String url = "https://b02e-2402-800-623f-cdec-84d6-dd08-28f4-2575.ngrok-free.app/predict";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_hien_thi, container, false);
        ph = v.findViewById(R.id.ph);
        rainfall = v.findViewById(R.id.rainfall);
        temp = v.findViewById(R.id.temp);
        doam = v.findViewById(R.id.humid);
        reload = v.findViewById(R.id.reloadButton);
        LoadingAlert loadingAlert = new LoadingAlert(getActivity());
        //----------------------------------------------------
        string1 = v.findViewById(R.id.temp1);
        string2 = v.findViewById(R.id.humid1);
        string3 = v.findViewById(R.id.rainfall1);
        string4 = v.findViewById(R.id.ph1);
        //-----------------------------------------------------
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(getActivity(), ResultActivity.class);
//                startActivity(i);

                loadingAlert.startAlertDialog();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    String data1 = jsonObject.getString("pH");
                                    String data2 = jsonObject.getString("Luong mua");
                                    String data3 = jsonObject.getString("Nhiet do");
                                    String data4 = jsonObject.getString("Do am");
                                    ph.setText(data1);
                                    rainfall.setText(data2 + " mm");
                                    temp.setText(data3 + " °C");
                                    doam.setText(data4 + " %");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                loadingAlert.closeAlertDialog();

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
//                                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                                loadingAlert.closeAlertDialog();
                            }
                        });
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(stringRequest);
            }
        });
        return  v;
    }
}