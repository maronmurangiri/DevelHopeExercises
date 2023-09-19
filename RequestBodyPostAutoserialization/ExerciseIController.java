package onlineExercises.springBoot.demo.controller.RequestBodyPostAutoserialization;

import onlineExercises.springBoot.demo.model.Meal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

 //Exercise 1 :  Create a PutMapping to add a new meal
@RestController
@RequestMapping("/api")
public class ExerciseIController {

    @PostMapping("/meal")
    public ResponseEntity<?> addNewMeal(@RequestBody Meal meal){
        List<Meal> mealList = new ArrayList<>();
        mealList.add(meal);
        return ResponseEntity.status(HttpStatus.CREATED).body(meal);
            }
}
