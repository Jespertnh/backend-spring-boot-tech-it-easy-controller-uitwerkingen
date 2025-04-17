package nl.novi.techiteasy1121.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TelevisionController {

    @GetMapping("/")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("Hello hello hello");
    }
    

    @GetMapping("/televisions")
    public ResponseEntity<String> getAllTelevisions() {

        // Return een String met een 200 status
        return ResponseEntity.ok("televisions");

    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<String> getTelevision(@PathVariable("id") int id) {

        // return een String met een 200 status
        return ResponseEntity.ok("television with id: " + id);

    }

    @PostMapping("/televisions")
    public ResponseEntity<String> addTelevision(@RequestBody String television) {

        // Return een String met een 201 status
        //De null van created zal over een paar weken vervangen worden door een gegenereerde url.
        return ResponseEntity.created(null).body("television");

    }

    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable int id) {

        //Return een 204 status
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<Void> updateTelevision(@PathVariable int id, @RequestBody String television) {

        // Return een 204 status
        return ResponseEntity.noContent().build();

    }


}
