package org.bubulescu.completecircle;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;


public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        preformTask();
        sendNotification(intent);
    }

    private void preformTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Log.e(getClass().getName(), e.toString());
        }
    }

    private void sendNotification(Intent i) {
        if (i.hasExtra(BcastReceiver.PARAM)) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(BcastReceiver.PARAM, i.getStringExtra(BcastReceiver.PARAM));
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Service finished")
                    .setContentIntent(pendingIntent);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(0, builder.build());
        }
    }

}
