package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
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

public class Donor extends AppCompatActivity {
    CalendarView calender;
    EditText uni;
    Button submit;
    String date;




    private static final String url="http://192.168.43.224/proj/donor.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor);
        calender=findViewById(R.id.calendarView);
        uni=findViewById(R.id.lit);
        submit=findViewById(R.id.submit);
        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                date=i+"/"+(i1+1)+"/"+i2;

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String unit=uni.getText().toString();



                if (date.equals("") || unit.equals("")) {
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
                                      /*  Bundle bundle=getIntent().getExtras();
                                        Strinemail=bundle.getString("email");*/
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
                            params.put("email",DemoClass.email);
                            params.put("date", date);
                            params.put("unit", unit);

                            return params;
                        }

                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);
                }


            }
        });




    }
}
