package hamim.sazadah.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class Form extends AppCompatActivity {
    TextView txtNama,txtEmail,txtTanggal;
    Spinner spAlamat;
    RadioGroup rdJkl;
    Button btnSend;
    String kota,jkl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        setTitle("Form");
        kota="";
        jkl ="";
        txtNama = (TextView)findViewById(R.id.txtNama);
        txtEmail = (TextView)findViewById(R.id.txtEmail);
        txtTanggal = (TextView)findViewById(R.id.txtDate);
        spAlamat = (Spinner) findViewById(R.id.spAlamat);
        rdJkl = (RadioGroup)findViewById(R.id.rdJkl);
        btnSend = (Button) findViewById(R.id.btnSend);

        rdJkl.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                jkl = String.valueOf(rdJkl.getCheckedRadioButtonId());
            }
        });


        spAlamat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                kota=spAlamat.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Form.this,Result.class);
                intent.putExtra("nama",txtNama.getText().toString());
                intent.putExtra("email",txtEmail.getText().toString());
                intent.putExtra("tgl",txtTanggal.getText().toString());
                intent.putExtra("kota",kota);
                intent.putExtra("jkl",jkl);
                startActivity(intent);
                finish();
            }
        });

    }
    public void home(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
