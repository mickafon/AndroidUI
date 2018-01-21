package project.festup;

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
public class Request extends AsyncTask<String, Long, ArrayList<Artist>> {
    private String site = "https://api.discogs.com/database/search?key=aDcvryBIrPKnnwxMNLro&secret=PwQfycIWOaRcgXclBnFoQhIDTUfFeLfg&type=artist";
    private String link;
    private String type;
    protected ListView listView;
    protected ArtistSearchActivity activity;

    public Request(String page, String type, ListView listView, ArtistSearchActivity activity){
        page = "&q=" + page;
        link = site + page;
        this.type = type;
        this.listView = listView;
        this.activity = activity;
        System.out.println(link);
    }

    @Override
    protected ArrayList<Artist> doInBackground(String... strings) {
        ArrayList<Artist> objects = new ArrayList<>();
        try {
            /*StrictMode.ThreadPolicy policy = new StrictMode.
                    ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);*/
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(1500);
            conn.setRequestMethod("GET");
            //conn.setDoOutput(true);
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

    public ArrayList<Artist> parseJson(String json){
        JsonElement jelement = new JsonParser().parse(json);
        JsonObject jobject = jelement.getAsJsonObject();
        JsonArray jarray = jobject.getAsJsonArray("results");
        ArrayList<Artist> artists = new ArrayList<>();
        for (int i = 0; i < jarray.size(); i++) {
            JsonObject jsonObject = jarray.get(i).getAsJsonObject();
            artists.add(new Artist(jsonObject.get("id").getAsInt(), jsonObject.get("thumb").getAsString(), jsonObject.get("title").getAsString(), jsonObject.get("resource_url").getAsString()));
        }
        return artists;
    }

    @Override
    protected void onPostExecute(ArrayList<Artist> objects) {
        super.onPostExecute(objects);
        ArtistAdapter artistAdapter = new ArtistAdapter(activity, objects);
        listView.setAdapter(artistAdapter);
    }
}
