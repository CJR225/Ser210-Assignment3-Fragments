package edu.quinnipiac.ser210.dadjokes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

public class JokesActivity extends AppCompatActivity {


    //key: 9cc181177emsh18889f38a315853p1ff686jsn7ec323484f9f
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
    }

    public void onClick(View view) {

    }
}