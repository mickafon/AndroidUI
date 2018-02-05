package project.festup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

import project.festup.model.Media;

/**
 * Created by Micka on 05/02/2018.
 */

public class MediaAdapter extends ArrayAdapter<Media> {

    public MediaAdapter(@NonNull Context context,  @NonNull List<Media> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.media_list_row, null);

        Media currentMedia = (Media) getItem(position);
        ImageView imageView = (ImageView) row.findViewById(R.id.image_media);

        if (currentMedia != null){
            if (currentMedia.getUrl() != null){
                new DownloadImage(imageView).execute(currentMedia.getUrl());
            }
        }

        return row;
    }
}
