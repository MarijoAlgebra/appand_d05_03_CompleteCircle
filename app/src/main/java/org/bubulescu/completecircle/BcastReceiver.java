package org.bubulescu.completecircle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BcastReceiver extends BroadcastReceiver {

    public static final String PARAM = "org.bubulescu.completecircle.BcastReceiver.param";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("BREC", "Bcast received");
        if (intent.hasExtra(PARAM)) {
            Intent i = new Intent(context, MyIntentService.class);
            i.putExtra(PARAM, intent.getStringExtra(PARAM));
            context.startService(i);
        }
    }
}
