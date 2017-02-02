package cloudit.brooks.Adapter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import cloudit.brooks.R;


import java.io.File;
import java.util.ArrayList;


/**
 * Created by saifi45 on 8/9/2015.
 */

    public class Basefragmentforphotoopen extends Fragment {
        static String ds2;
        public  static  int y;
    TextView title, copy;
    int d;
    private ImageLoader mImageLoader;
    ArrayList<String> photos = new ArrayList<>();

public  static ImageView img;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layoutforphotoopen, null);

           img = (ImageView)root.findViewById(R.id.imageView);

            d= getArguments().getInt("msg");
            photos = getArguments().getStringArrayList("msg3");
            String de= ""+getArguments().getString("msg2");

            String images= ""+de;
            File imgFile = new File(images);
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            img.setImageBitmap(myBitmap);



            return root;
        }


        public static Basefragmentforphotoopen newInstance(int position, String s, ArrayList<String> farray) {
            Basefragmentforphotoopen f = new Basefragmentforphotoopen();
            Bundle b = new Bundle();
            b.putInt("msg", position);
            b.putString("msg2", s);
            b.putStringArrayList("msg3", farray);
            // y=ber;
            f.setArguments(b);

            return f;
        }
    }

