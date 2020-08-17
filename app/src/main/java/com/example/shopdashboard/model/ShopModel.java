package com.example.shopdashboard.model;

public class ShopModel {

    private String shopName, shopItemList;
    private  int shopImage;

    public ShopModel(String shopName, String shopItemList, int shopImage) {
        this.shopName = shopName;
        this.shopItemList = shopItemList;
        this.shopImage = shopImage;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopItemList() {
        return shopItemList;
    }

    public void setShopItemList(String shopItemList) {
        this.shopItemList = shopItemList;
    }

    public int getShopImage() {
        return shopImage;
    }

    public void setShopImage(int shopImage) {
        this.shopImage = shopImage;
    }
}
