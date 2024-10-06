package com.users.users.model.services.impl;

import com.users.users.model.domain.Activity;
import com.users.users.model.repository.ActivityRepository;
import com.users.users.model.services.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;
    @Override
    public void createActivity(Activity activity) {
        if(activity.getName() == null || activity.getName().isBlank()){
            throw new RuntimeException("NAME CANNOT BY EMPTY");
        }
        if(activity.getDescription() == null || activity.getDescription().isBlank()){
            throw new RuntimeException("DISCRIPTION CANNOT BY EMTPY");
        }
        if(activity.getMaxCapity()<= 0){
            throw new RuntimeException("CAPACITY CANNOT BE INFERIOR TO 1");
        }
        var act = Activity.builder()
                .name(activity.getName())
                .description(activity.getDescription())
                .maxCapity(activity.getMaxCapity())
                .build();
        activityRepository.save(act);
    }

    @Override
    public Optional<Activity> readActivity(long id) {
        Activity act = activityRepository.findById(id)
                .orElseThrow(()->new RuntimeException("ACTIVITY NOT FOUND"));
        return activityRepository.findById(id);
    }

    @Override
    public Activity updateActivity(long id, Activity activity) {
        Activity upActivity = activityRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("ACTIVITY NOT FOUNT"));
        upActivity.setName(activity.getName());
        upActivity.setDescription(activity.getDescription());
        return activityRepository.save(activity);

    }

    @Override
    public void deleteActivity(long id) {
        activityRepository.deleteById(id);
    }
    @Override
    public List<Activity> exportActivities() {
        return activityRepository.findAll();
    }

    @Override
    public void importActivities(List<Activity> activities) {
        activityRepository.saveAll(activities);
    }
}
