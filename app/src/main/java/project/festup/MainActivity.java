package project.festup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button artist = (Button) findViewById(R.id.artistButton);
        Button festival = (Button) findViewById(R.id.festivalButton);

        artist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAddArtistActivity();
            }
        });

        festival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAddFestivalActivity();
            }
        });

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame, new MenuFragment())
                .commit();
    }

    public void goToAddArtistActivity(){
        Intent intent = new Intent(this, ArtistSearchActivity.class);
        startActivity(intent);
    }

    public void goToAddFestivalActivity(){
        Intent intent = new Intent(this, FestivalSearchActivity.class);
        startActivity(intent);
    }
}
