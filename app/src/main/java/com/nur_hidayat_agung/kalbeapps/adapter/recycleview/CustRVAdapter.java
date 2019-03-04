package com.nur_hidayat_agung.kalbeapps.adapter.recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nur_hidayat_agung.kalbeapps.Model.Customer;
import com.nur_hidayat_agung.kalbeapps.adapter.db.DBAdapter;
import com.nur_hidayat_agung.kalbeapps.databinding.ItemBrandList4Binding;
import com.nur_hidayat_agung.kalbeapps.util.Constant;

import java.util.ArrayList;
import java.util.List;

public class CustRVAdapter extends RecyclerView.Adapter<CustRVAdapter.MyViewHolder>{

    private LayoutInflater inflater;
    private Context context;
    private List<Customer> customerList = new ArrayList<>();
    private DBAdapter dbAdapter;
    private ItemBrandList4Binding binding;

    public CustRVAdapter(Context context, List<Customer> customerList) {
        this.context = context;
        this.dbAdapter = new DBAdapter(context,1);
        this.customerList = customerList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflater = LayoutInflater.from(viewGroup.getContext());
        binding = ItemBrandList4Binding.inflate(inflater, viewGroup, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Customer customer = customerList.get(i);
        myViewHolder.bind(customer);
    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private final ItemBrandList4Binding binding;

        public MyViewHolder(ItemBrandList4Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Customer customer){
            binding.tvName.setText(customer.getTxtCustomerName());
            binding.tvId.setText( customer.getIntCustomerID() + "");
            binding.tvGender.setText(Constant.getStringGender(customer.isBitGender()));
            binding.tvAddress.setText(customer.getTxtCustomerAddress());
            binding.executePendingBindings();
        }
    }
}
