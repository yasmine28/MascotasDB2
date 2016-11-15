package mx.yasmine.mascotasdb2.pojo;

/**
 * Created by Yasmine on 27/10/2016.
 */

public class Mascota {

    private int id;
    private String nombre;
    private String tipo;
    private int foto;
    private int likes;

    public Mascota(String nombre, String tipo, int foto, int likes) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.foto = foto;
        this.likes = likes;
    }

    public Mascota() {

    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
