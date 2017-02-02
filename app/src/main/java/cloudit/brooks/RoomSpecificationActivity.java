package cloudit.brooks;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RoomSpecificationActivity extends Activity {
    ImageView add,add2,add3,add4,back;
    ImageView min,min2,min3,min4;
    TextView res,res2,res3,res4,next;
    public static RoomSpecificationActivity rdp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_specification);
        add = (ImageView)findViewById(R.id.add);
        add2 = (ImageView)findViewById(R.id.add2);
        add3 = (ImageView)findViewById(R.id.add3);
        add4 = (ImageView)findViewById(R.id.add4);
        min = (ImageView)findViewById(R.id.mins);
        min2 = (ImageView)findViewById(R.id.mins2);
        min3 = (ImageView)findViewById(R.id.mins3);
        min4 = (ImageView)findViewById(R.id.mins4);
        back = (ImageView)findViewById(R.id.back);
        res = (TextView)findViewById(R.id.res);
        res2 = (TextView)findViewById(R.id.res2);
        res3 = (TextView)findViewById(R.id.res3);
        res4 = (TextView)findViewById(R.id.res4);
        next = (TextView)findViewById(R.id.next);
        rdp = RoomSpecificationActivity.this;
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =  new Intent(RoomSpecificationActivity.this,AddroomdetailsActivity.class);
                startActivity(in);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText("" + (Integer.parseInt(res.getText().toString()) + 1));
            }
        });
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(res.getText().toString()) == 1) {
                } else {
                    res.setText("" + (Integer.parseInt(res.getText().toString()) - 1));
                }
            }
        });
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res2.setText("" + (Integer.parseInt(res2.getText().toString()) + 1));
            }
        });
        min2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(res2.getText().toString()) == 1) {
                } else {
                    res2.setText("" + (Integer.parseInt(res2.getText().toString()) - 1));
                }
            }
        });
        add3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res3.setText("" + (Integer.parseInt(res3.getText().toString()) + 1));
            }
        });
        min3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(res3.getText().toString()) == 1) {
                } else {
                    res3.setText("" + (Integer.parseInt(res3.getText().toString()) - 1));
                }
            }
        });
        add4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res4.setText("" + (Float.parseFloat(res4.getText().toString()) + 0.5));
            }
        });
        min4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Float.parseFloat(res4.getText().toString()) == 0.5) {
                } else {
                    res4.setText("" + (Float.parseFloat(res4.getText().toString()) - 0.5));
                }
            }
        });
    }
}
