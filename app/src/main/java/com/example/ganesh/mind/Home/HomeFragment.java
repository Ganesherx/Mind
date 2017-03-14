package com.example.ganesh.mind.Home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.ganesh.mind.R;
import com.example.ganesh.mind.Utils.Constants;
import com.example.ganesh.mind.model.MindCardList;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ListView mListView;
    private DatabaseReference activeCardsRef;
    private ActiveCardAdapter mActiveCardAdapter;


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment homeFragment = new HomeFragment();
        Bundle args = new Bundle();
        homeFragment.setArguments(args);
        return homeFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        initializeScreen(rootView);
        Firebase.setAndroidContext(getActivity());

        activeCardsRef = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_LOCATION_ACTIVE_CARDS);
        mActiveCardAdapter = new ActiveCardAdapter(getActivity(),
                MindCardList.class,
                R.layout.single_active_card,
                activeCardsRef);


        mListView.setAdapter(mActiveCardAdapter);

        return rootView;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
       mActiveCardAdapter.cleanup();

    }

    private void initializeScreen(View rootView) {
        mListView = (ListView) rootView.findViewById(R.id.list_view_active_cards);

    }

}
