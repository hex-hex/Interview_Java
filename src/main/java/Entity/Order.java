package Entity;

import lombok.Getter;
import lombok.Setter;

public class Order {
    @Getter
    @Setter
    private int quatity;

    @Getter
    @Setter
    private Item item;

    public Order(Item item,int quatity){
        this.item = item;
        this.quatity = quatity;
    }
}
