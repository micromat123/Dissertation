package com.example.GrowBuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlantList extends AppCompatActivity {


        private EditText editTxt;
        private Button add;
        private Button remove;
        private ListView list;
        private ArrayAdapter<String> adapter;
        private ArrayList<String> arrayList;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_plant_list);

            editTxt = (EditText) findViewById(R.id.taskName);
                                                                                                        // declaring page elements
            add = (Button) findViewById(R.id.btn_Add);
            remove = (Button) findViewById(R.id.btn_Remove);
            list = (ListView) findViewById(R.id.listView);
            arrayList = new ArrayList<String>();

            adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList);       // ideally, this would store the array list in a SQLite database

            list.setAdapter(adapter);

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    arrayList.add("Plant Name:"+editTxt.getText().toString());


                    adapter.notifyDataSetChanged();

                    Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_SHORT).show();      // toast to alert user of current action
                }

            });
            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    arrayList.remove(0);
                    Toast.makeText(getApplicationContext(),"Deleted", Toast.LENGTH_SHORT).show();

                }
            });
        }
    }

