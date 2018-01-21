package project.festup;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import project.festup.model.Artist;

/**
 * Created by Micka on 15/01/2018.
 */

public class ArtistAdapter extends ArrayAdapter<Artist> {
    public ArtistAdapter(@NonNull Context context, @NonNull List<Artist> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.list_row, null);

        ImageView imageView = (ImageView) row.findViewById(R.id.image);
        TextView nameTextView = (TextView) row.findViewById(R.id.name);

        Artist currentArtist = getItem(position);

        new DownloadImage(imageView).execute(currentArtist.getThumb());

        nameTextView.setText(currentArtist.getTitle());

        return row;
    }
}
