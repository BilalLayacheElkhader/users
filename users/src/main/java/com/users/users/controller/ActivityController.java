package com.users.users.controller;

import com.users.users.model.domain.Activity;
import com.users.users.model.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appActivitats/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ResponseEntity<String> creatActivity(@RequestBody Activity activity){
        activityService.createActivity(activity);
        return ResponseEntity.ok("ACTIVITY CREATED");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Activity>> readActivity(@PathVariable Long id){
        Optional<Activity> activity = activityService.readActivity(id);
        return ResponseEntity.ok(activity);
    }
    @GetMapping("/export")
    public ResponseEntity<List<Activity>>exportActivity(){
        List<Activity> activities = activityService.exportActivities();
        return ResponseEntity.ok(activities);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateActivity(@PathVariable long id, @RequestBody Activity activity){
        activityService.updateActivity(id,activity);
        return ResponseEntity.ok("ACTIVITY UPDATED");
    }
    @PostMapping("/import")
    public ResponseEntity<String> importActivity(@RequestBody List<Activity> activities){
        activityService.importActivities(activities);
        return ResponseEntity.ok("ACTIVITIES IMPORTED");
    }
}
