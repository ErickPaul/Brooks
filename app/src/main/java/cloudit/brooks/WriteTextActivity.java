package cloudit.brooks;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class WriteTextActivity extends Activity {
    EditText ed;
    TextView tt,heading;
    ImageView save;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_text);
        ed= (EditText) findViewById(R.id.descp);
        tt = (TextView) findViewById(R.id.indi);
        heading = (TextView) findViewById(R.id.title);
        save = (ImageView) findViewById(R.id.call);

        if(getIntent().getStringExtra("Head").equals("Title")){
            ed.setHint("Give your listing a descriptive headline ...");
            tt.setText("25/25");

            ed.setFilters(new InputFilter[] {new InputFilter.LengthFilter(25)});
            i=25;
            ed.setText(""+getIntent().getStringExtra("Descp"));
            heading.setText("Write Title");

        }
       else if(getIntent().getStringExtra("Head").equals("Summary")){
            ed.setHint("Give your listing a descriptive summary ...");
            tt.setText("100/100");
            ed.setFilters(new InputFilter[] {new InputFilter.LengthFilter(100)});
            i=100;
            ed.setText(""+getIntent().getStringExtra("Descp"));
            heading.setText("Write Summary");

        }
        else {

        }
        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

                tt.setText(String.valueOf(i - ed.length())+"/"+i);
            }

            @Override
            public void onTextChanged(CharSequence s, int st, int b, int c) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int st, int c, int a) {
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getIntent().getStringExtra("Head").equals("Title")){
                    AddroomdetailsActivity.titleed=ed.getText().toString().trim();
                    AddroomdetailsActivity.i=1;
                }
                else if(getIntent().getStringExtra("Head").equals("Summary")){
                    AddroomdetailsActivity.descriptioned=ed.getText().toString().trim();
                    AddroomdetailsActivity.i=2;
                }
                else {
                    Toast.makeText(WriteTextActivity.this, "Else", Toast.LENGTH_SHORT).show();
                    AddroomdetailsActivity.i=0;
                }
                finish();
            }
        });
    }
}
