package mx.yasmine.mascotasdb2.pojo;

import java.io.Serializable;

/**
 * Created by Yasmine on 04/11/2016.
 */


public class Contacto implements Serializable {
    private String name;
    private String email;
    private String comentario;

    public Contacto(String name,String email, String comentario) {
        this.name = name;
        this.email = email;
        this.comentario = comentario;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return comentario;
    }

    public void setNotes(String notes) {
        this.comentario = notes;
    }


}

