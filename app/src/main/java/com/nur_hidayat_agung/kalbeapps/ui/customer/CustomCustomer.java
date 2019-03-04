package com.nur_hidayat_agung.kalbeapps.ui.customer;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.nur_hidayat_agung.kalbeapps.Model.Customer;
import com.nur_hidayat_agung.kalbeapps.R;
import com.nur_hidayat_agung.kalbeapps.adapter.db.DBAdapter;
import com.nur_hidayat_agung.kalbeapps.databinding.ActivityCustomCustomerBinding;
import com.nur_hidayat_agung.kalbeapps.util.Constant;

import java.util.Date;

public class CustomCustomer extends AppCompatActivity {

    private ActivityCustomCustomerBinding binding;
    private DBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_custom_customer);
        dbAdapter = new DBAdapter(this,1);

        binding.btnAddCust.setOnClickListener(v -> {
            Customer customer = new Customer();
            customer.setTxtCustomerName(binding.tieNamaCustomer.getText().toString());
            customer.setTxtCustomerAddress(binding.tieAdrCustomer.getText().toString());
            customer.setInserted(new Date());
            customer.setBitGender(Constant.getBitGender(binding.spnGender.getSelectedItem().toString()));
            dbAdapter.persistCust(customer);
            Toast.makeText(this,"insert success", Toast.LENGTH_SHORT).show();
            binding.tvIdCustomer.setText("");
            binding.tieNamaCustomer.setText("");
            binding.tieAdrCustomer.setText("");
            binding.spnGender.setSelection(-1);
        });
    }


}
