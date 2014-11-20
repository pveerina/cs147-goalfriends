package cs147.goalfriends;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pveerina on 11/18/14.
 */
public class FindFriendActivity extends ListActivity {
    Firebase fb;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_friend);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        fb = new Firebase("https://goalfriends.firebaseio.com/");
        List<Profile> profiles = new ArrayList<Profile>();
        Profile p1 = new Profile("Tom Brady", "Old Arrillaga Gym", "Weight Lifting");
        p1.setPicture(getResources().getDrawable(R.drawable.brady_profile));
        Profile p2 = new Profile("Michael Jordan", "Flomo Courts", "Basketball");
        p2.setPicture(getResources().getDrawable(R.drawable.jodan_profile));
        profiles.add(p1);
        profiles.add(p2);
        ListAdapter la = new ProfileArrayAdapter(this, profiles, 1);
        setListAdapter(la);
    }
    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
    }
    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
    }

    public void addFriend(View v) {
        fb.child("addfriend").setValue("me->tom");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
