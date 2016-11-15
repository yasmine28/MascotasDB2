package mx.yasmine.mascotasdb2.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import mx.yasmine.mascotasdb2.R;
import mx.yasmine.mascotasdb2.pojo.Mascota;

/**
 * Created by Yasmine on 14/11/2016.
 */

public class ConstructorMascotas {
    private Context context;
    public static final int LIKE = 1;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
       // ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        BaseDatos db = new BaseDatos(context);
      /*  mascotas.add(new Mascota("Lula", "gato", R.drawable.gato1,1));
        mascotas.add(new Mascota("Duque", "perro", R.drawable.perro1,3));
        mascotas.add(new Mascota("Pelusa", "gato",  R.drawable.gato_1,2));
        mascotas.add(new Mascota("Silvano", "perro",  R.drawable.perro2,4));
        mascotas.add(new Mascota("Solovino", "gato",  R.drawable.morris_cat,0));
        mascotas.add(new Mascota("Hierro", "perro",  R.drawable.perro3,5));*/
        insertarTresMascotas(db);
                return db.obtenerMascotas();
    }

    public void insertarTresMascotas(BaseDatos db){
        ContentValues values = new ContentValues();

        values.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Lula");
        values.put(ConstantesBaseDatos.TABLE_PETS_TIPO, "gato");
        values.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.gato_1);

        db.insertarMascota(values);
        values = new ContentValues();

        values.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Risky");
        values.put(ConstantesBaseDatos.TABLE_PETS_TIPO, "perro");
        values.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.perro1);

        db.insertarMascota(values);
        values = new ContentValues();

        values.put(ConstantesBaseDatos.TABLE_PETS_NOMBRE, "Pelusa");
        values.put(ConstantesBaseDatos.TABLE_PETS_TIPO, "gato");
        values.put(ConstantesBaseDatos.TABLE_PETS_FOTO, R.drawable.morris_cat);

        db.insertarMascota(values);

    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos bd = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_PETS_ID_PET,mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CANTIDAD,LIKE);
        bd.insertarLike(contentValues);


    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos bd = new BaseDatos(context);

        return bd.obtenerLikesMascota(mascota);
    }
}
