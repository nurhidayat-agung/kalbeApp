package com.nur_hidayat_agung.kalbeapps.ui.sales;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.nur_hidayat_agung.kalbeapps.Model.Customer;
import com.nur_hidayat_agung.kalbeapps.Model.Pembelian;
import com.nur_hidayat_agung.kalbeapps.Model.Product;
import com.nur_hidayat_agung.kalbeapps.R;
import com.nur_hidayat_agung.kalbeapps.adapter.db.DBAdapter;
import com.nur_hidayat_agung.kalbeapps.databinding.ActivitySalesMenuBinding;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalesMenuActivity extends AppCompatActivity {

    private List<Product> productList = new ArrayList<>();
    private List<Customer> customerList =  new ArrayList<>();
    private List<String> prodNames = new ArrayList<>();
    private List<String> custNames = new ArrayList<>();
    private DBAdapter dbAdapter;
    private ActivitySalesMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sales_menu);
        dbAdapter = new DBAdapter(this,1);
        preLoadData();
        setSpinner();
        binding.btnAddSale.setOnClickListener(v -> {
            Pembelian sale = new Pembelian();
            sale.setIntProductID(productList.get(binding.spnProduct.getSelectedItemPosition()).getIntProductID());
            sale.setIntCustomerID(customerList.get(binding.spnCustomer.getSelectedItemPosition()).getIntCustomerID());
            sale.setIntQty(Integer.parseInt(binding.tieSaleQty.getText().toString()));
            sale.setDtSalesOrder(new Date());
            dbAdapter.persistSale(sale);
            Toast.makeText(this,"Insert Success", Toast.LENGTH_SHORT).show();

        });
    }

    private void preLoadData() {
        productList = dbAdapter.getProduct();
        customerList = dbAdapter.getCustomer();

        for (int a = 0; a < productList.size(); a++)
        {
            prodNames.add(productList.get(a).getTxtProductName()+"");
        }

        for (int a = 0; a < customerList.size(); a++)
        {
            custNames.add(customerList.get(a).getTxtCustomerName()+"");
        }
    }

    private void setSpinner() {
        if (prodNames != null){
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    R.layout.spinner_item_1, prodNames);
            binding.spnProduct.setAdapter(dataAdapter);
        }

        if (custNames != null){
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    R.layout.spinner_item_1, custNames);
            binding.spnCustomer.setAdapter(dataAdapter2);
        }
    }
}
