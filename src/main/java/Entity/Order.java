package Entity;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

public class Order implements Serializable {
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
