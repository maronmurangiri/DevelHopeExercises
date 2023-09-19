package demo.controller;

import demo.model.Item;
import demo.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    @Autowired
    ItemServiceImpl itemServiceimpl;

    @PostMapping("/post/item")
    public ResponseEntity<?> createItem(@RequestBody Item item){
        if (itemServiceimpl.getItemMap().containsKey(item.getId())){
            return ResponseEntity.badRequest().body("The item  exist");
        }

           Item item1 = itemServiceimpl.createItem(item);
        return ResponseEntity.ok("Item "+item1.getItemName()+" successfully created");

    }

    @PutMapping("/put/item")
    public ResponseEntity<?> updateItem(@RequestBody Item item){
        if (itemServiceimpl.getItemMap().containsKey(item.getId())){
            Item item1 = itemServiceimpl.updateItem(item);
            return ResponseEntity.ok("Item name updated successfully to" +item1.getItemName());
        }
        else {
            return ResponseEntity.badRequest().body("item not found");
        }
    }

    @DeleteMapping("/delete/item/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable("itemId") int itemId){
        if (itemServiceimpl.getItemMap().containsKey(itemId)) {
            Item item = itemServiceimpl.deleteItem(itemId);
            return ResponseEntity.ok("Item "+item.getItemName()+"  deleted successfully");
        }
        else{
            return ResponseEntity.badRequest().body("item not found");
        }


    }

    @GetMapping("/get/items/{itemId}")
    public ResponseEntity<?> getItems(@PathVariable("itemId") int itemId){
        if (itemServiceimpl.getItemMap().containsKey(itemId)) {
           Item item = itemServiceimpl.getItem(itemId);
            return ResponseEntity.ok(item);
        }
        else{
            return ResponseEntity.badRequest().body("item not found");
        }
    }
}
