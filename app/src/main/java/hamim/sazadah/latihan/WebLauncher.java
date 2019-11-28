package hamim.sazadah.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebLauncher extends AppCompatActivity {
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_launcher);
        setTitle("Web View");


        web = (WebView)findViewById(R.id.web);
        web.loadUrl("https://www.detik.com");
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
    }
    public void home(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
