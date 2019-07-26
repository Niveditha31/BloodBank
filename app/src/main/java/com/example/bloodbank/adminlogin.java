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

public class adminlogin extends AppCompatActivity {
    EditText emai,pass;
    Button login;

    private static final String url="http://192.168.43.224/proj/admin.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        emai=findViewById(R.id.email2);
        pass=findViewById(R.id.password2);
        login=findViewById(R.id.login2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email=emai.getText().toString();
                final String password=pass.getText().toString();


                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                JSONObject jsonResponse;
                                try
                                {
                                    jsonResponse = new JSONObject(response);
                                    String email=jsonResponse.getString("email");
                                    //Toast.makeText(getApplicationContext(),jsonResponse.getString("message"),Toast.LENGTH_LONG).show();
//                                    if(jsonResponse.getString("message")=="success")
//                                    {
                                    Intent i=new Intent(getApplicationContext(),admin.class);
                                    i.putExtra("email", email);
                                    startActivity(i);
//                                    }
                                }
                                catch (JSONException e)
                                {
                                    Toast.makeText(adminlogin.this,"invlaid credentials",Toast.LENGTH_SHORT).show();
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {




                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //  loading.dismiss();
                                Toast.makeText(adminlogin.this,error.toString(),Toast.LENGTH_LONG).show();
                            }
                        })
                {
                    @Override
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String, String>();
                        params.put("email", email);
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
