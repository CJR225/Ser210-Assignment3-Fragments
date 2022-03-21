package edu.quinnipiac.ser210.dadjokes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {



    //key: 9cc181177emsh18889f38a315853p1ff686jsn7ec323484f9f
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);

        String joke = (String) getIntent().getExtras().get("Joke");
        TextView textView = (TextView) findViewById(R.id.jokeSetup);
        textView.setText(joke);
    }

    public void onClick(View view) {


    }
}