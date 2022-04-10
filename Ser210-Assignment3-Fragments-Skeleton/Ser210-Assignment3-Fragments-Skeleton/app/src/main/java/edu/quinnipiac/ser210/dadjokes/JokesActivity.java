/**
 * JokeActivity - Displays multiple textviews that house setup and punchline of joke, and accepts user edittext
 *
 * @author Chris Rocco & Rion-Mark Mclaren
 * @date 3/21/22
 *
 * I dont know if it counts but the background is an image
 */


package edu.quinnipiac.ser210.dadjokes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {

jokeHandler jkHandler = new jokeHandler();
    ImageView jokebkgrnd;
    /*
    key: 9cc181177emsh18889f38a315853p1ff686jsn7ec323484f9f
    Re-builds the action bar in the Joke Activity screen.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
    /*
    Gets the intent joke from the main activity, and updates the text view to display it
     */
        String joke = (String) getIntent().getExtras().get("Joke");
        TextView textView = (TextView) findViewById(R.id.jokeSetup);
        textView.setText(joke);

    }

    public void onClick(View view) {
    /*
    Gets the intent punchline from the main activity, and updates the text view to display it
     */
    String punchline = (String) getIntent().getExtras().get("Punchline");
        TextView textView = (TextView) findViewById(R.id.jokePunchline);
        textView.setText(punchline);
    }



}