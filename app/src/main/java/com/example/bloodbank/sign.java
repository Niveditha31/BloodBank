package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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



public class sign extends AppCompatActivity {
    EditText name, email3, password3, phone;
    Spinner bg, cit;
    Button signup2;

    private static final String url = "http://192.168.43.224/proj/reg.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        name = findViewById(R.id.name);
        email3 = findViewById(R.id.email3);
        password3 = findViewById(R.id.password3);
        bg = findViewById(R.id.spinner);
        cit = findViewById(R.id.spinner4);
        signup2 = findViewById(R.id.signup2);
        phone=findViewById(R.id.phn);


        signup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DemoClass.fullname = name.getText().toString();
               DemoClass.email= email3.getText().toString();
               final String password = password3.getText().toString();
                DemoClass.bloodgroup = bg.getSelectedItem().toString();
                DemoClass.phoneno = phone.getText().toString();
                DemoClass.city = cit.getSelectedItem().toString();

                if (DemoClass.email.equals("") || password.equals("") || DemoClass.fullname.equals("") || DemoClass.bloodgroup.equals("") || DemoClass.phoneno.equals("") || DemoClass.city.equals("") ) {
                    Toast.makeText(getApplicationContext(), "invlaid credentials", Toast.LENGTH_SHORT).show();
                } else {

                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {

                                    JSONObject jsonResponse;
                                    try {
                                        jsonResponse = new JSONObject(response);
                                        Toast.makeText(getApplicationContext(), jsonResponse.getString("message"), Toast.LENGTH_LONG).show();
                                    } catch (JSONException e) {
                                        Toast.makeText(getApplicationContext(), "invlaid credentials", Toast.LENGTH_SHORT).show();
                                        e.printStackTrace();
                                    }
                                }
                            },
                            new Response.ErrorListener() {


                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    //  loading.dismiss();
                                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                                }
                            }) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("fullname", DemoClass.fullname);
                            params.put("email", DemoClass.email);
                            params.put("password", password);
                            params.put("bloodgroup", DemoClass.bloodgroup);
                            params.put("phoneno", DemoClass.phoneno);
                            params.put("city", DemoClass.city);
                            return params;
                        }

                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);
                }
                /*SharedPreferences preferences=getSharedPreferences("email",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("email_id",email);
                editor.commit();*/
                Intent intent=new Intent(getApplicationContext(),userlogin.class);
                intent.putExtra("fullname",DemoClass.fullname);
                intent.putExtra("bloodgroup",DemoClass.bloodgroup);
                intent.putExtra("phoneno",DemoClass.phoneno);
                intent.putExtra("city",DemoClass.city);
                startActivity(intent);

            }
        });



    }
}

