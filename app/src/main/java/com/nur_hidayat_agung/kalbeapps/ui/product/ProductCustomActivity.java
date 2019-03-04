package com.nur_hidayat_agung.kalbeapps.ui.product;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.nur_hidayat_agung.kalbeapps.Model.Brand;
import com.nur_hidayat_agung.kalbeapps.Model.Product;
import com.nur_hidayat_agung.kalbeapps.R;
import com.nur_hidayat_agung.kalbeapps.adapter.db.DBAdapter;
import com.nur_hidayat_agung.kalbeapps.databinding.ActivityProductCustomBinding;
import com.nur_hidayat_agung.kalbeapps.util.Constant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductCustomActivity extends AppCompatActivity {

    private DBAdapter dbAdapter;
    private ActivityProductCustomBinding binding;
    private List<Brand> brandList = new ArrayList<>();
    private List<String> brandName = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_product_custom);
        dbAdapter = new DBAdapter(this,1);
        setSpinner();



        binding.btnAddProduct.setOnClickListener(v -> {
            Product product = new Product();
            product.setDtInserted(new Date());
            product.setIntBrandID(brandList.get(binding.spnBrand.getSelectedItemPosition()).getIntBrandID());
            product.setTxtProductName(binding.tieNamaProduct.getText().toString());
            product.setTxtProductCode(binding.tieProductCode.getText().toString());
            dbAdapter.persistProduct(product);
            Toast.makeText(this,"Insert Success", Toast.LENGTH_SHORT).show();
            binding.tieNamaProduct.setText("");
            binding.tieProductCode.setText("");
            binding.tvIdProduct.setText("");
        });


    }

    private void setSpinner() {
        brandList = dbAdapter.getBrand();
        for (int a = 0; a < brandList.size(); a++)
        {
            brandName.add(brandList.get(a).getTxtBrandName());
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, brandName);
        binding.spnBrand.setAdapter(dataAdapter);
    }
}
