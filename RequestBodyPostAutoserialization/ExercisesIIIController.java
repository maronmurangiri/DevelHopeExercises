package onlineExercises.springBoot.demo.controller.RequestBodyPostAutoserialization;

import onlineExercises.springBoot.demo.model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//Exercise 3: Create a DeleteMapping to delete a meal by name
@RestController
@RequestMapping("/api")
public class ExercisesIIIController {

    @DeleteMapping("/meal/{name}" )
    public ResponseEntity<?> deleteMealByName(@PathVariable("name") String name){
        List<Meal> mealList = new ArrayList<>(List.of(new Meal(1,"pasta","yummy",200)));
        for (Meal meal :mealList ){
            if (meal.getName().equals(name)){
                mealList.remove(meal);

                return ResponseEntity.ok("meal successfully deleted");
            }
        }
        return ResponseEntity.notFound().build();
    }
}
