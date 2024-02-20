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
    private String nhan1,nhan2,nhan3,nhan4,ac1,ac2,ac3,ac4,ch1,ch2,ch3,ch4;
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
//                                        ket qua check phan loai
                                        ch1 = jsonObject.getString("Check 1");
                                        ch2 = jsonObject.getString("Check 2");
                                        ch3 = jsonObject.getString("Check 3");
                                        ch4 = jsonObject.getString("Check 4");
                                                /*
                                        if (nhan11.equals("0")) nhan1 = "Cây Táo";
                                        else if (nhan11.equals("1")) nhan1 = "Cây Chuối";
                                        else if (nhan11.equals("2")) nhan1 = "Cây Đậu đen";
                                        else if (nhan11.equals("3")) nhan1 = "Cây Đậu gà";
                                        else if (nhan11.equals("4")) nhan1 = "Cây Dừa";
                                        else if (nhan11.equals("5")) nhan1 = "Cây cà phê";
                                        else if (nhan11.equals("6")) nhan1 = "Cây Bông vải";
                                        else if (nhan11.equals("7")) nhan1 = "Cây ";
                                        else if (nhan11.equals("8")) nhan1 = "Cây ";
                                        else if (nhan11.equals("9")) nhan1 = "Cây ";
                                        else if (nhan11.equals("10")) nhan1 = "Cây ";
                                        else if (nhan11.equals("11")) nhan1 = "Cây ";
                                        else if (nhan11.equals("12")) nhan1 = "Cây ";
                                        else if (nhan11.equals("13")) nhan1 = "Cây ";
                                        else if (nhan11.equals("15")) nhan1 = "Cây ";
                                        else if (nhan11.equals("16")) nhan1 = "Cây ";
                                        else if (nhan11.equals("17")) nhan1 = "Cây ";
                                        else if (nhan11.equals("18")) nhan1 = "Cây ";
                                        else if (nhan11.equals("19")) nhan1 = "Cây ";
                                        else if (nhan11.equals("20")) nhan1 = "Cây ";
                                        else if (nhan11.equals("21")) nhan1 = "Cây ";

                                        if (nhan22.equals("0")) nhan2 = "Cây Táo";
                                        else if (nhan22.equals("1")) nhan2 = "";
                                        else if (nhan22.equals("2")) nhan2 = "";
                                        else if (nhan22.equals("3")) nhan2 = "";
                                        else if (nhan22.equals("4")) nhan2 = "";
                                        else if (nhan22.equals("5")) nhan2 = "";
                                        else if (nhan22.equals("6")) nhan2 = "";
                                        else if (nhan22.equals("7")) nhan2 = "";
                                        else if (nhan22.equals("8")) nhan2 = "";
                                        else if (nhan22.equals("9")) nhan2 = "";
                                        else if (nhan22.equals("10")) nhan2 = "";
                                        else if (nhan22.equals("11")) nhan2 = "";
                                        else if (nhan22.equals("12")) nhan2 = "";
                                        else if (nhan22.equals("13")) nhan2 = "";
                                        else if (nhan22.equals("14")) nhan2 = "";
                                        else if (nhan22.equals("15")) nhan2 = "";
                                        else if (nhan22.equals("16")) nhan2 = "";
                                        else if (nhan22.equals("17")) nhan2 = "";
                                        else if (nhan22.equals("18")) nhan2 = "";
                                        else if (nhan22.equals("19")) nhan2 = "";
                                        else if (nhan22.equals("20")) nhan2 = "";
                                        else if (nhan22.equals("21")) nhan2 = "";

                                        if (nhan33.equals("0")) nhan3 = "Cây Táo";
                                        else if (nhan33.equals("1")) nhan3 = "";
                                        else if (nhan33.equals("2")) nhan3 = "";
                                        else if (nhan33.equals("3")) nhan3 = "";
                                        else if (nhan33.equals("4")) nhan3 = "";
                                        else if (nhan33.equals("5")) nhan3 = "";
                                        else if (nhan33.equals("6")) nhan3 = "";
                                        else if (nhan33.equals("7")) nhan3 = "";
                                        else if (nhan33.equals("8")) nhan3 = "";
                                        else if (nhan33.equals("9")) nhan3 = "";
                                        else if (nhan33.equals("10")) nhan3 = "";
                                        else if (nhan33.equals("11")) nhan3 = "";
                                        else if (nhan33.equals("12")) nhan3 = "";
                                        else if (nhan33.equals("13")) nhan3 = "";
                                        else if (nhan33.equals("14")) nhan3 = "";
                                        else if (nhan33.equals("15")) nhan3 = "";
                                        else if (nhan33.equals("16")) nhan3 = "";
                                        else if (nhan33.equals("17")) nhan3 = "";
                                        else if (nhan33.equals("18")) nhan3 = "";
                                        else if (nhan33.equals("19")) nhan3 = "";
                                        else if (nhan33.equals("20")) nhan3 = "";
                                        else if (nhan33.equals("21")) nhan3 = "";

                                        if (nhan44.equals("0")) nhan4 = "Cây Táo";
                                        else if (nhan44.equals("1")) nhan4 = "";
                                        else if (nhan44.equals("2")) nhan4 = "";
                                        else if (nhan44.equals("3")) nhan4 = "";
                                        else if (nhan44.equals("4")) nhan4 = "";
                                        else if (nhan44.equals("5")) nhan4 = "";
                                        else if (nhan44.equals("6")) nhan4 = "";
                                        else if (nhan44.equals("7")) nhan4 = "";
                                        else if (nhan44.equals("8")) nhan4 = "";
                                        else if (nhan44.equals("9")) nhan4 = "";
                                        else if (nhan44.equals("10")) nhan4 = "";
                                        else if (nhan44.equals("11")) nhan4 = "";
                                        else if (nhan44.equals("12")) nhan4 = "";
                                        else if (nhan44.equals("13")) nhan4 = "";
                                        else if (nhan44.equals("14")) nhan4 = "";
                                        else if (nhan44.equals("15")) nhan4 = "";
                                        else if (nhan44.equals("16")) nhan4 = "";
                                        else if (nhan44.equals("17")) nhan4 = "";
                                        else if (nhan44.equals("18")) nhan4 = "";
                                        else if (nhan44.equals("19")) nhan4 = "";
                                        else if (nhan44.equals("20")) nhan4 = "";
                                        else if (nhan44.equals("21")) nhan4 = "";
*/

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

                                    intent.putExtra("check1",ch1);
                                    intent.putExtra("check2",ch2);
                                    intent.putExtra("check3",ch3);
                                    intent.putExtra("check4",ch4);

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