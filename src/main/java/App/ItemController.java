package App;

import Data.Inventories;
import Data.Orders;
import com.fasterxml.jackson.databind.ObjectMapper;
import Entity.Inventory;
import io.vavr.Tuple;
import io.vavr.collection.List;
import io.vavr.collection.Queue;
import io.vavr.jackson.datatype.VavrModule;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedHashMap;


@RestController
public class ItemController {
    @RequestMapping(value = "/api/item/",method = RequestMethod.GET)
    public ResponseEntity GetItem() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new VavrModule());
        String json = mapper.writer().writeValueAsString(Inventories.getInventories());
        return ResponseEntity.ok().body(json);
    }

    @RequestMapping(value = "/api/item/",method = RequestMethod.POST)
    public ResponseEntity OrderItem(@RequestBody String data) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new VavrModule());
        List<LinkedHashMap> orders = mapper.readValue(data, List.class);
        orders.forEach(object -> Orders.AddOrder((String)object.get("itemName"), Integer.parseInt((String)object.get("quantity"))));
        return ResponseEntity.ok().body("");
    }
}
