package edu.quinnipiac.ser210.dadjokes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class jokeFragment extends Fragment {

    private String joke;

    public jokeFragment() {
        // Required empty public constructor
    }

    public void setJoke(String joke) {

        this.joke = joke;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




    return inflater.inflate(R.layout.fragment_joke, container, false);




    }
    @Override
    public void onStart() {

        super.onStart();

        View view = getView();

        if (view != null && joke != null) {
            TextView setupText = (TextView) view.findViewById(R.id.jokeSetupFrag);
            setupText.setText(joke);
        }
    }



}