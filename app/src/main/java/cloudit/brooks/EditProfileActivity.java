package cloudit.brooks;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import cloudit.brooks.directory.AlbumStorageDirFactory;
import cloudit.brooks.directory.BaseAlbumDirFactory;
import cloudit.brooks.directory.FroyoAlbumDirFactory;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EditProfileActivity extends Activity implements DatePickerDialog.OnDateSetListener{
    LinearLayout llforgender,llfordateofbirth,llforemail,llforphone;
    ImageView camera2,camera;
    TextView date, gender, phone,email;
    public  static Bitmap bitmap1;
    String []rimarray={"Male","Female","Other"};
    private AlbumStorageDirFactory mAlbumStorageDirFactory = null;
    private static final String JPEG_FILE_PREFIX = "IMG_";
    private static final String JPEG_FILE_SUFFIX = ".jpg";
    public static String imgDecodableString="";
    private static int RESULT_LOAD_IMG = 1;
    private static final int MY_PERMISSIONS_REQUEST_Call_Contacts2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        ImageView  close = (ImageView) findViewById(R.id.back);
        camera2 = (ImageView) findViewById(R.id.camera);
        date = (TextView) findViewById(R.id.d);
        gender = (TextView) findViewById(R.id.g);
        phone = (TextView) findViewById(R.id.p);
        email = (TextView) findViewById(R.id.e);

        camera = (ImageView) findViewById(R.id.ea);

        llforgender = (LinearLayout) findViewById(R.id.genderll);
        llfordateofbirth = (LinearLayout) findViewById(R.id.datell);
        llforemail = (LinearLayout) findViewById(R.id.emailll);
        llforphone = (LinearLayout) findViewById(R.id.phonell);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
            mAlbumStorageDirFactory = new FroyoAlbumDirFactory();
        } else {
            mAlbumStorageDirFactory = new BaseAlbumDirFactory();
        }

        llforphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdialog("Phone");
            }
        });
        llforemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdialog("Email");
            }
        });

        llforgender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(EditProfileActivity.this)
                        .title("Select Gender")
                        .items(rimarray)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                gender.setText("" + text);
                            }
                        })
                        .show();
            }
        });

        camera2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkpermissionforcamera();
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        llfordateofbirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        EditProfileActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)

                );
                Calendar c = Calendar.getInstance();
                dpd.setMinDate(c);
                dpd.setAccentColor(Color.parseColor("#c34040"));
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });

       
    }
    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
//        final Calendar c = Calendar.getInstance();
//        myear = c.get(Calendar.YEAR);
//        mmonth = c.get(Calendar.MONTH)+1;
//        mday = c.get(Calendar.DAY_OF_MONTH);

        date.setText("" + dayOfMonth + "/" + (++monthOfYear) + "/" + year);


    }
    private void showdialog(final String text) {



        final Dialog dialog = new Dialog(EditProfileActivity.this,android.R.style.Theme_Translucent_NoTitleBar);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window=dialog.getWindow();
        dialog.setCancelable(true);
        window.setGravity(Gravity.CENTER);
        dialog.getWindow().setWindowAnimations(
                R.style.customDialogAnimation);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        dialog.setContentView(R.layout.dialogforemail);
        final EditText ed = (EditText) dialog.findViewById(R.id.price);
        final TextView title = (TextView) dialog.findViewById(R.id.textView);
        if(text.equals("Email")){
            title.setText("Set Email Address");
            ed.setInputType(InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS);
            ed.setHint("E-mail");
        }
        else {
            title.setText("Set Phone Number");
            ed.setHint("Phone Number");
            ed.setInputType(InputType.TYPE_CLASS_PHONE);
        }
        ImageView close = (ImageView)dialog.findViewById(R.id.closed);
        ImageView saved = (ImageView)dialog.findViewById(R.id.call);

        saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.equals("Email")){
                    email.setText(ed.getText().toString().trim());
                    dialog.dismiss();
                }
                else {
                    phone.setText(ed.getText().toString().trim());
                    dialog.dismiss();

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



    private void checkpermissionforcamera() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String permission = "android.permission.READ_EXTERNAL_STORAGE";

            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                try {


                    int permissionCheck = ContextCompat.checkSelfPermission(EditProfileActivity.this,
                            Manifest.permission.READ_EXTERNAL_STORAGE);

                    if (ContextCompat.checkSelfPermission(EditProfileActivity.this,
                            Manifest.permission.READ_EXTERNAL_STORAGE)
                            != PackageManager.PERMISSION_GRANTED) {

                        // Should we show an explanation?
                        if (ActivityCompat.shouldShowRequestPermissionRationale(EditProfileActivity.this,
                                Manifest.permission.READ_EXTERNAL_STORAGE)) {
                            Toast.makeText(getApplicationContext(), "Please allow phone permission to take images !!!", Toast.LENGTH_LONG).show();
                            // Show an expanation to the user *asynchronously* -- don't block
                            // this thread waiting for the user's response! After the user
                            // sees the explanation, try again to request the permission.


                        } else {

                            // No explanation needed, we can request the permission.

                            ActivityCompat.requestPermissions(EditProfileActivity.this,
                                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                    MY_PERMISSIONS_REQUEST_Call_Contacts2);

                            showoptioncameradialog();

                        }
                    } else {
                        showoptioncameradialog();
                    }
                } catch (Exception e) {
                    Log.e("ghghghhg", "" + e);
                }
            } else {
                showoptioncameradialog();
            }

            // parsingfornotification.parsing(MainActivity.this,regId,dd);

        } else {
            showoptioncameradialog();
        }


    }

    private void showoptioncameradialog() {
        final Dialog dialog = new Dialog(EditProfileActivity.this,android.R.style.Theme_Translucent_NoTitleBar);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window=dialog.getWindow();
        dialog.setCancelable(false);
        window.setGravity(Gravity.CENTER);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.camerdialog);
        Button cancel = (Button) dialog.findViewById(R.id.button1);
        LinearLayout button = (LinearLayout) dialog.findViewById(R.id.layout12);
        LinearLayout button1 = (LinearLayout) dialog.findViewById(R.id.layout13);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                dispatchTakePictureIntent(11);


            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                // Start the Intent
                startActivityForResult(galleryIntent, RESULT_LOAD_IMG);

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void dispatchTakePictureIntent(int actionCode) {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        switch(actionCode) {
            case 11:
                File f = null;

                try {
                    f = setUpPhotoFile();
                    imgDecodableString = f.getAbsolutePath();
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                } catch (IOException e) {
                    e.printStackTrace();
                    f = null;
                    imgDecodableString = null;
                }
                break;

            default:
                break;
        } // switch

        startActivityForResult(takePictureIntent, 11);
    }
    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        File f = new File(imgDecodableString);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        EditProfileActivity.this.sendBroadcast(mediaScanIntent);
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            //Toast.makeText(getActivity(),""+requestCode+" "+resultCode,Toast.LENGTH_SHORT).show();
            switch(requestCode){
                case 11:
                    if(resultCode!=0){

                        // Profileactivity.intentproceed=11;
                        handleBigCameraPhoto();
                    }
                case 1:
                    if (requestCode == RESULT_LOAD_IMG && resultCode != 0
                            && null != data) {
                        // Get the Image from data
                        // MainActivity.intentproceed=1;
                        Uri selectedImage = data.getData();
                        String[] filePathColumn = {MediaStore.Images.Media.DATA};

                        // Get the cursor
                        Cursor cursor = EditProfileActivity.this.getContentResolver().query(selectedImage,
                                filePathColumn, null, null, null);
                        // Move to first row
                        cursor.moveToFirst();

                        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                        imgDecodableString = cursor.getString(columnIndex);
                        cursor.close();
                        //img.setImageResource(android.R.color.transparent);
                        // Set the Image in ImageView after decoding the String

                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFile(imgDecodableString, options);
                        final int REQUIRED_SIZE = 300;
                        int scale = 1;
                        while (options.outWidth / scale / 2 >= REQUIRED_SIZE
                                && options.outHeight / scale / 2 >= REQUIRED_SIZE)
                            scale *= 2;
                        options.inSampleSize = scale;
                        options.inJustDecodeBounds = false;
                        bitmap1 = BitmapFactory.decodeFile(imgDecodableString, options);
                        camera.setImageBitmap(bitmap1);
                        camera.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    }
                default:{
                    // Toast.makeText(getActivity(), "You haven't picked Image",Toast.LENGTH_LONG).show();
                }
            }

            // When an Image is picked
            // Toast.makeText(getActivity(),""+requestCode+" "+resultCode,Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(EditProfileActivity.this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

    }

    private String getAlbumName() {
        return getString(R.string.album_name);
    }
    private void handleBigCameraPhoto() {

        if (imgDecodableString != null) {
            galleryAddPic();
            setPic();

            imgDecodableString = null;
        }

    }

    private void setPic() {

		/* There isn't enough memory to open up more than a couple camera photos */
		/* So pre-scale the target bitmap into which the file is decoded */

		/* Get the size of the ImageView */
        int targetW =150;
        int targetH = 150;


		/* Get the size of the image */
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imgDecodableString, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

		/* Figure out which way needs to be reduced less */
        int scaleFactor = 1;
        if ((targetW > 0) || (targetH > 0)) {
            scaleFactor = Math.min(photoW/targetW, photoH/targetH);
        }

		/* Set bitmap options to scale the image decode target */
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

		/* Decode the JPEG file into a Bitmap */
        bitmap1 = BitmapFactory.decodeFile(imgDecodableString, bmOptions);
        Log.e("bitmap", "" + bitmap1);
        camera.setImageBitmap(bitmap1);

       		/* Associate the Bitmap to the ImageView */

    }


    private File getAlbumDir() {
        File storageDir = null;

        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {

            storageDir = mAlbumStorageDirFactory.getAlbumStorageDir(getAlbumName());

            if (storageDir != null) {
                if (! storageDir.mkdirs()) {
                    if (! storageDir.exists()){
                        Log.d("CameraSample", "failed to create directory");
                        return null;
                    }
                }
            }

        } else {
            Log.v(getString(R.string.app_name), "External storage is not mounted READ/WRITE.");
        }

        return storageDir;
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = JPEG_FILE_PREFIX + timeStamp + "_";
        File albumF = getAlbumDir();
        File imageF = File.createTempFile(imageFileName, JPEG_FILE_SUFFIX, albumF);
        return imageF;
    }

    private File setUpPhotoFile() throws IOException {

        File f = createImageFile();
        imgDecodableString = f.getAbsolutePath();

        return f;
    }
}
