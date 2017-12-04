package mx.com.cristian.itemfragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import static mx.com.cristian.itemfragment.R.string.correo;
import static mx.com.cristian.itemfragment.R.string.telefono;

public class DetalleContacto extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvCorreo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle parametros = getIntent().getExtras();
        String nombre     = parametros.getString("nombre");
        String telefono   = parametros.getString("telefono");
        String correo     = parametros.getString("correo");

        tvNombre   = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvCorreo   = (TextView) findViewById(R.id.tvCorreo);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvCorreo.setText(correo);

    }

    public void llamar(View v) {
        tvTelefono.getText().toString();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        //startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel " + telefono)));
    }

    public void correo(View v){
        tvCorreo.getText().toString();
        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.setData(Uri.parse("mailto:" ));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, correo);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent,"Email"));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){

        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent=new Intent(DetalleContacto.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode,event);
    }


}
