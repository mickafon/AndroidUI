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
        Button go = (Button) findViewById(R.id.buttonGo);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAddArtistActivity();
            }
        });

    }

    public void goToAddArtistActivity(){
        Intent intent = new Intent(this, ArtistSearchActivity.class);
        startActivity(intent);
    }
}
