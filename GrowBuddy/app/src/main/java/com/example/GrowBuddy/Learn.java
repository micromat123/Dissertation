package com.example.GrowBuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Learn extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {        //Buttons to redirect user to other resources
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
    }
    public void plantCare(View view){
        Intent i1 = (new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ambius.com/learn/online/top-tips/")));
        startActivity(i1);

    }
    public void equipment(View view){
        Intent i2 = (new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.suttons.co.uk/Gardening/Garden-Equipment/")));
        startActivity(i2);

    }
    public void buy (View view){
        Intent i3 = (new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gardens4you.co.uk/")));
        startActivity(i3);

    }
}