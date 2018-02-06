package project.festup;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.os.StrictMode;
import android.widget.ListView;
import android.widget.Switch;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Objects;

import project.festup.WidgetServices.FestivalSuggestionWidget;
import project.festup.model.Address;
import project.festup.model.Artist;
import project.festup.model.Festival;
import project.festup.model.Media;
import project.festup.model.Platform;
import project.festup.model.Scene;


/**
 * Created by mickael.afonso on 17/12/2017.
 */
public class Request extends AsyncTask<String, Long, ArrayList<Object>> {
    private String site = "http://10.0.2.2:3000";
    private String link;
    private String type;
    private String textPostReq;
    protected ListView listView;
    protected Activity activity;

    public Request(String page, String type, String textPostReq, ListView listView, Activity activity){
        link = site + page;
        this.type = type;
        this.textPostReq = textPostReq;
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
            if (textPostReq != null){
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("charset", "utf-8");
                conn.setRequestMethod("POST");

                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("term", textPostReq);
                System.out.println(jsonObject.toString());
                OutputStreamWriter writer = null;
                writer = new OutputStreamWriter(conn.getOutputStream());
                writer.write(jsonObject.toString());
                writer.close();

            }
            else{
                conn.setRequestMethod("GET");
                conn.connect();
            }


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
        ArrayList<Object> objects = new ArrayList<>();
        JsonElement jelement = new JsonParser().parse(json);
        JsonObject jobject = jelement.getAsJsonObject();

        if (jobject.get("result").getAsInt() == 1) {
            JsonArray jarray = jobject.getAsJsonArray("content");
            for (int i = 0; i < jarray.size(); i++) {
                JsonObject jsonObject = jarray.get(i).getAsJsonObject();

                switch (type) {
                    case "artist":
                        Artist artist = getArtist(jsonObject);
                        artist.setFestivals(getFestivals(jsonObject.getAsJsonArray("festivals")));
                        if (jsonObject.get("medias") != null) {
                            artist.setMedias(getMedias(jsonObject.getAsJsonArray("medias")));
                        }
                        if (jsonObject.get("platforms") != null) {
                            artist.setPlatforms(getPlatforms(jsonObject.getAsJsonArray("platforms")));
                        }
                        objects.add(artist);
                        break;
                    case "festival":
                        Festival festival = getFestival(jsonObject);
                        if (jsonObject.get("artists") != null) {
                            festival.setArtists(getArtists(jsonObject.getAsJsonArray("artists")));
                        }
                        if (jsonObject.get("medias") != null) {
                            festival.setMedias(getMedias(jsonObject.getAsJsonArray("medias")));
                        }
                        if (jsonObject.get("platforms") != null) {
                            festival.setPlatforms(getPlatforms(jsonObject.getAsJsonArray("platforms")));
                        }
                        objects.add(festival);
                        break;
                }
            }

        }
        return objects;
    }

    public Artist getArtist(JsonObject jsonObject){
        Artist artist = new Artist();
        artist.setId(jsonObject.get("id").getAsInt());
        artist.setName(jsonObject.get("name").getAsString());
        artist.setDescription(jsonObject.get("description").getAsString());
        return artist;
    }

    public ArrayList<Artist> getArtists(JsonArray jarray){
        ArrayList<Artist> artists = new ArrayList<>();
        for (int i = 0; i < jarray.size(); i++) {
            JsonObject jsonObject = jarray.get(i).getAsJsonObject();
            artists.add(getArtist(jsonObject));
        }
        return artists;
    }

    public Festival getFestival(JsonObject jsonObject){
        Festival festival = new Festival();
        festival.setId(jsonObject.get("id").getAsInt());
        festival.setName(jsonObject.get("name").getAsString());
        festival.setDescription(jsonObject.get("description").getAsString());
        festival.setInformation(jsonObject.get("information").getAsString());
        //DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.getDefault());
        //Date date = dateFormat.parse(jsonObject.get("begin").getAsString());
        festival.setBegin(jsonObject.get("begin").getAsString());
        festival.setEnd(jsonObject.get("end").getAsString());

        if (jsonObject.get("address") != null){
            festival.setAddress(getAddress(jsonObject.get("address").getAsJsonObject()));
        }
        return festival;
    }

    public ArrayList<Festival> getFestivals(JsonArray jarray){
        ArrayList<Festival> festivals = new ArrayList<>();
        for (int i = 0; i < jarray.size(); i++) {
            JsonObject jsonObject = jarray.get(i).getAsJsonObject();
            festivals.add(getFestival(jsonObject));
        }
        return festivals;
    }

    public Address getAddress(JsonObject jsonObject){
        Address address = new Address();
        address.setId(jsonObject.get("id").getAsInt());
        address.setName(jsonObject.get("name").getAsString());
        address.setAdditional(jsonObject.get("additional").getAsString());
        address.setStreet(jsonObject.get("street").getAsString());
        address.setCity(jsonObject.get("city").getAsString());
        address.setPostal(jsonObject.get("additional").getAsString());
        return address;
    }

    public Media getMedia(JsonObject jsonObject){
        Media media = new Media();
        media.setId(jsonObject.get("id").getAsInt());
        media.setName(jsonObject.get("name").getAsString());
        media.setUrl(jsonObject.get("url").getAsString());
        return media;
    }

    public ArrayList<Media> getMedias(JsonArray jarray){
        ArrayList<Media> medias = new ArrayList<>();
        for (int i = 0; i < jarray.size(); i++) {
            JsonObject jsonObject = jarray.get(i).getAsJsonObject();
            medias.add(getMedia(jsonObject));
        }
        return medias;
    }

    public Platform getPlatform(JsonObject jsonObject){
        Platform platform = new Platform();
        platform.setId(jsonObject.get("id").getAsInt());
        platform.setName(jsonObject.get("name").getAsString());
        platform.setUrl(jsonObject.get("url").getAsString());
        return platform;
    }

    public ArrayList<Platform> getPlatforms(JsonArray jarray){
        ArrayList<Platform> platform = new ArrayList<>();
        for (int i = 0; i < jarray.size(); i++) {
            JsonObject jsonObject = jarray.get(i).getAsJsonObject();
            platform.add(getPlatform(jsonObject));
        }
        return platform;
    }

    public Scene getScene(JsonObject jsonObject){
        Scene scene = new Scene();
        scene.setId(jsonObject.get("id").getAsInt());
        scene.setName(jsonObject.get("name").getAsString());
        scene.setDescription(jsonObject.get("description").getAsString());
        return scene;
    }

    public ArrayList<Scene> getScenes(JsonArray jarray){
        ArrayList<Scene> scenes = new ArrayList<>();
        for (int i = 0; i < jarray.size(); i++) {
            JsonObject jsonObject = jarray.get(i).getAsJsonObject();
            scenes.add(getScene(jsonObject));
        }
        return scenes;
    }

   /* public DateFormat parseDate(String strDate){
        /*DateFormat date = DateFormat.getDateTimeInstance().parse("d")
        return
    }*/

    @Override
    protected void onPostExecute(ArrayList<Object> objects) {
        super.onPostExecute(objects);
        switch (type) {
            case "artist":
                ArtistAdapter artistAdapter = new ArtistAdapter(activity, objects);
                listView.setAdapter(artistAdapter);
                break;
            case "festival":
                if (listView != null) {
                    FestivalAdapter festivalAdapter = new FestivalAdapter(activity, objects);
                    listView.setAdapter(festivalAdapter);
                }
                break;
        }
    }
}
