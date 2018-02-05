package project.festup.FirebaseServices;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

import project.festup.MainActivity;
import project.festup.R;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by aimee on 17/01/2018.
 */

public class MyNotificationManager {

    private Context context;
    private static MyNotificationManager notificationManager;

    public MyNotificationManager(Context context) {
        this.context = context;
    }

    public static synchronized MyNotificationManager getInstance(Context context) {
        if (notificationManager == null) {
            notificationManager = new MyNotificationManager(context);
        }
        return notificationManager;
    }

    public void displayNotification(String title, String body) {

        //Notification builder
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.icone)
                        .setContentTitle(title)
                        .setContentText(body);

        //Clicking on the notification will take us to this intent
        Intent resultIntent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        //Setting the pending intent to notification builder
        mBuilder.setContentIntent(pendingIntent);

        NotificationManager mNotifyMgr =
                (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

        /*
        * The first parameter is the notification id
        * better don't give a literal here (right now we are giving a int literal)
        * because using this id we can modify it later
        * */
        if (mNotifyMgr != null) {
            mNotifyMgr.notify(1, mBuilder.build());
        }
    }


}
