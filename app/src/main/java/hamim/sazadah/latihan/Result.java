package hamim.sazadah.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView lblNama,lblEmail,lblTanggal,lblAlamat,lblJkl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        lblNama = (TextView)findViewById(R.id.lblNama);
        lblEmail = (TextView)findViewById(R.id.lblEmail);
        lblTanggal = (TextView)findViewById(R.id.lblTanggal);
        lblAlamat= (TextView)findViewById(R.id.lblAlamat);
        lblJkl = (TextView)findViewById(R.id.lblJkl);

        Intent intent = getIntent();
        lblNama.setText("Nama : "+intent.getStringExtra("nama"));
        lblEmail.setText("Email : "+intent.getStringExtra("email"));
        lblTanggal.setText("Tanggal : "+intent.getStringExtra("tgl"));
        lblAlamat.setText("Kota : "+intent.getStringExtra("kota"));
        lblJkl.setText("Jenis Kelamin : "+intent.getStringExtra("jkl"));


    }
    public void home(View v){
        Intent intent = new Intent(this,Form.class);
        startActivity(intent);
        finish();
    }
}
