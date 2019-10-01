package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class WelcomeController {

   public String msg;

     public WelcomeController( @Value("${welcome.message}")
                                            String msg) {

         this.msg = msg;
   }
    @GetMapping("/")
    public String sayHello() {
        return msg;
    }
}
