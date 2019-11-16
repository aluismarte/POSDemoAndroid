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
import com.alsjava.courses.posdemoandroid.model.CallBack;
import com.alsjava.courses.posdemoandroid.model.api.BuyAPI;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by aluis on 11/16/19.
 */
public class BuyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Activity activity;
    private CallBack<BuyAPI> callBack;
    private final List<BuyAPI> data;

    public BuyAdapter(@NonNull Activity activity, List<BuyAPI> data, CallBack<BuyAPI> callBack) {
        this.activity = activity;
        this.callBack = callBack;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BuyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_buy, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BuyViewHolder lotteryViewHolder = (BuyViewHolder) holder;
        lotteryViewHolder.currentItem = data.get(position);
        lotteryViewHolder.fillContent();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private class BuyViewHolder extends RecyclerView.ViewHolder {

        private AppCompatImageView ivImage;
        private AppCompatTextView tvName;
        private AppCompatTextView tvPrice;
        private AppCompatTextView tvQuantity;

        private BuyAPI currentItem;

        BuyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
            // En un boton con el callback hacemos el delete.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callBack != null) {
                        callBack.onResult(currentItem);
                    }
                }
            });
        }

        void fillContent() {
            Glide.with(activity).load(currentItem.getProduct().getImage()).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(R.drawable.ic_file_download_black_24dp).into(ivImage);
            tvName.setText(currentItem.getProduct().getName());
            tvPrice.setText(String.format("%s", currentItem.getPrice()));
            tvQuantity.setText(String.format("%s", currentItem.getQuantity()));
        }
    }
}
