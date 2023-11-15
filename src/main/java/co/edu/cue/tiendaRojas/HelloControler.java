package co.edu.cue.tiendaRojas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {
    @GetMapping(path="/hello")
    public String helloWorld(){
        return "Hello World";
    }
}
