package cs147.goalfriends;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pveerina on 11/18/14.
 */
public class Profile {
    String name;
    String location;
    String activity;
    List<Profile> friends;
    int hoursExcercised;
    int workouts;
    int picture;
    int coverPhoto;
    List<String> recentActivity;
    String availability;
    String lastEvent;
    String cancellations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public List<Profile> getFriends() {
        return friends;
    }

    public void addFriend(Profile friend) {
        friends.add(friend);
    }

    public void setFriends(List<Profile> friends) {
        this.friends = friends;
    }

    public int getHoursExcercised() {
        return hoursExcercised;
    }

    public void setHoursExcercised(int hoursExcercised) {
        this.hoursExcercised = hoursExcercised;
    }

    public int getWorkouts() {
        return workouts;
    }

    public void setWorkouts(int workouts) {
        this.workouts = workouts;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public int getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(int coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public List<String> getRecentActivity() {
        return recentActivity;
    }

    public void setRecentActivity(List<String> recentActivity) {
        this.recentActivity = recentActivity;
    }

    public void addRecentActivity(String message) {
        recentActivity.add(message);
    }

    public boolean isFriend(Profile p) {
        for (Profile friend : friends) {
            if (friend.name.equals(p.name)) {
                return true;
            }
        }
        return false;
    }

    public String getAvailability() {
        return availability;
    }


    public Profile(String name, String location, String activity, String availability,
                   String lastEvent, String cancellations) {
        this.name = name;
        this.location = location;
        this.activity = activity;
        recentActivity = new ArrayList<String>();
        friends = new ArrayList<Profile>();
        hoursExcercised = 0;
        workouts = 0;
        this.availability = availability;
        this.lastEvent = lastEvent;
        this.cancellations = cancellations;
//        picture = Resources.getSystem().getDrawable(R.drawable.default_profile);
//        coverPhoto = Resources.getSystem().getDrawable(R.drawable.default_cover);
    }
}
