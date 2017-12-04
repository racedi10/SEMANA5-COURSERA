package mx.com.cristian.itemfragment.adapter;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import mx.com.cristian.itemfragment.R;
import mx.com.cristian.itemfragment.db.ConstructorContactos;
import mx.com.cristian.itemfragment.pojo.Contacto;
import mx.com.cristian.itemfragment.DetalleContacto;

public class contactoAdaptador extends RecyclerView.Adapter<contactoAdaptador.contactoViewHolder> {

    ArrayList<Contacto> contactos;
    Activity activity;

    public contactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos=contactos;
        this.activity=activity;
    }
    //infla olayout y mandar al viewHolder
    @Override
    public contactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Crea al layout
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);

        return new contactoViewHolder(v);
    }

    @Override
    //Asocia cada elemento de la lista a con cada view
    public void onBindViewHolder(final contactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());
        //contactoViewHolder.tvLikes.setText(String.valueOf(contacto.getLikes())+" Likes");

        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity,DetalleContacto.class);
                intent.putExtra("nombre", contacto.getNombre());
                intent.putExtra("telefono", contacto.getTelefono());
                intent.putExtra("correo", contacto.getCorreo());
                activity.startActivity(intent);
            }
        });

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                Toast.makeText(activity, "Le diste Like a " +  contacto.getNombre(),Toast.LENGTH_SHORT).show();

                ConstructorContactos constructorContactos = new ConstructorContactos(activity);
                constructorContactos.darLike(contacto);
               // contactoViewHolder.tvLikes.setText(constructorContactos.obtenerLikes(contacto));
                contactoViewHolder.tvLikes.setText(String.valueOf(constructorContactos.obtenerLikes(contacto))+" Likes");
            }
        });

    }

    @Override
    public int getItemCount() {//Cantidad de elementos que tiene la lista
        return contactos.size();
    }

    public static class contactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private ImageButton btnLike;
        private TextView tvLikes;


        public contactoViewHolder(View itemView) {
            super(itemView);
            imgFoto     =(ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV  =(TextView) itemView.findViewById(R.id.textViewNombre);
            tvTelefonoCV=(TextView) itemView.findViewById(R.id.tvTelefonoCV);
            btnLike     =(ImageButton) itemView.findViewById(R.id.btnLike);
            tvLikes     =(TextView) itemView.findViewById(R.id.tvLikes);
        }
    }
}
