package com.nur_hidayat_agung.kalbeapps.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nur_hidayat_agung.kalbeapps.R;
import com.nur_hidayat_agung.kalbeapps.databinding.ActivityMain2Binding;
import com.nur_hidayat_agung.kalbeapps.ui.brand.BrandActivity;
import com.nur_hidayat_agung.kalbeapps.ui.customer.CustomerActivity;
import com.nur_hidayat_agung.kalbeapps.ui.product.ProductActivity;
import com.nur_hidayat_agung.kalbeapps.ui.sales.SellingActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);

        binding.btnBarang.setOnClickListener(v -> {startActivity(new Intent(this, ProductActivity.class));});
        binding.btnCustomer.setOnClickListener(v -> {startActivity(new Intent(this, CustomerActivity.class));});
        binding.btnSelling.setOnClickListener(v -> {startActivity(new Intent(this, SellingActivity.class));});
        binding.btnBrand.setOnClickListener(v -> {startActivity(new Intent(this, BrandActivity.class));});

    }
}
