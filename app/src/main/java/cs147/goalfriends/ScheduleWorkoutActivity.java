package cs147.goalfriends;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NavUtils;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.pkmmte.view.CircularImageView;

import java.util.Calendar;

/**
 * Created by pveerina on 11/18/14.
 */
public class ScheduleWorkoutActivity extends Activity {
    Profile selectedFriend;
    TextView nameText;
    TextView activityText;
    TextView availabilityText;
    Spinner dateSpinner;
    Spinner timeSpinner;
    Spinner activitySpinner;
    Spinner locationSpinner;
//    TextView locationText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_schedule_workout);
        nameText = (TextView)findViewById(R.id.firstLine_sw);
        availabilityText = (TextView)findViewById(R.id.secondLine_sw);
        activityText = (TextView)findViewById(R.id.thirdLine_sw);

        dateSpinner = (Spinner) findViewById(R.id.date_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Date, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dateSpinner.setAdapter(adapter);

        timeSpinner = (Spinner) findViewById(R.id.time_spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.Times, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(adapter2);

        activitySpinner = (Spinner) findViewById(R.id.activity_spinner);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.activities, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activitySpinner.setAdapter(adapter3);

        locationSpinner = (Spinner) findViewById(R.id.location_spinner);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.Locations, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(adapter4);

//        locationText = (TextView)findViewById(R.id.location_name);

    }
    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
        Intent i = getIntent();
        String friendname = i.getStringExtra(FriendPickerActivity.PICKED_FRIEND_EXTRA);
        for (Profile p : ((GoalfriendsApplication)getApplication()).getProfiles()) {
            if (p.name.equals(friendname)) {
                selectedFriend = p;
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
        nameText.setText(selectedFriend.name);
        activityText.setText("Activity: " + selectedFriend.getActivity());
        availabilityText.setText("Available: " + selectedFriend.getAvailability());
//        locationText.setText(selectedFriend.location);
        ((CircularImageView)findViewById(R.id.profpic_sw)).setImageResource(selectedFriend.picture);
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

    public void scheduleWorkout(View view) {
        final Activity ref = this;
        ((GoalfriendsApplication) getApplication()).getNotifications().add(0, "Workout requested with " + selectedFriend.name);
        ((GoalfriendsApplication) getApplication()).getProfile().scheduledWorkouts.add(selectedFriend.name);
        ((GoalfriendsApplication) getApplication()).refreshNotificationList();
        new AlertDialog.Builder(this)
                .setTitle("Sent Request")
                .setMessage("You've sent a workout request to " +  selectedFriend.name)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Execute some code after 2 seconds have passed
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                ((GoalfriendsApplication) getApplication()).getNotifications().add(0, selectedFriend.name + " accepted your request to " + activitySpinner.getSelectedItem() + " "
                                        + dateSpinner.getSelectedItem() + ", " + timeSpinner.getSelectedItem() + " at " + locationSpinner.getSelectedItem() );
                                ((GoalfriendsApplication) getApplication()).refreshNotificationList();

                            }
                        }, 5000);

                        ref.setResult(2);
                        ref.finish();

                    }
                })
                .setIcon(R.drawable.check)
                .show();
    }

}
