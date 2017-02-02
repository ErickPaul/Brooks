package cloudit.brooks.Fragment_mainscreen;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.afollestad.materialdialogs.MaterialDialog;

import cloudit.brooks.AboutActivity;
import cloudit.brooks.HelpSupportActivity;
import cloudit.brooks.MainActivity;
import cloudit.brooks.R;
import cloudit.brooks.ViewEditActivity;
import cloudit.brooks.WhyhostActivity;
import views.ProgressWheel;

/**
 * Created by apporio6 on 16-08-2016.
 */
public class Settingsfragment extends Fragment {
    public static ListView lv1;
    public static ProgressWheel pb;
    public static Context ctc;
    LinearLayout llforviewprofile,llforsettings,llforhelpsupport,llforwhyhost,llforbecomehost,llforinvitefrnds,
    llforlogout,llforfeedback;

    //  int images[]={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        llforviewprofile = (LinearLayout)v.findViewById(R.id.llv);
        llforsettings = (LinearLayout)v.findViewById(R.id.lls);

        llforhelpsupport = (LinearLayout)v.findViewById(R.id.llforhelp);
        llforwhyhost = (LinearLayout)v.findViewById(R.id.llforwhyhost);
        llforbecomehost = (LinearLayout)v.findViewById(R.id.llforbecomehost);
        llforinvitefrnds = (LinearLayout)v.findViewById(R.id.llforinvite);
        llforlogout = (LinearLayout)v.findViewById(R.id.llforlogout);
        llforfeedback = (LinearLayout)v.findViewById(R.id.llforfeedback);

        llforviewprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),ViewEditActivity.class);
                startActivity(in);
            }
        });
        llforsettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),AboutActivity.class);
                startActivity(in);
            }
        });
        llforhelpsupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),HelpSupportActivity.class);
                startActivity(in);
            }
        });
        llforwhyhost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),WhyhostActivity.class);
                startActivity(in);
            }
        });
        llforbecomehost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.pager.setCurrentItem(2);
                MainActivity.forvisiblecolor(MainActivity.calendarcolor);
                MainActivity.forinvisiblecolor(MainActivity.calendargrey);
            }
        });
        llforlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(getActivity())
                        .title("Log Out")
                        .content("Are you sure you want to logout?")
                        .positiveText("Log Out")
                        .negativeText("Cancel")
                        .positiveColorRes(R.color.pink)
                        .negativeColorRes(R.color.heading)
                        .show();
            }
        });
        llforinvitefrnds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS();
            }
        });

        llforfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "allanwanzalah@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Regarding Brook's Real Estate App");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
        emailIntent.setType("text/plain");
            }
        });
        return v;
    }
    private void sendSMS() {

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml("Hey! Check out Brook's Real Estate app on Play Store! ") + "\n" + "https://play.google.com/store/apps/details?id=cloudit.brooks");
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent,"Share it!"));
    }
    public static Settingsfragment newInstance(String text) {

        Settingsfragment f = new Settingsfragment();

        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }
}