package com.hackovfl.foodomeeter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HistoryRecordsRecyclerViewAdapter extends RecyclerView.Adapter<HistoryRecordsRecyclerViewAdapter.ViewHolder> {
    private List<Product> products;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView score;
        private TextView name;
        private View mView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            score = (TextView) view.findViewById(R.id.score_history);
            name = (TextView) view.findViewById(R.id.name_history);
        }
    }
    public HistoryRecordsRecyclerViewAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public HistoryRecordsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_record_layout, parent, false);
        return new HistoryRecordsRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryRecordsRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.score.setText(products.get(position).getScore());
        holder.name.setText(products.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

}
