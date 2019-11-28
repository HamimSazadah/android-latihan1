package hamim.sazadah.latihan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
                if(!(txtNama.getText().toString().matches("[A-Za-z\\s]+"))){
                    txtNama.setError("Nama harus diisi!");
                }else if(!(txtEmail.getText().toString().matches("\\w+@\\w+\\.\\w+"))){
                    txtEmail.setError("Email tidak Valid!");
                }else if(kota.trim().matches("Pilih Kota")){
                    Toast.makeText(getBaseContext(),"Harus Pilih Kota!",Toast.LENGTH_SHORT);
                }else if(!(txtTanggal.getText().toString().matches("\\d{2}/\\d{2}/\\d{4}"))){
                    Toast.makeText(getBaseContext(),"Format Tanggal : dd/mm/yyyy",Toast.LENGTH_SHORT);
                }else {
                    Intent intent = new Intent(Form.this, Result.class);
                    intent.putExtra("nama", txtNama.getText().toString());
                    intent.putExtra("email", txtEmail.getText().toString());
                    intent.putExtra("tgl", txtTanggal.getText().toString());
                    intent.putExtra("kota", kota);
                    intent.putExtra("jkl", jkl);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
    public void home(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Back to Home");
        builder.setMessage("back to home?");
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
        builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),
                        "Ok!", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(false);
        builder.show();

    }
}
