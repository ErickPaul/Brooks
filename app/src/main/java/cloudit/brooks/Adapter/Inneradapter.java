package cloudit.brooks.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import cloudit.brooks.R;

import java.util.ArrayList;

/**
 * Created by apporio6 on 24-08-2016.
 */
public class Inneradapter extends BaseAdapter {

    Context ctc;
    //String[] color_arr={"#d7b853","#E27556","#9D3B54","#523259","#4dbd7c"};
    final LayoutInflater inflater;
    String abc[] = {"Recent Searches", "Popular Cities", "Favourites", "Just for the weekend"};
    String[] ad;
    //    private NetworkImageView mNetworkImageView;
//    private ImageLoader mImageLoader;
    int pos = 0;
    ArrayList<String> firstname = new ArrayList<String>();
    ArrayList<String> lastname = new ArrayList<String>();
    ArrayList<String> address = new ArrayList<String>();
    ArrayList<String> city = new ArrayList<String>();
    ArrayList<String> postcode = new ArrayList<String>();
    ArrayList<String> countrys = new ArrayList<String>();
    ArrayList<String> zone = new ArrayList<String>();
    ArrayList<String> addressid = new ArrayList<String>();

    String mobile;


    public Inneradapter(Context c) {

        ctc = c;

        //Image URL - This can point to any image file supported by Android


        inflater = LayoutInflater.from(this.ctc);

    }

    @Override
    public int getCount() {
//        return product_id.size();
        return 1;
    }

    @Override
    public Object getItem(int position) {
        Log.e("position", "Dish" + address.get(position));
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class Holder {
        public LinearLayout addviewLayout, toppings, sausage, sizeno, toppingsno, sausageno;
        public android.widget.ImageView ImageView, plus, minus;
        public TextView name, cat_NameTextView, mobile, noofunit_product, cuisines;
        public android.widget.ImageView delete, tv2;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.itemlayoutforphoto, null);
            holder = new Holder();
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }



//        Log.e("catname",""+cat_name.size());
//        Log.e("pimage", "" + p_Image.size());

//        doaddview(holder.addviewLayout, p_Image.get(position).length, p_Image.get(position), p_Name.get(position), p_Price.get(position), p_Listprice.get(position), p_ID.get(position));



        return convertView;
    }
}