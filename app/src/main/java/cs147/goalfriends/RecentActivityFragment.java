package cs147.goalfriends;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.pkmmte.view.CircularImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pveerina on 11/18/14.
 */
public class RecentActivityFragment  extends Fragment {
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
    public static RecentActivityFragment newInstance(int sectionNumber) {
        RecentActivityFragment fragment = new RecentActivityFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public RecentActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        ListView lw = (ListView)rootView.findViewById(R.id.topFriendsList);
        lw.setAdapter(pf.topFriendsAdapter);
        lw.setEmptyView(rootView.findViewById(R.id.noGoalfriendsMessage));
        return rootView;
    }



    @Override
    public void onResume() {
        super.onResume();
    }
}
