package mx.com.cristian.itemfragment.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import mx.com.cristian.itemfragment.R;
import mx.com.cristian.itemfragment.pojo.Contacto;

public class ConstructorContactos {

    private static final Integer LIKE = 1;
    private Context context;
    public ConstructorContactos(Context context){
        this.context=context;
    }


    public ArrayList<Contacto> obtenerContactos(){

        /*ArrayList<Contacto> contactos=new ArrayList<>();
        contactos.add(new Contacto(R.drawable.phone_48,"Cristian Solis","5523078920","cristian.solis.esca@hotmail.com", 0));
        contactos.add(new Contacto(R.drawable.email_48,"Angeles Martinez","5528596456","angels2701@icloud.com", 0));
        contactos.add(new Contacto(R.drawable.email_48,"Silvia Escamilla","5515946276","silvia.escamilla@gmail.com", 0));
        contactos.add(new Contacto(R.drawable.peinadoma3,"Irving Solis","42097007","chiva_susa@hotmail.com", 0));
        return contactos;*/
        BaseDatos db= new BaseDatos(context);
        insertarDatos(db);
        return db.obtenerContactos();
    }

    public void insertarDatos(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_CONTACTO_NOMBRE,"Cristian Solis");
        contentValues.put(ConstantesBD.TABLE_CONTACTO_TELEFONO,"5523078920");
        contentValues.put(ConstantesBD.TABLE_CONTACTO_EMAIL,"cristian.solis.esca@hotmail.com");
        contentValues.put(ConstantesBD.TABLE_CONTACTO_FOTO,R.drawable.phone_48);

        db.insertarDatosBD(contentValues);

        contentValues  = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_CONTACTO_NOMBRE,"Silvia Escamilla");
        contentValues.put(ConstantesBD.TABLE_CONTACTO_TELEFONO,"5515946276");
        contentValues.put(ConstantesBD.TABLE_CONTACTO_EMAIL,"silvia.esca@hotmail.com");
        contentValues.put(ConstantesBD.TABLE_CONTACTO_FOTO,R.drawable.ic_contacs);

        db.insertarDatosBD(contentValues);

        contentValues  = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_CONTACTO_NOMBRE,"Mario Solis");
        contentValues.put(ConstantesBD.TABLE_CONTACTO_TELEFONO,"42097007");
        contentValues.put(ConstantesBD.TABLE_CONTACTO_EMAIL,"silvia.esca@hotmail.com");
        contentValues.put(ConstantesBD.TABLE_CONTACTO_FOTO,R.drawable.ic_action_name);

        db.insertarDatosBD(contentValues);
    }

    public void darLike(Contacto contacto){
        BaseDatos db= new BaseDatos(context);
        ContentValues contentValues= new ContentValues();
        contentValues.put(ConstantesBD.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBD.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);
        db.insertarLike(contentValues);
    }

    public int obtenerLikes(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return  db.obtenerLikes(contacto);
    }

}
