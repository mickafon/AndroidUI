package project.festup.FirebaseServices;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by aimee on 17/01/2018.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d("NotificationManager", remoteMessage.getNotification().toString());

        String ID;

        if (remoteMessage.getData().size() > 0) {
            //if the message contains data payload
            //It is a map of custom keyvalues
            //we can read it easily
            ID = remoteMessage.getData().get("ID");
        }

        //getting the title and the body
        String title = remoteMessage.getNotification().getTitle();
        String body = remoteMessage.getNotification().getBody();

        //then here we can use the title and body to build a notification
        MyNotificationManager.getInstance(getApplicationContext()).displayNotification(title, body);

    }

}
