package tech.iosd.yfhr;

import android.app.Application;
import android.os.SystemClock;

public class SplashApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(1000);
    }
}
