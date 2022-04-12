/**
 * JokeActivity - Displays multiple textviews that house setup and punchline of joke, and accepts user edittext
 *
 * @author Chris Rocco & Rion-Mark Mclaren
 * @date 3/21/22
 * <p>
 * I dont know if it counts but the background is an image
 */


package edu.quinnipiac.ser210.dadjokes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {

    jokeHandler jkHandler = new jokeHandler();
    ImageView jokebkgrnd;
    private String joke;
    private String punchline;


    //key: 9cc181177emsh18889f38a315853p1ff686jsn7ec323484f9f
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

        joke = (String) getIntent().getExtras().get("Joke");
        punchline = (String) getIntent().getExtras().get("Punchline");

        jokeFragment frag = (jokeFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);

        frag.setJoke(joke);


    }

    public String getSetup() {

        return joke;
    }



    public String getPunchline() {
        return punchline;
    }

    public void onClick(View view) {
        punchlineFragment fragP = new punchlineFragment();
        fragP.setPunchline(punchline);


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainerView, fragP);
        ft.commit();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

    }


}