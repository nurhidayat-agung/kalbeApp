package com.nur_hidayat_agung.kalbeapps.ui.brand;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;

import com.nur_hidayat_agung.kalbeapps.Model.Brand;
import com.nur_hidayat_agung.kalbeapps.R;
import com.nur_hidayat_agung.kalbeapps.adapter.db.DBAdapter;
import com.nur_hidayat_agung.kalbeapps.adapter.recycleview.BrandRVAdapter;
import com.nur_hidayat_agung.kalbeapps.databinding.ActivityBrandBinding;
import com.nur_hidayat_agung.kalbeapps.databinding.PopUpBrandBinding;

import java.util.ArrayList;
import java.util.List;

public class BrandActivity extends AppCompatActivity {

    private ActivityBrandBinding binding;
    private Dialog addBrandDialog;
    private DBAdapter dbAdapter;
    private BrandRVAdapter brandRVAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Brand> brandList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_brand);
        dbAdapter = new DBAdapter(this,1);
        brandList = dbAdapter.getBrand();

        brandRVAdapter = new BrandRVAdapter(this,dbAdapter.getBrand(),dbAdapter);
        setRecyclerView();



        binding.btnAddBrand.setOnClickListener(v -> {

            addBrandDialog = new Dialog(this);
            addBrandDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            PopUpBrandBinding binding2 = PopUpBrandBinding.inflate(LayoutInflater.from(this), null);
            addBrandDialog.setContentView(binding2.getRoot());
            Window window = addBrandDialog.getWindow();
            WindowManager.LayoutParams params = window.getAttributes();
            params.gravity = Gravity.CENTER;
            addBrandDialog.setCancelable(true);
            addBrandDialog.setCanceledOnTouchOutside(true);

            binding2.btnPopUpAddBrand.setOnClickListener(v1 -> {
                dbAdapter.persistBrand(new Brand(binding2.edtBrand.getText().toString()));
                brandList = dbAdapter.getBrand();
                brandRVAdapter.notifyDataSetChanged();
                setRecyclerView();
                addBrandDialog.dismiss();
            });


            addBrandDialog.show();


        });


    }

    private void setRecyclerView() {
        layoutManager = new LinearLayoutManager(this);
        Log.i("logBrand","isi brand : " + brandList.size());
        brandRVAdapter = new BrandRVAdapter(this,brandList,dbAdapter);
        binding.rvBrand.setLayoutManager(layoutManager);
        binding.rvBrand.setAdapter(brandRVAdapter);
    }


}
