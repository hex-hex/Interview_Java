package Entity;

import lombok.Getter;

public class Item {
    @Getter
    private String name;

    public Item(String name){
        this.name = name;
    }
}
