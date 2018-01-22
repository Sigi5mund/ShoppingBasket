import Basket.Item;
import Basket.ShoppingBasket;
import Discounts.Bogof;
import Discounts.TenPercentOff;
import Discounts.TwoPercentLoyaltyDiscount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasketTest {

    ShoppingBasket basket;
    Item item0;
    Item item1;
    Item item2;
    Item item3;
    Item item4;
    Item item5;
    Item item6;
    Bogof bogof;
    TenPercentOff tenPercentOff;
    TwoPercentLoyaltyDiscount twoPercentLoyaltyDiscount;


@Before
    public void setUp(){
    basket = new ShoppingBasket();
    item0 = new Item("Toilet Roll", 4.0);
    item1 = new Item("Tooth Brush", 1.0);
    item2 = new Item("Soap", 2.0);
    item3 = new Item("Shower Gel", 3.0);
    item4 = new Item("Shower Radio", 20.0);
    item5 = new Item("Tooth Paste", 2.0);
    item6 = new Item("Towel", 5.0);

}

@Test
    public void canAddDiscountToBasket(){
    assertEquals(0, basket.getDiscounts().size());
    basket.addDiscount(bogof);
    assertEquals(1, basket.getDiscounts().size());
}

@Test
    public void canAddItemsToBasket(){
    assertEquals(0, basket.howManyItemsInBasket(), 0.0);
    basket.addItemToBasket(item0, 2);
    assertEquals(2, basket.howManyItemsInBasket(), 0.0);
}

@Test
    public void canGetTotalBeforeDiscount(){
    bogof = new Bogof("Save now!");
    tenPercentOff = new TenPercentOff("Summer Sale");
    twoPercentLoyaltyDiscount = new TwoPercentLoyaltyDiscount("Loyalty Card Presented");
    basket.addDiscount(twoPercentLoyaltyDiscount);
    basket.addDiscount(tenPercentOff);
    basket.addDiscount(bogof);
    basket.addItemToBasket(item0, 3);
    basket.addItemToBasket(item1, 1);
    basket.addItemToBasket(item2, 2);
    basket.addItemToBasket(item3, 1);
    basket.addItemToBasket(item4, 1);
    basket.addItemToBasket(item5, 1);
    basket.addItemToBasket(item6, 1);
    assertEquals(47.0, basket.getBasketTotal(), 0.01);
}

@Test
public void tenPercentOffWorks(){

    tenPercentOff = new TenPercentOff("Summer Sale");
    basket.addDiscount(tenPercentOff);
    basket.addItemToBasket(item0, 3);
    basket.addItemToBasket(item1, 1);
    basket.addItemToBasket(item2, 2);
    basket.addItemToBasket(item3, 1);
    basket.addItemToBasket(item4, 1);
    basket.addItemToBasket(item5, 1);
    basket.addItemToBasket(item6, 1);
    assertEquals(39.88, basket.totalBasketAfterDiscounts(), 0.01);
}

@Test
    public void twoPercentOffWorks(){
    twoPercentLoyaltyDiscount = new TwoPercentLoyaltyDiscount("Loyalty Card Presented");
    basket.addDiscount(twoPercentLoyaltyDiscount);
    basket.addItemToBasket(item0, 3);
    basket.addItemToBasket(item1, 1);
    basket.addItemToBasket(item2, 2);
    basket.addItemToBasket(item3, 1);
    basket.addItemToBasket(item4, 1);
    basket.addItemToBasket(item5, 1);
    basket.addItemToBasket(item6, 1);
    assertEquals(45.52, basket.getBasketTotalAfterDiscounts(), 0.01);
}

@Test
    public void bogofWorks(){

    bogof = new Bogof("Save now!");
    basket.addDiscount(bogof);
    basket.addItemToBasket(item0, 3);
    basket.addItemToBasket(item1, 1);
    basket.addItemToBasket(item2, 2);
    basket.addItemToBasket(item3, 1);
    basket.addItemToBasket(item4, 1);
    basket.addItemToBasket(item5, 1);
    basket.addItemToBasket(item6, 1);
    assertEquals(44, basket.getBasketTotalAfterDiscounts(), 0.01);
}

@Test
    public void allDiscountsWork(){
    bogof = new Bogof("Save now!");
    tenPercentOff = new TenPercentOff("Summer Sale");
    twoPercentLoyaltyDiscount = new TwoPercentLoyaltyDiscount("Loyalty Card Presented");
    basket.addDiscount(twoPercentLoyaltyDiscount);
    basket.addDiscount(tenPercentOff);
    basket.addDiscount(bogof);
    basket.addItemToBasket(item0, 3);
    basket.addItemToBasket(item1, 1);
    basket.addItemToBasket(item2, 2);
    basket.addItemToBasket(item3, 1);
    basket.addItemToBasket(item4, 1);
    basket.addItemToBasket(item5, 1);
    basket.addItemToBasket(item6, 1);
    assertEquals(36.35, basket.getBasketTotalAfterDiscounts(), 0.01);
}
}
