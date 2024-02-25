package com.example.appdemo.fragment_home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import com.example.appdemo.R;
import com.example.appdemo.ResultActivity;
import com.example.appdemo.loading.LoadingAlert;

public class DeXuatFragment extends Fragment {
    Button predict;
    EditText N,P,K;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View v = inflater.inflate(R.layout.fragment_de_xuat, container, false);


            predict = v.findViewById(R.id.startButton);
            N = v.findViewById(R.id.N);
            P = v.findViewById(R.id.P);
            K = v.findViewById(R.id.K);

        LoadingAlert loadingAlert = new LoadingAlert(getActivity());
            predict.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    loadingAlert.startAlertDialog();

                    Intent i = new Intent(getActivity(),ResultActivity.class);

                    i.putExtra("N",N.getText().toString());
                    i.putExtra("K",P.getText().toString());
                    i.putExtra("P",K.getText().toString());
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loadingAlert.closeAlertDialog();
                        }
                    },10000);
                    startActivity(i);
                }
            });

            return  v;
    }
}