package com.nur_hidayat_agung.kalbeapps.ui.customer;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.nur_hidayat_agung.kalbeapps.Model.Customer;
import com.nur_hidayat_agung.kalbeapps.R;
import com.nur_hidayat_agung.kalbeapps.adapter.db.DBAdapter;
import com.nur_hidayat_agung.kalbeapps.adapter.recycleview.BrandRVAdapter;
import com.nur_hidayat_agung.kalbeapps.adapter.recycleview.CustRVAdapter;
import com.nur_hidayat_agung.kalbeapps.databinding.ActivityCustomerBinding;

import java.util.ArrayList;
import java.util.List;

public class CustomerActivity extends AppCompatActivity {

    private ActivityCustomerBinding binding;
    private DBAdapter dbAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Customer> customerList = new ArrayList<>();
    private CustRVAdapter custRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_customer);
        dbAdapter = new DBAdapter(this,1);
        setRecyclerView();

        binding.btmAddCustomer.setOnClickListener(v -> {startActivity(new Intent(this,CustomCustomer.class));});
    }

    private void setRecyclerView()
    {
        customerList = dbAdapter.getCustomer();
        layoutManager = new LinearLayoutManager(this);
        Log.i("logCust","isi Cust : " + customerList.size());
        custRVAdapter = new CustRVAdapter(this,customerList);
        binding.rvCustomer.setLayoutManager(layoutManager);
        binding.rvCustomer.setAdapter(custRVAdapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("logCust", "this is on restart");
        setRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("logCust", "this is on resume");
    }
}
