package com.users.users.model.services;

import com.users.users.model.domain.Activity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityService {
    void createActivity(Activity activity);
    void readActivity(long id);
    void updateActivity(long id, Activity activity);
    void deleteActivity(long id);

    List<Activity> getAllActivities();
}
