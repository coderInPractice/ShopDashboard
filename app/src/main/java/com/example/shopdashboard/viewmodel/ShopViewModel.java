package com.example.shopdashboard.viewmodel;

import android.app.Application;
import android.content.res.Resources;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.shopdashboard.R;
import com.example.shopdashboard.model.ShopModel;

import java.util.ArrayList;
import java.util.Collections;

public class ShopViewModel extends ViewModel {
    MutableLiveData<ArrayList<ShopModel>> shopLiveData ;
    ArrayList<ShopModel> shopArrayList;

    public ShopViewModel() {
        shopLiveData = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<ArrayList<ShopModel>> getShopLiveData(){
        return shopLiveData;
    }

    public void init(){
        populateList();
        shopLiveData.setValue(shopArrayList);
    }

    public void populateList(){
//        ShopModel shopModel = new ShopModel();
//
//        shopModel.setShopName("Shop 1");
//        shopModel.setShopImage(R.drawable.shop1);
//        shopModel.setShopItemList("Products :\n Food Items \n Dairy Products \n Cooking and Baking");

        shopArrayList = new ArrayList<>();

        shopArrayList.add(new ShopModel("Shop 1","Products :\nFood Items \nDairy Products \nCooking and Baking",
                R.drawable.shop1));

        shopArrayList.add(new ShopModel("Shop 2","Products :\nFood Items \nTea & Coffee \nBeverage",
                R.drawable.shop2));

        shopArrayList.add(new ShopModel("Shop 3","Products :\nFood Items \nGrocery \nCooking and Baking",
                R.drawable.shop3));

        shopArrayList.add(new ShopModel("Shop 4","Products :\nFood Items \nDairy Products \nBaby Care",
                R.drawable.shop4));

        shopArrayList.add(new ShopModel("Shop 5","Products :\nPersonal Care \nDairy Products \nCooking and Baking",
                R.drawable.shop5));

        shopArrayList.add(new ShopModel("Shop 6","Products :\nFood Items \nDairy Products \nCleaning & Washing Needs",
                R.drawable.shop6));
    }

}

