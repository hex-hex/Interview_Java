package Data;

import Entity.Inventory;
import Entity.Item;
import Entity.Order;
import io.vavr.collection.List;
import lombok.Getter;

import static io.vavr.API.println;

public class Orders {
    @Getter
    static private List<Order> orders = List.empty();

    static public boolean AddOrder(String itemName, int quantity){
        Inventory inventory = Inventories.getInventories().filter(i -> itemName.equals(i.getItem().getName())).head();
        orders.append(new Order(inventory.getItem(), quantity));
        inventory.setAmount(inventory.getAmount() > quantity ? inventory.getAmount() - quantity : 0);
        return true;
    }
}
