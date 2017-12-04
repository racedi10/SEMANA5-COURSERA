package mx.com.cristian.itemfragment.pojo;



public class Contacto {

    private int id;
    private String nombre;
    private String telefono;
    private String correo;
    private int foto;
    private int likes;



    public Contacto(int foto, String nombre, String telefono, String correo, int likes) {
        this.foto=foto;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo=correo;
        this.likes = likes;
    }

    public Contacto(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
