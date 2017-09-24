package Entity;

import lombok.Getter;

import java.io.Serializable;

public class Order implements Serializable {
    static int idCount = 0;

    @Getter
    private int id;

    @Getter
    private int quantity;

    @Getter
    private Item item;

    public Order(Item item,int quantity){
        this.item = item;
        this.quantity = quantity;
        this.id = idCount ++;
    }
}
