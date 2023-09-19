package onlineExercises.springBoot.demo.controller.RequestBodyPostAutoserialization;

import onlineExercises.springBoot.demo.model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Exercise 2: Create a PutMapping to update a meal by name
@RestController
@RequestMapping("/api")
public class ExerciseIIController {
    @PutMapping("/meal/{name}")
    public ResponseEntity<?> updateMeal(@PathVariable("name") String name,@RequestBody Meal updatedMeal){
        List<Meal> mealList = List.of(new Meal(1,"pasta","yummy",200));
        for (Meal meal : mealList){
            if (meal.getName().equals(name)){
                meal.setId(updatedMeal.getId());
                meal.setName(updatedMeal.getName());
                meal.setDescription(updatedMeal.getDescription());
                meal.setPrice(updatedMeal.getPrice());

                return ResponseEntity.ok(meal);
            }
        }
        return ResponseEntity.notFound().build();
    }

}
