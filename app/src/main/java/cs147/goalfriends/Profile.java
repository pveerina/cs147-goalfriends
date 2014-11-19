package cs147.goalfriends;

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

    public Profile(String name, String location, String activity) {

        this.name = name;
        this.location = location;
        this.activity = activity;
    }
}
