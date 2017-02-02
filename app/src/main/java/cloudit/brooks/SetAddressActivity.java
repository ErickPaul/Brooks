package cloudit.brooks;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class SetAddressActivity extends Activity {
        String coun[]={"Nairobi","Mombasa","Nakuru","Naivasha","Kisumu","Kericho","Eldoret"};
    String citys[]={"CBD","Kwale","Milimani","Lakeside","Lake Shore","Tea Plains","Park View"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_address);
        final EditText address = (EditText)findViewById(R.id.address1);
        final EditText city = (EditText)findViewById(R.id.city);
        Spinner statesp = (Spinner)findViewById(R.id.State);
        Spinner countrysp = (Spinner)findViewById(R.id.country11);
        final EditText pincode = (EditText)findViewById(R.id.pincode);
        ImageView close = (ImageView) findViewById(R.id.closed);
        TextView saved = (TextView)findViewById(R.id.savedd);
        countrysp.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                coun));
        statesp.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, citys));

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
    }
}
