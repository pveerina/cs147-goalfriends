package cs147.goalfriends;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.pkmmte.view.CircularImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pveerina on 11/19/14.
 */
public class GoalfriendsApplication extends Application {

    private static GoalfriendsApplication sInstance;

    private Profile profile;
    private List<Profile> profiles;
    private List<String> notifications;
    private ListAdapter notificationListAdapter;
    private ArrayAdapter<String> activityList;

    public static GoalfriendsApplication getInstance() {
        return sInstance;
    }

    public Profile getProfile() {
        return profile;
    }
    public List<String> getNotifications() {
        return notifications;
    }
    public List<Profile> getProfiles() { return profiles; }
    public ListAdapter getNotificationListAdapter() {
        return notificationListAdapter;
    }
    public void refreshNotificationList() {
        ((BaseAdapter) notificationListAdapter).notifyDataSetChanged();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        sInstance.initializeInstance();
    }

    protected void initializeInstance() {
        // do all your initialization here
        profile = new Profile("Tiger Woods", "Arrillaga", "Weight Lifting", "5-7pm", "2 days ago", "1 in 20", this);
        profiles = new ArrayList<Profile>();
        Profile p1 = new Profile("Tom Brady", "Old Arrillaga Gym", "Weight Lifting", "2-4pm", "10 days ago", "1 in 10", this);
        p1.setPicture(R.drawable.brady_profile);
        p1.setCoverPhoto(R.drawable.default_cover);
        Profile p2 = new Profile("Michael Jordan", "Flomo Courts", "Basketball", "5-9pm", "1 day ago", "none", this);
        p2.setPicture(R.drawable.jodan_profile);
        p2.setCoverPhoto(R.drawable.default_cover);
        profiles.add(p1);
        profiles.add(p2);
        notifications = new ArrayList<String>();



        notificationListAdapter =
                new ArrayAdapter<String>(this, R.layout.notificatinlistitem, R.id.text1, notifications);


    }



}