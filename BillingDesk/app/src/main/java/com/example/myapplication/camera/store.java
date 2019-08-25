package com.example.myapplication.camera;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class store extends MainActivity {
    private ArrayList<Item> mexampleList;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button buttonSave;
    private EditText editTextSave;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store);

        //getting string from main activity

        Bundle bundle = getIntent().getExtras();
        String amout = bundle.getString(number);
        amt = amout;
        createExampleList();
        buildRecyclerView();

        buttonSave=findViewById(R.id.button_save);
        editTextSave=findViewById(R.id.edittext_insert);

        //inserting data to recyclerview

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position =Integer.parseInt(editTextSave.getText().toString());
                insertItem(position);
            }
        });





    }
    public String amt;



    public void insertItem(int position){
        mexampleList.add(new Item("Bill"+" "+position,"amount"+" "+ amt));
        mAdapter.notifyItemInserted(position);
    }

    //adding in recyclerView

    public void createExampleList(){
        mexampleList = new ArrayList<>();
    }
    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter= new Adapter(mexampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }


}
