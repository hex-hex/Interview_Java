package Entity;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

public class Order implements Serializable {
    static int idCount = 0;
    @Getter
    private int id;

    @Getter
    @Setter
    private int quantity;

    @Getter
    @Setter
    private Item item;

    public Order(Item item,int quantity){
        this.item = item;
        this.quantity = quantity;
        this.id = idCount ++;
    }
}
