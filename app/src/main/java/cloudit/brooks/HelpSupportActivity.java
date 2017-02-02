package cloudit.brooks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HelpSupportActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_support);
    }

    public void OpenMail(View view) {

        Intent emailintent = new Intent(android.content.Intent.ACTION_SEND);
        emailintent.setType("plain/text");
        emailintent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] {"allanwanzalah@gmail.com" });
        emailintent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Help Regarding Brook's Real Estate App");
        emailintent.putExtra(android.content.Intent.EXTRA_TEXT,"");
        startActivity(Intent.createChooser(emailintent, "Send mail..."));

    }
}
