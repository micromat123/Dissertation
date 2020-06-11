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

public class Tasks extends AppCompatActivity {
    private EditText editTxt;
    private Button add;
    private Button remove;
    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        editTxt = (EditText) findViewById(R.id.taskName);

        add = (Button) findViewById(R.id.btn_Add);
        remove = (Button) findViewById(R.id.btn_Remove);
        list = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList);

        list.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                arrayList.add("Task Name:"+editTxt.getText().toString());


                adapter.notifyDataSetChanged();

                Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_SHORT).show();
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

