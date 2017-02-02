package cloudit.brooks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PropertyTypeActivity extends Activity {
    TextView heading,morehead;
    ImageView imagemore,back;
    public static PropertyTypeActivity pdp;
    LinearLayout llformore,llforclickmore;
    public static LinearLayout llforappt, llforcafe, llforvilla;
    String data[]={"Loft","Cabin","Villa","Castle","Dorm","Treehouse",
            "Boat","Plane","Camper","Igloo","Hut","Train","Tent","Other"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_type);
        llformore = (LinearLayout)findViewById(R.id.llformore);
        llforclickmore = (LinearLayout)findViewById(R.id.llforclickmore);
        llforappt = (LinearLayout)findViewById(R.id.llforappt);
        heading = (TextView)findViewById(R.id.textviewtitle);
        morehead = (TextView)findViewById(R.id.more);
        imagemore = (ImageView)findViewById(R.id.img);
        back = (ImageView)findViewById(R.id.back);
        pdp = PropertyTypeActivity.this;
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        llformore.setVisibility(View.GONE);
        morehead.setTextColor(Color.parseColor("#FF5959"));
        imagemore.setVisibility(View.VISIBLE);
        for(int i=0;i<data.length;i++){
            llformore.addView(Moreadd(PropertyTypeActivity.this,
                    R.layout.itemmorelist
                    , data[i]));
        }

        llforclickmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llformore.setVisibility(View.VISIBLE);
                morehead.setTextColor(Color.parseColor("#474747"));
                imagemore.setVisibility(View.INVISIBLE);
            }
        });
        llforappt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PropertyTypeActivity.this, LocationActivity.class);
                i.putExtra("title", "appartment");
                startActivity(i);
            }
        });

        heading.setText("What type of place is your "+ getIntent().getStringExtra("title")+" in ?");
    }

    public static View Moreadd(Context c, int layout_name, String s1) {

        LayoutInflater layoutInflater =
                (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View addView = layoutInflater.inflate(layout_name, null);

        final TextView tb = (TextView) addView.findViewById(R.id.edit);


        tb.setText("" + s1);



        return addView;
    }
}
