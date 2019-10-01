package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class EnvController {

    @Value("${PORT:NOT SET}")
    String port;

    @Value("${MEMORY_LIMIT:NOT SET}")
    String memory_limit;

    @Value("${cf.instance.index:NOT SET}")
    String cf_instance_index;

    @GetMapping("/env")
    public String sayHello() {
        return cf_instance_index;
    }
}
