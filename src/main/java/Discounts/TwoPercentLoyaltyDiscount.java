package Discounts;

import Basket.Item;

import java.util.ArrayList;

public class TwoPercentLoyaltyDiscount extends Discount {

        Double discountAmount;

        public TwoPercentLoyaltyDiscount(String name) {
            super(name);

            discountAmount = 0.98;
        }

        @Override
        public void doDiscount(ArrayList<Item> items){
            for (Item item: items
                    ) {
                item.applyDiscountPrice(discountAmount);
            }
        }
}
