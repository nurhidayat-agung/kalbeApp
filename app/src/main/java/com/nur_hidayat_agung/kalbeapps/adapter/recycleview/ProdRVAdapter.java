package com.nur_hidayat_agung.kalbeapps.adapter.recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nur_hidayat_agung.kalbeapps.Model.Product;
import com.nur_hidayat_agung.kalbeapps.adapter.db.DBAdapter;
import com.nur_hidayat_agung.kalbeapps.databinding.ItemBrandList4Binding;

import java.util.List;

public class ProdRVAdapter extends RecyclerView.Adapter<ProdRVAdapter.MyViewHolder>{

    private RecyclerView.LayoutManager layoutManager;
    private List<Product> products;
    private Context context;
    private DBAdapter dbAdapter;
    private ItemBrandList4Binding binding;
    private LayoutInflater inflater;

    public ProdRVAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
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
        Product product = products.get(i);
        myViewHolder.bind(product);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private final ItemBrandList4Binding binding;

        private MyViewHolder(ItemBrandList4Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Product product){
            binding.tvName.setText(product.getTxtProductName());
            binding.tvId.setText( product.getIntProductID() + "");
            binding.tvGender.setText(product.getTxtProductCode());
            binding.tvAddress.setText(product.getBrandName());
            binding.executePendingBindings();
        }
    }
}
