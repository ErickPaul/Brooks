package cloudit.brooks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import cloudit.brooks.Adapter.MyAdapter1;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class AddroomdetailsActivity extends FragmentActivity {
    TextView next;
    TextView addphotos,titlemain,titledescp,summarymain,summarydescp,preview;
    ArrayList<String> images ;
    ViewPager pager;
    public static  int i=0;
    public  static String titleed="",descriptioned="";
    LinearLayout llfortitle,llfordescp,llforaddress,llforsetprice,llforbookingdetails,llforoptional;
    public static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addroomdetails);
        next = (TextView)findViewById(R.id.Next);
        fragmentManager = getSupportFragmentManager();
        pager = (ViewPager) findViewById(R.id.pager);
        llfortitle = (LinearLayout) findViewById(R.id.llfortitle);
        llfordescp = (LinearLayout) findViewById(R.id.llforsummary);
        llforaddress = (LinearLayout) findViewById(R.id.llforaddress);
        llforsetprice = (LinearLayout) findViewById(R.id.llforsetprice);
        llforbookingdetails = (LinearLayout) findViewById(R.id.llforbookingdetails);
        llforoptional = (LinearLayout) findViewById(R.id.llforoptional);
        images = new ArrayList<>();
        addphotos = (TextView) findViewById(R.id.addphotos);
        preview = (TextView) findViewById(R.id.prew);
        titlemain = (TextView) findViewById(R.id.edit);
        summarymain = (TextView) findViewById(R.id.ws);
        titledescp = (TextView) findViewById(R.id.desc);
        summarydescp = (TextView) findViewById(R.id.descs);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(AddroomdetailsActivity.this, "Your home is listed now", Toast.LENGTH_SHORT).show();

                new SweetAlertDialog(v.getContext(), SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Listed!")
                        .setContentText("Your property is listed now!")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                finish();
                                PropertyTypeActivity.pdp.finish();
                                LocationActivity.ldp.finish();
                                RoomSpecificationActivity.rdp.finish();
                            }
                        })
                        .show();
            }
        });

        addphotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(AddroomdetailsActivity.this, "Your home is listed now", Toast.LENGTH_SHORT).show();

                Intent in = new Intent(AddroomdetailsActivity.this,ImageChooseActivity.class);

                if(images.size()>0){
                    in.putExtra("sizeadd",images.size());
                    for (int i=0;i<images.size();i++){
                        in.putExtra("resultadd"+i,""+images.get(i));
                    }
                }
                startActivityForResult(in, 1);
            }
        });



        llfortitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(AddroomdetailsActivity.this, "Your home is listed now", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(AddroomdetailsActivity.this,WriteTextActivity.class);
                in.putExtra("Head","Title");
                in.putExtra("Descp",titleed);
                startActivity(in);
            }
        });

        llfordescp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(AddroomdetailsActivity.this, "Your home is listed now", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(AddroomdetailsActivity.this,WriteTextActivity.class);
                in.putExtra("Head","Summary");
                in.putExtra("Descp",descriptioned);
                startActivity(in);
            }
        });

        llforaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(AddroomdetailsActivity.this, "Your home is listed now", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(AddroomdetailsActivity.this,SetAddressActivity.class);
                startActivity(in);
            }
        });

        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(AddroomdetailsActivity.this, "Your home is listed now", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(AddroomdetailsActivity.this,InnerActivity.class);
                startActivity(in);
            }
        });

        llforsetprice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(AddroomdetailsActivity.this, "Your home is listed now", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(AddroomdetailsActivity.this,SetPriceActivity.class);
                startActivity(in);
            }
        });
        llforbookingdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(AddroomdetailsActivity.this, "Your home is listed now", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(AddroomdetailsActivity.this,BookingdetailsActivity.class);
                startActivity(in);
            }
        });
        llforoptional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(AddroomdetailsActivity.this, "Your home is listed now", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(AddroomdetailsActivity.this,OptionaldetailsActivity.class);
                startActivity(in);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {

            if(resultCode == Activity.RESULT_OK){
                int size = data.getIntExtra("size", 0);
                for (int i=0;i<size;i++){
                    images.add(data.getStringExtra("result" + i));
                }
                pager.setAdapter(new MyAdapter1(getSupportFragmentManager(), 0, images));

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult

    @Override
    protected void onResume() {
        super.onResume();
        View view = AddroomdetailsActivity.this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)AddroomdetailsActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        if(i==1){
            if(!titleed.equals("")){
                titlemain.setText(""+titleed);
                titledescp.setVisibility(View.GONE);
            }
            else if(titleed.equals("")) {
                titlemain.setText("Write Title");
                titledescp.setVisibility(View.VISIBLE);
            }
        }
       else if(i==2) {
           if (!descriptioned.equals("")) {
                summarymain.setText("" + descriptioned);
                summarydescp.setVisibility(View.GONE);
            } else if (descriptioned.equals("")) {
                summarymain.setText("Write Summary");
                summarydescp.setVisibility(View.VISIBLE);
            }
        }

    }
}
