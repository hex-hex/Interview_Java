package Entity;

import lombok.Getter;

public class Inventory {
    @Getter
    private Item item;

    @Getter
    private int amount;

    public Inventory(Item item, int amount){
        this.item = item;
        this.amount = amount;
    }
}
