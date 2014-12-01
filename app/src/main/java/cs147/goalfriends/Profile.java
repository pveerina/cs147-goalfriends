package cs147.goalfriends;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.pkmmte.view.CircularImageView;

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
    ProfileAdapter topFriendsAdapter;
    List<String> scheduledWorkouts;

    ArrayList<Profile> topFriends;

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
        topFriends.add(0, friend);
        topFriendsAdapter.notifyDataSetChanged();
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
                   String lastEvent, String cancellations, Context cxt) {
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
        topFriends = new ArrayList<Profile>();
        topFriendsAdapter = new ProfileAdapter(cxt, topFriends);
        scheduledWorkouts = new ArrayList<String>();
//        picture = Resources.getSystem().getDrawable(R.drawable.default_profile);
//        coverPhoto = Resources.getSystem().getDrawable(R.drawable.default_cover);
    }


    public class ProfileAdapter extends ArrayAdapter<Profile> {
        public ProfileAdapter(Context context, ArrayList<Profile> users) {
            super(context, 0, users);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Profile user = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.top_friend_row, parent, false);
            }
            // Lookup view for data population
            TextView tvName = (TextView) convertView.findViewById(R.id.topProfileName);
            CircularImageView profPic = (CircularImageView) convertView.findViewById(R.id.topProfilePic);
            // Populate the data into the template view using the data object
            tvName.setText(user.name);
            profPic.setImageResource(user.picture);
            // Return the completed view to render on screen
            return convertView;
        }
    }
}
