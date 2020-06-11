package com.example.GrowBuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    private Button learn;
    private Button meditate;
    private Button task;
    private Button plantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        learn = (Button) findViewById(R.id.btn_Learn);
        meditate = (Button) findViewById(R.id.btn_Meditate);
        task = (Button) findViewById(R.id.btn_Tasks);
        plantList = (Button) findViewById(R.id.btn_plantList);
                                                                                //Buttons to navigate users to other activities
        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLearn();
            }

        });


        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTask();
            }
        });

        meditate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMeditate();
            }
        });

        plantList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPlantList();
            }
        });
    }
    public void openLearn(){

        Intent iLearn = new Intent(this,Learn.class);
        startActivity(iLearn);
    }

    public void openMeditate(){

        Intent iMeditate = new Intent(this,Meditation.class);
        startActivity(iMeditate);
    }
    public void openTask(){

        Intent iTask = new Intent(this,Tasks.class);
        startActivity(iTask);
    }
    public void openPlantList(){

        Intent iPlantList = new Intent(this,PlantList.class);
        startActivity(iPlantList);
    }

}