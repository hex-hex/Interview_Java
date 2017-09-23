package Entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Inventory implements Serializable {
    private @Getter Item item;

    private @Getter @Setter int amount;

    public Inventory(Item item, int amount){
        this.item = item;
        this.amount = amount;
    }
}
