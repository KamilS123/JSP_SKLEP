package com.kamil.jsp_sklep.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class JsonAccess {

    @SerializedName("users")
    @Expose
    private List<User> users = null;
    @SerializedName("products")
    @Expose
    private List<Product> products = null;
    @SerializedName("shoppingCarts")
    @Expose
    private List<ShoppingCart> shoppingCarts = null;
}