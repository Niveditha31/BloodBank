package com.example.bloodbank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class accept_or_donate extends Fragment {

    Button accepter, donor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
       View view =inflater.inflate(R.layout.accept__or__donate,container,false);
       accepter= view.findViewById(R.id.acceptor);
       accepter.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(getContext(),"Hello Accepter", Toast.LENGTH_LONG).show();
           }
       });
       return view;
    }
}
