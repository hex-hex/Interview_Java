package Entity;

import lombok.Getter;
import java.io.Serializable;

public class Item implements Serializable {
    @Getter
    private String name;

    public Item(String name){
        this.name = name;
    }
}
