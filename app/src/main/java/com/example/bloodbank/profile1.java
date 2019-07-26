package com.example.bloodbank;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class profile1 extends Fragment {
    TextView name,emai,bg,phone,cit;

    private static final String url="http://192.168.43.224/proj/profile.php";
    public static ArrayList<detailsmodel> detaillist=new ArrayList<detailsmodel>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.profile,container,false);
        name= view.findViewById(R.id.name1);
        emai=view.findViewById(R.id.email4);
        bg=view.findViewById(R.id.bg);
        phone=view.findViewById(R.id.phone);
        cit=view.findViewById(R.id.city);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                detaillist.clear();
                try {
                    JSONObject jsonresponse;
                    jsonresponse = new JSONObject(response);
                    JSONArray jsonArray = jsonresponse.getJSONArray("product");
                    for (int t = 0; t < jsonArray.length(); t++) {
                        JSONObject object = jsonArray.getJSONObject(t);
                        detailsmodel table = new detailsmodel();
                        table.setName(object.getString("fullname"));
                        table.setEmail(object.getString("email"));
                        table.setBloodgroup(object.getString("bloodgroup"));
                        table.setPhoneno(object.getString("phoneno"));
                        table.setCity(object.getString("city"));
                        detaillist.add(table);
                    }/*
                           JSONObject jsonObject = new JSONObject(response);
                            String data = jsonObject.getString("name");
                            String data = jsonObject.getString("message");
                            Toast.makeText(getApplicationContext(),data,Toast.LENGTH_LONG).show();*/
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < detaillist.size(); i++) {
                    name.setText(name.getText().toString() + "\n" + detaillist.get(i).getName());
                    emai.setText(emai.getText().toString() + "\n" + detaillist.get(i).getEmail());
                    bg.setText(bg.getText().toString() + "\n" + detaillist.get(i).getBloodgroup());
                    phone.setText(phone.getText().toString() + "\n" + detaillist.get(i).getPhoneno());
                    cit.setText(cit.getText().toString() + "\n" + detaillist.get(i).getCity());

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_LONG).show();

            }
        }) {

              /*  @Override
                    protected Map<String,String> getParams() throws AuthFailureError {
                        Map<String,String> params = new HashMap<>();
                        params.put("email",DemoClass.email);
                        return params;
                    }*/


        };
        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);


        /*name.setText(DemoClass.fullname);
        emai.setText(DemoClass.email);
        bg.setText(DemoClass.bloodgroup);
        phone.setText(DemoClass.phoneno);
        cit.setText(DemoClass.city);
*/
        return  view;




    }
}
