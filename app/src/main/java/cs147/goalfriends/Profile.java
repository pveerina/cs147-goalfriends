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
    Drawable picture;
    Drawable coverPhoto;
    List<String> recentActivity;

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

    public Drawable getPicture() {
        return picture;
    }

    public void setPicture(Drawable picture) {
        this.picture = picture;
    }

    public Drawable getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(Drawable coverPhoto) {
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

    public Profile(String name, String location, String activity) {
        this.name = name;
        this.location = location;
        this.activity = activity;
        recentActivity = new ArrayList<String>();
        friends = new ArrayList<Profile>();
        hoursExcercised = 0;
        workouts = 0;
//        picture = Resources.getSystem().getDrawable(R.drawable.default_profile);
//        coverPhoto = Resources.getSystem().getDrawable(R.drawable.default_cover);
    }
}
