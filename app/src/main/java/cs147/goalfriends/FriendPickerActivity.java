package cs147.goalfriends;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pveerina on 11/18/14.
 */
public class FriendPickerActivity extends ListActivity {
    public static final String PICKED_FRIEND_EXTRA = "pickedfriend";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_friend_picker);
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

    public void launchNext(View v) {
        Intent i = getIntent();
        String nextActivity = i.getStringExtra(MainActivity.NEXT_ACTIVITY_EXTRA);
        if (nextActivity.equals(ScheduleWorkoutActivity.class.getSimpleName())) {
            Intent intent = new Intent(this, ScheduleWorkoutActivity.class);
            intent.putExtra(PICKED_FRIEND_EXTRA, "friendid");
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, MotivateActivity.class);
            intent.putExtra(PICKED_FRIEND_EXTRA, "friendid");
            startActivity(intent);
        }

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
