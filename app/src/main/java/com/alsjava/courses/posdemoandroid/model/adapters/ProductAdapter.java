package com.alsjava.courses.posdemoandroid.model.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.alsjava.courses.posdemoandroid.R;
import com.alsjava.courses.posdemoandroid.model.api.ProductAPI;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aluis on 11/9/19.
 */
public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Activity activity;
    private final List<ProductAPI> data = new ArrayList<>();

    public ProductAdapter(@NonNull Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_product, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProductViewHolder lotteryViewHolder = (ProductViewHolder) holder;
        lotteryViewHolder.currentItem = data.get(position);
        lotteryViewHolder.fillContent();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void loadData(List<ProductAPI> products) {
        data.clear();
        if (products != null) {
            data.addAll(products);
        }
    }

    private class ProductViewHolder extends RecyclerView.ViewHolder {

        private AppCompatImageView ivImage;
        private AppCompatTextView tvName;
        private AppCompatTextView tvPrice;

        private ProductAPI currentItem;

        ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }

        void fillContent() {
            Glide.with(activity).load(currentItem.getImage()).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(R.drawable.ic_file_download_black_24dp).into(ivImage);
            tvName.setText(currentItem.getName());
            tvPrice.setText(String.format("%s", currentItem.getPrice()));
        }
    }
}
