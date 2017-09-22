package Data;

import Entity.Inventory;
import static io.vavr.API.*;
import static io.vavr.Predicates.*;
import Entity.Item;
import io.vavr.collection.List;
import lombok.Getter;

public class Inventories {
    @Getter
    static private List<Inventory> inventories;

    static {
        inventories = List.of(
                new Inventory(new Item("Item A"), 20),
                new Inventory(new Item("Item B"), 10)
                );
    }

    static public int ShipItems(String itemName, int amount){
        Inventory inventory = inventories.filter(i -> itemName == i.getItem().getName()).head();
        return inventory.getAmount();
    }
}
