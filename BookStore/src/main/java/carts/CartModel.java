/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carts;

import books.BookModel;
import books.BookRepository;
import exceptions.BookNotFoundException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class CartModel {
    
    Map<Integer, Integer> cartMap = new HashMap<Integer, Integer> ();
    BookRepository bookRepository = BookRepository.getInstance();
    
    public void AddToCart(int bookId, int customerSentQty){
   
            //Find the valid book id
            findTheValidBookId(bookId);
            
            //Find its quantity avaialable in store
            int availableBookQtyInStore = checkisEnoughQuantity(bookId, customerSentQty);
            
            //If quentity is enough then add to cart
            addToCartMap(bookId,customerSentQty);
                    
            //Decrease the book quantity form book repository
            int remaininggBookQuantityInStore = availableBookQtyInStore - customerSentQty;
            cartMap.put(bookId, remaininggBookQuantityInStore);
              
    }
    
    private void findTheValidBookId(int bookId){
        if(bookRepository.findBookById(bookId)== null)
                throw new BookNotFoundException(String.format("Book with ID %d does not exist.", bookId));
    }
    
    private int checkisEnoughQuantity(int bookId, int userEnterdQuantity){
        BookModel retreivedBook = bookRepository.findBookById(bookId);
            int retreivedBookQuantity = retreivedBook.getStock();
            if(retreivedBookQuantity< userEnterdQuantity)
                throw new BookNotFoundException("Not enough book available in the store");
            
            return retreivedBookQuantity;
    }
    
    private void addToCartMap(int bookId,int customerSentQty){
        cartMap.put(bookId, cartMap.get(bookId)+ customerSentQty);
    }
    
}
