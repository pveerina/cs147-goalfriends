package cs147.goalfriends;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pveerina on 11/19/14.
 */
public class GoalfriendsApplication extends Application {

    private static GoalfriendsApplication sInstance;

    private Profile profile;
    private List<String> notifications;

    public static GoalfriendsApplication getInstance() {
        return sInstance;
    }

    public Profile getProfile() {
        return profile;
    }
    public List<String> getNotifications() {
        return notifications;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        sInstance.initializeInstance();
    }

    protected void initializeInstance() {
        // do all your initialization here
        profile = new Profile("Tiger Woods", "Arrillaga", "Weight Lifting");
        notifications = new ArrayList<String>();

    }
}