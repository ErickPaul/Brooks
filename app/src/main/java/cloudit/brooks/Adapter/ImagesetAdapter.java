package cloudit.brooks.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cloudit.brooks.InnerActivity;
import cloudit.brooks.R;
import com.nguyenhoanglam.imagepicker.model.Image;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by apporio6 on 19-09-2016.
 */
public class ImagesetAdapter extends BaseAdapter {

    Context ctc;
    //String[] color_arr={"#d7b853","#E27556","#9D3B54","#523259","#4dbd7c"};
    final LayoutInflater inflater;
    String abc = "null";
    String[] ad;
    //    private NetworkImageView mNetworkImageView;
//    private ImageLoader mImageLoader;
    int pos=0;
    ArrayList<Image> Images = new ArrayList<>();
    ArrayList<String> Imagess = new ArrayList<String>();
    ArrayList<String> address = new ArrayList<String>();
    ArrayList<String> city = new ArrayList<String>();
    ArrayList<String> postcode = new ArrayList<String>();
    ArrayList<String> countrys = new ArrayList<String>();
    ArrayList<String> zone = new ArrayList<String>();
    ArrayList<String> addressid = new ArrayList<String>();

    String mobile ;


    public ImagesetAdapter(Context c,ArrayList<Image> img) {

        ctc = c;
        abc="null";
        //Image URL - This can point to any image file supported by Android
        inflater = LayoutInflater.from(this.ctc);
        Images = img;

    }
    public ImagesetAdapter(Context c,ArrayList<String> img,String s) {

        ctc = c;
        abc=s;
        //Image URL - This can point to any image file supported by Android
        inflater = LayoutInflater.from(this.ctc);
        Imagess = img;

    }

    @Override
    public int getCount() {
//        return product_id.size();
        if(abc.equals("null")) {
            return Images.size();

        }
        else {
            return Imagess.size();
        }
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
        public android.widget.ImageView ImageView,plus,minus;
        public TextView name, cat_NameTextView, mobile, noofunit_product, cuisines;
        public ImageView delete, tv2;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder;
        if(convertView== null) {
            convertView = inflater.inflate(R.layout.itemlayoutformainlist,null);
            holder = new Holder();
            convertView.setTag(holder);
        }
        else {
            holder = (Holder)convertView.getTag();
        }
        holder.tv2=(ImageView)convertView.findViewById(R.id.photoss);

        if(abc.equals("null")) {
            String images = "" + Images.get(position).getPath();
            File imgFile = new File(images);
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

            holder.tv2.setImageBitmap(myBitmap);
        }
        else {
            String images = "" + Imagess.get(position);
            File imgFile = new File(images);
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

            holder.tv2.setImageBitmap(myBitmap);
        }




//        Log.e("catname",""+cat_name.size());
//        Log.e("pimage", "" + p_Image.size());

//        doaddview(holder.addviewLayout, p_Image.get(position).length, p_Image.get(position), p_Name.get(position), p_Price.get(position), p_Listprice.get(position), p_ID.get(position));



        return convertView;
    }

}
