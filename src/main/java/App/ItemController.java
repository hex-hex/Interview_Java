package App;

import Data.Inventories;
import com.fasterxml.jackson.databind.ObjectMapper;
import Entity.Inventory;
import io.vavr.collection.List;
import io.vavr.jackson.datatype.VavrModule;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    @RequestMapping(value = "/api/item/",method = RequestMethod.GET)
    public String GetItem() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new VavrModule());
        String json = mapper.writer().writeValueAsString(Inventories.getInventories());
        return json;
    }

    @RequestMapping(value = "/api/item/",method = RequestMethod.POST)
    public String OrderItem(){
        return "{'success':'true'}";
    }
}
