package cs147.goalfriends;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pkmmte.view.CircularImageView;

import java.util.List;

/**
 * Created by pveerina on 11/19/14.
 */
public class ProfileArrayAdapter extends ArrayAdapter<Profile> {

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
        imageView.setImageDrawable(values.get(position).picture);
        textView.setText("Location: " + values.get(position).location);
        textView2.setText(values.get(position).name);
        textView3.setText("Activity: " + values.get(position).activity);
        Button btn = (Button) rowView.findViewById(R.id.add_friend_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((GoalfriendsApplication)context.getApplicationContext()).getProfile().addFriend(values.get(position));
                ((GoalfriendsApplication)context.getApplicationContext()).getNotifications().add("Sent Goalfriend request to " + values.get(position).name);
                new AlertDialog.Builder(context)
                        .setTitle("Sent Request")
                        .setMessage("You've requested " + values.get(position).name + " to be your Goalfriend")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                ((Activity)context).finish();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .show();


        }});
        return rowView;
    }
}
