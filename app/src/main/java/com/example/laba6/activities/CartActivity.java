package com.example.laba6.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.laba6.other.DBHelper;
import com.example.laba6.other.Helper;
import com.example.laba6.other.Model;
import com.example.laba6.R;
import com.example.laba6.other.ProductModel;
import com.example.laba6.other.Singleton;
import com.example.laba6.adapters.CartAdapter;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    Helper db = new Helper(this);
    List<ProductModel>productModels;
    Button buy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        productModels = db.getAllProducts();
        recyclerView=(RecyclerView)findViewById(R.id.cartRecycleView);
        LinearLayoutManager linearLayout=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayout);
        CartAdapter cartAdapter=new CartAdapter(CartActivity.this, productModels);
        recyclerView.setAdapter(cartAdapter);
        buy=(Button)findViewById(R.id.butProduct);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Покупка совершена", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent=new Intent(CartActivity.this, MainActivity.class);
                db.deleteAll();
                startActivity(intent);
            }
        });
    }
}
