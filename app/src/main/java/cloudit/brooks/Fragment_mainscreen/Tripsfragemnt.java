package cloudit.brooks.Fragment_mainscreen;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import cloudit.brooks.R;

import views.ProgressWheel;

/**
 * Created by apporio6 on 16-08-2016.
 */
public class Tripsfragemnt extends Fragment {
    public static ListView lv1;
    public static ProgressWheel pb;
    public static Context ctc;

    //  int images[]={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_trips, container, false);

        return v;
    }

    public static Tripsfragemnt newInstance(String text) {

        Tripsfragemnt f = new Tripsfragemnt();

        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }
}