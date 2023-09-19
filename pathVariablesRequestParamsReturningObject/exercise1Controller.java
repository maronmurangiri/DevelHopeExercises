package onlineExercises.springBoot.demo.controller.pathVariablesRequestParamsReturningObject;

import onlineExercises.springBoot.demo.model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class exercise1Controller {

    //Exercise 1: Create a GetMapping that returns a list of meals
    @GetMapping("/meals")
    public ResponseEntity<?> getMeals(){
        List<Meal> meal =List.of(new Meal(1,"Pasta","Yummy",300),
                                 new Meal(2,"greens","fibrous",100));

        return ResponseEntity.ok(meal);
    }
}


