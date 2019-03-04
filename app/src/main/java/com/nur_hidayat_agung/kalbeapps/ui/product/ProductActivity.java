package com.nur_hidayat_agung.kalbeapps.ui.product;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.nur_hidayat_agung.kalbeapps.Model.Product;
import com.nur_hidayat_agung.kalbeapps.R;
import com.nur_hidayat_agung.kalbeapps.adapter.db.DBAdapter;
import com.nur_hidayat_agung.kalbeapps.adapter.recycleview.ProdRVAdapter;
import com.nur_hidayat_agung.kalbeapps.databinding.ActivityProductBinding;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    private ActivityProductBinding binding;
    private DBAdapter dbAdapter;
    private List<Product> productList = new ArrayList<>();
    private ProdRVAdapter prodRVAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_product);
        setRecyclerView();

        binding.btnAddProduct.setOnClickListener(v -> startActivity(new Intent(this, ProductCustomActivity.class)));

    }

    private void setRecyclerView()
    {
        dbAdapter = new DBAdapter(this,1);
        productList = dbAdapter.getProduct();
        layoutManager = new LinearLayoutManager(this);
        Log.i("logCust","isi Cust : " + productList.size());
        Log.i("logCust","product code : " + productList.get(0).getTxtProductCode());
        prodRVAdapter = new ProdRVAdapter(productList,this);
        binding.rvProduct.setLayoutManager(layoutManager);
        binding.rvProduct.setAdapter(prodRVAdapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setRecyclerView();
    }
}
