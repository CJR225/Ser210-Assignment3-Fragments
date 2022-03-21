package edu.quinnipiac.ser210.dadjokes;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class jokeHandler {


    public String getRandomJoke(String randomJokeJsonStr) throws JSONException {
        Log.i("holder",randomJokeJsonStr);
        JSONObject randomJokeJSONObj = new JSONObject(randomJokeJsonStr);
        //return randomJokeJSONObj.getString("text");

        JSONArray array = randomJokeJSONObj.getJSONArray("body");
        JSONObject firstObject = (JSONObject)array.get(0);
        String setup = firstObject.getString("setup");
        String punchline = firstObject.getString("punchline");
        return setup;
    }

}
