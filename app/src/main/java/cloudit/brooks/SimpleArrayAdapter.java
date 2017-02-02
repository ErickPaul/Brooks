package cloudit.brooks;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.HashMap;
import java.util.List;
/**
 * Created by Erick-Paul on 21/11/2016.
 */
public class SimpleArrayAdapter extends ArrayAdapter<String> {

    Context context;
    int textViewResourceId;
    private static final String TAG = "SimpleArrayAdapter" ;
    HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

    public SimpleArrayAdapter(Context context, int textViewResourceId,
                              List<String> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.textViewResourceId = textViewResourceId;
        for (int i = 0; i < objects.size(); ++i) {
            hashMap.put(objects.get(i), i);
        }
    }

    @Override
    public long getItemId(int position) {
        String item = getItem(position);
        return hashMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public void add(String object){
        hashMap.put(object,hashMap.size());
        this.notifyDataSetChanged();
    }
}