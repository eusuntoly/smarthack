package com.hackovfl.foodomeeter;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
//    private List<Product> products = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
//        recyclerView = (RecyclerView) findViewById(R.id.recycler_view2);
        TextView textbox = findViewById(R.id.textbox);


        //use a linear layout manager
        layoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());


        String email = getUserEmail();
        TextView em = findViewById(R.id.name_product_history);
        List<Product> products = new ArrayList<>();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("products");
        reference.orderByChild("email").equalTo(email).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot datas : dataSnapshot.getChildren()) {
                    String name = datas.child("name").getValue().toString();
                    String score = datas.child("score").getValue().toString();
                    Product product = new Product(name, score, null, email);
                    products.add(product);
                    textbox.append(product.toString());

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
//specifing an adapter
        System.out.println("`````````````````````");
        System.out.println(products.toString());
//        mAdapter = new HistoryRecordsRecyclerViewAdapter(products);
//        recyclerView.setAdapter(mAdapter);
//        textbox.setText(products.toString());
    }

    private String getUserEmail() {
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        //  System.out.println(acct.getEmail());
        if (acct != null) {
            return acct.getEmail();
        }
        return "";
    }


}
