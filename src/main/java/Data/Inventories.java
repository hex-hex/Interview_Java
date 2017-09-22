package Data;

import Entity.Inventory;
import Entity.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventories {
    static private List<Inventory> inventories;

    static {
        inventories = new ArrayList<Inventory>();
        inventories.add(new Inventory(new Item("Item A"), 100));
        inventories.add(new Inventory(new Item("Item B"), 100));
    }
}
