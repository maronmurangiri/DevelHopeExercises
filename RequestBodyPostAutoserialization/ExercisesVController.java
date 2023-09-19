package onlineExercises.springBoot.demo.controller.RequestBodyPostAutoserialization;

import onlineExercises.springBoot.demo.model.Meal;
import onlineExercises.springBoot.demo.model.updatedPriceRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Exercise 5: Create a PutMapping to update the price of a meal by name
@RestController
@RequestMapping("/api")
public class ExercisesVController {

    @PutMapping("/meal/{name}/price")
    public ResponseEntity<?> updateMealByName(@PathVariable("name") String name, @RequestBody updatedPriceRequest updatedPriceRequest){
        List<Meal> mealList = List.of(new Meal(1,"pasta","yummy",200));
        for (Meal meal :mealList ){
            if (meal.getName().equals(name)){
                meal.setPrice(updatedPriceRequest.getUpdatedPrice());

                return ResponseEntity.ok(meal);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
