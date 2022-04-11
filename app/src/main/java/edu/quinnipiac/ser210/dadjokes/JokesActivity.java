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
    String joke;

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

        Fragment fr1 = new jokeFragment();



        //TextView textView = (TextView) findViewById(R.id.jokeSetup);
        //textView.setText(joke);


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainerView, fr1);
        ft.commit();
    }

    public String getSetup() {
        return joke;
    }
    public void onClick(View view) {

        Fragment fr2 = new punchlineFragment();


        String punchline = (String) getIntent().getExtras().get("Punchline");
        //TextView textView = (TextView) findViewById(R.id.jokePunchline);
        //textView.setText(punchline);





        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainerView, fr2);
        ft.commit();


    }

    /*
    public void selectFrag(View view) {
        Fragment fr;
        if (view == findViewById(R.id.buttonJoke)) {
            fr = new jokeFragment();
        } else {
            fr = new punchlineFragment();

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragmentContainerView,fr);
            ft.commit();
        }

     */


}