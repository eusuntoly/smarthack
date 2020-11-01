package com.hackovfl.foodomeeter;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

public class IngredientRecyclerViewAdapter extends RecyclerView.Adapter<IngredientRecyclerViewAdapter.ViewHolder> {

    private  List<Ingredient> ingredients;
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView score;
        private TextView name;
        private TextView description;
        private View mView;
        public ViewHolder(View view) {
            super(view);
            mView = view;
            score = (TextView) view.findViewById(R.id.score);
            description = (TextView) view.findViewById(R.id.description);
            name = (TextView) view.findViewById(R.id.name);
        }

    }
    public IngredientRecyclerViewAdapter(List<Ingredient> items) {
        ingredients = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ingredient_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
      holder.score.setText(ingredients.get(position).getScore());
      holder.name.setText(ingredients.get(position).getName());
      holder.description.setText(ingredients.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

}