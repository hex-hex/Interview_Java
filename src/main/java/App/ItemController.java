package App;

import Data.Inventories;
import com.fasterxml.jackson.databind.ObjectMapper;
import Entity.Inventory;
import io.vavr.collection.List;
import io.vavr.jackson.datatype.VavrModule;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(data);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new VavrModule());
        Object orders = mapper.readValue(data, List.class);
        return ResponseEntity.ok().body("");
    }
}
