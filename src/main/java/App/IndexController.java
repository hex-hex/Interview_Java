package App;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Index(){
        System.out.println("-------this is home----------");
        return "index";
    }

    @RequestMapping(value = "/error/", method = RequestMethod.GET)
    @ResponseBody
    public String Error(){
        return "Sorry, there is something wrong.";
    }
}