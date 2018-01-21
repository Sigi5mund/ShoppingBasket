package Basket;

import Discounts.IDiscount;

import java.util.ArrayList;
import java.util.Arrays;

public class ShoppingBasket {

    public ArrayList<Item> items;
    ArrayList<IDiscount> discounts;
    Double basketTotal;
    Double basketTotalAfterDiscounts;


    public ShoppingBasket() {
        this.items = new ArrayList<>();
        this.discounts = new ArrayList<>();
        this.basketTotal = 0.0;
        this.basketTotalAfterDiscounts = 0.0;
    }

    public Double totalBasketBeforeDiscounts(){
        Double total = 0.0;
        for (Item item: items) {
            total += item.getPrice();
        }
        return total;
    }

    public Double totalBasketAfterDiscounts(){
        ArrayList<Item> itemsDiscount = new ArrayList(Arrays.asList(items));
         Double newTotal = 0.0;
         applyDiscountsToBasketTotal(itemsDiscount);

        for (Item item: itemsDiscount) {
            newTotal += item.getPrice();
        }
        return newTotal;
    }

    public void addItemToBasket(Item item, Integer numberOfItems){
        for (int i = 0; i < numberOfItems; i++) {
            items.add(item);
        }
    }

    public void removeItemFromBasket(Item item, Integer numberOfItemToRemove){
        int counter = 0;
        if (counter <numberOfItemToRemove) {
            for (Item thing : items) {
                if (thing == item) {
                    items.remove(thing);
                    counter += 1;
                }
            }
        }
    }


    public void addDiscount(IDiscount discount){
        discounts.add(discount);
    }

    public void emptyBasket(){
        this.items.clear();
    }

    public void clearDiscounts(){
        this.discounts.clear();
    }

    public void applyDiscountsToBasketTotal(ArrayList<Item> itemsDiscount){
        Double runningTotal =totalBasketBeforeDiscounts();
        for (IDiscount iDiscount: discounts
             ) {
             iDiscount.doDiscount(itemsDiscount);
            }
        }


    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<IDiscount> getDiscounts() {
        return discounts;
    }

    public Double getBasketTotal() {
        this.basketTotal = totalBasketBeforeDiscounts();
        return basketTotal;
    }

    public Integer howManyItemsInBasket(){
        return this.items.size();
    }

    public Double getBasketTotalAfterDiscounts(){
        basketTotalAfterDiscounts = totalBasketAfterDiscounts();
        return this.basketTotalAfterDiscounts;
    }
}



