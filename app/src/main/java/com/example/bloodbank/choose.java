package com.example.bloodbank;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bloodbank.ui.main.SectionsPagerAdapter;

public class choose extends AppCompatActivity {
    Button acceptor,donor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


        //acceptor=view.findViewById(R.id.acceptor);
       // donor=view.findViewById(R.id.donor);

       //Toast.makeText(getApplicationContext(), acceptor.toString(), Toast.LENGTH_LONG).show();
/*
       acceptor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getApplicationContext(),acceptor.class);
                startActivity(i1);
            }
        });
        donor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(getApplicationContext(),Donor.class);
                startActivity(i2);
            }
        });

*/
    }


}