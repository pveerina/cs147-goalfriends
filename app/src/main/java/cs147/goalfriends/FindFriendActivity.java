package cs147.goalfriends;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.firebase.client.Firebase;

import java.util.List;

/**
 * Created by pveerina on 11/18/14.
 */
public class FindFriendActivity extends Activity {
    Firebase fb;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_friend);
        fb = new Firebase("https://<your-firebase>.firebaseio.com/");

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

}
