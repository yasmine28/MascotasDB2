package mx.yasmine.mascotasdb2.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import mx.yasmine.mascotasdb2.R;
import mx.yasmine.mascotasdb2.pojo.Mascota;

/**
 * Created by Yasmine on 15/11/2016.
 */

public class ConstructorFavMascotas {

    private Context context;
    public static final int LIKE = 1;

    public ConstructorFavMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerMascotasFav(){

        BaseDatos db = new BaseDatos(context);
        return db.obtenerFavMascotas();
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
