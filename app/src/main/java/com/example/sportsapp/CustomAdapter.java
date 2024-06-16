package com.example.sportsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
//this  class is an adapter class
//it's a brigde between the your data (List<Sports>) and the recyclerview +cardView
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.SportsViewHolder>{
    private List<Sports> sportList;
    public static ItemClickListner ClickListner;

    public CustomAdapter(List<Sports> sportList) {
        this.sportList = sportList;
    }

    @NonNull
    @Override
    public SportsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating the layout for each item in the recycler view
         View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_layout,parent,false);
         return new SportsViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull SportsViewHolder holder, int position) {
        Sports sport =sportList.get(position);
        holder.textView.setText(sport.sportName);
        holder.imageView.setImageResource(sport.sportImg);
    }

    @Override
    public int getItemCount() {
        return sportList.size();
    }

    public void setClickListener(ItemClickListner myClickListner) {
        this.ClickListner = myClickListner;

    }


    public static class SportsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //hold the reference to the view with the item layout
        TextView textView;
        ImageView imageView;

        public SportsViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(ClickListner!=null){
                ClickListner.onClick(v,getAdapterPosition());
            }
        }
    }

}
