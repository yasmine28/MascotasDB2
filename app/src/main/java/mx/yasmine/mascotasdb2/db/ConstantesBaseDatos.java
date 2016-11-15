package mx.yasmine.mascotasdb2.db;

/**
 * Created by Yasmine on 14/11/2016.
 */

public final class ConstantesBaseDatos {
    public static final String DATABASE_NAME="mascotas";
    public static final int DATABASE_VERSION=1;

    public static final String TABLE_PETS = "mascotas";
    public static final String TABLE_PETS_ID = "id";
    public static final String TABLE_PETS_NOMBRE = "nombre";
    public static final String TABLE_PETS_TIPO = "tipo";
    public static final String TABLE_PETS_FOTO = "foto";

    public static final String TABLE_LIKES_PETS = "likes_mascotas";


    public static final String  TABLE_LIKES_PETS_ID = "id_likes_mascotas";

    public static final String TABLE_LIKES_CANTIDAD = "num_likes";
    public static final String TABLE_LIKES_PETS_ID_PET = "id_mascota";
}
