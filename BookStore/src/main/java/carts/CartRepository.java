/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class CartRepository {
    
    private Map<Integer, CartModel> cartsMap = new HashMap<>();
    private static CartRepository instance;

    private CartRepository() {
    }
    
    public static CartRepository getInstance(){
        if(instance == null){
            instance = new CartRepository();
        }
        return instance;
    }
    
    public void addToCartMap(int customerId, CartModel cart){
        cartsMap.put(customerId, cart);
    }
    
    public void removeCrt(int customerId){
        cartsMap.remove(customerId);
    }
    
    
}
