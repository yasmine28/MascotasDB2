package mx.yasmine.mascotasdb2.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import mx.yasmine.mascotasdb2.pojo.Mascota;

/**
 * Created by Yasmine on 14/11/2016.
 */

public class BaseDatos extends SQLiteOpenHelper{

    private Context context;
    public BaseDatos(Context context) {

        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.DATABASE_NAME + "(" +
                ConstantesBaseDatos.TABLE_PETS_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TABLE_PETS_NOMBRE   + " TEXT," +
                ConstantesBaseDatos.TABLE_PETS_TIPO     + " TEXT," +
                ConstantesBaseDatos.TABLE_PETS_FOTO     + " INTEGER" +
                ")";

        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_PETS+ "(" +
        ConstantesBaseDatos.TABLE_LIKES_PETS_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TABLE_LIKES_PETS_ID_PET  + " INTEGER," +
                ConstantesBaseDatos.TABLE_LIKES_CANTIDAD     + " INTEGER," +
                " FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_PETS_ID_PET + ")"+
                " REFERENCES " + ConstantesBaseDatos.TABLE_PETS + " (" +
                ConstantesBaseDatos.TABLE_PETS_ID +
                ") )";


        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_PETS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKES_PETS);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * from " + ConstantesBaseDatos.TABLE_PETS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setTipo(registros.getString(2));
            mascotaActual.setFoto(registros.getInt(3));

            String queryLike = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_CANTIDAD+") as likes FROM " + ConstantesBaseDatos.TABLE_LIKES_PETS
                    +" WHERE "+ ConstantesBaseDatos.TABLE_LIKES_PETS_ID_PET +"="+ mascotaActual.getId();
            Cursor registroLike = db.rawQuery(queryLike, null);
            if(registroLike.moveToNext()) {
                mascotaActual.setLikes(registroLike.getInt(0));
            }else{
                mascotaActual.setLikes(0);
            }
            mascotas.add(mascotaActual);
        }
        db.close();

        return mascotas;
    }

    public ArrayList<Mascota> obtenerFavMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        int favC = 0;


        String queryLike = "SELECT mascotas.*,COUNT("+ConstantesBaseDatos.TABLE_LIKES_CANTIDAD+") as likes FROM mascotas LEFT JOIN " + ConstantesBaseDatos.TABLE_LIKES_PETS
                +" ON mascotas.id=likes_mascotas.id_mascota"
                +" GROUP BY mascotas.id"
                +" ORDER BY likes DESC";
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(queryLike, null);
        while(registros.moveToNext() && favC <5){

            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setTipo(registros.getString(2));
            mascotaActual.setFoto(registros.getInt(3));
            mascotaActual.setLikes(registros.getInt(4));

            mascotas.add(mascotaActual);
            favC++;
        }



        db.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_PETS, null, contentValues);
        db.close();
    }

    public void insertarLike(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_PETS,null, contentValues);
        db.close();

    }
    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;
        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_CANTIDAD+") FROM " + ConstantesBaseDatos.TABLE_LIKES_PETS
                +" WHERE "+ ConstantesBaseDatos.TABLE_LIKES_PETS_ID_PET +"="+ mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){
           likes = registros.getInt(0);

        }
        db.close();

        return likes;
    }
}
