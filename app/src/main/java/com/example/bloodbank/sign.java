package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class sign extends AppCompatActivity {
    EditText name, email3,password3;
    Spinner spinner;
    Button signup2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        name=findViewById(R.id.name);
        email3=findViewById(R.id.email3);
        password3=findViewById(R.id.password3);
        spinner=findViewById(R.id.spinner);
        signup2=findViewById(R.id.signup2);

      //  addListenerOnSpinnerItemSelection();
        signup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(getApplicationContext(),userlogin.class);
                startActivity(intent2);

             /*   Toast.makeText(com.example.bloodbank.signup2.this,
                        "OnClickListener : " +
                                "\nSpinner  : "+ String.valueOf(spinner.getSelectedItem())
                               ,
                        Toast.LENGTH_SHORT).show();*/
            }
        });

    }

   /* private void addListenerOnSpinnerItemSelection() {
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) new CustomOnItemSelectedListener());
    }*/
}


