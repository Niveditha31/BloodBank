package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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


public class userlogin extends AppCompatActivity {
    Button Signup,login;
    EditText emai;
    EditText pass;


    private static final String url="http://192.168.43.224/proj/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);
        emai=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        Signup=findViewById(R.id.signup);
        login=findViewById(R.id.login);
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(getApplicationContext(), sign.class);
                startActivity(intent4);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               DemoClass.email=emai.getText().toString();
                final String password=pass.getText().toString();
                


                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                JSONObject jsonResponse;
                                try
                                {
                                    jsonResponse = new JSONObject(response);
                                    DemoClass.email=jsonResponse.getString("email");
                                    //Toast.makeText(getApplicationContext(),jsonResponse.getString("message"),Toast.LENGTH_LONG).show();
//                                    if(jsonResponse.getString("message")=="success")
//                                    {
                                    Intent i=new Intent(getApplicationContext(),choose.class);
                                    i.putExtra("email", DemoClass.email);
                                    startActivity(i);
//                                    }
                                }
                                catch (JSONException e)
                                {
                                    Toast.makeText(userlogin.this,"invlaid credentials",Toast.LENGTH_SHORT).show();
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {




                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //  loading.dismiss();
                                Toast.makeText(userlogin.this,error.toString(),Toast.LENGTH_LONG).show();
                            }
                        })
                {
                    @Override
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String, String>();
                        params.put("email", DemoClass.email);
                        params.put("password",password);
                        return params;
                    }

                };

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);
            }
        });
               /*Intent intent5=new Intent(getApplicationContext(),choose.class);
                startActivity(intent5);*/



    }
}
