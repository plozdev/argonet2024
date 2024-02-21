package com.example.appdemo.fragment_home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

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
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

import com.example.appdemo.R;
import com.example.appdemo.ResultActivity;
import com.example.appdemo.loading.LoadingAlert;

public class DeXuatFragment extends Fragment {
    Button predict;
    EditText N,P,K;


    TextView result;
    private String nhan1,nhan2,nhan3,nhan4,ac1,ac2,ac3,ac4;
    private String url = "https://172.28.0.12:5000/predict";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View v = inflater.inflate(R.layout.fragment_de_xuat, container, false);
            predict = v.findViewById(R.id.startButton);
            N = v.findViewById(R.id.N);
            P = v.findViewById(R.id.P);
            K = v.findViewById(R.id.K);
            result = v.findViewById(R.id.resultText);

        LoadingAlert loadingAlert = new LoadingAlert(getActivity());

            predict.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    loadingAlert.startAlertDialog();
                    // hit the API -> Volley
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {

                                    try {
                                        JSONObject jsonObject = new JSONObject(response);
//                                      ket qua nhan
                                        nhan1 = jsonObject.getString("Nhan 1");
                                        nhan2 = jsonObject.getString("Nhan 2");
                                        nhan3 = jsonObject.getString("Nhan 3");
                                        nhan4 = jsonObject.getString("Nhan 4");
//                                        ket qua accuracy
                                        ac1 = jsonObject.getString("Acc 1");
                                        ac2 = jsonObject.getString("Acc 2");
                                        ac3 = jsonObject.getString("Acc 3");
                                        ac4 = jsonObject.getString("Acc 4");

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    loadingAlert.closeAlertDialog();
                                    Intent intent = new Intent(getActivity(), ResultActivity.class);
                                    intent.putExtra("nhan1",nhan1);
                                    intent.putExtra("nhan2",nhan2);
                                    intent.putExtra("nhan3",nhan3);
                                    intent.putExtra("nhan4",nhan4);

                                    intent.putExtra("ac1",ac1);
                                    intent.putExtra("ac2",ac2);
                                    intent.putExtra("ac3",ac3);
                                    intent.putExtra("ac4",ac4);

                                    startActivity(intent);
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
//                                    Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                                    loadingAlert.closeAlertDialog();
                                }
                            }) {

                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("N", N.getText().toString());
                            params.put("P", P.getText().toString());
                            params.put("K", K.getText().toString());
                            return params;
                        }
                    };
                    RequestQueue queue = Volley.newRequestQueue(getActivity());
                    queue.add(stringRequest);

                }
            });

            return  v;
    }
}