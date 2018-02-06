package project.festup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import project.festup.model.Artist;
import project.festup.model.Festival;

/**
 * Created by Micka on 28/01/2018.
 */

public class FestivalAdapter  extends ArrayAdapter<Object> {
    public FestivalAdapter(@NonNull Context context, @NonNull List<Object> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.list_row, null);

        ImageView imageView = (ImageView) row.findViewById(R.id.image);
        TextView nameTextView = (TextView) row.findViewById(R.id.name);

        Festival currentFestival = (Festival) getItem(position);

        //new DownloadImage(imageView).execute(currentFestival.getInformation());

        nameTextView.setText(currentFestival.getName());
        notifyDataSetChanged();
        return row;
    }

}
