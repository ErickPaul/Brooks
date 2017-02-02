package cloudit.brooks;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nguyenhoanglam.imagepicker.model.Image;

public class BookingdetailsActivity extends Activity {
        LinearLayout l1, l2, l3,houserules;
    ImageView img1, img2, img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookingdetails);
        l1 = (LinearLayout) findViewById(R.id.l1);
        l2 = (LinearLayout) findViewById(R.id.l2);
        l3 = (LinearLayout) findViewById(R.id.l3);
        houserules = (LinearLayout) findViewById(R.id.houserule);
        img1 = (ImageView) findViewById(R.id.img);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        ImageView close = (ImageView) findViewById(R.id.back);
        ImageView saved = (ImageView) findViewById(R.id.call);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changetick(img1);
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changetick(img2);
            }
        });
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changetick(img3);
            }
        });
        houserules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(BookingdetailsActivity.this,HouseRulesActivity.class);
                startActivity(in);
            }
        });


    }

    private  void changetick(ImageView i){
        img1.setVisibility(View.INVISIBLE);
        img2.setVisibility(View.INVISIBLE);
        img3.setVisibility(View.INVISIBLE);
        i.setVisibility(View.VISIBLE);
    }
}
