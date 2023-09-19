package onlineExercises.springBoot.demo.controller.RequestBodyPostAutoserialization;

import onlineExercises.springBoot.demo.model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//Exercise 4: Create a DeleteMapping to delete all meals above a certain price
@RestController
@RequestMapping("/api")
public class ExercisesIVController {

    @DeleteMapping( "/meal/price/{price}" )
    public ResponseEntity<?> deleteMapping(@PathVariable("price") int price){
        List<Meal> mealList = new ArrayList<>(List.of(new Meal(1,"pasta","yummy",200),new Meal(2,"pasta","yummy",300),new Meal(3,"pasta","yummy",400)));

        List<Meal> mealsToDelete = new ArrayList<>();
        for (Meal meal : mealList){
            if (meal.getPrice()>price){
                mealsToDelete.add(meal);
                System.out.println(mealsToDelete);
            }
        }
        System.out.println(mealList);
        System.out.println(mealsToDelete);
        if (mealList.isEmpty()){
            return ResponseEntity.ok("no meals found");
        }
        if (mealsToDelete.isEmpty()){
            return ResponseEntity.ok("Meals to delete not set");
        }
        mealList.removeAll(mealsToDelete);
        return ResponseEntity.ok("meals with price above ksh"+price+" successfully deleted");
    }
}
