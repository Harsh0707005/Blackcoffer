package com.example.blackcofferdemo;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
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
        holder.name.setText(data.get(0));
        String[] words = data.get(0).split(" ");

        // Extract the first character of each word
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(word.charAt(0));
            }
        }
        holder.initials.setText(result);

        holder.location.setText(data.get(1));
        holder.distance.setText(data.get(2));
        holder.progressBar.setProgress(30);
        try {
            holder.progressBar.setProgress(Integer.parseInt(data.get(3)));
        }catch (Exception e){
            Log.d("harsh", e.getMessage());
        }
        holder.interests.setText(data.get(4));
        holder.bio.setText(data.get(5));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, location, distance, interests, bio, initials;
        ProgressBar progressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            initials = itemView.findViewById(R.id.initials);
            location = itemView.findViewById(R.id.location);
            distance = itemView.findViewById(R.id.distance);
            progressBar = itemView.findViewById(R.id.progressBar);
            interests = itemView.findViewById(R.id.interests);
            bio = itemView.findViewById(R.id.bio);
        }
    }
}
