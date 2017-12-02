package tech.iosd.yfhr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by AtulSachdeva on 02/12/17.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
