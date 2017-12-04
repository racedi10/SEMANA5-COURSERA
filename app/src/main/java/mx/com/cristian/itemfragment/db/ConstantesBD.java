package mx.com.cristian.itemfragment.db;

/**
 * Created by DIEGO on 31/07/2017.
 */

public final class ConstantesBD {
    public static final String DATABASE_NAME="contactos";
    public static final int DATABASE_VERSION=1;

    public static final String TABLE_CONTACTO="contacto";
    public static final String TABLE_CONTACTO_ID="id";
    public static final String TABLE_CONTACTO_NOMBRE="nombre";
    public static final String TABLE_CONTACTO_TELEFONO="telefono";
    public static final String TABLE_CONTACTO_EMAIL="email";
    public static final String TABLE_CONTACTO_FOTO="foto";

    public static final String TABLE_LIKES_CONTACT="contacto_likes";
    public static final String TABLE_LIKES_CONTACT_ID ="id" ;
    public static final String TABLE_LIKES_CONTACT_ID_CONTACTO="id_contacto ";
    public static final String TABLE_LIKES_CONTACT_NUMERO_LIKES ="numero_likes" ;
}
