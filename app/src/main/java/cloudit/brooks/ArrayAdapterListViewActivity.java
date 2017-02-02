package cloudit.brooks;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by Erick-Paul on 21/11/2016.
 */
public class ArrayAdapterListViewActivity extends ActionBarActivity {

    private static final String TAG = "ArrayAdapterListViewActivity";
    EditText editText;
    Button addButton;
    TextView textView;
    SimpleArrayAdapter adapter;
    ListView listview;
    ArrayList<String> arrayList;
    Runnable run;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_array_adapter);


      //  textView = (TextView) findViewById(R.id.textView);

        listview = (ListView) findViewById(R.id.listview);

		/**
						*  This class is from a different project!
		*/

        String[] values = new String[] {
                "Table 01 - Frontal Left",
                "Table 02 - Frontal Right",
                "Table 03 - Frontal Window View",
                "Table 04 - Centre Dom",
                "Table 05 - Next To Piano",
                "Table 06 - Centre Window View",
                "Table 07 - Rear Centre",
                "Table 08 - Rear Next To Chandelier",
                "Table 09 - Extreme Rear Next To Aquarium" };

        arrayList = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            arrayList.add(values[i]);
        }
        adapter = new SimpleArrayAdapter(this,
                android.R.layout.simple_list_item_1, arrayList);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			/**
						* You can customize this to navigate the user to wherever you want from above selections
			*/

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                if(item.equals("Table 01 - Frontal Left")) {
                    new AlertDialog.Builder(ArrayAdapterListViewActivity.this).setTitle("Ooops!").setMessage("This table has already been reserved. Please pick another.").setCancelable(false).setNeutralButton("OK",null).show();
                }else

				/**
						* Customize this to fit your above table selections. E.g table already booked. Try another selection.
				*/

                {
                    sampleload();

                }
            }

        });


    }
    public void sampleload()
    {
        Intent intent= new Intent(this,SplashActivity.class);
        startActivity(intent);
    }


    public void OpenSpecials(View view) {

        Intent intent2= new Intent(this,SplashActivity.class);
        startActivity(intent2);
    }
}