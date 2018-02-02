package project.festup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import project.festup.model.Festival;

public class FestivalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival);
        Festival festival = (Festival) getIntent().getSerializableExtra("festival");
        TextView name = (TextView) findViewById(R.id.inputName);
        name.setText(festival.getName());
    }


}
