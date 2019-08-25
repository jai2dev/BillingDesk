package com.example.myapplication.camera;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

//creating adapter class to fill data in UI component
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<Item> mexampleList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
         public TextView mTextView1;
         public TextView mTextView2;
        public ViewHolder(View itemView) {
            super(itemView);
            mTextView1=itemView.findViewById(R.id.text_view1);
            mTextView2=itemView.findViewById(R.id.text_view2);
        }
    }
     //creating an array list to store the data
    public Adapter(ArrayList<Item> exampleList){
        mexampleList=exampleList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent, false);
        ViewHolder evh= new ViewHolder(v);
        return evh;

    }
    //settting textviews value

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       Item currentItem=mexampleList.get(position);

       holder.mTextView1.setText(currentItem.getmText1());
       holder.mTextView2.setText(currentItem.getmText2());
    }

    @Override
    public int getItemCount() {
        return mexampleList.size();
    }
}
