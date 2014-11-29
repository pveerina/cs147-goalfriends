package cs147.goalfriends;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.pkmmte.view.CircularImageView;

import java.util.List;

/**
 * Created by pveerina on 11/19/14.
 */
public class ProfileArrayAdapter extends ArrayAdapter<Profile> {
    public static final String PICKED_FRIEND_EXTRA = "pickedfriend";

    private final Context context;
    private final List<Profile> values;

    // 1 == find friend
    // 2 == pick friend - schedule
    // 3 == pick friend - motivate
    private final int screen_id;

    public ProfileArrayAdapter(Context context, List<Profile> values, int screen_id) {
        super(context, R.layout.pick_friend_row, values);
        this.context = context;
        this.values = values;
        this.screen_id = screen_id;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.pick_friend_row, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.firstLine);
        TextView textView2 = (TextView) rowView.findViewById(R.id.secondLine);
        TextView textView3 = (TextView) rowView.findViewById(R.id.thirdLine);
        CircularImageView imageView = (CircularImageView) rowView.findViewById(R.id.row_profile_pic);
        imageView.setImageResource(values.get(position).picture);
        if (screen_id == 1) {
            textView.setText("Location: " + values.get(position).location);
            textView2.setText(values.get(position).name);
            textView3.setText("Activity: " + values.get(position).activity);
            Button btn = (Button) rowView.findViewById(R.id.add_friend_button);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Firebase fb = new Firebase("https://goalfriends.firebaseio.com/");
                    final String addedFriend = values.get(position).name;

//                    fb.child("addfriend").setValue( ((GoalfriendsApplication) context.getApplicationContext()).getProfile().name + values.get(position).name );
//                    ((GoalfriendsApplication) context.getApplicationContext()).getProfile().addFriend(values.get(position));
                    ((GoalfriendsApplication) context.getApplicationContext()).getNotifications().add("Sent Goalfriend request to " + addedFriend);
                    new AlertDialog.Builder(context)
                            .setTitle("Sent Request")
                            .setMessage("You've requested " + values.get(position).name + " to be your Goalfriend")
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Execute some code after 2 seconds have passed
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        public void run() {
                                            ((GoalfriendsApplication) context.getApplicationContext()).getNotifications().add(0, addedFriend + " accepted your request");

                                            ((GoalfriendsApplication) context.getApplicationContext()).getProfile().addFriend(values.get(position));

                                            ((GoalfriendsApplication) context.getApplicationContext()).refreshNotificationList();
                                        }
                                    }, 5000);


                                    ((Activity) context).finish();
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_info)
                            .show();


                }
            });
        } else if (screen_id == 2) {
            textView.setText("Activity: " + values.get(position).getActivity());
            textView2.setText(values.get(position).name);
            textView3.setText("Available: " + values.get(position).getAvailability());
            Button btn = (Button) rowView.findViewById(R.id.add_friend_button);
            btn.setText("Schedule Workout");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ScheduleWorkoutActivity.class);
                    intent.putExtra(PICKED_FRIEND_EXTRA, values.get(position).name);
                    context.startActivity(intent);
                }
            });
        } else if (screen_id == 3) {
            textView.setText("Cancellations: " + values.get(position).getActivity());
            textView2.setText(values.get(position).name);
            textView3.setText("Last Event: " + values.get(position).getAvailability());
            Button btn = (Button) rowView.findViewById(R.id.add_friend_button);
            btn.setText("Motivate");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MotivateActivity.class);
                    intent.putExtra(PICKED_FRIEND_EXTRA, values.get(position).name);
                    context.startActivity(intent);
                }
            });
        }

        return rowView;
    }
}
