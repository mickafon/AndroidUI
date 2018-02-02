package project.festup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import project.festup.model.Artist;

public class ArtistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
        Artist artist = (Artist) getIntent().getSerializableExtra("artist");
        TextView name = (TextView) findViewById(R.id.inputName);
        name.setText(artist.getName());
    }
}
