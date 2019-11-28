package hamim.sazadah.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setTitle("About");
    }
    public void call(View v){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:08567869150"));
        startActivity(intent);
    }

    public void maps(View v){
        Uri uri = Uri.parse("geo:-6.180614, 106.826078");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    public void email(View view) {
        String[] TO = {"info@inixindo.co.id"};
        String[] CC = {"ami@inixindo.co.id"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,
                "Sample Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT,
                "Email Message");
        try { startActivity(Intent.
                createChooser(emailIntent,"Send Email.."));
            finish();
            Log.i("Email Sent", "");
            Toast.makeText(getBaseContext(), "Done",
                    Toast.LENGTH_SHORT).show();
        } catch (android.content
                .ActivityNotFoundException ex) {
            Toast.makeText(this,
                    ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }
    public void home(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
