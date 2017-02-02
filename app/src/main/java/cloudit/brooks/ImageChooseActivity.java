package cloudit.brooks;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import cloudit.brooks.Adapter.ImagesetAdapter;
import com.nguyenhoanglam.imagepicker.activity.ImagePickerActivity;
import com.nguyenhoanglam.imagepicker.model.Image;

import java.util.ArrayList;


public class ImageChooseActivity extends Activity {
    ImageView Plus,back,reload;
    private ArrayList<Image> images = new ArrayList<>();
    private ArrayList<Image> images3 = new ArrayList<>();
    private ArrayList<String> images2 = new ArrayList<>();
    TextView done;
    private int REQUEST_CODE_PICKER = 2000;
    GridView gd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser);
        Plus = (ImageView) findViewById(R.id.call);
        back = (ImageView) findViewById(R.id.back);
        reload = (ImageView) findViewById(R.id.reload);
        done = (TextView) findViewById(R.id.done);
        gd = (GridView) findViewById(R.id.gd);

            ;
        if(getIntent().getIntExtra("sizeadd",0)>0) {
            for (int i = 0; i < getIntent().getIntExtra("sizeadd",0); i++) {
                images2.add(getIntent().getStringExtra("resultadd"+i));
            }

            gd.setAdapter(new ImagesetAdapter(ImageChooseActivity.this,images2,"old"));
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("size",images.size());
                for (int i=0;i<images.size();i++){
                    returnIntent.putExtra("result"+i,""+images.get(i).getPath());
                }

                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });

        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                images.clear();
                REQUEST_CODE_PICKER=2000;
                gd.setAdapter(new ImagesetAdapter(ImageChooseActivity.this,images));
            }
        });
        Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ImageChooseActivity.this, ImagePickerActivity.class);

                intent.putExtra(ImagePickerActivity.INTENT_EXTRA_FOLDER_MODE, true);
                intent.putExtra(ImagePickerActivity.INTENT_EXTRA_MODE, ImagePickerActivity.MODE_MULTIPLE);
                intent.putExtra(ImagePickerActivity.INTENT_EXTRA_LIMIT, 10);
                intent.putExtra(ImagePickerActivity.INTENT_EXTRA_SHOW_CAMERA, true);
                intent.putExtra(ImagePickerActivity.INTENT_EXTRA_SELECTED_IMAGES, images);
                intent.putExtra(ImagePickerActivity.INTENT_EXTRA_FOLDER_TITLE, "Album");
                intent.putExtra(ImagePickerActivity.INTENT_EXTRA_IMAGE_TITLE, "Tap to select images");
                intent.putExtra(ImagePickerActivity.INTENT_EXTRA_IMAGE_DIRECTORY, "Camera");

                startActivityForResult(intent, REQUEST_CODE_PICKER);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICKER && resultCode == RESULT_OK && data != null) {
            images3.clear();
            images3 = data.getParcelableArrayListExtra(ImagePickerActivity.INTENT_EXTRA_SELECTED_IMAGES);
            for(int i=0;i<images3.size();i++){
                images.add(images3.get(i));
            }

            gd.setAdapter(new ImagesetAdapter(ImageChooseActivity.this,images));
        }
    }
}
