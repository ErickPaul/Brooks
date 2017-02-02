package cloudit.brooks;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.gcm.GoogleCloudMessaging;

public class SplashActivity extends Activity {
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    GoogleCloudMessaging gcmObj;
    private static final int MY_PERMISSIONS_REQUEST_Call_Contacts = 1;
    public static String regId = "";
    int PERMISSION_ALL = 1;
    String[] PERMISSIONS = {Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_FINE_LOCATION};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if(!hasPermissions(this, PERMISSIONS)){
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }
        else {
            Handler handler1 = new Handler();

            handler1.postDelayed(new Runnable() {

                @Override
                public void run()

                {


                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();


                }
            }, 4000);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        // Toast.makeText(SplashScreen.this, "Entered"+requestCode, Toast.LENGTH_SHORT).show();
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_Call_Contacts: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    //  Toast.makeText(SplashScreen.this, ""+requestCode, Toast.LENGTH_SHORT).show();
                    if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                            PackageManager.PERMISSION_GRANTED) {
                        // Toast.makeText(SplashScreen.this, "No granted", Toast.LENGTH_SHORT).show();

                        if(!hasPermissions(this, PERMISSIONS)){
                            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
                        }
                        else {
                            // Toast.makeText(SplashScreen.this, "granted", Toast.LENGTH_SHORT).show();
                            Handler handler1 = new Handler();

                            handler1.postDelayed(new Runnable() {

                                @Override
                                public void run()

                                {


                                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                                    startActivity(i);
                                    finish();


                                }
                            }, 4000);
                        }

                        return;
                    }
                    else {
                        //  Toast.makeText(SplashScreen.this, "granted", Toast.LENGTH_SHORT).show();
                        Handler handler1 = new Handler();

                        handler1.postDelayed(new Runnable() {

                            @Override
                            public void run()

                            {


                                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                                startActivity(i);
                                finish();


                            }
                        }, 4000);
                    }


                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {
                    // Toast.makeText(SplashScreen.this, "else request code", Toast.LENGTH_SHORT).show();
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }


        return;
    }


    public static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
}
