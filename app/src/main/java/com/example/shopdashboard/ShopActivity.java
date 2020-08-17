package com.example.shopdashboard;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopdashboard.adapter.ShopAdapter;
import com.example.shopdashboard.model.ShopModel;
import com.example.shopdashboard.viewmodel.ShopViewModel;
import com.example.shopdashboard.viewmodel.ShopViewModelFactory;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity {

    ShopActivity context;
    RecyclerView recyclerView;
    ShopAdapter shopAdapter;
    ShopViewModel shopViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        context = this;

        recyclerView = findViewById(R.id.recyclerView);

        ShopViewModelFactory shopViewModelFactory = new ShopViewModelFactory();
        shopViewModel = new ViewModelProvider(this,shopViewModelFactory).get(ShopViewModel.class);

        shopViewModel.getShopLiveData().observe(context,userListUpdateObserver);
    }

    Observer<ArrayList<ShopModel>> userListUpdateObserver = new Observer<ArrayList<ShopModel>>() {
        @Override
        public void onChanged(ArrayList<ShopModel> shopArrayList) {
            shopAdapter = new ShopAdapter(context,shopArrayList);
            recyclerView.setLayoutManager(new GridLayoutManager(context,2));
            recyclerView.setAdapter(shopAdapter);
        }
    };
}