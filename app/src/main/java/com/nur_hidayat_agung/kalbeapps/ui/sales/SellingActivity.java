package com.nur_hidayat_agung.kalbeapps.ui.sales;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.nur_hidayat_agung.kalbeapps.Model.Pembelian;
import com.nur_hidayat_agung.kalbeapps.R;
import com.nur_hidayat_agung.kalbeapps.adapter.db.DBAdapter;
import com.nur_hidayat_agung.kalbeapps.adapter.recycleview.SaleRVAdapter;
import com.nur_hidayat_agung.kalbeapps.databinding.ActivitySellingBinding;

import java.util.ArrayList;
import java.util.List;

public class SellingActivity extends AppCompatActivity {

    private ActivitySellingBinding binding;
    private DBAdapter dbAdapter;
    private List<Pembelian> salesList = new ArrayList<>();
    private SaleRVAdapter saleRVAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_selling);
        binding.btnAddSales.setOnClickListener(v -> startActivity(new Intent(this, SalesMenuActivity.class)));
        setRecyclerView();

    }

    private void setRecyclerView()
    {
        dbAdapter = new DBAdapter(this,1);
        salesList = dbAdapter.getSales();
        layoutManager = new LinearLayoutManager(this);
        Log.i("logCust","isi Sales : " + salesList.size());
        saleRVAdapter = new SaleRVAdapter(this,salesList);
        binding.rvSales.setLayoutManager(layoutManager);
        binding.rvSales.setAdapter(saleRVAdapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setRecyclerView();
    }
}
