package project.festup;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Micka on 19/01/2018.
 */

public class DownloadImage extends AsyncTask<String, Long, Drawable> {
    private ImageView image;

    public DownloadImage(ImageView image) {
        this.image = image;
    }


    @Override
    protected Drawable doInBackground(String... strings) {
        Drawable draw = null;
        try {
            InputStream is = (InputStream) new URL(strings[0]).getContent();
            draw = Drawable.createFromStream(is, "src");
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return draw;
    }

    @Override
    protected void onPostExecute(Drawable drawable) {
        super.onPostExecute(drawable);
        image.setImageDrawable(drawable);
    }
}
