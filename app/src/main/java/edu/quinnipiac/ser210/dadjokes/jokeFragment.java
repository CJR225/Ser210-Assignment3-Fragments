package edu.quinnipiac.ser210.dadjokes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link jokeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class jokeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public jokeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment jokeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static jokeFragment newInstance(String param1, String param2) {
        jokeFragment fragment = new jokeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        //SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(),new jokeHandler().getSetup(),R.layout.fragment_joke,0,0);





    JokesActivity activity = (JokesActivity) getActivity();
        String setuptext = activity.getSetup();
        TextView view = (TextView) getView().findViewById(R.id.jokeSetupFrag);
        view.setText(setuptext);

    return inflater.inflate(R.layout.fragment_joke, container, false);




    }



}