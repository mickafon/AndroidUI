package project.festup;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.Serializable;

import project.festup.model.Artist;

public class ArtistSearchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_search);
        Button search = (Button) findViewById(R.id.buttonSearch);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getList();
            }
        });
    }

    public void getList() {
        EditText editText = (EditText) findViewById(R.id.editText);
        final ListView listView = (ListView) findViewById(R.id.list);
        new Request(editText.getText().toString(), "Artist", listView, this).execute();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Artist artist = (Artist) listView.getItemAtPosition(i);
                goToArtistPage(artist);
            }
        });
    }

    public void goToArtistPage(Artist artist){
        Intent intent = new Intent(this, ArtistActivity.class);
        intent.putExtra("artist", (Serializable) artist);
        startActivity(intent);
    }
}
