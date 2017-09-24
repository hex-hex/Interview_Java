package Data;

import Entity.Inventory;
import Entity.Order;
import io.vavr.collection.List;
import lombok.Getter;

public class Orders {
    @Getter
    static private List<Order> orders = List.of();

    static public boolean AddOrder(String itemName, int quantity){
        Inventory inventory = Inventories.getInventories().filter(i -> itemName.equals(i.getItem().getName())).head();
        int orderQuantity = inventory.getAmount() > quantity ? quantity : inventory.getAmount();
        if (orderQuantity >0){
            inventory.setAmount(inventory.getAmount() - orderQuantity);
            orders = orders.append(new Order(inventory.getItem(), orderQuantity));
            return true;
        }else {
            return false;
        }
    }
}
