package project.festup.WidgetServices;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;

import project.festup.R;
import project.festup.model.Festival;

/**
 * Implementation of App Widget functionality.
 */
public class NextEventWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/YYYY");
        String title, name, date, location;

        //GET FESTIVAL & INIT WIDGET : NEXT DATE OR SUGGEST
        Festival festival = getnextevent();

        if(festival != null) {
            title = "Prochain Festival :";
        } else {
            festival = getsuggestevent();
            title = "Suggestion :";
        }

        name = festival.getName();
        date = formater.format(festival.getStartDate()) + " - " + formater.format(festival.getEndDate());
        location = festival.getLocation();

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.next_event_widget);
        views.setTextViewText(R.id.w_festival_title, title);
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



    private static Festival getnextevent() {

        Festival festival;

        //TODO : modifier afin de récupérer le prochain event pour un user
        festival = new Festival("SuperFestival n°1", "Paname");

        return festival;
    }

    private static Festival getsuggestevent() {

        Festival festival;

        //TODO : modifier afin de récupérer un event de suggestion (random sur top 10 festival ? )
        festival = new Festival("SuperFestival n°2", "Paname");

        return festival;

    }

}

