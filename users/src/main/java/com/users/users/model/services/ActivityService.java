package com.users.users.model.services;

import com.users.users.model.domain.Activity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ActivityService {
    void createActivity(Activity activity);
    Optional<Activity> readActivity(long id);
    Activity updateActivity(long id, Activity activity);
    void deleteActivity(long id);

    List<Activity> getAllActivities();
}
