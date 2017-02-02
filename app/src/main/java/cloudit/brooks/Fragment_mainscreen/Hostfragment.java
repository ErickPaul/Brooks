package cloudit.brooks.Fragment_mainscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import cloudit.brooks.MainActivity;
import cloudit.brooks.PropertyTypeActivity;
import cloudit.brooks.R;

import views.ProgressWheel;

/**
 * Created by apporio6 on 16-08-2016.
 */
public class Hostfragment extends Fragment {
    public static ListView lv1;
    public static ProgressWheel pb;
    public static Context ctc;
    public static LinearLayout llforhome, llforprivateroom, llforsharedroom;

    //  int images[]={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_host, container, false);
        llforhome = (LinearLayout)v.findViewById(R.id.llforhome);
        llforprivateroom = (LinearLayout)v.findViewById(R.id.llforprivate);
        llforsharedroom = (LinearLayout)v.findViewById(R.id.llforshared);

        llforhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), PropertyTypeActivity.class);
                i.putExtra("title","entire home");
                startActivity(i);
            }
        });
        llforprivateroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), PropertyTypeActivity.class);
                i.putExtra("title","private room");
                startActivity(i);
            }
        });
        llforsharedroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), PropertyTypeActivity.class);
                i.putExtra("title","shared room");
                startActivity(i);
            }
        });

        return v;
    }

    public static Hostfragment newInstance(String text) {

        Hostfragment f = new Hostfragment();

        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }
}