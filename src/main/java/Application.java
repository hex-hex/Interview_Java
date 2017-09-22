import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import Controller.IndexController;

@SpringBootApplication
public class Application{
    public static void main(String[] args) throws Exception{
        SpringApplication.run(IndexController.class,args);
    }
}
