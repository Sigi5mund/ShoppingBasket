package Discounts;

import Basket.Item;

import java.util.ArrayList;

public class TenPercentOff extends Discount {
    Double discountAmount;

    public TenPercentOff(String name) {
        super(name);

        discountAmount = 0.9;
    }

    @Override
    public void doDiscount(ArrayList<Item> items){
        for (Item item: items
             ) {
            item.applyDiscountPrice(discountAmount);
        }
    }
}
