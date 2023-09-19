package onlineExercises.springBoot.demo.controller.firstController;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class firstController {

    //Exercise1
    @GetMapping("/hello")
    public String getSimpleWord(){
        return "hello world";
    }


    //Exercise2
    @GetMapping("/greeting")
    public ResponseEntity<?> getGreetings(){
        return ResponseEntity.ok("Good Afternoon");
    }


}


//Exercise3
@RestController
@RequestMapping("/api")
 class exercise3Controller {

    @GetMapping("/info")
    public ResponseEntity<?> getOkayStatus(){
        return ResponseEntity.ok().build();
    }
}


//Exercise3
@RestController
@RequestMapping("/api")
 class exercise4Controller {

    @GetMapping("/random")
    public ResponseEntity<?> getStatus(){
        if (new Random().nextBoolean()){
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.badRequest().build();
        }


    }
}


