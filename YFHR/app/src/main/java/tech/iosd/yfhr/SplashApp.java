package tech.iosd.yfhr;

import android.app.Application;
import android.os.SystemClock;

/**
 * Created by AtulSachdeva on 02/12/17.
 */

public class SplashApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(1000);
    }
}
