package App;

import Data.Inventories;
import com.fasterxml.jackson.databind.ObjectMapper;
import Entity.Inventory;
import io.vavr.collection.List;
import io.vavr.jackson.datatype.VavrModule;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class ItemController {
    @RequestMapping(value = "/api/item/",method = RequestMethod.GET)
    public ResponseEntity GetItem() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new VavrModule());
        String json = mapper.writer().writeValueAsString(Inventories.getInventories());
        return ResponseEntity.ok().body(json);
    }

    @RequestMapping(value = "/api/item/{name}/{quantity}/",method = RequestMethod.POST)
    public ResponseEntity OrderItem(@PathVariable("name")String name,@PathVariable("quantity") int quantity){
        System.out.println("inside post function!");
        Inventory itemInventory = Inventories.getInventories().filter(inventory -> inventory.getItem().getName() == name).head();
        if(itemInventory.getAmount() < quantity)
            return ResponseEntity.badRequest().body("");
        else
            return ResponseEntity.ok().body("");
    }
}
