package onlineExercises.springBoot.demo.controller.pathVariablesRequestParamsReturningObject;

import onlineExercises.springBoot.demo.model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExerciseIIIController {

    @GetMapping("/meal/description-match/{phrase}")
    public ResponseEntity<?> getMealByDescription(@PathVariable("phrase") String description){
        List<Meal> meals = List.of(new Meal(1, "Pasta", "Yummy", 300),
                new Meal(2, "greens", "fibrous", 100));

        for (Meal meal : meals) {
            if (meal.getDescription().equals(description)) {
                return ResponseEntity.ok(meal);
            }
        }

        return ResponseEntity.notFound().build();

    }

}
