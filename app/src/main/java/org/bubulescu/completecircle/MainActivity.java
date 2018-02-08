package org.bubulescu.completecircle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handleIntent(getIntent());
    }

    private void handleIntent(Intent intent) {
        if (intent.hasExtra(BcastReceiver.PARAM)) {
            Toast.makeText(this, intent.getStringExtra(BcastReceiver.PARAM), Toast.LENGTH_SHORT).show();
        }
    }
}
