package hamim.sazadah.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAbout,btnHobby,btnForm;
    ImageButton btnList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main Menu");

        btnAbout = (Button)findViewById(R.id.btnAbout);
        btnList = (ImageButton) findViewById(R.id.btnList);
        btnForm = (Button)findViewById(R.id.btnForm);
        btnHobby = (Button)findViewById(R.id.btnHobby);

        btnHobby.setOnClickListener(this);
        btnList.setOnClickListener(this);
        btnForm.setOnClickListener(this);
        btnAbout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch(v.getId()){
            case R.id.btnAbout :   intent = new Intent(this,About.class); break;
            case R.id.btnList :   intent = new Intent(this,List.class);  break;
            case R.id.btnHobby :    intent = new Intent(this,Hobby.class); break;
            case R.id.btnForm:   intent = new Intent(this,Form.class);break;
        }
        startActivity(intent);
        finish();
    }

}
