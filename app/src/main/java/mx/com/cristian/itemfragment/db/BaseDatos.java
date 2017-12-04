package mx.com.cristian.itemfragment.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import mx.com.cristian.itemfragment.pojo.Contacto;


public class BaseDatos extends SQLiteOpenHelper{
    int likes=0;
    private Context context;

    public BaseDatos(Context context) {
        super(context,ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context= context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String querycrearTablaContacto="CREATE TABLE " +
                                        ConstantesBD.TABLE_CONTACTO + "("+
                                        ConstantesBD.TABLE_CONTACTO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                                        ConstantesBD.TABLE_CONTACTO_NOMBRE + " TEXT, "+
                                        ConstantesBD.TABLE_CONTACTO_TELEFONO+ " TEXT, "+
                                        ConstantesBD.TABLE_CONTACTO_EMAIL+ " TEXT, " +
                                        ConstantesBD.TABLE_CONTACTO_FOTO +" INTEGER " + ")";

        String queryTablaLikes="CREATE TABLE "+ ConstantesBD.TABLE_LIKES_CONTACT +"("+
                                                ConstantesBD.TABLE_LIKES_CONTACT_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                ConstantesBD.TABLE_LIKES_CONTACT_ID_CONTACTO + " INTEGER, " +
                                                ConstantesBD.TABLE_LIKES_CONTACT_NUMERO_LIKES + " INTEGER, " +
                                                "FOREIGN KEY ("+ ConstantesBD.TABLE_LIKES_CONTACT_ID_CONTACTO+ ") " +
                                                "REFERENCES "+ ConstantesBD.TABLE_CONTACTO+ "("+ConstantesBD.TABLE_CONTACTO_ID+ ")"+
                                                ")";


        db.execSQL(querycrearTablaContacto);
        db.execSQL(queryTablaLikes);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+ ConstantesBD.TABLE_CONTACTO);
        db.execSQL("DROP TABLE IF EXIST "+ ConstantesBD.TABLE_LIKES_CONTACT);
        onCreate(db);
    }

    public ArrayList<Contacto> obtenerContactos(){
        ArrayList<Contacto> contactos= new ArrayList<>();

        String query="SELECT * FROM "+ ConstantesBD.TABLE_CONTACTO;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registros=db.rawQuery(query, null);
        while(registros.moveToNext()) {
            Contacto contactoActual = new Contacto();
            contactoActual.setId(registros.getInt(0));
            contactoActual.setNombre(registros.getString(1));
            contactoActual.setTelefono(registros.getString(2));
            contactoActual.setCorreo(registros.getString(3));
            contactoActual.setFoto(registros.getInt(4));

            String queryLikes = "SELECT COUNT(" + ConstantesBD.TABLE_LIKES_CONTACT_NUMERO_LIKES + ") as likes" +
                                " FROM " + ConstantesBD.TABLE_LIKES_CONTACT +
                                " WHERE " + ConstantesBD.TABLE_LIKES_CONTACT_ID_CONTACTO + " = " + contactoActual.getId();

            Cursor registroLikes = db.rawQuery(queryLikes, null);

            if (registroLikes.moveToNext()) {
                contactoActual.setLikes(registroLikes.getInt(0));
            } else {
                contactoActual.setLikes(0);
            }


            contactos.add(contactoActual);
        }
        db.close();
        return contactos;
    }

    public void insertarDatosBD(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_CONTACTO,null, contentValues);
        db.close();

    }

    public void insertarLike(ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_LIKES_CONTACT,null, contentValues);
        db.close();
    }

    public int obtenerLikes(Contacto contacto){


        String query="SELECT COUNT("+ConstantesBD.TABLE_LIKES_CONTACT_NUMERO_LIKES+") "+
                     " FROM " + ConstantesBD.TABLE_LIKES_CONTACT +
                     " WHERE " + ConstantesBD.TABLE_LIKES_CONTACT_ID_CONTACTO+"="+contacto.getId();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registros=db.rawQuery(query, null);

        if(registros.moveToNext()) {
            likes=registros.getInt(0);
        }
        db.close();

        return likes;
    }

}
