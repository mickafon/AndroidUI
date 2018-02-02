package project.festup;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Objects;

import project.festup.model.Artist;


/**
 * Created by mickael.afonso on 17/12/2017.
 */
public class Request extends AsyncTask<String, Long, ArrayList<Object>> {
    private String site = "http://localhost:3000";
    private String link;
    private String type;
    protected ListView listView;
    protected Activity activity;

    public Request(String page, String type, ListView listView, Activity activity){
        link = site + page;
        this.type = type;
        this.listView = listView;
        this.activity = activity;
        System.out.println(link);
    }

    @Override
    protected ArrayList<Object> doInBackground(String... strings) {
        ArrayList<Object> objects = new ArrayList<>();
        try {
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(1500);
            conn.setRequestMethod("GET");
            conn.connect();

            InputStream is = conn.getInputStream();
            InputStreamReader isReader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(isReader);
            String line = null;

            while ((line = bufferedReader.readLine()) != null){
                objects = parseJson(line);
            }

            is.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objects;
    }

    public ArrayList<Object> parseJson(String json){
        JsonElement jelement = new JsonParser().parse(json);
        JsonObject jobject = jelement.getAsJsonObject();
        JsonArray jarray = jobject.getAsJsonArray("results");
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < jarray.size(); i++) {
            JsonObject jsonObject = jarray.get(i).getAsJsonObject();
            switch (type){
                case "Artist":
                    //objects.add(new Artist(jsonObject.get("id").getAsInt(), jsonObject.get("thumb").getAsString(), jsonObject.get("title").getAsString(), jsonObject.get("resource_url").getAsString()));
                    break;
            }

        }
        return objects;
    }

    @Override
    protected void onPostExecute(ArrayList<Object> objects) {
        super.onPostExecute(objects);
        ArtistAdapter artistAdapter = new ArtistAdapter(activity, objects);
        listView.setAdapter(artistAdapter);
    }
}
