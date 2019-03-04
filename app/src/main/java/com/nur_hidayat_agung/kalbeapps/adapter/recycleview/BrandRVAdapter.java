package com.nur_hidayat_agung.kalbeapps.adapter.recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nur_hidayat_agung.kalbeapps.Model.Brand;
import com.nur_hidayat_agung.kalbeapps.adapter.db.DBAdapter;
import com.nur_hidayat_agung.kalbeapps.databinding.ItemBrandList4Binding;

import java.util.ArrayList;
import java.util.List;

public class BrandRVAdapter extends RecyclerView.Adapter<BrandRVAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<Brand> brandList = new ArrayList<>();
    private DBAdapter dbAdapter;
    private ItemBrandList4Binding binding;

    public BrandRVAdapter(Context context, List<Brand> brands, DBAdapter dbAdapter) {
        this.context = context;
        this.brandList = brands;
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
        Brand brand = brandList.get(i);
        myViewHolder.bind(brand);
    }

    @Override
    public int getItemCount() {
        return brandList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        private final ItemBrandList4Binding binding;

        public MyViewHolder(ItemBrandList4Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Brand brand){
            binding.tvName.setText(brand.getTxtBrandName());
            binding.tvId.setText( brand.getIntBrandID() + "");
            binding.executePendingBindings();
        }
    }

}
