package cs147.goalfriends;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.client.Firebase;

/**
 * Created by pveerina on 11/18/14.
 */
public class FriendPickerActivity extends Activity {
    public static final String PICKED_FRIEND_EXTRA = "pickedfriend";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}
