package cs147.goalfriends;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.pkmmte.view.CircularImageView;

/**
 * Created by pveerina on 11/18/14.
 */
public class ProfileFragment  extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    Profile pf;
    View rootView;


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ProfileFragment newInstance(int sectionNumber) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public Profile getProfile() {
        return pf;
    }

    public void setProfile(Profile pf) {
        this.pf = pf;
        if (rootView != null) {
            updateView();
        }
    }

    private void updateView() {
        ImageView cover = (ImageView) rootView.findViewById(R.id.coverphoto);
        CircularImageView profpic = (CircularImageView) rootView.findViewById(R.id.profpic);

        cover.setBackground(pf.coverPhoto);
        profpic.setBackground(pf.picture);

        TextView tv = (TextView) rootView.findViewById(R.id.myname);
        tv.setText(pf.name);



    }


    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        if (pf != null) {
            updateView();
        }
        ListView lw = (ListView)rootView.findViewById(R.id.topFriendsList);
        lw.setEmptyView(rootView.findViewById(R.id.noGoalfriendsMessage));
        return rootView;
    }

}
