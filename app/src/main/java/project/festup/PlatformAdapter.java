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

import project.festup.model.Media;
import project.festup.model.Platform;

/**
 * Created by Micka on 05/02/2018.
 */

public class PlatformAdapter extends ArrayAdapter<Platform> {

    public PlatformAdapter(@NonNull Context context, @NonNull List<Platform> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.platform_list_row, null);

        Platform currentPlatform = (Platform) getItem(position);
        TextView nameTextView = (TextView) row.findViewById(R.id.name_platform);

        if (currentPlatform != null){
            if (currentPlatform.getUrl() != null){
                nameTextView.setText(currentPlatform.getUrl());
            }
        }
        notifyDataSetChanged();
        return row;
    }
}
