package edu.quinnipiac.ser210.dadjokes;

import org.json.JSONException;
import org.json.JSONObject;

public class jokeHandler {


    public String getRandomJoke(String randomJokeJsonStr) throws JSONException {
        JSONObject randomJokeJSONObj = new JSONObject(randomJokeJsonStr);
        return randomJokeJSONObj.getString("setup");
    }
}
