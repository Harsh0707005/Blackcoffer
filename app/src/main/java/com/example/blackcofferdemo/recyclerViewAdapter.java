package com.example.blackcofferdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.ViewHolder> {

    private List<List<String>> dataList;

    public recyclerViewAdapter(List<List<String>> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<String> data = dataList.get(position);
        // Set data to the views in the CardView
        holder.name.setText(data.get(0));
        holder.location.setText(data.get(1));
        holder.distance.setText(data.get(2));
        holder.interests.setText(data.get(3));
        holder.bio.setText(data.get(4));
        // Set other data as needed

        // Add any other data binding logic here
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Define your CardView views here
        TextView name, location, distance, interests, bio;
        // Add other views as needed

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize your views here
            name = itemView.findViewById(R.id.name);
            location = itemView.findViewById(R.id.location);
            distance = itemView.findViewById(R.id.distance);
            interests = itemView.findViewById(R.id.interests);
            bio = itemView.findViewById(R.id.bio);
            // Initialize other views as needed
        }
    }
}
