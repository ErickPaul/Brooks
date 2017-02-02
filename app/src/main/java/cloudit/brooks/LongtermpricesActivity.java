package cloudit.brooks;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LongtermpricesActivity extends Activity {
        LinearLayout daily,monthly;
    TextView dailytxt,monthlytext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_longtermprices);
        ImageView close = (ImageView) findViewById(R.id.back);
        monthlytext =  (TextView) findViewById(R.id.monthlytext);
        dailytxt =  (TextView) findViewById(R.id.dailytext);
        daily = (LinearLayout) findViewById(R.id.daily);
        monthly = (LinearLayout) findViewById(R.id.monthly);

        daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdialog("Weekly");
            }
        });

        monthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdialog("Monthly");
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

    private void showdialog(final String text) {



            final Dialog dialog = new Dialog(LongtermpricesActivity.this,android.R.style.Theme_Translucent_NoTitleBar);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            Window window=dialog.getWindow();
            dialog.setCancelable(true);
            window.setGravity(Gravity.CENTER);
            dialog.getWindow().setWindowAnimations(
                    R.style.customDialogAnimation);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            dialog.setContentView(R.layout.dialogfordiscount);
          final   EditText ed = (EditText) dialog.findViewById(R.id.price);
        final TextView title = (TextView) dialog.findViewById(R.id.textView);
            if(text.equals("Weekly")){
                title.setText("Set Weekly Discount");
            }
        else {
                title.setText("Set Monthly Discount");

            }
            ImageView close = (ImageView)dialog.findViewById(R.id.closed);
        ImageView saved = (ImageView)dialog.findViewById(R.id.call);

        saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.equals("Weekly")){
                    dailytxt.setText(ed.getText().toString().trim()+"%");
                }
                else {
                    monthlytext.setText(ed.getText().toString().trim()+"%");

                }
            }
        });



            close.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    dialog.dismiss();
                }


            });


            dialog.show();
        }
}
