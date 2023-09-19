package onlineExercises.springBoot.demo.controller.pathVariablesRequestParamsReturningObject;

import onlineExercises.springBoot.demo.model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ExerciseIVController {

    @GetMapping("/meal/price" )
    public ResponseEntity<?> getMealByPrice(@RequestParam("min") int minPrice,@RequestParam("max") int maxPrice){
        List<Meal> meals = List.of(new Meal(1, "Pasta", "Yummy", 300),
                new Meal(2, "greens", "fibrous", 100));

        List<Meal> mealsInPriceRange = new ArrayList<>();
        for (Meal meal : meals) {
            if ((meal.getPrice()>= minPrice) && (meal.getPrice()<=maxPrice)) {
                mealsInPriceRange.add(meal);
            }
        }

        if(mealsInPriceRange.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mealsInPriceRange);
    }
}
