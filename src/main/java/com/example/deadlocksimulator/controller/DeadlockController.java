package com.example.deadlocksimulator.controller;
import com.example.deadlocksimulator.service.DeadlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.deadlocksimulator.service.DeadlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deadlock")
public class DeadlockController {

    @Autowired
    private DeadlockService deadlockService;

    @GetMapping("/simulate")
    public String simulateDeadlock() {
        deadlockService.simulateDeadlock();
        return "Deadlock simulation started. Check the logs for output.";
    }
}
