package com.riezki.serviceapp;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * @author riezkymaisyar
 */

public class MyService extends Service {

    public interface MyServiceCallback {
        void onReceivedStringData(String data);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        sendDataToActivity();
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void setCallback(MyServiceCallback callback) {
        callback.onReceivedStringData("Hi!, this is from service");
    }

    private void sendDataToActivity() {
        Log.i("MainActivity", "Received data from service out");
    }
}
