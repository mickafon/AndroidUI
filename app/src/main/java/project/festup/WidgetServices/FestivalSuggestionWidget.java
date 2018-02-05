package project.festup.WidgetServices;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import project.festup.MainActivity;
import project.festup.R;
import project.festup.Request;
import project.festup.model.Addresses;
import project.festup.model.Festival;

/**
 * Implementation of App Widget functionality.
 */
public class FestivalSuggestionWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        String name = "", date = "", location = "";
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/YYYY");
        Random rand = new Random();

        ArrayList<Festival> list = getnextfestival();

        if (list.size() > 0) {
            int max = list.size();
            int value = rand.nextInt(max);
            Festival festival = list.get(value);

            if (festival != null) {
                name = festival.getName();
                date = formater.format(festival.getBegin()) + " - " + formater.format(festival.getEnd());
                location = festival.getAddress().getPostal() + " (" + festival.getAddress().getCity() + ")";
            }
        }

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.festival_suggestion_widget);
        views.setTextViewText(R.id.w_festival_name, name);
        views.setTextViewText(R.id.w_festival_date, date);
        views.setTextViewText(R.id.w_festival_location, location);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    public static ArrayList<Festival> getnextfestival() {

        ArrayList<Festival> list = new ArrayList<Festival>();
        Request req = new Request("/festivals/coming", "GET", null, null, null);
        req.execute();
        list = req.getFestivalArrayList();
        return list;
    }

}
