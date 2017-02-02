package cloudit.brooks.Fragment_mainscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import cloudit.brooks.InnerActivity;
import cloudit.brooks.R;
import views.ProgressWheel;

/**
 * Created by apporio6 on 16-08-2016.
 */
public class Searchfragment extends Fragment {
    public static ListView lv1;
    public static ProgressWheel pb;
    public static Context ctc;
    String []abc={"Nairobi","Naivasha","Mombasa","Nakuru","Eldoret"};
    //  int images[]={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4};

    static class Holder {
        public LinearLayout addviewLayout, toppings, sausage, sizeno, toppingsno, sausageno;
        public android.widget.ImageView ImageView,plus,minus;
        public TextView name, cat_NameTextView, mobile, noofunit_product, cuisines;
        public android.widget.ImageView delete, tv2;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_search, container, false);
        lv1 = (ListView) v.findViewById(R.id.lvsearch);
        lv1.setAdapter(new ArrayAdapter(getActivity(),R.layout.itemlayoutforsearch,R.id.textv,abc));
        return v;
    }

    public static Searchfragment newInstance(String text) {

        Searchfragment f = new Searchfragment();

        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }

    public void onClick()
    {
        for (int i = 0; i < (abc.length - 1); i++)
        {
            Intent in = new Intent(ctc, InnerActivity.class);
            ctc.startActivity(in);

        }
    }


}