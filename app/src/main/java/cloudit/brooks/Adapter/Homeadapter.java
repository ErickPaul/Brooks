package cloudit.brooks.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import cloudit.brooks.InnerActivity;
import cloudit.brooks.R;

/**
 * Created by apporio6 on 16-08-2016.
 */
public class Homeadapter  extends BaseAdapter {

    Context ctc;
    //String[] color_arr={"#d7b853","#E27556","#9D3B54","#523259","#4dbd7c"};
    final LayoutInflater inflater;
    String abc []={"Recent Searches","Popular Cities","Favourites","Just for the weekend"};
    String[] ad;
//    private NetworkImageView mNetworkImageView;
//    private ImageLoader mImageLoader;
    int pos=0;
    ArrayList<String> firstname = new ArrayList<String>();
    ArrayList<String> lastname = new ArrayList<String>();
    ArrayList<String> address = new ArrayList<String>();
    ArrayList<String> city = new ArrayList<String>();
    ArrayList<String> postcode = new ArrayList<String>();
    ArrayList<String> countrys = new ArrayList<String>();
    ArrayList<String> zone = new ArrayList<String>();
    ArrayList<String> addressid = new ArrayList<String>();

    String mobile ;


    public Homeadapter(Context c) {

        ctc = c;

        //Image URL - This can point to any image file supported by Android



        inflater = LayoutInflater.from(this.ctc);

    }

    @Override
    public int getCount() {
//        return product_id.size();
        return abc.length;
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
        public ImageView ImageView,plus,minus;
        public TextView name, cat_NameTextView, mobile, noofunit_product, cuisines;
        public android.widget.ImageView delete, tv2;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder;
        if(convertView== null) {
            convertView = inflater.inflate(R.layout.itemlayoutforhomescreen,null);
            holder = new Holder();
            convertView.setTag(holder);
        }
        else {
            holder = (Holder)convertView.getTag();
        }

        holder.cat_NameTextView = (TextView)convertView.findViewById(R.id.subtitle);
        holder.cat_NameTextView.setText(abc[position]);

        holder.addviewLayout=(LinearLayout)convertView.findViewById(R.id.all_store_container);

//        Log.e("catname",""+cat_name.size());
//        Log.e("pimage", "" + p_Image.size());

//        doaddview(holder.addviewLayout, p_Image.get(position).length, p_Image.get(position), p_Name.get(position), p_Price.get(position), p_Listprice.get(position), p_ID.get(position));

        doaddview(holder.addviewLayout);

        return convertView;
    }

//    private void doaddview(LinearLayout addviewLayout, int size, String[] image,String[] name,String[] price,String[] listprice,Integer[] pid) {
        private void doaddview(LinearLayout addviewLayout) {
            for (int i=0;i<1;i++) {


//            addviewLayout.addView(HorizontalList(R.layout.horizontal_items_layout, image[i], name[i],
//                    price[i], listprice[i], i,pid[i]));
                    addviewLayout.addView(HorizontalList(R.layout.horizontal_items_layout));

        }
            for (int i=1;i<2;i++) {


//            addviewLayout.addView(HorizontalList(R.layout.horizontal_items_layout, image[i], name[i],
//                    price[i], listprice[i], i,pid[i]));
                addviewLayout.addView(HorizontalList(R.layout.horizontal_items_layout2));

            }
            for (int i=2;i<3;i++) {


//            addviewLayout.addView(HorizontalList(R.layout.horizontal_items_layout, image[i], name[i],
//                    price[i], listprice[i], i,pid[i]));
                addviewLayout.addView(HorizontalList(R.layout.horizontal_items_layout3));

            }
            for (int i=3;i<4;i++) {


//            addviewLayout.addView(HorizontalList(R.layout.horizontal_items_layout, image[i], name[i],
//                    price[i], listprice[i], i,pid[i]));
                addviewLayout.addView(HorizontalList(R.layout.horizontal_items_layout4));

            }



    }


//    public  View HorizontalList(int layout_name, String productimage, final String prTitle,String pPrice,String PListPrice,final int pos, final int prdID) {
        public  View HorizontalList(int layout_name) {

            LayoutInflater layoutInflater =
                    (LayoutInflater) ctc.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            final View addView = layoutInflater.inflate(layout_name, null);

        addView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(ctc, InnerActivity.class);
                ctc.startActivity(in);

            }
        });

        return addView ;
    }




}
