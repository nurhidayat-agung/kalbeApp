package com.nur_hidayat_agung.kalbeapps.adapter.recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nur_hidayat_agung.kalbeapps.Model.Pembelian;
import com.nur_hidayat_agung.kalbeapps.adapter.db.DBAdapter;
import com.nur_hidayat_agung.kalbeapps.databinding.ItemBrandList4Binding;

import java.util.List;

public class SaleRVAdapter extends RecyclerView.Adapter<SaleRVAdapter.MyViewHolder>{

    private Context context;
    private DBAdapter dbAdapter;
    private List<Pembelian> salesList;
    private LayoutInflater inflater;
    private ItemBrandList4Binding binding;
    private RecyclerView.LayoutManager layoutManager;

    public SaleRVAdapter(Context context, List<Pembelian> salesList) {
        this.context = context;
        this.salesList = salesList;
        this.dbAdapter = new DBAdapter(context,1);
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
        Pembelian sale = salesList.get(i);
        myViewHolder.bind(sale);
    }

    @Override
    public int getItemCount() {
        return salesList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        private final ItemBrandList4Binding binding;

        private MyViewHolder(ItemBrandList4Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Pembelian sale){
            binding.tvName.setText(sale.getProdName()+"");
            binding.tvId.setText( sale.getIntSalesOrderID() + "");
            binding.tvGender.setText(sale.getCustName());
            binding.tvAddress.setText(sale.getIntQty()+"");
            binding.executePendingBindings();
        }
    }
}
