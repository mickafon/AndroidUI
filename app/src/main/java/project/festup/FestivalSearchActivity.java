package project.festup;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class FestivalSearchActivity extends Activity {

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
        ListView listView = (ListView) findViewById(R.id.list);
        new Request(editText.getText().toString(), "Festival", listView, this).execute();
    }
}
