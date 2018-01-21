package Discounts;

import Basket.ShoppingBasket;

public abstract class Discount implements IDiscount {

    String name;
    Integer discountAmount;


    public Discount(String name) {
        this.name = name;
        this.discountAmount = discountAmount;
    }


    public void doDiscount(Integer basketTotal){

    }



}
