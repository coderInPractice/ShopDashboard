package com.example.shopdashboard.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopdashboard.R;
import com.example.shopdashboard.model.ShopModel;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {

    Activity context;
    ArrayList<ShopModel> shopArrayList;

    public ShopAdapter(Activity context, ArrayList<ShopModel> shopArrayList) {
        this.context = context;
        this.shopArrayList = shopArrayList;
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row,parent,false);
        return new ShopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
        final String shopName = shopArrayList.get(position).getShopName();
        final String productDetails = shopArrayList.get(position).getShopItemList();
        final int ImageId = shopArrayList.get(position).getShopImage();
        holder.shopName.setText(shopName);
        holder.shopImage.setImageResource(ImageId);
        holder.productDetails.setText(productDetails);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,shopName + "\n" + productDetails);
                intent.setType("text/plain");

                v.getContext().startActivity(Intent.createChooser(intent, "Share to...."));
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopArrayList.size();
    }

    public static class ShopViewHolder extends RecyclerView.ViewHolder {

        TextView shopName ,productDetails;
        ImageView shopImage;
        CardView cardView;


        public ShopViewHolder(@NonNull View itemView) {
            super(itemView);

            shopImage = itemView.findViewById(R.id.shop_image_view);
            shopName = itemView.findViewById(R.id.shop_text_view);
            productDetails = itemView.findViewById(R.id.products_text_view);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
