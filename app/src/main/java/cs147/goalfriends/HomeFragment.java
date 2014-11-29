package cs147.goalfriends;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.firebase.client.Firebase;

/**
 * Created by pveerina on 11/18/14.
 */
public class HomeFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    Firebase fb;
    ListView notificationList;
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static HomeFragment newInstance(int sectionNumber) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {
        fb = new Firebase("https://goalfriends.firebaseio.com/");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        notificationList = (ListView)rootView.findViewById(R.id.notificationList);
        notificationList.setAdapter(((GoalfriendsApplication) getActivity().getApplication()).getNotificationListAdapter());
        notificationList.setEmptyView(rootView.findViewById(R.id.noNotificationMessage));
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((ArrayAdapter<String>)notificationList.getAdapter()).notifyDataSetChanged();
    }
}
