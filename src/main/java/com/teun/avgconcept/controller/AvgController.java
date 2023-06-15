package com.teun.avgconcept.controller;

import com.teun.avgconcept.rabbitmq.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/avg")
public class AvgController {
    @Autowired
    Publisher publisher;

    @PostMapping("/delete/{id}")
    public ResponseEntity sendUserForDeleteion(@PathVariable(value = "id")Long userId){
        try{
            publisher.userToDelete(userId);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}
