package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
public class DistilleryController {
    @Autowired
    DistilleryRepository distilleryRepository;
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/distilleries/whiskies")
    public ResponseEntity<List<Whisky>> findDistilleriesThatHaveWhiskiesByYear(
            @RequestParam(name = "named") int year){
        return new ResponseEntity<>(whiskyRepository.findWhiskiesByYear(year), HttpStatus.OK);
    }
}
