package cloudit.brooks;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

public class OptionaldetailsActivity extends Activity {
    LinearLayout ltp, lc, ldescp,lamenties,lroombed,lrooms;
    String []rimarray={"INR","USD","SGD"};
    String []ament={"Essentials","Shampoo","Heating","TV","Hot Tub","Pool","Breakfast","GYM"};
    TextView rimtext,amentiestx,deactivating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optionaldetails);
        ltp = (LinearLayout) findViewById(R.id.ltp);
        lc = (LinearLayout) findViewById(R.id.lc);
        ldescp = (LinearLayout) findViewById(R.id.descpll);
        lamenties = (LinearLayout) findViewById(R.id.amentill);
        lroombed = (LinearLayout) findViewById(R.id.roomll);
        rimtext = (TextView) findViewById(R.id.usd);
        amentiestx = (TextView) findViewById(R.id.none);
        deactivating = (TextView) findViewById(R.id.dect);
        ImageView close = (ImageView) findViewById(R.id.back);
        ltp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(OptionaldetailsActivity.this,LongtermpricesActivity.class);
                startActivity(in);
            }
        });
        lc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdialogforcurrency();
            }
        });
        ldescp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(OptionaldetailsActivity.this,DescriptionActivity.class);
                startActivity(in);
            }
        });
        deactivating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(OptionaldetailsActivity.this)
                        .title("Deactivate Listing")
                        .content("Are you sure you want to deactivate this listing? Deactivation is permanent and cannot be reversed. You may wish to unlist this listing.")
                        .positiveText("Deactivate")
                        .negativeText("Cancel")
                        .positiveColorRes(R.color.pink)
                        .negativeColorRes(R.color.pink)
                        .show();
            }
        });
        lamenties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              showdialogforamenties();
            }
        });
        lroombed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(OptionaldetailsActivity.this,RoomsandbedActivity.class);
                startActivity(in);
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void showdialogforamenties() {
        new MaterialDialog.Builder(this)
                .title("Select Amenities")
                .items(ament)
                .itemsCallbackMultiChoice(null, new MaterialDialog.ListCallbackMultiChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {
                       if(text.length==0) {
                           amentiestx.setText("None");
                       }
                        else {
                           amentiestx.setText("" + text.length);
                       }
                        return true;
                    }
                })
                .positiveText("OK")
                .show();
    }

    private void showdialogforcurrency() {
        new MaterialDialog.Builder(this)
                .title("Select Currency")
                .items(rimarray)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        rimtext.setText("" + text);
                    }
                })
                .show();
    }
}
