package com.hackovfl.foodomeeter;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScoreActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Product product;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //use a linear layout manager
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        product = (Product) getIntent().getSerializableExtra("product");
        List<Ingredient> ingredientList = product.getIngredients();
        TextView prodScore = findViewById(R.id.score);
        TextView prodName = findViewById(R.id.numeprodus);
        prodScore.setText("Score: " + product.getScore());
        prodName.setText(product.getName());


//specifing an adapter
        mAdapter = new IngredientRecyclerViewAdapter(ingredientList);
        recyclerView.setAdapter(mAdapter);

    }


}
