package hamim.sazadah.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.lang.reflect.Array;

public class Hobby extends AppCompatActivity implements View.OnClickListener {
    CheckBox cRead,cWrite,cTravel,cProgram;
    TextView txtHobby;
    String[]  data = new String[] {"","","",""};;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobby);
        cRead = (CheckBox)findViewById(R.id.cRead);
        cWrite = (CheckBox)findViewById(R.id.cWrite);
        cProgram = (CheckBox)findViewById(R.id.cProgram);
        cTravel = (CheckBox)findViewById(R.id.cTravel);
        txtHobby = (TextView)findViewById(R.id.txtHobby);

        cRead.setOnClickListener(this);
        cWrite.setOnClickListener(this);
        cProgram.setOnClickListener(this);
        cTravel.setOnClickListener(this);

    }
    public void home(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cRead : if(cRead.isChecked()) data[0]="Reading"; else data[0]="";break;
            case R.id.cWrite : if(cWrite.isChecked()) data[1]="Writing"; else data[1]="";break;
            case R.id.cProgram : if(cProgram.isChecked()) data[2]="Programming"; else data[2]="";break;
            case R.id.cTravel : if(cTravel.isChecked()) data[3]="Traveling"; else data[3]="";break;
        }
        txtHobby.setText(String.join(",",data));
    }
}
