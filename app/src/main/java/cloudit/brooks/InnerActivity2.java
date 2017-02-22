package cloudit.brooks;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import cloudit.brooks.Adapter.Inneradapter;
import cloudit.brooks.checker.ConnectionDetector;
import cn.pedant.SweetAlert.SweetAlertDialog;
import views.WorkaroundMapFragment;

public class InnerActivity2 extends FragmentActivity implements DatePickerDialog.OnDateSetListener, OnMapReadyCallback {
        LinearLayout allamenties,llfordetails,llforopen,back;
    MapView mapView;
    FrameLayout actionbar;
    public static Boolean isInternetPresent = false;
    public static GoogleMap map;
    ImageView close;
    String date1="";
    Calendar c2 = Calendar.getInstance();

    public static ConnectionDetector cd;
    TextView ca;
    ListView lv;
    String date;
    static SimpleDateFormat dfDate  = new SimpleDateFormat("dd-MM-yyyy");
    int count =0;
    private int myear;
    private int mmonth;
    private int mday;
    private int myear2;
    private int mmonth2;
    private int mday2;
    LinearLayout llfrom, llto;
    TextView fromvalue, tovalue;
    int data[]={R.drawable.dd,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Statusbar.setStatusBarColor(InnerActivity2.this, R.color.statusbar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner2);
        map = ((WorkaroundMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapgh)).getMap();
        back = (LinearLayout) findViewById(R.id.back22);
        close = (ImageView) findViewById(R.id.close);
        ca = (TextView) findViewById(R.id.ca);
        tovalue = (TextView) findViewById(R.id.tovalue);
        fromvalue = (TextView) findViewById(R.id.datevalue);
        allamenties = (LinearLayout) findViewById(R.id.all_amenties);
        actionbar = (FrameLayout) findViewById(R.id.actionbar);
        llfordetails = (LinearLayout) findViewById(R.id.llfordetails);
        llforopen = (LinearLayout) findViewById(R.id.llforopen);
        llfrom = (LinearLayout) findViewById(R.id.llfrom);
        llto = (LinearLayout) findViewById(R.id.llto);
        lv = (ListView) findViewById(R.id.listView2);
        cd = new ConnectionDetector(InnerActivity2.this);
        lv.setAdapter(new Inneradapter(InnerActivity2.this));

        TextView textView = (TextView) findViewById(R.id.text2);
        textView.append(Html.fromHtml("<a href=\"mailto:allanwanzallah@gmail.com\"><b> E-Mail Us</b></a><br/>\n"));

        getthetracker("-0.4500", "36.2500");
        for (int i = 0; i < 1; i++) {
//            addviewLayout.addView(HorizontalList(R.layout.horizontal_items_layout, image[i], name[i],
//                    price[i], listprice[i], i,pid[i]));
            allamenties.addView(HorizontalList(R.layout.itemlayoutfrspecificroomhori));
        }

        llforopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llfordetails.animate()
                        .translationY(0)
                        .alpha(0.0f)
                        .setDuration(500)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                llfordetails.setVisibility(View.GONE);
                            }
                        });
                actionbar.animate()
                        .translationY(0)
                        .alpha(0.0f)
                        .setDuration(500)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                actionbar.setVisibility(View.GONE);
                            }
                        });
                ca.animate()
                        .translationY(0)
                        .alpha(0.0f)
                        .setDuration(500)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                ca.setVisibility(View.GONE);
                            }
                        });
                YoYo.with(Techniques.SlideInUp)
                        .duration(500)
                        .playOn(findViewById(R.id.close));
                close.setVisibility(View.VISIBLE);
                lv.setSelection(0);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        llfrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count =0;
                date1="";
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        InnerActivity2.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)

                );
                Calendar c = Calendar.getInstance();
                dpd.setMinDate(c);
                dpd.setAccentColor(Color.parseColor("#c34040"));
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });
        llto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=1;
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        InnerActivity2.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)

                );
                Calendar c = Calendar.getInstance();
                dpd.setMinDate(c);
                dpd.setAccentColor(Color.parseColor("#c34040"));
                dpd.show(getFragmentManager(), "Datepickerdialog");

            }
        });
        ca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!fromvalue.getText().toString().trim().equals("Please Select")&&
                        !tovalue.getText().toString().trim().equals("Please Select")){
                if (!ca.getText().toString().trim().equals("Instant Book")) {
                    Toast.makeText(InnerActivity2.this, "Checking availibility...", Toast.LENGTH_SHORT).show();
                    Handler handler1 = new Handler();

                    handler1.postDelayed(new Runnable() {

                        @Override
                        public void run()

                        {
                            Toast.makeText(InnerActivity2.this, "Availabl!", Toast.LENGTH_SHORT).show();
                            ca.setText("Instant Book");
                        }
                    }, 2000);
                }
                else {
                    new SweetAlertDialog(v.getContext(), SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Confirmed!")
                            .setContentText("Your are booked! Proceed to Pay.")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sweetAlertDialog) {

                                    Intent intent=new Intent(InnerActivity2.this,PayPal_sdk.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .show()
                    ;
                }
                }
                else {
                    Toast.makeText(InnerActivity2.this, "Please select dates first!", Toast.LENGTH_SHORT).show();
                }
            }


        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.FadeInUp)
                        .duration(500)
                        .playOn(findViewById(R.id.llfordetails));
                llfordetails.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.SlideInDown)
                        .duration(500)
                        .playOn(findViewById(R.id.actionbar));
                actionbar.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.SlideInUp)
                        .duration(500)
                        .playOn(findViewById(R.id.ca));
                ca.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.SlideInDown)
                        .duration(500)
                        .playOn(findViewById(R.id.close));
                close.setVisibility(View.GONE);
                lv.setSelection(0);
            }
        });


    }
    public View HorizontalList(int layout_name) {

        LayoutInflater layoutInflater =
                (LayoutInflater) InnerActivity2.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View addView = layoutInflater.inflate(layout_name, null);

        return addView;
    }

    public void getthetracker(String clientLatitude, String clientLongitude) {

        MapsInitializer.initialize(InnerActivity2.this);
        switch (GooglePlayServicesUtil.isGooglePlayServicesAvailable(InnerActivity2.this)) {
            case ConnectionResult.SUCCESS:
                isInternetPresent =cd.isConnectingToInternet();

                // check for Internet status
                if (isInternetPresent) {
                    //Toast.makeText(ctc, "tracker", Toast.LENGTH_SHORT).show();
                    // Gets to GoogleMap from the MapView and does initialization stuff


                        map.clear();
                        map.getUiSettings().setMyLocationButtonEnabled(false);
                        LatLng curentpoint = new LatLng(Double.parseDouble(clientLatitude),
                                Double.parseDouble(clientLongitude));
                        map.addMarker(new MarkerOptions()
                                .position(curentpoint)
                                .title("").icon(BitmapDescriptorFactory.fromResource(R.drawable.markerforcurrent)));

                        CameraPosition cameraPosition = new CameraPosition.Builder()
                                .target(curentpoint).zoom(14).build();

                        map.animateCamera(CameraUpdateFactory
                                .newCameraPosition(cameraPosition));
//                    CameraUpdate center =
//                            CameraUpdateFactory.newLatLng(new LatLng(Double.parseDouble(clientLatitude),
//                                    Double.parseDouble(clientLongitude)));
//                    CameraUpdate zoom = CameraUpdateFactory.zoomTo(10);
////                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(Double.parseDouble(clientLatitude),
////                            Double.parseDouble(clientLongitude)), 10), 4000, null);
//                    map.moveCamera(center);
//                    map.animateCamera(zoom);








                } else {
                    // Internet connection is not present
                    // Ask user to connect to Internet
                    Toast.makeText(InnerActivity2.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                }



                break;
            case ConnectionResult.SERVICE_MISSING:
                Toast.makeText(InnerActivity2.this, "SERVICE MISSING", Toast.LENGTH_SHORT).show();
                break;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED:
                Toast.makeText(InnerActivity2.this, "UPDATE REQUIRED", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(InnerActivity2.this, GooglePlayServicesUtil.isGooglePlayServicesAvailable(InnerActivity2.this), Toast.LENGTH_SHORT).show();
        }




    }

    @Override
    public void onResume() {

        super.onResume();
        getthetracker("-0.4500", "36.2500");

    }
    @Override
    public void onDestroy() {
        super.onDestroy();



    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        final Calendar c = Calendar.getInstance();
        myear = c.get(Calendar.YEAR);
        mmonth = c.get(Calendar.MONTH)+1;
        mday = c.get(Calendar.DAY_OF_MONTH);

        date = "Date : " + dayOfMonth + "/" + (++monthOfYear) + "/" + year;
        if(count==0){

            myear2 = year;
            mmonth2 = ++monthOfYear;
            mday2 = dayOfMonth;
            date1 = dayOfMonth+"-"+(++monthOfYear)+"-"+year;
            fromvalue.setText(""+date);
            c2.set(year,monthOfYear,dayOfMonth+1);
        }
        else {
            if (!date1.equals("")) {
                if (CheckDates(date1,dayOfMonth+"-"+(++monthOfYear)+"-"+year)) {
                    tovalue.setText("" + date);
                } else {
                    tovalue.setText("" + date);
                }

            }
            else {
                Toast.makeText(InnerActivity2.this, "Please select From date first !!!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }


    public static boolean CheckDates(String d1,String d2)    {
        boolean b = false;
        try {
            if(dfDate.parse(d1).before(dfDate.parse(d2)))
            {
                b = true;//If start date is before end date
            }
            else if(dfDate.parse(d1).equals(dfDate.parse(d2)))
            {
                b = true;//If two dates are equal
            }
            else
            {
                b = false; //If start date is after the end date
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return b;
    }

    public void openMail(View view) {
        Intent emailintent = new Intent(Intent.ACTION_SEND);
        emailintent.setType("plain/text");
        emailintent.putExtra(Intent.EXTRA_EMAIL,new String[] {"allanwanzalah@gmail.com" });
        emailintent.putExtra(Intent.EXTRA_SUBJECT, "Regarding your property");
        emailintent.putExtra(Intent.EXTRA_TEXT,"");
        startActivity(Intent.createChooser(emailintent, "Send mail..."));

    }
}
