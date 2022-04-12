package edu.quinnipiac.ser210.dadjokes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class punchlineFragment extends Fragment {

    private String punchline;

    public punchlineFragment() {
        // Required empty public constructor
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_punchline, container, false);
    }

    @Override
    public void onStart() {

        super.onStart();

        View view = getView();

        if (view != null && punchline != null) {
            TextView setupText = (TextView) view.findViewById(R.id.jokePunchline);
            setupText.setText(punchline);
        }
    }

}