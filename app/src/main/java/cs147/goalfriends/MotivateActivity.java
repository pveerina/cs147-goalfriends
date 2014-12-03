package cs147.goalfriends;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pkmmte.view.CircularImageView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by pveerina on 11/18/14.
 */
public class MotivateActivity extends Activity {
    Profile selectedFriend;
    TextView nameText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_motivate);
        nameText = (TextView)findViewById(R.id.textView9);
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
        nameText.setText("Motivate " + selectedFriend.name);
        ((CircularImageView)findViewById(R.id.profpic_m)).setImageResource(selectedFriend.picture);
        Button send_reminder = (Button)findViewById(R.id.send_reminder);

        Profile myprofile = ((GoalfriendsApplication) getApplication()).getProfile();
        if (!myprofile.scheduledWorkouts.contains(selectedFriend.name)){
            send_reminder.setVisibility(View.GONE);
        }

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

    public void sendSong(View view) {
        SendSongDialog  d = new SendSongDialog();
        d.name = selectedFriend.name;
        FragmentManager fm = getFragmentManager();
        d.show(fm, "tag");
    }

    public void sendReminder(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Sent Reminder")
                .setMessage("You sent a workout reminder to " + selectedFriend.name)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(R.drawable.check)
                .show();
    }

    public void sendMessage(View view) {
        SendMessageDialog  d = new SendMessageDialog();
        d.name = selectedFriend.name;
        FragmentManager fm = getFragmentManager();
        d.show(fm, "tag");
    }


    public static class SendMessageDialog extends DialogFragment {
        String name;
        List mSelectedItems;
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            mSelectedItems = new ArrayList();  // Where we track the selected items
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            // Set the dialog title
            builder.setTitle("Motivational Message")
                    // Specify the list array, the items to be selected by default (null for none),
                    // and the listener through which to receive callbacks when items are selected
                    .setSingleChoiceItems(R.array.motivational_messages, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                            // Set the action buttons
                    .setPositiveButton("Send", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            ((GoalfriendsApplication) getActivity().getApplication()).getNotifications().add(0, "Sent motivational message to " + name);

                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });

           return builder.create();

        }
    }



    public static class SendSongDialog extends DialogFragment {
        String name;
        List mSelectedItems;
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            mSelectedItems = new ArrayList();  // Where we track the selected items
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            // Set the dialog title
            builder.setTitle("Motivational Song")
                    // Specify the list array, the items to be selected by default (null for none),
                    // and the listener through which to receive callbacks when items are selected
                    .setSingleChoiceItems(R.array.motivational_songs, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                            // Set the action buttons
                    .setPositiveButton("Send", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            ((GoalfriendsApplication) getActivity().getApplication()).getNotifications().add(0, "Sent motivational song to " + name);
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });

            return builder.create();

        }
    }

}
