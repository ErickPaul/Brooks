package cloudit.brooks.Fragment_mainscreen;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import cloudit.brooks.Adapter.Homeadapter;
import cloudit.brooks.R;

import views.ProgressWheel;

/**
 * Created by apporio6 on 16-08-2016.
 */
public class Homefragment extends Fragment {
    public static ListView lv1;
    public static ProgressWheel pb;
    public static Context ctc;

    // int images[]={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        lv1 = (ListView) v.findViewById(R.id.listView);
        pb = (ProgressWheel) v.findViewById(R.id.pb112);
        ctc = getActivity();
        lv1.setAdapter(new Homeadapter(ctc));


        lv1.setFocusable(false);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        return v;
    }

    public static Homefragment newInstance(String text) {

        Homefragment f = new Homefragment();

        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }
}