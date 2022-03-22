/**
 * MainActivity - Houses the async class which connects to the api api,
 * connects to handler and outputs the variables in a arraylist to be retrieved using intent
 *
 * @author Chris Rocco & Rion-Mark Mclaren
 * @date 3/21/22
 * I dont know if it counts but the background is an image
 */


package edu.quinnipiac.ser210.dadjokes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String LOG_TAG = MainActivity.class.getSimpleName();
    jokeHandler jkHandler = new jokeHandler();

    private ShareActionProvider shareActionProvider;
    private String url1 = ("https://dad-jokes.p.rapidapi.com/random/jokes");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView mainbkgrnd = findViewById(R.id.mainBkgrnd);

    }

    public void onClick(View view) {

        Intent intent = new Intent(this, JokesActivity.class);


        new FetchJoke().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("Want to share this dad joke?");


        return super.onCreateOptionsMenu(menu);

    }

    private void setShareActionIntent(String text) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.blue_background:
                mainbkgrnd.setImageResource(R.drawable.navy_bkgrnd);
                break;
            case R.id.red_background:
                mainbkgrnd.setImageResource(R.drawable.red_and_black_synthwave_phone_wallpaper);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    class FetchJoke extends AsyncTask<ArrayList<String>, Void, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(ArrayList<String>... arrayLists) {

            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            ArrayList<String> joke;

            try {
                URL url = new URL(url1);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setRequestProperty("X-RapidAPI-Key", "9cc181177emsh18889f38a315853p1ff686jsn7ec323484f9f");
                urlConnection.connect();

                InputStream in = urlConnection.getInputStream();
                if (in == null)
                    return null;

                reader = new BufferedReader(new InputStreamReader(in));
                joke = getStringFromBuffer(reader);


            } catch (Exception e) {
                Log.e(LOG_TAG, "Error" + e.getMessage());
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        Log.e(LOG_TAG, "Error" + e.getMessage());
                        return null;
                    }
                }
            }
            return joke;
        }

        @Override
        protected void onPostExecute(ArrayList<String> result) {
            if (result != null)
                Log.d(LOG_TAG, "Result is null");
            Intent intent = new Intent(MainActivity.this, JokesActivity.class);
            intent.putExtra("Joke", result.get(0));
            intent.putExtra("Punchline", result.get(1));
            startActivity(intent);
        }
    }

    private ArrayList<String> getStringFromBuffer(BufferedReader bufferedReader) {
        StringBuffer buffer = new StringBuffer();
        String line;

        if (bufferedReader != null) {
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    buffer.append(line + '\n');
                }
                bufferedReader.close();
                return jkHandler.getRandomJoke(buffer.toString());
            } catch (Exception e) {
                Log.e("MainActivity", "Error" + e.getMessage());
                return null;
            } finally {

            }
        }
        return null;
    }
}