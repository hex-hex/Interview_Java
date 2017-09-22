package Data;

import Entity.Inventory;
import Entity.Item;
import Entity.Order;
import io.vavr.collection.List;

public class Orders {
    static private List<Order> orders = List.empty();

    static public boolean AddOrder(String itemName, int quantity){
        Inventory inventory = Inventories.getInventories().filter(i -> i.getItem().getName() == itemName).head();
        orders.append(new Order(inventory.getItem(),quantity));
        return false;
    }
}
