/**
 * JokeHander class - Handles the inputted string from api using JSON
 *
 * @author Chris Rocco & Rion-Mark Mclaren
 * @date 3/21/22
 */

package edu.quinnipiac.ser210.dadjokes;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class jokeHandler {


    public ArrayList<String> getRandomJoke(String randomJokeJsonStr) throws JSONException {
        Log.i("holder",randomJokeJsonStr);
        JSONObject randomJokeJSONObj = new JSONObject(randomJokeJsonStr);

        JSONArray array = randomJokeJSONObj.getJSONArray("body");
        JSONObject firstObject = (JSONObject)array.get(0);
        String setup = firstObject.getString("setup");
        String punchline = firstObject.getString("punchline");

        ArrayList<String> list = new ArrayList<String>();
        list.add(setup);
        list.add(punchline);

        return list;
    }

}
