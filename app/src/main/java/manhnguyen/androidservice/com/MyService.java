package manhnguyen.androidservice.com;

import static manhnguyen.androidservice.com.MyApplication.CHANNEL_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("manhKamil", "MyService OnCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String strDataIntent = intent.getStringExtra("key_data_extent");
        sendNotificationIntent(strDataIntent);
        return START_NOT_STICKY;
    }

    private void sendNotificationIntent(String strDataIntent) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Notification Service")
                .setContentText(strDataIntent).
                setContentIntent(pendingIntent).
                setSmallIcon(R.drawable.ic_baseline_announcement_24).build();
        startForeground(1, notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("manhKamil", "MyService OnDestroy");

    }
}
