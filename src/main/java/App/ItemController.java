package App;

import Data.Inventories;
import Data.Orders;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.collection.List;
import io.vavr.jackson.datatype.VavrModule;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        try{
            orders.forEach(object -> Orders.AddOrder((String)object.get("itemName"), Integer.parseInt((String)object.get("quantity"))));
            return ResponseEntity.ok().body("");
        }
        catch (Exception e){
            return ResponseEntity.status(401).body("Your request is broken.");
        }
    }

    @RequestMapping(value = "/api/order/", method = RequestMethod.GET)
    public ResponseEntity GetOrder() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new VavrModule());
        String json = mapper.writer().writeValueAsString(Orders.getOrders());
        return ResponseEntity.ok().body(json);
    }
}
